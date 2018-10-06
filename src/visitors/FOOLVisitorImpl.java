package visitors;

import ast.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import parser.FOOLBaseVisitor;
import parser.FOOLLexer;
import parser.FOOLParser;
import type.*;

import java.util.ArrayList;
import java.util.HashMap;

public class FOOLVisitorImpl extends FOOLBaseVisitor<INode>
{

    @Override
    public INode visitSingleExp(FOOLParser.SingleExpContext ctx) {
        return  new SingleExp(visit(ctx.exp()));
    }

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

        if(ctx.exp() != null)
            expression = visit(ctx.exp());

        //if the variable declaration is inside a class, it is a member declaration,
        //so we must set the isAttribute property
        //if(FOOLParser.ruleNames[ctx.getParent().getRuleIndex()].equals(FOOLParser.ruleNames[FOOLParser.RULE_classdec]))
        //    isAttribute = true;

        return new VardecNode(typeNode, ctx.ID().getSymbol().getText(), expression, ctx, isAttribute);
    }

    @Override
    public INode visitIntVal(FOOLParser.IntValContext ctx)
    {
        // notice that this method is not actually a rule but a named production #intVal

        //there is no need to perform a check here, the lexer ensures this text is an int
        return new IntNode(Integer.parseInt(ctx.INTEGER().getText()), ctx);
    }

    @Override
    public INode visitNullVal(FOOLParser.NullValContext ctx)
    {
        return new NullNode(ctx);
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

        value = Boolean.parseBoolean(ctx.booleanVal.getText());

        return new BoolNode(value,ctx);
    }

    @SuppressWarnings("Duplicates")
    private INode visitIf(ParserRuleContext ctx)
    {
        IfNode res;
        INode condExp;
        INode thenBranch;
        INode elseBranch;


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
        boolean isAttribute = false;

        TypeNode typeNode = (TypeNode) visitType(ctx.type());

        //if the variable declaration is inside a class, it is a member declaration,
        //so we must set the isAttribute property
        if(FOOLParser.ruleNames[ctx.getParent().getRuleIndex()].equals(FOOLParser.ruleNames[FOOLParser.RULE_classdec]))
            isAttribute = true;

        //isAttribute = false because it is not relevant in this case to discriminate variables from members
        return new FormalParamNode(ctx.ID().getSymbol().getText(), typeNode.getType(),
                isAttribute, ctx);
    }

    @Override
    public INode visitFun(FOOLParser.FunContext ctx)
    {
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

        if(ctx.funlet() != null)
            for(FOOLParser.VardecContext vc : ctx.funlet().vardec())
            {
                INode param = visitVardec(vc);
                declarations.add(param);
            }

        INode body;

        if(ctx.exp() == null)
            body = visit(ctx.stats());
        else
            body = visit(ctx.exp());

        return new FunctionNode(funName, retType, params, declarations, body, ctx);

    }


    @Override
    public INode visitFunExp(FOOLParser.FunExpContext ctx) {
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
    public INode visitObjInst(FOOLParser.ObjInstContext ctx)
    {
        //this corresponds to a new operator call, used to instantiate an object
        INode res;
        String className;

        //get the actual arguments passed to the constructor
        ArrayList<INode> args = new ArrayList<>();

        for (FOOLParser.ExpContext exp : ctx.exp())
            args.add(visit(exp));

        className = ctx.ID().getText();

        res = new NewNode(className, new ActualParamsNode(args), ctx);

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
                INode left = visit(ctx.left);
                INode right = visit(ctx.right);

                switch (ctx.operator.getType()) {
                    case FOOLLexer.EQ:
                        return new EqualNode(left, right, ctx);
                    case FOOLLexer.LQ:
                        return new LessEqualNode(left, right, ctx);
                    case FOOLLexer.GQ:
                        return new GreaterEqualNode(left, right, ctx);
                    case FOOLLexer.AND:
                        return new AndNode(left, right, ctx);
                    case FOOLLexer.GREATER:
                        return new GreaterNode(left, right, ctx);
                    case FOOLLexer.LESS:
                        return new LessNode(left, right, ctx);
                    case FOOLLexer.OR:
                        return new OrNode(left, right, ctx);
                    case FOOLLexer.DEQ:
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
        return new IdNode(ctx.ID().getText(), ctx);
    }

    @Override
    public INode visitExp(FOOLParser.ExpContext ctx) {
        if (ctx.right == null) {
            return visit(ctx.left);
        } else {
            INode left = visit(ctx.left);
            INode right = visit(ctx.right);
            if (ctx.operator.getType() == FOOLLexer.PLUS) {
                return new PlusNode(left, right, ctx);
            } else {
                return new MinusNode(left, right, ctx);
            }
        }
    }

    @Override
    public INode visitTerm(FOOLParser.TermContext ctx) {
        if (ctx.right == null) {
            return visit(ctx.left);
        } else {
            INode left = visit(ctx.left);
            INode right = visit(ctx.right);
            if (ctx.operator.getType() == FOOLLexer.TIMES) {
                return new TimesNode(left, right, ctx);
            } else {
                return new DivNode(left, right, ctx);
            }
        }
    }

    @Override
    public INode visitVarasm(FOOLParser.VarasmContext ctx)
    {
       String varName = ctx.ID().getSymbol().getText();

       INode exp = visit(ctx.exp());

       return new VarNode(varName, exp, ctx);
    }


    @Override
    public INode visitLetInExp(FOOLParser.LetInExpContext ctx)
    {
        ProgLetInNode res;

        ArrayList<INode> declarations = new ArrayList<>();

        for(FOOLParser.DecContext dc : ctx.let().dec())
        {
            declarations.add(visit(dc));
        }

        LetNode letNode = new LetNode(declarations, ctx);
        INode exp = null;
        ArrayList<INode> statements = new ArrayList<>();

        if(ctx.exp() != null)
            exp = visit(ctx.exp());
        else
        {
            for(FOOLParser.StatContext sc : ctx.stats().stat())
            {
                INode stat = visit(sc);
                statements.add(stat);
            }
        }

        res = new ProgLetInNode(letNode, exp, statements);

        return res;
    }

    @Override
    public INode visitVarasmStat(FOOLParser.VarasmStatContext ctx)
    {
        return visit(ctx.varasm());
    }

    @Override
    public INode visitPrintStat(FOOLParser.PrintStatContext ctx)
    {
        INode exp = visit(ctx.exp());

        return new PrintNode(exp, ctx);
    }

    @Override
    public INode visitBaseExp(FOOLParser.BaseExpContext ctx)
    {
        return new BaseExpNode(ctx, visit(ctx.exp()));
    }

    @Override
    public INode visitClassdec(FOOLParser.ClassdecContext ctx)
    {
        //the first ID token is the class name token, the following one (if any) is the parent's class name
        Token classToken = ctx.ID(0).getSymbol();
        String parentString = null;

        //let's get the parent's string, if present
        if(ctx.ID().size() == 2)
            parentString = ctx.ID(1).getSymbol().getText();

        ArrayList<MemberNode> memberNodes = new ArrayList<>();

        //we get the list of class members and member nodes
        for(FOOLParser.ArgdecContext ac : ctx.argdec())
        {
            //we call the visit on the ArgdecContext, get the FormalParamNode through the appropriate visit
            //function and use its return value to build the subclass MemberNode
            MemberNode memberNode = new MemberNode((FormalParamNode) visit(ac));
            memberNodes.add(memberNode);
        }

        ArrayList<MethodNode> methodNodes = new ArrayList<>();

        //we get the list of class methods and method nodes
        for(FOOLParser.FunContext fc : ctx.fun())
        {
            //we call the visit on the FunContext, get the FunctionNode through the appropriate visit
            //function and use its return value to build the subclass FunctionNode
            MethodNode methodNode = new MethodNode((FunctionNode) visit(fc));
            methodNodes.add(methodNode);

        }

        //we don't pass the parent ClassType because it gets retrieved by the ClassDecNode's checkSemantics
        //through the parent string passed to the ClassDecNode constructor.
        //This is necessary because the Environment class stable gets built by the various
        //checkSemantic's call and right now it will remain empty.
        ClassType classType = new ClassType(classToken.getText());

        return new ClassDecNode(classType, parentString, memberNodes, methodNodes, ctx);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public INode visitClassdecExp(FOOLParser.ClassdecExpContext ctx)
    {
        ArrayList<ClassDecNode> classdecs = new ArrayList<>();
        LetNode letNode = null;
        INode exp = null;
        ArrayList<INode> statements = new ArrayList<>();

        for(FOOLParser.ClassdecContext cd : ctx.classdec())
        {
            ClassDecNode cn = (ClassDecNode) visit(cd);
            classdecs.add(cn);
        }

        ArrayList<INode> declarations = new ArrayList<>();

        if(ctx.let() != null)
        {
            for (FOOLParser.DecContext dc : ctx.let().dec())
            {
                declarations.add(visit(dc));
            }

            letNode = new LetNode(declarations, ctx);

            if (ctx.exp() != null)
                exp = visit(ctx.exp());
            else
            {
                for (FOOLParser.StatContext sc : ctx.stats().stat())
                {
                    INode stat = visit(sc);
                    statements.add(stat);
                }
            }
        }

        ClassdecProgLetInNode res = new ClassdecProgLetInNode(classdecs, letNode, exp, statements);

        return res;
    }

    @Override
    public INode visitObjCall(FOOLParser.ObjCallContext ctx) {

        INode res;

        //get the invocation arguments
        ArrayList<INode> args = new ArrayList<INode>();

        for (FOOLParser.ExpContext exp : ctx.exp())
            args.add(visit(exp));

       // res = new FunCallNode(ctx.ID().getSymbol(), new ActualParamsNode(args), ctx);
        res=new MethodCallNode(ctx.ID(0).getSymbol() , new ActualParamsNode(args),
                ctx, ctx.ID(0).getText(), ctx.ID(1).getText());


        return res;
    }
}
