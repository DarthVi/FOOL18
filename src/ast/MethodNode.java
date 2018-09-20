package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;

import java.util.ArrayList;

public class MethodNode extends FunctionNode
{
    public MethodNode(String id, IType type, ArrayList<FormalParamNode> params, ArrayList<INode> decs, INode body, ParserRuleContext ctx)
    {
        super(id, type, params, decs, body, ctx);
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

    //TODO: see what's to override among codegen, checksemantics and typecheck
}
