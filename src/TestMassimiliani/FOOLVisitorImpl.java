package TestMassimiliani;

import ast.*;
import exception.FunctionAlreadyDefinedException;
import org.antlr.runtime.tree.Tree;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.FOOLBaseVisitor;
import parser.FOOLLexer;
import parser.FOOLParser;
import type.FunctionType;
import type.IType;
import util.SemanticError;

import java.util.ArrayList;
import java.util.function.Function;

public class FOOLVisitorImpl extends FOOLBaseVisitor<INode>
{

    @Override
    public INode visitType(FOOLParser.TypeContext ctx)
    {
        System.out.println("TypeNode   (" + ctx.getText() + ")");
        return new TypeNode(ctx, ctx.getText());
    }

    @Override
    public INode visitVardec(FOOLParser.VardecContext ctx)
    {
        VardecNode vardecNode;
        System.out.println("VarDecNode   (" + ctx.getText() + ")");

        TypeNode typeNode = (TypeNode) visit(ctx.type());
        INode expression = null;
        boolean isAttribute = false;

        if(ctx.exp() != null)
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
        System.out.println("IntNode   (" + ctx.getText() + ")");
        return new IntNode(Integer.parseInt(ctx.INTEGER().getText()));
    }

    @Override
    public INode visitNullVal(FOOLParser.NullValContext ctx)
    {
        System.out.println("NullNode   (" + ctx.getText() + ")");
        return new NullNode();
    }

    @Override
    public INode visitVoidExp(FOOLParser.VoidExpContext ctx)
    {
        System.out.println("VoidNode (" + ctx.getText() + ")");
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

        System.out.println("BoolNode   (" + ctx.getText() + ")");
        return new BoolNode(value);
    }

    private INode visitIf(ParserRuleContext ctx)
    {
        IfNode res;
        INode condExp;
        INode thenBranch;
        INode elseBranch;

        System.out.println("IfNode   (" + ctx.getText() + ")");


        if(ctx instanceof FOOLParser.IfExpContext)
        {
            condExp = visit (((FOOLParser.IfExpContext) ctx).cond);

            thenBranch = visit (((FOOLParser.IfExpContext) ctx).thenBranch);

            elseBranch = visit (((FOOLParser.IfExpContext) ctx).elseBranch);
        }
        else //FOOLParser.IfStatContext
        {
            condExp = visit (((FOOLParser.IfStatContext) ctx).cond);

            thenBranch = visit (((FOOLParser.IfStatContext) ctx).thenBranch);

            elseBranch = visit (((FOOLParser.IfStatContext) ctx).elseBranch);
        }


        res = new IfNode(condExp, thenBranch, elseBranch, ctx);

        return res;
    }

    @Override
    public INode visitIfExp(FOOLParser.IfExpContext ctx)
    {
        return visitIf(ctx);
    }

    @Override
    public INode visitIfStat(FOOLParser.IfStatContext ctx)
    {
        return visitIf(ctx);
    }

    @Override
    public INode visitArgdec(FOOLParser.ArgdecContext ctx)
    {
        FormalParamNode param;
        System.out.println("FormalParamNode   (" + ctx.getText() + ")");
        TypeNode typeNode = (TypeNode) visitType(ctx.type());

        //offset -2 in the AR (same as variable declared inside the function scope)
        //isAttribute = false because it is not relevant in this case to discriminate variables from members
        //TODO: controllare che questo offset funzioni

        return new FormalParamNode(ctx.ID().getSymbol().getText(), typeNode.getType(), -2,
                false, ctx);
    }





    @Override
    public INode visitFun(FOOLParser.FunContext ctx)
    {
      System.out.println("FunctionNode   (" + ctx.getText() + ")");



        INode type = visitType(ctx.type());
        IType retType = ((TypeNode) type).getType();

        String funName= ctx.ID().getSymbol().getText();
        ArrayList<FormalParamNode> params = new ArrayList<>();
        ArrayList<INode> declarations = new ArrayList<>();

        for(FOOLParser.ArgdecContext argdecContext : ctx.argdec())
        {
            FormalParamNode param = (FormalParamNode) visitArgdec(argdecContext);
            params.add(param);
        }

        for(FOOLParser.VardecContext vc : ctx.funlet().vardec())
        {
            INode param = visitVardec(vc);
            declarations.add(param);
        }

        INode body;

        if(ctx.exp().isEmpty())
            body = visit(ctx.stats());
        else
            body = visit(ctx.exp());


        return new FunctionNode(funName, retType, params, declarations, body, ctx);

    }


    @Override
    public INode visitFunExp(FOOLParser.FunExpContext ctx) {

        System.out.println("FunCallNode   (" + ctx.getText() + ")");
        //this corresponds to a function invocation
        //        //declare the result
        INode res;
        String functionID;
        //get the invocation arguments
        ArrayList<INode> args = new ArrayList<INode>();

        for (FOOLParser.ExpContext exp : ctx.exp())
            args.add(visit(exp));

        functionID = ctx.ID().getText();


        res = new FunCallNode(ctx.ID().getSymbol(), new ActualParamsNode(args), ctx);

        return res;
    }


