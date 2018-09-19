package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.IType;

public class MemberNode extends FormalParamNode
{
    public MemberNode(String id, IType type, int offset, ParserRuleContext ctx)
    {
        super(id, type, offset, true, ctx);
    }

    @Override
    public String toString()
    {
        return "Function parameter " + super.type + " " + super.id;
    }

    public FOOLParser.ArgdecContext getCtx()
    {
        return (FOOLParser.ArgdecContext) super.ctx;
    }
}
