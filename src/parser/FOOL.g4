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
       | let (exp | stats) SEMIC                    #
       | classdec+ (let? (exp | stats) SEMIC)?      #classdecExp
       ;

let       : LET (dec SEMIC)+ IN ;

vardec  : type ID (ASM exp)?;

funlet  : LET (vardec SEMIC)+ IN ;

varasm     : ID ASM exp ;

// funlet serve ad evitare di usare let, il quale permetterebbe di avere funzioni annidate
fun    : type ID LPAR ( vardec ( COMMA vardec)* )? RPAR (funlet)? (exp | stats)* ;

dec   : vardec           #varDeclaration
      | fun              #funDeclaration
      ;

classdec    : CLASS ID (EXTENDS ID)? (LPAR vardec SEMIC (vardec SEMIC)* RPAR)?
              (CLPAR fun SEMIC (fun SEMIC)* CRPAR)? ;


type   : INTletInExp
        | BOOL
        | VOID
        | NULL
        | ID
      ;

exp    :  ('-')? left=term (operator=(PLUS | MINUS) right=exp)?
      ;

term   : left=factor (operator=(TIMES | DIV) right=term)?
      ;

factor : left=value (operator=(EQ | GREATER | LQ | GQ | AND | OR | DEQ) right=value)?
      ;

value  :  INTEGER                                     #intVal
      | optionalNot=NOT? booleanVal=( TRUE | FALSE )  #boolVal
      | NULL                                          #nullVal
      | VOID                                          #voidExp
      | LPAR exp RPAR                                 #baseExp
      | IF cond=exp THEN CLPAR thenBranch=exp CRPAR ELSE CLPAR elseBranch=exp CRPAR  #ifExp
      | ID                                             #varExp
      | ID ( LPAR (exp (COMMA exp)* )? RPAR )?         #funExp
      | NEW ID LPAR (ID (COMMA ID)* )? RPAR            #objInst
      | ID '.' ID LPAR (ID (COMMA ID)*)? RPAR          #objCall
      ;


stats:  stat (SEMIC stat)* ;

stat:   varasm  #varasmStat
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
//PRINT : 'print' ;
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
