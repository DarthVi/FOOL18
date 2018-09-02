package ast;

import exception.TypeException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import type.BoolType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class EqualNode implements INode{
    private INode left;
    private INode right;
    private ParserRuleContext ctx;

    public EqualNode( INode left, INode right, ParserRuleContext ctx) {
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException {
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
        return null;
    }

    @Override
     public String codeGeneration() {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        return left.codeGeneration() +
                right.codeGeneration() +
                "beq " + l1 + "\n" +
                "push 0\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 1\n" +
                l2 + ":\n";
    }
}
