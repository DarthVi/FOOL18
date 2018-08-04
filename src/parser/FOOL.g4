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
  
prog:  exp SEMIC | LET decs IN (exp | stats) SEMIC ;

decs:   (vardec SEMIC | fundec)+ ;

vardec: type ID (ASM exp)?;

varasm: ID ASM exp ;

fundec: type ID LPAR (args)? RPAR fbody SEMIC ;

fbody:  exp | stats | LET (vardec)+ IN (exp | stats) ;

args:   vardec (COMMA vardec)* ;

type:   INT | BOOL | VOID ;

exp    :  ('-')? left=term ((PLUS | MINUS) right=exp)?
      ;

term   : left=factor ((TIMES | DIV) right=term)?
      ;

factor : left=value (EQ right=value)?
      ;

value  :  INTEGER                           #intVal
      | ( TRUE | FALSE )                   #boolVal
      | LPAR exp RPAR                      #baseExp
      | IF cond=exp THEN CLPAR thenBranch=exp CRPAR ELSE CLPAR elseBranch=exp CRPAR  #ifExp
      | ID                                             #varExp
      | ID ( LPAR (exp (COMMA exp)* )? RPAR )?         #funExp
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
PRINT : 'print' ;
LET    : 'let' ;
IN     : 'in' ;
VAR    : 'var' ;
FUN    : 'fun' ;
INT    : 'int' ;
BOOL   : 'bool' ;
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




 //VERY SIMPLISTIC ERROR CHECK FOR THE LEXING PROCESS, THE OUTPUT GOES DIRECTLY TO THE TERMINAL
 //THIS IS WRONG!!!!
ERR     : . { errors.add("Invalid char: " + getText());} -> channel(HIDDEN) ;
//  ERR     : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN);
