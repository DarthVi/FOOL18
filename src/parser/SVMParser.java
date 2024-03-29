// Generated from /home/vincenzo/IdeaProjects/FOOL18new/src/parser/SVM.g4 by ANTLR 4.7
package parser;

import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, STOREW=7, LOADW=8, BRANCH=9, 
		BRANCHEQ=10, BRANCHLESSEQ=11, JS=12, LOADRA=13, STORERA=14, LOADRV=15, 
		STORERV=16, LOADFP=17, STOREFP=18, COPYFP=19, LOADHP=20, STOREHP=21, PRINT=22, 
		HALT=23, NEW=24, COPY=25, CALCHOFF=26, LC=27, MM=28, COL=29, LABEL=30, 
		NUMBER=31, WHITESP=32, ERR=33;
	public static final int
		RULE_code = 0, RULE_assembly = 1;
	public static final String[] ruleNames = {
		"code", "assembly"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'sw'", 
		"'lw'", "'b'", "'beq'", "'bleq'", "'js'", "'lra'", "'sra'", "'lrv'", "'srv'", 
		"'lfp'", "'sfp'", "'cfp'", "'lhp'", "'shp'", "'print'", "'halt'", "'new'", 
		"'copy'", "'calchoff'", "'lc'", "'mm'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "STOREW", "LOADW", "BRANCH", 
		"BRANCHEQ", "BRANCHLESSEQ", "JS", "LOADRA", "STORERA", "LOADRV", "STORERV", 
		"LOADFP", "STOREFP", "COPYFP", "LOADHP", "STOREHP", "PRINT", "HALT", "NEW", 
		"COPY", "CALCHOFF", "LC", "MM", "COL", "LABEL", "NUMBER", "WHITESP", "ERR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CodeContext extends ParserRuleContext {
		public List<AssemblyContext> assembly() {
			return getRuleContexts(AssemblyContext.class);
		}
		public AssemblyContext assembly(int i) {
			return getRuleContext(AssemblyContext.class,i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << STOREW) | (1L << LOADW) | (1L << BRANCH) | (1L << BRANCHEQ) | (1L << BRANCHLESSEQ) | (1L << JS) | (1L << LOADRA) | (1L << STORERA) | (1L << LOADRV) | (1L << STORERV) | (1L << LOADFP) | (1L << STOREFP) | (1L << COPYFP) | (1L << LOADHP) | (1L << STOREHP) | (1L << PRINT) | (1L << HALT) | (1L << NEW) | (1L << COPY) | (1L << CALCHOFF) | (1L << LC) | (1L << MM) | (1L << LABEL))) != 0)) {
				{
				{
				setState(4);
				assembly();
				}
				}
				setState(9);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssemblyContext extends ParserRuleContext {
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
	 
		public AssemblyContext() { }
		public void copyFrom(AssemblyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StoreRaContext extends AssemblyContext {
		public TerminalNode STORERA() { return getToken(SVMParser.STORERA, 0); }
		public StoreRaContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitStoreRa(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubContext extends AssemblyContext {
		public TerminalNode SUB() { return getToken(SVMParser.SUB, 0); }
		public SubContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends AssemblyContext {
		public TerminalNode MULT() { return getToken(SVMParser.MULT, 0); }
		public MultContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadFpContext extends AssemblyContext {
		public TerminalNode LOADFP() { return getToken(SVMParser.LOADFP, 0); }
		public LoadFpContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLoadFp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BranchLessEqLabelContext extends AssemblyContext {
		public Token l;
		public TerminalNode BRANCHLESSEQ() { return getToken(SVMParser.BRANCHLESSEQ, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public BranchLessEqLabelContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBranchLessEqLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JsContext extends AssemblyContext {
		public TerminalNode JS() { return getToken(SVMParser.JS, 0); }
		public JsContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitJs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BranchEqLabelContext extends AssemblyContext {
		public Token l;
		public TerminalNode BRANCHEQ() { return getToken(SVMParser.BRANCHEQ, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public BranchEqLabelContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBranchEqLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PopContext extends AssemblyContext {
		public TerminalNode POP() { return getToken(SVMParser.POP, 0); }
		public PopContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends AssemblyContext {
		public TerminalNode DIV() { return getToken(SVMParser.DIV, 0); }
		public DivContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PushNumberContext extends AssemblyContext {
		public Token n;
		public TerminalNode PUSH() { return getToken(SVMParser.PUSH, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public PushNumberContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPushNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LabelColContext extends AssemblyContext {
		public Token l;
		public TerminalNode COL() { return getToken(SVMParser.COL, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public LabelColContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLabelCol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadHpContext extends AssemblyContext {
		public TerminalNode LOADHP() { return getToken(SVMParser.LOADHP, 0); }
		public LoadHpContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLoadHp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CopyContext extends AssemblyContext {
		public TerminalNode COPY() { return getToken(SVMParser.COPY, 0); }
		public CopyContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitCopy(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CalchoffContext extends AssemblyContext {
		public TerminalNode CALCHOFF() { return getToken(SVMParser.CALCHOFF, 0); }
		public CalchoffContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitCalchoff(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadRvContext extends AssemblyContext {
		public TerminalNode LOADRV() { return getToken(SVMParser.LOADRV, 0); }
		public LoadRvContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLoadRv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CopyFpContext extends AssemblyContext {
		public TerminalNode COPYFP() { return getToken(SVMParser.COPYFP, 0); }
		public CopyFpContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitCopyFp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddContext extends AssemblyContext {
		public TerminalNode ADD() { return getToken(SVMParser.ADD, 0); }
		public AddContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadRaContext extends AssemblyContext {
		public TerminalNode LOADRA() { return getToken(SVMParser.LOADRA, 0); }
		public LoadRaContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLoadRa(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PushLabelContext extends AssemblyContext {
		public Token l;
		public TerminalNode PUSH() { return getToken(SVMParser.PUSH, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public PushLabelContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPushLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewContext extends AssemblyContext {
		public TerminalNode NEW() { return getToken(SVMParser.NEW, 0); }
		public NewContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StorewContext extends AssemblyContext {
		public TerminalNode STOREW() { return getToken(SVMParser.STOREW, 0); }
		public StorewContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitStorew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LabelContext extends AssemblyContext {
		public Token l;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public LabelContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModmemberContext extends AssemblyContext {
		public TerminalNode MM() { return getToken(SVMParser.MM, 0); }
		public ModmemberContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitModmember(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HaltContext extends AssemblyContext {
		public TerminalNode HALT() { return getToken(SVMParser.HALT, 0); }
		public HaltContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitHalt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends AssemblyContext {
		public TerminalNode PRINT() { return getToken(SVMParser.PRINT, 0); }
		public PrintContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadwContext extends AssemblyContext {
		public TerminalNode LOADW() { return getToken(SVMParser.LOADW, 0); }
		public LoadwContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLoadw(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StoreRvContext extends AssemblyContext {
		public TerminalNode STORERV() { return getToken(SVMParser.STORERV, 0); }
		public StoreRvContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitStoreRv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LcContext extends AssemblyContext {
		public TerminalNode LC() { return getToken(SVMParser.LC, 0); }
		public LcContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StoreHpContext extends AssemblyContext {
		public TerminalNode STOREHP() { return getToken(SVMParser.STOREHP, 0); }
		public StoreHpContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitStoreHp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StoreFpContext extends AssemblyContext {
		public TerminalNode STOREFP() { return getToken(SVMParser.STOREFP, 0); }
		public StoreFpContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitStoreFp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BranchLabelContext extends AssemblyContext {
		public Token l;
		public TerminalNode BRANCH() { return getToken(SVMParser.BRANCH, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public BranchLabelContext(AssemblyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBranchLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assembly);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PushNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				match(PUSH);
				setState(11);
				((PushNumberContext)_localctx).n = match(NUMBER);
				}
				break;
			case 2:
				_localctx = new PushLabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				match(PUSH);
				setState(13);
				((PushLabelContext)_localctx).l = match(LABEL);
				}
				break;
			case 3:
				_localctx = new PopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(14);
				match(POP);
				}
				break;
			case 4:
				_localctx = new AddContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(15);
				match(ADD);
				}
				break;
			case 5:
				_localctx = new SubContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(16);
				match(SUB);
				}
				break;
			case 6:
				_localctx = new MultContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(17);
				match(MULT);
				}
				break;
			case 7:
				_localctx = new DivContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(18);
				match(DIV);
				}
				break;
			case 8:
				_localctx = new StorewContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(19);
				match(STOREW);
				}
				break;
			case 9:
				_localctx = new LoadwContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(20);
				match(LOADW);
				}
				break;
			case 10:
				_localctx = new LabelColContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(21);
				((LabelColContext)_localctx).l = match(LABEL);
				setState(22);
				match(COL);
				}
				break;
			case 11:
				_localctx = new BranchLabelContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(23);
				match(BRANCH);
				setState(24);
				((BranchLabelContext)_localctx).l = match(LABEL);
				}
				break;
			case 12:
				_localctx = new BranchEqLabelContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(25);
				match(BRANCHEQ);
				setState(26);
				((BranchEqLabelContext)_localctx).l = match(LABEL);
				}
				break;
			case 13:
				_localctx = new BranchLessEqLabelContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(27);
				match(BRANCHLESSEQ);
				setState(28);
				((BranchLessEqLabelContext)_localctx).l = match(LABEL);
				}
				break;
			case 14:
				_localctx = new LabelContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(29);
				((LabelContext)_localctx).l = match(LABEL);
				}
				break;
			case 15:
				_localctx = new JsContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(30);
				match(JS);
				}
				break;
			case 16:
				_localctx = new LoadRaContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(31);
				match(LOADRA);
				}
				break;
			case 17:
				_localctx = new StoreRaContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(32);
				match(STORERA);
				}
				break;
			case 18:
				_localctx = new LoadRvContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(33);
				match(LOADRV);
				}
				break;
			case 19:
				_localctx = new StoreRvContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(34);
				match(STORERV);
				}
				break;
			case 20:
				_localctx = new LoadFpContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(35);
				match(LOADFP);
				}
				break;
			case 21:
				_localctx = new StoreFpContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(36);
				match(STOREFP);
				}
				break;
			case 22:
				_localctx = new CopyFpContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(37);
				match(COPYFP);
				}
				break;
			case 23:
				_localctx = new LoadHpContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(38);
				match(LOADHP);
				}
				break;
			case 24:
				_localctx = new StoreHpContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(39);
				match(STOREHP);
				}
				break;
			case 25:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(40);
				match(PRINT);
				}
				break;
			case 26:
				_localctx = new HaltContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(41);
				match(HALT);
				}
				break;
			case 27:
				_localctx = new NewContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(42);
				match(NEW);
				}
				break;
			case 28:
				_localctx = new LcContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(43);
				match(LC);
				}
				break;
			case 29:
				_localctx = new CalchoffContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(44);
				match(CALCHOFF);
				}
				break;
			case 30:
				_localctx = new CopyContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(45);
				match(COPY);
				}
				break;
			case 31:
				_localctx = new ModmemberContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(46);
				match(MM);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\64\4\2\t\2\4\3\t"+
		"\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3\3\2\2\4\2\4\2"+
		"\2\2P\2\t\3\2\2\2\4\61\3\2\2\2\6\b\5\4\3\2\7\6\3\2\2\2\b\13\3\2\2\2\t"+
		"\7\3\2\2\2\t\n\3\2\2\2\n\3\3\2\2\2\13\t\3\2\2\2\f\r\7\3\2\2\r\62\7!\2"+
		"\2\16\17\7\3\2\2\17\62\7 \2\2\20\62\7\4\2\2\21\62\7\5\2\2\22\62\7\6\2"+
		"\2\23\62\7\7\2\2\24\62\7\b\2\2\25\62\7\t\2\2\26\62\7\n\2\2\27\30\7 \2"+
		"\2\30\62\7\37\2\2\31\32\7\13\2\2\32\62\7 \2\2\33\34\7\f\2\2\34\62\7 \2"+
		"\2\35\36\7\r\2\2\36\62\7 \2\2\37\62\7 \2\2 \62\7\16\2\2!\62\7\17\2\2\""+
		"\62\7\20\2\2#\62\7\21\2\2$\62\7\22\2\2%\62\7\23\2\2&\62\7\24\2\2\'\62"+
		"\7\25\2\2(\62\7\26\2\2)\62\7\27\2\2*\62\7\30\2\2+\62\7\31\2\2,\62\7\32"+
		"\2\2-\62\7\35\2\2.\62\7\34\2\2/\62\7\33\2\2\60\62\7\36\2\2\61\f\3\2\2"+
		"\2\61\16\3\2\2\2\61\20\3\2\2\2\61\21\3\2\2\2\61\22\3\2\2\2\61\23\3\2\2"+
		"\2\61\24\3\2\2\2\61\25\3\2\2\2\61\26\3\2\2\2\61\27\3\2\2\2\61\31\3\2\2"+
		"\2\61\33\3\2\2\2\61\35\3\2\2\2\61\37\3\2\2\2\61 \3\2\2\2\61!\3\2\2\2\61"+
		"\"\3\2\2\2\61#\3\2\2\2\61$\3\2\2\2\61%\3\2\2\2\61&\3\2\2\2\61\'\3\2\2"+
		"\2\61(\3\2\2\2\61)\3\2\2\2\61*\3\2\2\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2"+
		"\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2\2\4\t\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}