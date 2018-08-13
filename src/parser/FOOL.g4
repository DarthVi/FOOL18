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
       | let (exp | stats) SEMIC                    #letInExp
       | classdec+ (let? (exp | stats) SEMIC)?      #classdecExp
       ;

let       : LET (dec SEMIC)+ IN ;

vardec  : type ID (ASM exp)?;

funlet  : LET (vardec SEMIC)+ IN ;

varasm     : ID ASM exp ;

// funlet serve ad evitare di usare let, il quale permetterebbe di avere funzioni annidate
fun    : type ID LPAR ( vardec ( COMMA vardec)* )? RPAR (funlet)? (exp | stats) ;

dec   : vardec           #varDeclaration
      | fun              #funDeclaration
      ;

classdec    : CLASS ID (EXTENDS ID (COMMA ID)*)? (LPAR vardec SEMIC (vardec SEMIC)* RPAR)?
              (CLPAR fun SEMIC (fun SEMIC)* CRPAR)? ;


type   : INT
        | BOOL
      ;

exp    :  ('-')? left=term ((PLUS | MINUS) right=exp)?
      ;

term   : left=factor ((TIMES | DIV) right=term)?
      ;

factor : left=value (EQ right=value)?
      ;

value  :  INTEGER                          #intVal
      | ( TRUE | FALSE )                   #boolVal
      | NULL                               #nullVal
      | VOID                               #voidExp
      | LPAR exp RPAR                      #baseExp
      | IF cond=exp THEN CLPAR thenBranch=exp CRPAR ELSE CLPAR elseBranch=exp CRPAR  #ifExp
      | ID                                             #varExp
      | ID ( LPAR (exp (COMMA exp)* )? RPAR )?         #funExp
      | NEW ID LPAR (ID (COMMA ID)* )? RPAR            #objInst
      | ID '.' ID LPAR (ID (COMMA ID)*)? RPAR          #objCall
      ;


stats:  stat (COMMA stat)* ;

stat:   varasm | IF cond=exp THEN CLPAR thenBranch=stats CRPAR ELSE CLPAR elseBranch=stats CRPAR ;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
SEMIC  : ';' ;
COLON  : ':' ;
COMMA  : ',' ;
EQ     : '==' ;
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
