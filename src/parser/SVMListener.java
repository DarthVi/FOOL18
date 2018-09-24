// Generated from C:/Users/Lorenzo/Desktop/src/parser\SVM.g4 by ANTLR 4.6
package parser;

import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SVMParser}.
 */
public interface SVMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SVMParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(SVMParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(SVMParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pushNumber}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterPushNumber(SVMParser.PushNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pushNumber}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitPushNumber(SVMParser.PushNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pushLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterPushLabel(SVMParser.PushLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pushLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitPushLabel(SVMParser.PushLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pop}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterPop(SVMParser.PopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pop}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitPop(SVMParser.PopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterAdd(SVMParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitAdd(SVMParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sub}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterSub(SVMParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitSub(SVMParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mult}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterMult(SVMParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitMult(SVMParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterDiv(SVMParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitDiv(SVMParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code storew}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterStorew(SVMParser.StorewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code storew}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitStorew(SVMParser.StorewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loadw}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterLoadw(SVMParser.LoadwContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loadw}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitLoadw(SVMParser.LoadwContext ctx);
	/**
	 * Enter a parse tree produced by the {@code labelCol}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterLabelCol(SVMParser.LabelColContext ctx);
	/**
	 * Exit a parse tree produced by the {@code labelCol}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitLabelCol(SVMParser.LabelColContext ctx);
	/**
	 * Enter a parse tree produced by the {@code branchLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterBranchLabel(SVMParser.BranchLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code branchLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitBranchLabel(SVMParser.BranchLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code branchEqLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterBranchEqLabel(SVMParser.BranchEqLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code branchEqLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitBranchEqLabel(SVMParser.BranchEqLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code branchLessEqLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterBranchLessEqLabel(SVMParser.BranchLessEqLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code branchLessEqLabel}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitBranchLessEqLabel(SVMParser.BranchLessEqLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code label}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterLabel(SVMParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code label}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitLabel(SVMParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code js}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterJs(SVMParser.JsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code js}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitJs(SVMParser.JsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loadRa}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterLoadRa(SVMParser.LoadRaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loadRa}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitLoadRa(SVMParser.LoadRaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code storeRa}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterStoreRa(SVMParser.StoreRaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code storeRa}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitStoreRa(SVMParser.StoreRaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loadRv}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterLoadRv(SVMParser.LoadRvContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loadRv}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitLoadRv(SVMParser.LoadRvContext ctx);
	/**
	 * Enter a parse tree produced by the {@code storeRv}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterStoreRv(SVMParser.StoreRvContext ctx);
	/**
	 * Exit a parse tree produced by the {@code storeRv}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitStoreRv(SVMParser.StoreRvContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loadFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterLoadFp(SVMParser.LoadFpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loadFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitLoadFp(SVMParser.LoadFpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code storeFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterStoreFp(SVMParser.StoreFpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code storeFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitStoreFp(SVMParser.StoreFpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code copyFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterCopyFp(SVMParser.CopyFpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code copyFp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitCopyFp(SVMParser.CopyFpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loadHp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterLoadHp(SVMParser.LoadHpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loadHp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitLoadHp(SVMParser.LoadHpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code storeHp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterStoreHp(SVMParser.StoreHpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code storeHp}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitStoreHp(SVMParser.StoreHpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SVMParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SVMParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code halt}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterHalt(SVMParser.HaltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code halt}
	 * labeled alternative in {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitHalt(SVMParser.HaltContext ctx);
}