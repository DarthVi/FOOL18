package ast;

import exception.TypeException;
import exception.UndeclaredVariableException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import parser.FOOLParser;
import type.BoolType;
import type.FunctionType;
import type.IType;
import type.IntType;
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
    int extra;                      // extra = 1 id preceded by '-', extra = 2 id preceded by 'not', extra = 0 there aren't both

    public IdNode(String varName, ParserRuleContext ctx)
    {
        this.varName = varName;
        this.entry = null;
        this.ctx = ctx;
        if (ctx.getChild(0).toString().equalsIgnoreCase( "-")) extra = 1;
        else if ((ctx.getChild(0).toString().equalsIgnoreCase( "not"))) extra = 2;
        else extra = 0;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        if(entry.getType() instanceof FunctionType)
            throw new TypeException("cannot call function without parentheses surrounding arguments (if any)", ctx);

        if (extra == 1 &&!(entry.getType().isSubtypeOf(new IntType())))
        {
            throw new TypeException("- operator allowed only for int value", ctx);
        }

        if (extra == 2 &&!(entry.getType().isSubtypeOf(new BoolType())))
        {
            throw new TypeException("not operator allowed only for bool value", ctx);
        }

         return entry.getType();
    }

    @Override
    public String codeGeneration()

    {

        String s;

        String getAR="";
        for (int i=0; i<nestingLevel-entry.getNestingLevel(); i++)  getAR+="lw\n";

        if(entry.isAttribute())
        {
            //TODO: controllare che basti avere l'offset dell'entry
           s = "push " + entry.getOffset() + "\n" + // pushing ID's offset
                   "push 0 \n" +       // TODO: check if it works
                   "lfp\n" +
                   "add\n" +
                   "lw\n" +
                   "calchoff\n" +  //this instruction converts the logic offset to the physical one inside the class
                                    //then loads it on the stack
                   "add\n" +
                   "lw\n";//carico sullo stack il valore all'indirizzo ottenuto
        }
        else
        {
            s= "push "+entry.getOffset()+"\n"+ //metto offset sullo stack
                    "lfp\n"+getAR+ //risalgo la catena statica
                    "add\n"+
                    "lw\n"; //carico sullo stack il valore all'indirizzo ottenuto
        }

        if(extra == 1) {
            s ="push 0\n" +
                s +
                "sub \n" ;
        }

        else if(extra == 2)

            s ="push 0\n" +
                    s +
                 "sub \n" ;



        return s;
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
        Token token = ((FOOLParser.VarExpContext) ctx).ID().getSymbol();

        try
        {
            this.entry = env.getEntry(token);
            this.nestingLevel = env.getNestingLevel();
        }
        catch (UndeclaredVariableException e)
        {
            res.add(new SemanticError(e.getMessage()));
        }

        return res;
    }
}
