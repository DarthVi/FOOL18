// Generated from /home/vincenzo/IdeaProjects/FOOL18new/src/parser/SVM.g4 by ANTLR 4.7
package parser;

import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SVMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SVMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SVMParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(SVMParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pushNumber}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushNumber(SVMParser.PushNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pushLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushLabel(SVMParser.PushLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pop}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPop(SVMParser.PopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(SVMParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(SVMParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(SVMParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(SVMParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storew}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorew(SVMParser.StorewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loadw}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadw(SVMParser.LoadwContext ctx);
	/**
	 * Visit a parse tree produced by the {@code labelCol}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelCol(SVMParser.LabelColContext ctx);
	/**
	 * Visit a parse tree produced by the {@code branchLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchLabel(SVMParser.BranchLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code branchEqLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchEqLabel(SVMParser.BranchEqLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code branchLessEqLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchLessEqLabel(SVMParser.BranchLessEqLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code label}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(SVMParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code js}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJs(SVMParser.JsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loadRa}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadRa(SVMParser.LoadRaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storeRa}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreRa(SVMParser.StoreRaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loadRv}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadRv(SVMParser.LoadRvContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storeRv}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreRv(SVMParser.StoreRvContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loadFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadFp(SVMParser.LoadFpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storeFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreFp(SVMParser.StoreFpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code copyFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyFp(SVMParser.CopyFpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loadHp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadHp(SVMParser.LoadHpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code storeHp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreHp(SVMParser.StoreHpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SVMParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code halt}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalt(SVMParser.HaltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(SVMParser.NewContext ctx);
}