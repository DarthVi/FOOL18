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

import java.util.ArrayList;

public class IdNode implements INode
{
    //TODO: aggiornarla per farla funzionare con classi e oggetti

    private String varName;
    private STentry entry;
    private int nestingLevel;
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
            throw new TypeException("cannot call function without parentheses surrounding arguments (if any)", ctx);

        return entry.getType();
    }

    @Override
    public String codeGeneration()
    {
        String getAR="";
        for (int i=0; i<nestingLevel-entry.getNestingLevel(); i++)
            getAR+="lw\n";
        return "push "+entry.getOffset()+"\n"+ //metto offset sullo stack
                "lfp\n"+getAR+ //risalgo la catena statica
                "add\n"+
                "lw\n"; //carico sullo stack il valore all'indirizzo ottenuto
    }

    @Override
    public String toString(){
        return null;
    }


    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
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
            this.nestingLevel = env.getNestingLevel();
        }
        catch (UndeclaredVariableException e)
        {
            res.add(new SemanticError("Error: undeclared variable"));
        }

        return res;
    }
}
