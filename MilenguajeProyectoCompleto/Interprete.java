import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.nio.file.*;

public class Interprete {
    
    public static void main(String[] args) {
        if (args.length < 1) {//si no hay nada escrito
            
            System.out.println("Uso: java Interprete <archivo_fuente>");
            System.out.println("   o: java Interprete -ast <archivo> (solo mostrar AST)");
            return;
        }
        
        boolean soloAST = false;
        String archivo;
        
        if (args[0].equals("-ast")) {
            soloAST = true;
            if (args.length < 2) {
                System.out.println("Error: Falta especificar archivo");
                return;
            }
            archivo = args[1];
        } else {
            archivo = args[0];
        }
        
        try {
            String codigo = new String(Files.readAllBytes(Paths.get(archivo)));
            
            CharStream input = CharStreams.fromString(codigo);
            MilenguajeLexer lexer = new MilenguajeLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MilenguajeParser parser = new MilenguajeParser(tokens);
            
            ErrorListener errorListener = new ErrorListener();
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            
            System.out.println("=== ANALIZANDO PROGRAMA ===\n");
            ParseTree tree = parser.programa();
            
            if (errorListener.hayErrores()) {
                System.out.println("ERRORES SINTACTICOS ENCONTRADOS!");
                for (String error : errorListener.getErrores()) {
                    System.out.println("  " + error);
                }
                return;
            }
            
            System.out.println(" Analisis sintactico exitoso\n");
            
            if (soloAST) {
                System.out.println("=== ARBOL DE SINTAXIS ===");
                System.out.println(tree.toStringTree(parser));
                return;
            }
            
            System.out.println("=== EJECUTANDO PROGRAMA ===\n");
            Evaluador evaluador = new Evaluador();
            
            try {
                evaluador.visit(tree);
                
                if (evaluador.hayErrores()) {
                    System.out.println("\nERRORES SEMANTICOS ENCONTRADOS!");
                    for (String error : evaluador.getErrores()) {
                        System.out.println("  " + error);
                    }
                } else {
                    System.out.println("\n Programa ejecutado exitosamente");
                }
                
            } catch (Exception e) {
                System.out.println("\nERROR EN TIEMPO DE EJECUCION");
                System.out.println("  " + e.getMessage());
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado - " + archivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}