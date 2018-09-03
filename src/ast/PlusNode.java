package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import util.Environment;
import util.SemanticError;
import type.IntType;

import java.util.ArrayList;

public class PlusNode implements INode {

    private INode left;
    private INode right;
    private ParserRuleContext ctx;

    public PlusNode (INode l, INode r, ParserRuleContext ctx) {
        left=l;
        right=r;
        this.ctx = ctx;
    }


    @Override
    public IType typeCheck() throws TypeException {

        if (!(left.typeCheck().isSubtypeOf(new IntType()) && right.typeCheck().isSubtypeOf(new IntType())))
        {
            throw new TypeException("+ operator allowed only between int values", ctx);
        }

        return new IntType();
    }


    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null; //TO DO
    }

    @Override
    public String codeGeneration() {
        return left.codeGeneration() +
                right.codeGeneration() +
                "add\n";
    }

}

