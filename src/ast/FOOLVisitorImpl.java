package ast;

import parser.FOOLBaseVisitor;
import parser.FOOLParser;

public class FOOLVisitorImpl extends FOOLBaseVisitor<INode>
{

    @Override
    public INode visitType(FOOLParser.TypeContext ctx)
    {
        return new TypeNode(ctx, ctx.getText());
    }

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
        if(FOOLParser.ruleNames[ctx.getParent().getRuleIndex()].equals(FOOLParser.ruleNames[FOOLParser.RULE_classdec]))
            isAttribute = true;

        return new VardecNode(typeNode, ctx.ID().getSymbol().getText(), expression, ctx, isAttribute);
    }

    @Override
    public INode visitIntVal(FOOLParser.IntValContext ctx)
    {
        // notice that this method is not actually a rule but a named production #intVal

        //there is no need to perform a check here, the lexer ensures this text is an int
        return new IntNode(Integer.parseInt(ctx.INTEGER().getText()));
    }

    @Override
    public INode visitNullVal(FOOLParser.NullValContext ctx)
    {
        return new NullNode();
    }

    @Override
    public INode visitVoidExp(FOOLParser.VoidExpContext ctx)
    {
        return new VoidNode();
    }

    @Override
    public INode visitBoolVal(FOOLParser.BoolValContext ctx)
    {
        boolean value;

        /*
         * if we do not have the "not" prefix, we can simply get the boolean value.
         * Otherwise we must convert the value into the opposite one (true to false and false to true).
         *
         * We can do this by checking if the booleanVal text is equal to the literal name chosen for the TRUE token.
         * If that's the case, we have "not true", which must be transformed in false. Likewise if we have "not false",
         * we must transform it in true. For this reason the assignment expression in the else branch has a "!"
         */
        if(ctx.optionalNot == null)
            value = Boolean.parseBoolean(ctx.booleanVal.getText());
        else
            value = !ctx.booleanVal.getText().equals(FOOLParser.VOCABULARY.getLiteralName(FOOLParser.TRUE));

        return new BoolNode(value);
    }

    //TODO: altri visitor
}
