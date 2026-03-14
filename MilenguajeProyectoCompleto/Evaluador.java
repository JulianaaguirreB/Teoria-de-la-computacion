import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class Evaluador extends MilenguajeBaseVisitor<Object> {
    
    private Map<String, Object> tablaSimbolos = new HashMap<>();
    private List<String> errores = new ArrayList<>();
    
    public List<String> getErrores() {
        return errores;
    }
    
    public boolean hayErrores() {
        return !errores.isEmpty();
    }
    
    private boolean mismoTipo(Object a, Object b) {
        if (a == null || b == null) return false;
        return a.getClass().equals(b.getClass());
    }
    
    private String getTipo(Object obj) {
        if (obj instanceof Integer) return "entero";
        if (obj instanceof Double) return "decimal";
        if (obj instanceof Boolean) return "booleano";
        if (obj instanceof String) return "cadena";
        if (obj instanceof Vector) return "vector";
        if (obj instanceof List) return "matriz";
        return "desconocido";
    }
    
    private String valorToString(Object valor) {
        if (valor == null) return "null";
        if (valor instanceof Vector) {
            Vector<?> v = (Vector<?>) valor;
            return v.toString();
        }
        if (valor instanceof List) {
            List<?> m = (List<?>) valor;
            return m.toString();
        }
        if (valor instanceof Double) {
            return String.format("%.4f", valor);
        }
        return valor.toString();
    }
    
    @Override
    public Object visitPrograma(MilenguajeParser.ProgramaContext ctx) {
        for (MilenguajeParser.SentenciaContext sentencia : ctx.sentencia()) {
            try {
                visit(sentencia);
            } catch (Exception e) {
                errores.add("Error en ejecucion: " + e.getMessage());
            }
        }
        return null;
    }
    
    @Override
    public Object visitDeclaracion(MilenguajeParser.DeclaracionContext ctx) {
        String id = ctx.ID().getText();
        Object valor = visit(ctx.expresion());
        tablaSimbolos.put(id, valor);
        return null;
    }
    
    @Override
    public Object visitAsignacion(MilenguajeParser.AsignacionContext ctx) {
        String id = ctx.ID().getText();
        if (!tablaSimbolos.containsKey(id)) {
            errores.add("Error: Variable '" + id + "' no declarada");
            return null;
        }
        Object valor = visit(ctx.expresion());
        
        Object tipoActual = tablaSimbolos.get(id);
        if (!mismoTipo(tipoActual, valor)) {
            errores.add("Error de tipo: No se puede asignar " + 
                       getTipo(valor) + " a variable de tipo " + 
                       getTipo(tipoActual));
            return null;
        }
        
        tablaSimbolos.put(id, valor);
        return null;
    }
    
    @Override
    public Object visitImprimir(MilenguajeParser.ImprimirContext ctx) {
        Object valor = visit(ctx.expresion());
        System.out.println(valorToString(valor));
        return null;
    }
    
    @Override
    public Object visitCondicional(MilenguajeParser.CondicionalContext ctx) {
        Object condVal = visit(ctx.expresion());
        
        if (!(condVal instanceof Boolean)) {
            errores.add("Error: La condicion debe ser booleana");
            return null;
        }
        
        if ((Boolean) condVal) {
            visit(ctx.bloque(0));
        } else if (ctx.SINO() != null) {
            visit(ctx.bloque(1));
        }
        return null;
    }
    
    @Override
    public Object visitCicloMientras(MilenguajeParser.CicloMientrasContext ctx) {
        while (true) {
            Object condVal = visit(ctx.expresion());
            if (!(condVal instanceof Boolean)) {
                errores.add("Error: La condicion debe ser booleana");
                return null;
            }
            if (!(Boolean) condVal) break;
            visit(ctx.bloque());
        }
        return null;
    }
    
    @Override
    public Object visitCicloPara(MilenguajeParser.CicloParaContext ctx) {
        visit(ctx.asignacion(0));
        
        while (true) {
            Object condVal = visit(ctx.expresion());
            if (!(condVal instanceof Boolean)) {
                errores.add("Error: La condicion del para debe ser booleana");
                return null;
            }
            if (!(Boolean) condVal) break;
            
            visit(ctx.bloque());
            visit(ctx.asignacion(1));
        }
        return null;
    }
    
    @Override
    public Object visitBloque(MilenguajeParser.BloqueContext ctx) {
        for (MilenguajeParser.SentenciaContext sentencia : ctx.sentencia()) {
            visit(sentencia);
        }
        return null;
    }
    
    @Override
    public Object visitNumExpr(MilenguajeParser.NumExprContext ctx) {
        return Integer.parseInt(ctx.NUMERO().getText());
    }
    
    @Override
    public Object visitDecExpr(MilenguajeParser.DecExprContext ctx) {
        return Double.parseDouble(ctx.DECIMAL().getText());
    }
    
    @Override
    public Object visitStringExpr(MilenguajeParser.StringExprContext ctx) {
        String texto = ctx.CADENA().getText();
        return texto.substring(1, texto.length() - 1);
    }
    
    @Override
    public Object visitBoolExpr(MilenguajeParser.BoolExprContext ctx) {
        return ctx.BOOLEANO().getText().equals("verdadero");
    }
    
    @Override
    public Object visitIdExpr(MilenguajeParser.IdExprContext ctx) {
        String id = ctx.ID().getText();
        if (!tablaSimbolos.containsKey(id)) {
            errores.add("Error: Variable '" + id + "' no declarada");
            return 0;
        }
        return tablaSimbolos.get(id);
    }
    
    @Override
    public Object visitParenExpr(MilenguajeParser.ParenExprContext ctx) {
        return visit(ctx.expresion());
    }
    
    @Override
    public Object visitAddExpr(MilenguajeParser.AddExprContext ctx) {
        Object left = visit(ctx.expresion(0));
        Object right = visit(ctx.expresion(1));
        String op = ctx.getChild(1).getText();
        
        if (left instanceof Integer && right instanceof Integer) {
            int l = (Integer) left;
            int r = (Integer) right;
            switch (op) {
                case "+": return l + r;
                case "-": return l - r;
            }
        } else if (left instanceof Number && right instanceof Number) {
            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();
            switch (op) {
                case "+": return l + r;
                case "-": return l - r;
            }
        } else if (op.equals("+")) {
            // Concatenacion de strings con cualquier tipo
            return valorToString(left) + valorToString(right);
        }
        
        errores.add("Error: Operacion " + op + " no soportada entre " + 
                   getTipo(left) + " y " + getTipo(right));
        return 0;
    }
    
    @Override
    public Object visitMulExpr(MilenguajeParser.MulExprContext ctx) {
        Object left = visit(ctx.expresion(0));
        Object right = visit(ctx.expresion(1));
        String op = ctx.getChild(1).getText();
        
        if (left instanceof Integer && right instanceof Integer) {
            int l = (Integer) left;
            int r = (Integer) right;
            switch (op) {
                case "*": return l * r;
                case "/": 
                    if (r == 0) {
                        errores.add("Error: Division por cero");
                        return 0;
                    }
                    return l / r;
                case "%": return l % r;
            }
        } else if (left instanceof Number && right instanceof Number) {
            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();
            switch (op) {
                case "*": return l * r;
                case "/": 
                    if (r == 0) {
                        errores.add("Error: Division por cero");
                        return 0;
                    }
                    return l / r;
                case "%": return l % r;
            }
        }
        
        errores.add("Error: Operacion " + op + " no soportada entre " + 
                   getTipo(left) + " y " + getTipo(right));
        return 0;
    }
    
    @Override
    public Object visitPowExpr(MilenguajeParser.PowExprContext ctx) {
        Object left = visit(ctx.expresion(0));
        Object right = visit(ctx.expresion(1));
        
        if (left instanceof Number && right instanceof Number) {
            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();
            return Math.pow(l, r);
        }
        
        errores.add("Error: Potencia solo soportada para numeros");
        return 0;
    }
    
    @Override
    public Object visitRelExpr(MilenguajeParser.RelExprContext ctx) {
        Object left = visit(ctx.expresion(0));
        Object right = visit(ctx.expresion(1));
        String op = ctx.getChild(1).getText();
        
        if (left instanceof Number && right instanceof Number) {
            double l = ((Number) left).doubleValue();
            double r = ((Number) right).doubleValue();
            switch (op) {
                case "==": return l == r;
                case "!=": return l != r;
                case "<": return l < r;
                case ">": return l > r;
                case "<=": return l <= r;
                case ">=": return l >= r;
            }
        } else if (left instanceof Boolean && right instanceof Boolean) {
            boolean l = (Boolean) left;
            boolean r = (Boolean) right;
            switch (op) {
                case "==": return l == r;
                case "!=": return l != r;
                default:
                    errores.add("Error: Operador " + op + " no soportado para booleanos");
                    return false;
            }
        } else if (left instanceof String && right instanceof String) {
            String l = (String) left;
            String r = (String) right;
            switch (op) {
                case "==": return l.equals(r);
                case "!=": return !l.equals(r);
                default:
                    errores.add("Error: Operador " + op + " no soportado para cadenas");
                    return false;
            }
        }
        
        errores.add("Error: Comparacion no valida entre " + getTipo(left) + " y " + getTipo(right));
        return false;
    }
    
    @Override
    public Object visitAndExpr(MilenguajeParser.AndExprContext ctx) {
        Object left = visit(ctx.expresion(0));
        Object right = visit(ctx.expresion(1));
        
        if (left instanceof Boolean && right instanceof Boolean) {
            return (Boolean) left && (Boolean) right;
        }
        
        errores.add("Error: && solo soportado para booleanos");
        return false;
    }
    
    @Override
    public Object visitOrExpr(MilenguajeParser.OrExprContext ctx) {
        Object left = visit(ctx.expresion(0));
        Object right = visit(ctx.expresion(1));
        
        if (left instanceof Boolean && right instanceof Boolean) {
            return (Boolean) left || (Boolean) right;
        }
        
        errores.add("Error: || solo soportado para booleanos");
        return false;
    }
    
    @Override
    public Object visitNotExpr(MilenguajeParser.NotExprContext ctx) {
        Object val = visit(ctx.expresion());
        
        if (val instanceof Boolean) {
            return !(Boolean) val;
        }
        
        errores.add("Error: ! solo soportado para booleanos");
        return false;
    }
    
    @Override
    public Object visitVector(MilenguajeParser.VectorContext ctx) {
        Vector<Object> vector = new Vector<>();
        
        if (ctx.listaExpresiones() != null) {
            for (MilenguajeParser.ExpresionContext expr : ctx.listaExpresiones().expresion()) {
                Object valor = visit(expr);
                vector.add(valor);
            }
            
            if (!vector.isEmpty()) {
                Class<?> tipoBase = vector.get(0).getClass();
                for (Object elem : vector) {
                    if (!tipoBase.equals(elem.getClass())) {
                        errores.add("Error: Vector debe ser homogeneo");
                        break;
                    }
                }
            }
        }
        
        return vector;
    }
    
    @Override
    public Object visitMatriz(MilenguajeParser.MatrizContext ctx) {
        List<Vector<Object>> matriz = new ArrayList<>();
        
        for (MilenguajeParser.VectorContext vectorCtx : ctx.vector()) {
            Object vectorObj = visit(vectorCtx);
            if (vectorObj instanceof Vector) {
                matriz.add((Vector<Object>) vectorObj);
            }
        }
        
        if (!matriz.isEmpty()) {
            int tamFila = matriz.get(0).size();
            for (Vector<Object> fila : matriz) {
                if (fila.size() != tamFila) {
                    errores.add("Error: Matriz debe tener filas del mismo tamaño");
                    break;
                }
            }
        }
        
        return matriz;
    }
    
    @Override
    public Object visitFuncion(MilenguajeParser.FuncionContext ctx) {
        String nombreFuncion = ctx.getChild(0).getText();
        Object argumento = visit(ctx.expresion());
        
        switch (nombreFuncion) {
            case "media":
                return calcularMedia(argumento);
            case "mediana":
                return calcularMediana(argumento);
            case "desvest":
                return calcularDesviacionEstandar(argumento);
            case "varianza":
                return calcularVarianza(argumento);
            case "min":
                return calcularMin(argumento);
            case "max":
                return calcularMax(argumento);
            case "suma":
                return calcularSuma(argumento);
            case "resumen":
                return calcularResumen(argumento);
            default:
                errores.add("Error: Funcion no reconocida: " + nombreFuncion);
                return 0;
        }
    }
    
    // -------------------------------------------------------
    // Metodo auxiliar: convierte un vector o matriz a lista de doubles
    // -------------------------------------------------------
    private List<Double> convertirANumeros(Object arg) {
        List<Double> numeros = new ArrayList<>();
        
        if (arg instanceof Vector) {
            Vector<?> vector = (Vector<?>) arg;
            for (Object elem : vector) {
                if (elem instanceof Number) {
                    numeros.add(((Number) elem).doubleValue());
                } else {
                    errores.add("Error: Funcion estadistica solo acepta numeros");
                    return null;
                }
            }
        } else if (arg instanceof List) {
            List<?> matriz = (List<?>) arg;
            for (Object fila : matriz) {
                if (fila instanceof Vector) {
                    Vector<?> vectorFila = (Vector<?>) fila;
                    for (Object elem : vectorFila) {
                        if (elem instanceof Number) {
                            numeros.add(((Number) elem).doubleValue());
                        } else {
                            errores.add("Error: Funcion estadistica solo acepta numeros");
                            return null;
                        }
                    }
                }
            }
        } else {
            errores.add("Error: Funcion estadistica requiere vector o matriz");
            return null;
        }
        
        return numeros;
    }
    
    // -------------------------------------------------------
    // media: suma de todos los elementos / cantidad de elementos
    // -------------------------------------------------------
    private Double calcularMedia(Object arg) {
        List<Double> numeros = convertirANumeros(arg);
        if (numeros == null || numeros.isEmpty()) return 0.0;
        
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.size();
    }
    
    // -------------------------------------------------------
    // mediana: valor central de la lista ordenada.
    // Si la cantidad de elementos es par, promedia los dos centrales.
    // -------------------------------------------------------
    private Double calcularMediana(Object arg) {
        List<Double> numeros = convertirANumeros(arg);
        if (numeros == null || numeros.isEmpty()) return 0.0;
        
        List<Double> ordenados = new ArrayList<>(numeros);
        Collections.sort(ordenados);
        
        int n = ordenados.size();
        if (n % 2 == 1) {
            // Cantidad impar: elemento del centro
            return ordenados.get(n / 2);
        } else {
            // Cantidad par: promedio de los dos elementos centrales
            return (ordenados.get(n / 2 - 1) + ordenados.get(n / 2)) / 2.0;
        }
    }
    
    // -------------------------------------------------------
    // varianza: promedio de las diferencias al cuadrado respecto a la media
    // Se usa varianza poblacional (dividir entre N)
    // -------------------------------------------------------
    private Double calcularVarianza(Object arg) {
        List<Double> numeros = convertirANumeros(arg);
        if (numeros == null || numeros.isEmpty()) return 0.0;
        
        double media = calcularMedia(arg);
        double sumaCuadrados = 0;
        for (double num : numeros) {
            double diferencia = num - media;
            sumaCuadrados += diferencia * diferencia;
        }
        return sumaCuadrados / numeros.size();
    }
    
    // -------------------------------------------------------
    // desvest: desviacion estandar = raiz cuadrada de la varianza
    // -------------------------------------------------------
    private Double calcularDesviacionEstandar(Object arg) {
        return Math.sqrt(calcularVarianza(arg));
    }
    
    // -------------------------------------------------------
    // suma: suma de todos los elementos del vector o matriz
    // -------------------------------------------------------
    private Double calcularSuma(Object arg) {
        List<Double> numeros = convertirANumeros(arg);
        if (numeros == null || numeros.isEmpty()) return 0.0;
        
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma;
    }
    
    // -------------------------------------------------------
    // max: valor maximo del vector o matriz
    // -------------------------------------------------------
    private Double calcularMax(Object arg) {
        List<Double> numeros = convertirANumeros(arg);
        if (numeros == null || numeros.isEmpty()) return 0.0;
        
        double max = numeros.get(0);
        for (double num : numeros) {
            if (num > max) max = num;
        }
        return max;
    }
    
    // -------------------------------------------------------
    // min: valor minimo del vector o matriz
    // -------------------------------------------------------
    private Double calcularMin(Object arg) {
        List<Double> numeros = convertirANumeros(arg);
        if (numeros == null || numeros.isEmpty()) return 0.0;
        
        double min = numeros.get(0);
        for (double num : numeros) {
            if (num < min) min = num;
        }
        return min;
    }
    
    // -------------------------------------------------------
    // resumen: aplica todas las funciones estadisticas y devuelve
    // un String con el reporte formateado
    // -------------------------------------------------------
    private String calcularResumen(Object arg) {
        List<Double> numeros = convertirANumeros(arg);
        if (numeros == null || numeros.isEmpty()) {
            return "Resumen: vector vacio o invalido";
        }
        
        double media     = calcularMedia(arg);
        double mediana   = calcularMediana(arg);
        double desvest   = calcularDesviacionEstandar(arg);
        double varianza  = calcularVarianza(arg);
        double minimo    = calcularMin(arg);
        double maximo    = calcularMax(arg);
        double suma      = calcularSuma(arg);
        int    cantidad  = numeros.size();
        
        return String.format(
            "\n RESUMEN ESTADISTICO\n" +
            "  Cantidad  : %d\n"     +
            "  Suma      : %.4f\n"   +
            "  Minimo    : %.4f\n"   +
            "  Maximo    : %.4f\n"   +
            "  Media     : %.4f\n"   +
            "  Mediana   : %.4f\n"   +
            "  Varianza  : %.4f\n"   +
            "  Desv. Est.: %.4f\n"   +
            "===============================",
            cantidad, suma, minimo, maximo, media, mediana, varianza, desvest
        );
    }
}