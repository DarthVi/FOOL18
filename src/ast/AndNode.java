package ast;
import exception.TypeException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import type.BoolType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class AndNode implements INode
{
    private INode left;
    private INode right;
    private ParserRuleContext ctx;

    public AndNode(INode left, INode right, ParserRuleContext ctx)
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
            throw new TypeException("&& operator works only between booleans", ctx);
        }

        return new BoolType();
    }

    @Override
    public String codeGeneration() {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        String l3 = FOOLlib.freshLabel();
        return  left.codeGeneration()
                + right.codeGeneration()
                + "beq " + l1 + "\n"
                + "push 0\n"
                + "b " + l2 + "\n"
                + l1 + ":\n"
                + left.codeGeneration()
                + "push 1\n"
                + "beq " + l3 + "\n"
                + "push 0\n"
                + "b " + l2 + "\n"
                + l3 + ":\n"
                + "push 1\n"
                + l2 + ":\n";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();
        errors.addAll(left.checkSemantics(env));
        errors.addAll(right.checkSemantics(env));
        return errors;
    }

    @Override
    public String toString()
    {
        return "And" + left.toString() + right.toString();
    }
}
