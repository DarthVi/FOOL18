package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.BoolType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class OrNode implements INode
{
    private INode left;
    private INode right;
    private ParserRuleContext ctx;

    public OrNode(INode left, INode right, ParserRuleContext ctx)
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

        if(!(l.isSubtypeOf(new BoolType()) && r.isSubtypeOf((new BoolType()))))
        {
            throw new TypeException("Type error: AND operator works only between booleans", ctx);
        }

        return new BoolType();
    }

    @Override
    public String codeGeneration()
    {
        //TODO
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        //TODO
        return null;
    }
}
