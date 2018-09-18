package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class PrintNode implements INode
{
    private INode exp;
    private ParserRuleContext ctx;

    public PrintNode(INode exp, ParserRuleContext ctx)
    {
        this.exp = exp;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        //we must call the typecheck of the expression we want to print
        exp.typeCheck();

        //the print itself returns void as decided during language design
        return new VoidType();
    }

    @Override
    public String codeGeneration()
    {
        return exp.codeGeneration() + "print\n";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        errors.addAll(exp.checkSemantics(env));

        return errors;
    }

    @Override
    public String toString()
    {
        return "{PrintNode: " + exp.toString() + "}";
    }
}