    @Override
    public INode visitFactor(FOOLParser.FactorContext ctx) {
        try {
            if (ctx.right == null) {
                //it is a simple expression
                return visit(ctx.left);
            } else {
                //it is a binary expression, you should visit left and right
                INode left, right;

                switch (ctx.operator.getType()) {
                    case FOOLLexer.EQ:
                        System.out.println("EqualNode   (" + ctx.getText() + ")");
                        left = visit(ctx.left);
                        right = visit(ctx.right);
                        return new EqualNode(left, right, ctx);
                    case FOOLLexer.LQ:
                        System.out.println("LessEqualNode   (" + ctx.getText() + ")");
                        left = visit(ctx.left);
                        right = visit(ctx.right);
                        return new LessEqualNode(left, right, ctx);
                    case FOOLLexer.GQ:
                        System.out.println("GreaterEqualNode   (" + ctx.getText() + ")");
                        left = visit(ctx.left);
                        right = visit(ctx.right);
                        return new GreaterEqualNode(left, right, ctx);
                    case FOOLLexer.AND:
                        System.out.println("AndNode   (" + ctx.getText() + ")");
                        left = visit(ctx.left);
                        right = visit(ctx.right);
                        return new AndNode(left, right, ctx);
                    case FOOLLexer.GREATER:
                        System.out.println("GreaterNode   (" + ctx.getText() + ")");
                        left = visit(ctx.left);
                        right = visit(ctx.right);
                        return new GreaterNode(left, right, ctx);
                    case FOOLLexer.LESS:
                        System.out.println("LessNode   (" + ctx.getText() + ")");
                        left = visit(ctx.left);
                        right = visit(ctx.right);
                        return new LessNode(left, right, ctx);
                    case FOOLLexer.OR:
                        System.out.println("OrNode   (" + ctx.getText() + ")");
                        left = visit(ctx.left);
                        right = visit(ctx.right);
                        return new OrNode(left, right, ctx);
                    case FOOLLexer.DEQ:
                        System.out.println("DiseqNode   (" + ctx.getText() + ")");
                        left = visit(ctx.left);
                        right = visit(ctx.right);
                        return new DiseqNode(left, right, ctx);
                    default:
                        throw new Exception("Invalid operator");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public INode visitVarExp(FOOLParser.VarExpContext ctx) {
        System.out.println("IdNode   (" + ctx.getText() + ")");
        return new IdNode(ctx.ID().getText(), ctx);
    }

    @Override
    public INode visitExp(FOOLParser.ExpContext ctx) {
        if (ctx.right == null) {
            return visit(ctx.left);
        } else {
            INode left, right;
            if (ctx.operator.getType() == FOOLLexer.PLUS) {
                System.out.println("PlusNode   (" + ctx.getText() + ")");
                left = visit(ctx.left);
                right = visit(ctx.right);
                return new PlusNode(left, right, ctx);
            } else {
                System.out.println("MinusNode   (" + ctx.getText() + ")");
                left = visit(ctx.left);
                right = visit(ctx.right);
                return new MinusNode(left, right, ctx);
            }
        }
    }

    @Override
    public INode visitTerm(FOOLParser.TermContext ctx) {
        if (ctx.right == null) {
            return visit(ctx.left);
        } else {
            INode left, right;
            if (ctx.operator.getType() == FOOLLexer.TIMES) {
                System.out.println("TimesNode   (" + ctx.getText() + ")");
                left = visit(ctx.left);
                right = visit(ctx.right);
                return new TimesNode(left, right, ctx);
            } else {
                System.out.println("DivNode   (" + ctx.getText() + ")");
                left = visit(ctx.left);
                right = visit(ctx.right);
                return new DivNode(left, right, ctx);
            }
        }
    }

    @Override
    public INode visitVarasm(FOOLParser.VarasmContext ctx)
    {
        System.out.println("VarNode   (" + ctx.getText() + ")");
       String varName = ctx.ID().getSymbol().getText();

       INode exp = visit(ctx.exp());


       return new VarNode(varName, exp, ctx);
    }

    @Override
    public INode visitLetInExp(FOOLParser.LetInExpContext ctx)
    {
        System.out.println("LetInExp   (" + ctx.getText() + ")");



        ProgLetInNode res;

        ArrayList<INode> declarations = new ArrayList<>();

        for(FOOLParser.DecContext dc : ctx.let().dec())
        {

            declarations.add(visit(dc));
        }

        LetNode letNode = new LetNode(declarations, ctx);
        INode dxPart;

        if(ctx.exp() != null) {

            dxPart = visit(ctx.exp());
        }
        else
            dxPart = visit(ctx.stats());

        res = new ProgLetInNode(letNode, dxPart, new ArrayList<>());

        return res;
    }

    @Override
    public INode visitSingleExp(FOOLParser.SingleExpContext ctx) {
        return visit(ctx.exp());
    }

    //TODO: altri visitor

}
