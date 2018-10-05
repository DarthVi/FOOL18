grammar FOOL;

@header {
    import java.util.ArrayList;
}

@lexer::members {
   public ArrayList<String> errors = new ArrayList<>();
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog   : exp SEMIC                                  #singleExp
       | let (exp SEMIC | stats)                    #letInExp
       | classdec+ (let (exp SEMIC | stats))?       #classdecExp
       ;

let       : LET dec+ IN ;

vardec  : type ID (ASM exp)? SEMIC;

argdec : type ID;

funlet  : LET vardec+ IN ;

varasm     : ID ASM exp ;

// funlet serve ad evitare di usare let, il quale permetterebbe di avere funzioni annidate
fun    : type ID LPAR ( argdec ( COMMA argdec)* )? RPAR (funlet)? (exp SEMIC | stats) ;

dec   : vardec           #varDeclaration
      | fun              #funDeclaration
      ;

classdec    : CLASS ID (EXTENDS ID)? (LPAR argdec (SEMIC argdec)* RPAR)?
              (CLPAR fun* CRPAR)? ;


type   :  INT
        | BOOL
        | VOID
        | NULL
        | ID
      ;

exp    : left=term (operator=(PLUS | MINUS) right=exp)? ;


term   : left=factor (operator=(TIMES | DIV) right=term)?
      ;

factor : left=value (operator=(EQ | GREATER | LQ | GQ | AND | OR | DEQ) right=value)?
      ;

value  : (MINUS)?  INTEGER                                        #intVal
      | optionalNot=NOT? booleanVal=( TRUE | FALSE )            #boolVal
      | NULL                                                    #nullVal
      | VOID                                                    #voidExp
      | (MINUS | NOT)? LPAR exp RPAR                                    #baseExp
      | IF cond=exp THEN CLPAR thenBranch=exp CRPAR ELSE CLPAR elseBranch=exp CRPAR  #ifExp
      | (MINUS| NOT)? ID                                             #varExp
      | (MINUS| NOT)? ID ( LPAR (exp (COMMA exp)* )? RPAR )?         #funExp
      | NEW ID LPAR (exp (COMMA exp)* )? RPAR                        #objInst
      | (MINUS| NOT)? ID '.' ID LPAR (exp (COMMA exp)*)? RPAR                      #objCall
      ;


stats:  (stat)+ ;

stat:   varasm SEMIC  #varasmStat
        | PRINT LPAR exp RPAR SEMIC #printStat
        | IF cond=exp THEN CLPAR thenBranch=stats CRPAR ELSE CLPAR elseBranch=stats CRPAR   #ifStat
        ;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
SEMIC  : ';' ;
COLON  : ':' ;
COMMA  : ',' ;
EQ     : '==' ;
DEQ    : '!=' ;
LQ     : '<=' ;
GQ     : '>=' ;
GREATER: '>' ;
LESS   : '<' ;
AND    : '&&' ;
OR     : '||' ;
NOT    : 'not' ;
ASM    : '=' ;
PLUS   : '+' ;
MINUS  : '-' ;
TIMES  : '*' ;
DIV    : '/' ;
TRUE   : 'true' ;
FALSE  : 'false' ;
LPAR   : '(' ;
RPAR   : ')' ;
CLPAR  : '{' ;
CRPAR  : '}' ;
IF        : 'if' ;
THEN   : 'then' ;
ELSE   : 'else' ;
PRINT : 'print' ;
LET    : 'let' ;
IN     : 'in' ;
VAR    : 'var' ;
FUN    : 'fun' ;
INT    : 'int' ;
BOOL   : 'bool' ;
CLASS  : 'class' ;
EXTENDS: 'extends' ;
NULL   : 'null';
NEW    : 'new' ;
VOID   : 'void' ;



//Numbers
fragment DIGIT : '0'..'9';
INTEGER       : DIGIT+;

//IDs
fragment CHAR  : 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

//ESCAPED SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS    : '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;




ERR     : . { errors.add("Invalid char: " + getText());} -> channel(HIDDEN) ;
