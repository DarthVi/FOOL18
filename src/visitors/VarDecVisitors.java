package visitors;

import ast.INode;
import ast.TypeNode;
import ast.VardecNode;
import lib.FOOLlib;
import parser.FOOLBaseVisitor;
import parser.FOOLParser;

public class VarDecVisitors extends FOOLBaseVisitor<INode> {

    @Override
    public INode visitVardec(FOOLParser.VardecContext ctx)
    {
        FOOLlib.increaseNumberDeclaration();
        return null;
    }

    @Override
    public INode visitFun(FOOLParser.FunContext ctx) {
        System.out.println(ctx.getParent().getParent().getRuleIndex());

        //in order to find only functions without methods
        if(FOOLParser.ruleNames[ctx.getParent().getParent().
                getRuleIndex()].equals(FOOLParser.ruleNames[FOOLParser.RULE_let]))
            FOOLlib.increaseNumberDeclaration();

        return null;
    }
}
