grammar Milenguaje;

// ---------------- PARSER RULES ----------------

programa
    : sentencia* EOF
    ;

sentencia
    : declaracion
    | asignacion
    | imprimir
    | condicional
    | cicloMientras
    | cicloPara
    | expresion ';'
    ;

declaracion
    : ID '=' expresion ';'
    ;

asignacion
    : ID '=' expresion ';'
    ;

imprimir
    : MOSTRAR '(' expresion ')' ';'
    ;

condicional
    : SI '(' expresion ')' bloque (SINO bloque)?
    ;

cicloMientras
    : MIENTRAS '(' expresion ')' bloque
    ;

cicloPara
    : PARA '(' asignacion expresion ';' asignacion ')' bloque
    ;

bloque
    : '{' sentencia* '}'
    ;

// ----------- EXPRESIONES CON PRECEDENCIA CORRECTA -----------

expresion
    : expresion '||' expresion          #orExpr
    | expresion '&&' expresion          #andExpr
    | '!' expresion                     #notExpr
    | expresion ('=='|'!='|'<'|'>'|'<='|'>=') expresion  #relExpr
    | expresion ('+'|'-') expresion     #addExpr
    | expresion ('*'|'/'|'%') expresion #mulExpr
    | expresion '^' expresion           #powExpr
    | funcion                           #funcExpr
    | vector                            #vectorExpr
    | matriz                            #matrizExpr
    | '(' expresion ')'                 #parenExpr
    | NUMERO                            #numExpr
    | DECIMAL                           #decExpr
    | CADENA                            #stringExpr
    | BOOLEANO                          #boolExpr
    | ID                                #idExpr
    ;

// ----------- ESTRUCTURAS -----------

vector
    : '[' listaExpresiones? ']'
    ;

matriz
    : '[' vector (',' vector)+ ']'
    ;

listaExpresiones
    : expresion (',' expresion)*
    ;

funcion
    : MEDIA '(' expresion ')'
    | MEDIANA '(' expresion ')'
    | DESVEST '(' expresion ')'
    | VARIANZA '(' expresion ')'
    | MIN '(' expresion ')'
    | MAX '(' expresion ')'
    | SUMA '(' expresion ')'
    | RESUMEN '(' expresion ')'
    ;

// ---------------- LEXER RULES ----------------

// Palabras reservadas

SI : 'si';
SINO : 'sino';
MIENTRAS : 'mientras';
PARA : 'para';
MOSTRAR : 'mostrar';

MEDIA : 'media';
MEDIANA : 'mediana';
DESVEST : 'desvest';
VARIANZA : 'varianza';
MIN : 'min';
MAX : 'max';
SUMA : 'suma';
RESUMEN : 'resumen';

// Booleanos

BOOLEANO
    : 'verdadero'
    | 'falso'
    ;

// Identificadores

ID
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

// Números

DECIMAL
    : [0-9]+ '.' [0-9]+
    ;

NUMERO
    : [0-9]+
    ;

// Cadenas (mejorado)

CADENA
    : '"' (~["\r\n])* '"'
    ;

// Espacios

WS
    : [ \t\r\n]+ -> skip
    ;