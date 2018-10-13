package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.IType;

public class MemberNode extends FormalParamNode
{
    public MemberNode(String id, IType type, ParserRuleContext ctx)
    {
        super(id, type, true, ctx);
    }

    public MemberNode(FormalParamNode fn)
    {
        super(fn.id, fn.type, fn.isAttribute, fn.ctx);
    }

    @Override
    public String toString()
    {
        return "Class attribute " + super.type + " " + super.id;
    }

    public FOOLParser.ArgdecContext getCtx()
    {
        return (FOOLParser.ArgdecContext) super.ctx;
    }

    public IType getType()
    {
        return this.type;
    }
}
