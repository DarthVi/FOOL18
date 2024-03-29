package ast;

import exception.TypeException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import type.BoolType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class DiseqNode implements INode
{
    private INode left;
    private INode right;
    private ParserRuleContext ctx;

    public DiseqNode( INode left, INode right, ParserRuleContext ctx) {
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        IType leftType = left.typeCheck();
        IType rightType = left.typeCheck();

        if(!(leftType.isSubtypeOf(rightType) || rightType.isSubtypeOf(leftType)))
        {
            throw new TypeException("Incompatible types in equal", ctx);
        }

        return new BoolType();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        errors.addAll(left.checkSemantics(env));
        errors.addAll(right.checkSemantics(env));
        return errors;
    }

    @Override
    public String codeGeneration() {
            String l1 = FOOLlib.freshLabel();
            String l2 = FOOLlib.freshLabel();
            return  left.codeGeneration() +
                    right.codeGeneration() +
                    "beq " + l1 + "\n" +
                    "push 1\n" +
                    "b " + l2 + "\n" +
                    l1 + ":\n" +
                    "push 0\n" +
                    l2 + ":\n";
    }

    @Override
    public String toString()
    {
        return "Diseq" + left.toString() + right.toString();
    }
}
