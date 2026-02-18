grammar Expr;

prog: (stat NEWLINE)* EOF ;

stat
    : ID '=' expr          #Assign
    | expr                 #PrintExpr
    ;

expr
    : expr ('*'|'/') expr  #MultDiv
    | expr ('+'|'-') expr  #AddSub
    | NUMBER               #Number
    | ID                   #Id
    | '(' expr ')'         #Parens
    ;

NEWLINE : [\r\n]+ ;
NUMBER  : [0-9]+ ('.' [0-9]+)? ;
ID      : [a-zA-Z]+ ;
WS      : [ \t]+ -> skip ;