package ast;

import parser.FOOLBaseVisitor;
import parser.FOOLParser;

public class FollVisitorImpl extends FOOLBaseVisitor<INode>
{

    @Override
    public INode visitVardec(FOOLParser.VardecContext ctx)
    {
        VardecNode vardecNode;

        TypeNode typeNode = (TypeNode) visit(ctx.type());
        INode expression = null;
        boolean isAttribute = false;

        if(!ctx.exp().isEmpty())
            expression = visit(ctx.exp());

        //if the variable declaration is inside a class, it is a member declaration,
        //so we must set the isAttribute property
        if(ctx.getParent().getRuleIndex() == FOOLParser.RULE_classdec)
            isAttribute = true;

        return new VardecNode(typeNode, ctx.ID().getSymbol().getText(), expression, ctx, isAttribute);
    }
}
