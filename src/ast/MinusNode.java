package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import type.IntType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class MinusNode implements INode {

    private INode left;
    private INode right;
    private ParserRuleContext ctx;

    public MinusNode (INode l, INode r, ParserRuleContext ctx) {
        left=l;
        right=r;
        this.ctx = ctx;
    }


    @Override
    public IType typeCheck() throws TypeException {
        if (!(left.typeCheck().isSubtypeOf(new IntType()) && right.typeCheck().isSubtypeOf(new IntType())))
        {
            throw new TypeException("- operator allowed only between int values", ctx);
        }

        return new IntType();
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
        return left.codeGeneration() +
                right.codeGeneration() +
                "sub\n";
    }

    @Override
    public String toString()
    {
        return "Minus" + left.toString() + right.toString();
    }
}
