package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VarNode implements INode{

    private String id;
    private IType type;
    private INode exp;
    private ParserRuleContext ctx;

    public VarNode(String id, IType type, INode exp, ParserRuleContext ctx)
    {
        this.id = id;
        this.type = type;
        this.exp = exp;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        //TODO
        return null;
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
