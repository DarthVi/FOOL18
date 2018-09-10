package ast;

import exception.TypeException;
import exception.UndefinedFunctionException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import parser.FOOLParser;
import type.FunctionType;
import type.IType;
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

    public FunCallNode(Token token, ActualParamsNode actualArgs, ParserRuleContext ctx)
    {
        this.token = token;
        this.id = token.getText();
        this.actualArgs = actualArgs;
        this.entry = null;
        this.ctx = ctx;
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

            //we must check that the actual arguments are of the right type
            //(the one that follows the function declaration)
            for(int i = 0; i < actualArgs.size(); i++)
            {
                INode arg = actualArgs.get(i);

                if(!arg.typeCheck().isSubtypeOf(funType.getArgumentType(i)))
                    throw new TypeException("Argument " + (i + 1) + " has an incorrect type.",ctx);
            }
        }

        return funType.getReturnType();
    }

    @Override
    public String codeGeneration() {
        StringBuilder parCode = new StringBuilder();
        for (int i = actualArgs.size() - 1; i >= 0; i--)
            parCode.append(actualArgs.get(i).codeGeneration());

        StringBuilder getAR = new StringBuilder();
        for (int i = 0; i < nestingLevel - entry.getNestingLevel(); i++)
            getAR.append("lw\n");

        return "lfp\n" + //CL
                parCode +
                "lfp\n" + getAR + //setto AL risalendo la catena statica
                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack
                "push " + entry.getOffset() + "\n" + //metto offset sullo stack
                "lfp\n" + getAR + //risalgo la catena statica
                "add\n" +
                "lw\n" + //carico sullo stack il valore all'indirizzo ottenuto
                "js\n";
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
        return super.toString();
    }
}
