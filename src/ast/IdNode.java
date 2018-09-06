package ast;

import exception.TypeException;
import exception.UndeclaredVariableException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import parser.FOOLParser;
import type.FunctionType;
import type.IType;
import util.Environment;
import util.STentry;
import util.SemanticError;
import parser.FOOLParser.VarExpContext;

import java.util.ArrayList;

public class IdNode implements INode
{
    //TODO: completare questa classe

    private String varName;
    private STentry entry;
    //private int nestingLevel;
    ParserRuleContext ctx;

    public IdNode(String varName, ParserRuleContext ctx)
    {
        this.varName = varName;
        this.entry = null;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        if(entry.getType() instanceof FunctionType)
            throw new TypeException("Error: cannot call function without parentheses surrounding arguments (if any)\n", ctx);

        return entry.getType();
    }

    @Override
    public String codeGeneration()
    {
        return null;
    }

    @Override
    public String toString(){
        return null;
    }


    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        //TODO: valutare le alternative e leggere il seguente commento
        /*
         * Se facciamo in modo che in una classe non si possano dichiarare variabili con lo stesso nome dei membri
         * (idem per i metodi), possiamo evitare l'uso di "this" e semplicemente cercare l'ultimo simbolo
         * con la stringa id nella tabella dei simboli relativa allo scope corrente
         */


        ArrayList<SemanticError> res = new ArrayList<>();
        STentry entry = null;
        Token token = ((FOOLParser.VarExpContext) ctx).ID().getSymbol();

        try
        {
            entry = env.getEntry(token);
        }
        catch (UndeclaredVariableException e)
        {
            res.add(new SemanticError("Error: undeclared variable"));
        }

        return res;
    }
}