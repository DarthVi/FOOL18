package parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class DebuggingVisitorImpl<INode> extends FOOLBaseVisitor<INode> {


	@Override
	public INode visitSingleExp(FOOLParser.SingleExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " SingleExp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitLetInExp(FOOLParser.LetInExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + "LetInExp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitClassdecExp(FOOLParser.ClassdecExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " ClassDecExp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitLet(FOOLParser.LetContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " Let");
		return visitChildren(ctx);
	}


	@Override
	public INode visitVardec(FOOLParser.VardecContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " VarDec");
		return visitChildren(ctx);
	}


	@Override
	public INode visitFunlet(FOOLParser.FunletContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " FunLet");
		return visitChildren(ctx);
	}


	@Override
	public INode visitVarasm(FOOLParser.VarasmContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " VarAsm");
		return visitChildren(ctx);
	}


	@Override
	public INode visitFun(FOOLParser.FunContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " Fun");
		return visitChildren(ctx);
	}


	@Override
	public INode visitVarDeclaration(FOOLParser.VarDeclarationContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " VarDeclaration");
		return visitChildren(ctx);
	}


	@Override
	public INode visitFunDeclaration(FOOLParser.FunDeclarationContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " FunDeclaration");
		return visitChildren(ctx);
	}


	@Override
	public INode visitClassdec(FOOLParser.ClassdecContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " ClassDec");
		return visitChildren(ctx);
	}


	@Override
	public INode visitType(FOOLParser.TypeContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " Type");
		return visitChildren(ctx);
	}


	@Override
	public INode visitExp(FOOLParser.ExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " Exp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitTerm(FOOLParser.TermContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " Term");
		return visitChildren(ctx);
	}


	@Override
	public INode visitFactor(FOOLParser.FactorContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " Factor");
		return visitChildren(ctx);
	}


	@Override
	public INode visitIntVal(FOOLParser.IntValContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " IntVal");
		return visitChildren(ctx);
	}


	@Override
	public INode visitBoolVal(FOOLParser.BoolValContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " BoolVal");
		return visitChildren(ctx);
	}


	@Override
	public INode visitNullVal(FOOLParser.NullValContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " NullVal");
		return visitChildren(ctx);
	}


	@Override
	public INode visitVoidExp(FOOLParser.VoidExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " VoidExp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitBaseExp(FOOLParser.BaseExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " BaseExp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitIfExp(FOOLParser.IfExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " IfExp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitVarExp(FOOLParser.VarExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " VarExp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitFunExp(FOOLParser.FunExpContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " FunExp");
		return visitChildren(ctx);
	}


	@Override
	public INode visitObjInst(FOOLParser.ObjInstContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " ObjInst");
		return visitChildren(ctx);
	}


	@Override
	public INode visitObjCall(FOOLParser.ObjCallContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " ObjCall");
		return visitChildren(ctx);
	}


	@Override
	public INode visitStats(FOOLParser.StatsContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " Stats");
		return visitChildren(ctx);
	}


	@Override
	public INode visitVarasmStat(FOOLParser.VarasmStatContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " VarAsmStat");
		return visitChildren(ctx);
	}


	@Override
	public INode visitIfStat(FOOLParser.IfStatContext ctx) {
		System.out.println(indentTree(getNodeDepth(ctx)) + " IfStat");
		return visitChildren(ctx);
	}

	@Override
	public INode visitTerminal(TerminalNode node){
		System.out.println(indentTree(getNodeDepth(node)) + " " + node.getSymbol().getText());
		return super.visitTerminal(node);
	}

	// For debugging
	private int getNodeDepth(ParseTree ctx) {
		ParseTree parent = ctx.getParent();
		int count = 0;
		while (parent != null) {
			parent = parent.getParent();
			count++;
		}
		return count;
	}

	private String indentTree(int count){
		String string = "";
		for (int i = 0; i < count; i++){
			string += "-";
		}
		return string;
	}
}