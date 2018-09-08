package ast;

import exception.TypeException;
import exception.UndefinedFunctionException;
import org.antlr.v4.runtime.Token;
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

    public FunCallNode(Token token, ActualParamsNode actualArgs, STentry entry)
    {
        this.token = token;
        this.id = token.getText();
        this.actualArgs = actualArgs;
        this.entry = entry;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        return null;
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
            STentry entry = env.getFunEntry(token);
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
