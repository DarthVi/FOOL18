package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.BoolType;
import type.IType;
import type.IntType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class LessEqualNode implements INode{

    private INode left;
    private INode right;
    private ParserRuleContext ctx;

    public LessEqualNode(INode left, INode right, ParserRuleContext ctx)
    {
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        IType l = left.typeCheck();
        IType r = right.typeCheck();

        if(!(l.isSubtypeOf(new IntType()) && r.isSubtypeOf(new IntType())))
        {
            throw new TypeException("Type error: <= operator allowed only on int", ctx);
        }

        return new BoolType();
    }

    @Override
    public String codeGeneration()
    {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        return left.codeGeneration() +
                right.codeGeneration() +
                "bleq " + l1 + "\n" +
                "push 0\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 1\n" +
                l2 + ":\n";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        //TODO
        return null;
    }
}
