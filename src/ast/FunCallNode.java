package ast;

import exception.TypeException;
import exception.UndefinedFunctionException;
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

public class FunCallNode implements INode
{
    private Token token;
    private String id;
    private ActualParamsNode actualArgs;
    private STentry entry;
    private int nestingLevel;
    private ParserRuleContext ctx;
    int extra;                      // extra = 1 id preceded by '-', extra = 2 id preceded by 'not', extra = 0 there aren't both

    public FunCallNode(Token token, ActualParamsNode actualArgs, ParserRuleContext ctx)
    {
        this.token = token;
        this.id = token.getText();
        this.actualArgs = actualArgs;
        this.entry = null;
        this.ctx = ctx;

        if (ctx.getChild(0).toString().equalsIgnoreCase( "-")) extra = 1;
        else if ((ctx.getChild(0).toString().equalsIgnoreCase( "not"))) extra = 2;
        else extra = 0;

    }

    @Override
    public IType typeCheck() throws TypeException
    {
        FunctionType funType;
        //we must check that we are actually calling a function
        if(!(entry.getType() instanceof FunctionType))
        {
            throw new TypeException("The object called is not a function.", ctx);
        }
        else
        {
            funType = (FunctionType) entry.getType();

            actualArgs.typeCheck();

            if(actualArgs.size() != funType.getArgumentListSize())
                throw new TypeException("Wrong number of arguments.", ctx);

            //we must check that the actual arguments are of the right type
            //(the one that follows the function declaration)
            for(int i = 0; i < actualArgs.size(); i++)
            {
                INode arg = actualArgs.get(i);

                if(!arg.typeCheck().isSubtypeOf(funType.getArgumentType(i)))
                    throw new TypeException("Argument " + (i + 1) + " has an incorrect type.",ctx);
            }
        }


        if (extra == 1 &&!(((FunctionType) entry.getType()).getReturnType().isSubtypeOf(new IntType())))
        {

            throw new TypeException("- operator allowed only for int value", ctx);
        }

        if (extra == 2 &&!(((FunctionType) entry.getType()).getReturnType().isSubtypeOf(new BoolType())))
        {
            throw new TypeException("not operator allowed only for bool value", ctx);
        }

        return funType.getReturnType();
    }

    @Override
    public String codeGeneration() {
        StringBuilder parCode = new StringBuilder();
        for (int i = actualArgs.size() - 1; i >= 0; i--)
            parCode.append(actualArgs.get(i).codeGeneration());

        StringBuilder getAR = new StringBuilder();
        for (int i = 0; i < nestingLevel - entry.getNestingLevel()-1; i++)
            getAR.append("lw\n");

        String s = "lfp\n" + //CL
                parCode +
                "lfp\n" + getAR + //setto AL risalendo la catena statica
                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack
                "push " + entry.getOffset() + "\n" + //metto offset sullo stack
                "lfp\n" + getAR + //risalgo la catena statica
                "add\n" +
                "lw\n" + //carico sullo stack il valore all'indirizzo ottenuto
                "js\n";
        if(extra==1) s="push 0\n" + s +"sub\n";
        else if(extra==2) s="push 1\n" + s +"sub\n";
        return s;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();
        try {
            entry = env.getFunEntry(token);
        } catch (UndefinedFunctionException e) {
            errors.add(new SemanticError(e.getMessage()));
        }
        nestingLevel = env.getNestingLevel();
        errors.addAll(actualArgs.checkSemantics(env));
        return errors;
    }

    @Override
    public String toString()
    {
        return "Called " + entry.getType().toString() + "\n";
    }
}
