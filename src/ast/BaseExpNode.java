package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.BoolType;
import type.FunctionType;
import type.IType;
import type.IntType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BaseExpNode implements INode {

    private FOOLParser.BaseExpContext ctx;
    private INode exp;
    int extra;                      // extra = 1 id preceded by '-', extra = 2 id preceded by 'not', extra = 0 there aren't both


    public BaseExpNode(FOOLParser.BaseExpContext ctx, INode exp) {
        this.ctx = ctx;
        this.exp = exp;
        if (ctx.getChild(0).toString().equalsIgnoreCase( "-")) extra = 1;
        else if ((ctx.getChild(0).toString().equalsIgnoreCase( "not"))) extra = 2;
        else extra = 0;

    }

    @Override
    public IType typeCheck() throws TypeException {


        if (extra == 1 &&!(exp.typeCheck().isSubtypeOf(new IntType())))
        {
            throw new TypeException("- operator allowed only for int value", ctx);
        }

        if (extra == 2 &&!(exp.typeCheck().isSubtypeOf(new BoolType())))
        {
            throw new TypeException("not operator allowed only for bool value", ctx);
        }

        return exp.typeCheck();
    }

    @Override
    public String codeGeneration() {
        if((ctx.getChild(0).toString().equalsIgnoreCase( "-"))) {
            return "push 0\n" +
                    exp.codeGeneration() +
                    "sub\n";
        }
        String s = exp.codeGeneration();
        if(extra==1) {
            s = "push 0\n" +
                    s +
                    "sub\n";
        }
        if(extra==2) {
            s = "push 1\n" +
                    s +
                    "sub\n";
        }
        return s;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();
        errors.addAll(exp.checkSemantics(env));
        return errors;
    }

    //TODO
}
