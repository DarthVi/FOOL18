package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.FunctionType;
import type.IType;

import java.util.ArrayList;

public class MethodNode extends FunctionNode
{
    public MethodNode(String id, IType type, ArrayList<FormalParamNode> params, ArrayList<INode> decs,
                      INode body, ParserRuleContext ctx)
    {
        super(id, type, params, decs, body, ctx);
    }

    public MethodNode(FunctionNode fn)
    {
        super(fn.id, fn.decReturnType, fn.params, fn.decs, fn.body, fn.ctx);
        this.fType = fn.fType;
    }

    public String getId()
    {
        return this.id;
    }

    @Override
    public boolean equals(Object obj)
    {
        return (obj instanceof MethodNode && this.id.equals(((MethodNode) (obj)).id));
    }

    public IType getDeclaredReturnType()
    {
        return this.decReturnType;
    }


    public FunctionType getFunctionType()
    {
        ArrayList<IType> paramTypes = new ArrayList<>();

        for (FormalParamNode param : params)
        {
            paramTypes.add(param.getType());
        }

        return new FunctionType(decReturnType, paramTypes);
    }

    public ParserRuleContext getCtx()
    {
        return this.ctx;
    }


    //TODO: see what's to override among codegen, checksemantics and typecheck
}
