package ast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import antlr.FOOLParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.SemanticError;
import  ast.*;


public class FoolVisitorImpl extends antlr.FOOLBaseVisitor<INode> {

    public INode visitExp(FOOLParser.ExpContext ctx) {
        if(ctx.right == null){
            return visit(ctx.left);
        }else{
            if(ctx.getChild(1).toString().contains("-")) {return new MinusNode(visit(ctx.left), visit(ctx.right));}
            else return new PlusNode(visit(ctx.left), visit(ctx.right));
        }
    }

    @Override
    public INode visitTerm(FOOLParser.TermContext ctx) {
        return visit(ctx.left);
    }


    @Override
    public INode visitFactor(FOOLParser.FactorContext ctx) {

        INode res = visit( ctx.left );
        return  res;
    }


    @Override
    public INode visitIntVal(FOOLParser.IntValContext ctx) {
        return new IntNode(Integer.parseInt(ctx.INTEGER().getText()));
    }



    @Override
    public INode visitIfExp(FOOLParser.IfExpContext ctx) {
        INode cond = visit(ctx.cond);
        INode th = visit(ctx.thenBranch);
        INode el = visit(ctx.elseBranch);
        return new IfNode(cond, th, el);
    }



    @Override
    public INode visitBoolVal(FOOLParser.BoolValContext ctx) {
        return new BoolNode(Boolean.parseBoolean(ctx.getText()));
    }

}

