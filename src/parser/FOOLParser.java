// Generated from /home/vincenzo/IdeaProjects/FOOL18new/src/parser/FOOL.g4 by ANTLR 4.7
package parser;

    import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SEMIC=2, COLON=3, COMMA=4, EQ=5, DEQ=6, LQ=7, GQ=8, GREATER=9, 
		LESS=10, AND=11, OR=12, NOT=13, ASM=14, PLUS=15, MINUS=16, TIMES=17, DIV=18, 
		TRUE=19, FALSE=20, LPAR=21, RPAR=22, CLPAR=23, CRPAR=24, IF=25, THEN=26, 
		ELSE=27, PRINT=28, LET=29, IN=30, VAR=31, FUN=32, INT=33, BOOL=34, CLASS=35, 
		EXTENDS=36, NULL=37, NEW=38, VOID=39, INTEGER=40, ID=41, WS=42, LINECOMENTS=43, 
		BLOCKCOMENTS=44, ERR=45;
	public static final int
		RULE_prog = 0, RULE_let = 1, RULE_vardec = 2, RULE_argdec = 3, RULE_funlet = 4, 
		RULE_varasm = 5, RULE_fun = 6, RULE_dec = 7, RULE_classdec = 8, RULE_type = 9, 
		RULE_exp = 10, RULE_term = 11, RULE_factor = 12, RULE_value = 13, RULE_stats = 14, 
		RULE_stat = 15;
	public static final String[] ruleNames = {
		"prog", "let", "vardec", "argdec", "funlet", "varasm", "fun", "dec", "classdec", 
		"type", "exp", "term", "factor", "value", "stats", "stat"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "';'", "':'", "','", "'=='", "'!='", "'<='", "'>='", "'>'", 
		"'<'", "'&&'", "'||'", "'not'", "'='", "'+'", "'-'", "'*'", "'/'", "'true'", 
		"'false'", "'('", "')'", "'{'", "'}'", "'if'", "'then'", "'else'", "'print'", 
		"'let'", "'in'", "'var'", "'fun'", "'int'", "'bool'", "'class'", "'extends'", 
		"'null'", "'new'", "'void'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "SEMIC", "COLON", "COMMA", "EQ", "DEQ", "LQ", "GQ", "GREATER", 
		"LESS", "AND", "OR", "NOT", "ASM", "PLUS", "MINUS", "TIMES", "DIV", "TRUE", 
		"FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", "PRINT", 
		"LET", "IN", "VAR", "FUN", "INT", "BOOL", "CLASS", "EXTENDS", "NULL", 
		"NEW", "VOID", "INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
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
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetInExpContext extends ProgContext {
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public LetInExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitLetInExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassdecExpContext extends ProgContext {
		public List<ClassdecContext> classdec() {
			return getRuleContexts(ClassdecContext.class);
		}
		public ClassdecContext classdec(int i) {
			return getRuleContext(ClassdecContext.class,i);
		}
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public ClassdecExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitClassdecExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleExpContext extends ProgContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public SingleExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitSingleExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case MINUS:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case NULL:
			case NEW:
			case VOID:
			case INTEGER:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				exp();
				setState(33);
				match(SEMIC);
				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				let();
				setState(40);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					exp();
					setState(37);
					match(SEMIC);
					}
					break;
				case 2:
					{
					setState(39);
					stats();
					}
					break;
				}
				}
				break;
			case CLASS:
				_localctx = new ClassdecExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(42);
					classdec();
					}
					}
					setState(45); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CLASS );
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LET) {
					{
					setState(47);
					let();
					setState(52);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(48);
						exp();
						setState(49);
						match(SEMIC);
						}
						break;
					case 2:
						{
						setState(51);
						stats();
						}
						break;
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LetContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FOOLParser.LET, 0); }
		public TerminalNode IN() { return getToken(FOOLParser.IN, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(LET);
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				dec();
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(64);
			match(IN);
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

	public static class VardecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public TerminalNode ASM() { return getToken(FOOLParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			type();
			setState(67);
			match(ID);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASM) {
				{
				setState(68);
				match(ASM);
				setState(69);
				exp();
				}
			}

			setState(72);
			match(SEMIC);
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

	public static class ArgdecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public ArgdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argdec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitArgdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgdecContext argdec() throws RecognitionException {
		ArgdecContext _localctx = new ArgdecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_argdec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			type();
			setState(75);
			match(ID);
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

	public static class FunletContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(FOOLParser.LET, 0); }
		public TerminalNode IN() { return getToken(FOOLParser.IN, 0); }
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public FunletContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funlet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFunlet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunletContext funlet() throws RecognitionException {
		FunletContext _localctx = new FunletContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funlet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(LET);
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				vardec();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(83);
			match(IN);
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

	public static class VarasmContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode ASM() { return getToken(FOOLParser.ASM, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarasmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varasm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVarasm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarasmContext varasm() throws RecognitionException {
		VarasmContext _localctx = new VarasmContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varasm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(ID);
			setState(86);
			match(ASM);
			setState(87);
			exp();
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

	public static class FunContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public List<ArgdecContext> argdec() {
			return getRuleContexts(ArgdecContext.class);
		}
		public ArgdecContext argdec(int i) {
			return getRuleContext(ArgdecContext.class,i);
		}
		public FunletContext funlet() {
			return getRuleContext(FunletContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			type();
			setState(90);
			match(ID);
			setState(91);
			match(LPAR);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(92);
				argdec();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(93);
					match(COMMA);
					setState(94);
					argdec();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(102);
			match(RPAR);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(103);
				funlet();
				}
			}

			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(106);
				exp();
				setState(107);
				match(SEMIC);
				}
				break;
			case 2:
				{
				setState(109);
				stats();
				}
				break;
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

	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunDeclarationContext extends DecContext {
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FunDeclarationContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFunDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclarationContext extends DecContext {
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public VarDeclarationContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dec);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new VarDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				vardec();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				fun();
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

	public static class ClassdecContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(FOOLParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode EXTENDS() { return getToken(FOOLParser.EXTENDS, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public List<ArgdecContext> argdec() {
			return getRuleContexts(ArgdecContext.class);
		}
		public ArgdecContext argdec(int i) {
			return getRuleContext(ArgdecContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FOOLParser.CLPAR, 0); }
		public TerminalNode CRPAR() { return getToken(FOOLParser.CRPAR, 0); }
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public ClassdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitClassdec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdecContext classdec() throws RecognitionException {
		ClassdecContext _localctx = new ClassdecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(CLASS);
			setState(117);
			match(ID);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(118);
				match(EXTENDS);
				setState(119);
				match(ID);
				}
			}

			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(122);
				match(LPAR);
				setState(123);
				argdec();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMIC) {
					{
					{
					setState(124);
					match(SEMIC);
					setState(125);
					argdec();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(RPAR);
				}
			}

			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLPAR) {
				{
				setState(135);
				match(CLPAR);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					{
					setState(136);
					fun();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				match(CRPAR);
				}
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FOOLParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(FOOLParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(FOOLParser.VOID, 0); }
		public TerminalNode NULL() { return getToken(FOOLParser.NULL, 0); }
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExpContext extends ParserRuleContext {
		public TermContext left;
		public Token operator;
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FOOLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			((ExpContext)_localctx).left = term();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(148);
				((ExpContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((ExpContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(149);
				((ExpContext)_localctx).right = exp();
				}
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public Token operator;
		public TermContext right;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(FOOLParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(FOOLParser.DIV, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((TermContext)_localctx).left = factor();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES || _la==DIV) {
				{
				setState(153);
				((TermContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
					((TermContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(154);
				((TermContext)_localctx).right = term();
				}
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

	public static class FactorContext extends ParserRuleContext {
		public ValueContext left;
		public Token operator;
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ() { return getToken(FOOLParser.EQ, 0); }
		public TerminalNode GREATER() { return getToken(FOOLParser.GREATER, 0); }
		public TerminalNode LQ() { return getToken(FOOLParser.LQ, 0); }
		public TerminalNode GQ() { return getToken(FOOLParser.GQ, 0); }
		public TerminalNode AND() { return getToken(FOOLParser.AND, 0); }
		public TerminalNode OR() { return getToken(FOOLParser.OR, 0); }
		public TerminalNode DEQ() { return getToken(FOOLParser.DEQ, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((FactorContext)_localctx).left = value();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << DEQ) | (1L << LQ) | (1L << GQ) | (1L << GREATER) | (1L << AND) | (1L << OR))) != 0)) {
				{
				setState(158);
				((FactorContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << DEQ) | (1L << LQ) | (1L << GQ) | (1L << GREATER) | (1L << AND) | (1L << OR))) != 0)) ) {
					((FactorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(159);
				((FactorContext)_localctx).right = value();
				}
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseExpContext extends ValueContext {
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(FOOLParser.NOT, 0); }
		public BaseExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitBaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(FOOLParser.NOT, 0); }
		public VarExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVarExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjCallContext extends ValueContext {
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(FOOLParser.NOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public ObjCallContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitObjCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValContext extends ValueContext {
		public TerminalNode INTEGER() { return getToken(FOOLParser.INTEGER, 0); }
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public IntValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullValContext extends ValueContext {
		public TerminalNode NULL() { return getToken(FOOLParser.NULL, 0); }
		public NullValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitNullVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VoidExpContext extends ValueContext {
		public TerminalNode VOID() { return getToken(FOOLParser.VOID, 0); }
		public VoidExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVoidExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfExpContext extends ValueContext {
		public ExpContext cond;
		public ExpContext thenBranch;
		public ExpContext elseBranch;
		public TerminalNode IF() { return getToken(FOOLParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FOOLParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FOOLParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FOOLParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FOOLParser.ELSE, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IfExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitIfExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjInstContext extends ValueContext {
		public TerminalNode NEW() { return getToken(FOOLParser.NEW, 0); }
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public ObjInstContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitObjInst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValContext extends ValueContext {
		public Token optionalNot;
		public Token booleanVal;
		public TerminalNode TRUE() { return getToken(FOOLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOOLParser.FALSE, 0); }
		public TerminalNode NOT() { return getToken(FOOLParser.NOT, 0); }
		public BoolValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitBoolVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(FOOLParser.NOT, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public FunExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitFunExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_value);
		int _la;
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(162);
					match(MINUS);
					}
				}

				setState(165);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(166);
					((BoolValContext)_localctx).optionalNot = match(NOT);
					}
				}

				setState(169);
				((BoolValContext)_localctx).booleanVal = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
					((BoolValContext)_localctx).booleanVal = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(NULL);
				}
				break;
			case 4:
				_localctx = new VoidExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				match(VOID);
				}
				break;
			case 5:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT || _la==MINUS) {
					{
					setState(172);
					_la = _input.LA(1);
					if ( !(_la==NOT || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(175);
				match(LPAR);
				setState(176);
				exp();
				setState(177);
				match(RPAR);
				}
				break;
			case 6:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(179);
				match(IF);
				setState(180);
				((IfExpContext)_localctx).cond = exp();
				setState(181);
				match(THEN);
				setState(182);
				match(CLPAR);
				setState(183);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(184);
				match(CRPAR);
				setState(185);
				match(ELSE);
				setState(186);
				match(CLPAR);
				setState(187);
				((IfExpContext)_localctx).elseBranch = exp();
				setState(188);
				match(CRPAR);
				}
				break;
			case 7:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT || _la==MINUS) {
					{
					setState(190);
					_la = _input.LA(1);
					if ( !(_la==NOT || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(193);
				match(ID);
				}
				break;
			case 8:
				_localctx = new FunExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT || _la==MINUS) {
					{
					setState(194);
					_la = _input.LA(1);
					if ( !(_la==NOT || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(197);
				match(ID);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(198);
					match(LPAR);
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(199);
						exp();
						setState(204);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(200);
							match(COMMA);
							setState(201);
							exp();
							}
							}
							setState(206);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(209);
					match(RPAR);
					}
				}

				}
				break;
			case 9:
				_localctx = new ObjInstContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(212);
				match(NEW);
				setState(213);
				match(ID);
				setState(214);
				match(LPAR);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(215);
					exp();
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(216);
						match(COMMA);
						setState(217);
						exp();
						}
						}
						setState(222);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(225);
				match(RPAR);
				}
				break;
			case 10:
				_localctx = new ObjCallContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT || _la==MINUS) {
					{
					setState(226);
					_la = _input.LA(1);
					if ( !(_la==NOT || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(229);
				match(ID);
				setState(230);
				match(T__0);
				setState(231);
				match(ID);
				setState(232);
				match(LPAR);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(233);
					exp();
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(234);
						match(COMMA);
						setState(235);
						exp();
						}
						}
						setState(240);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(243);
				match(RPAR);
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

	public static class StatsContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stats; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitStats(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatsContext stats() throws RecognitionException {
		StatsContext _localctx = new StatsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stats);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(246);
					stat();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(249); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatContext {
		public ExpContext cond;
		public StatsContext thenBranch;
		public StatsContext elseBranch;
		public TerminalNode IF() { return getToken(FOOLParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FOOLParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FOOLParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FOOLParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FOOLParser.ELSE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StatsContext> stats() {
			return getRuleContexts(StatsContext.class);
		}
		public StatsContext stats(int i) {
			return getRuleContext(StatsContext.class,i);
		}
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(FOOLParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarasmStatContext extends StatContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public VarasmStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitVarasmStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_stat);
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarasmStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				varasm();
				setState(252);
				match(SEMIC);
				}
				break;
			case PRINT:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(PRINT);
				setState(255);
				match(LPAR);
				setState(256);
				exp();
				setState(257);
				match(RPAR);
				setState(258);
				match(SEMIC);
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				match(IF);
				setState(261);
				((IfStatContext)_localctx).cond = exp();
				setState(262);
				match(THEN);
				setState(263);
				match(CLPAR);
				setState(264);
				((IfStatContext)_localctx).thenBranch = stats();
				setState(265);
				match(CRPAR);
				setState(266);
				match(ELSE);
				setState(267);
				match(CLPAR);
				setState(268);
				((IfStatContext)_localctx).elseBranch = stats();
				setState(269);
				match(CRPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2+\n\2\3\2\6\2.\n\2\r\2\16\2/\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\67\n\2\5\29\n\2\5\2;\n\2\3\3\3\3\6\3?\n\3\r\3\16\3@\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\5\4I\n\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\6\6R\n\6\r\6\16\6"+
		"S\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bb\n\b\f\b\16\be\13"+
		"\b\5\bg\n\b\3\b\3\b\5\bk\n\b\3\b\3\b\3\b\3\b\5\bq\n\b\3\t\3\t\5\tu\n\t"+
		"\3\n\3\n\3\n\3\n\5\n{\n\n\3\n\3\n\3\n\3\n\7\n\u0081\n\n\f\n\16\n\u0084"+
		"\13\n\3\n\3\n\5\n\u0088\n\n\3\n\3\n\7\n\u008c\n\n\f\n\16\n\u008f\13\n"+
		"\3\n\5\n\u0092\n\n\3\13\3\13\3\f\3\f\3\f\5\f\u0099\n\f\3\r\3\r\3\r\5\r"+
		"\u009e\n\r\3\16\3\16\3\16\5\16\u00a3\n\16\3\17\5\17\u00a6\n\17\3\17\3"+
		"\17\5\17\u00aa\n\17\3\17\3\17\3\17\3\17\5\17\u00b0\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00c2\n\17\3\17\3\17\5\17\u00c6\n\17\3\17\3\17\3\17\3\17\3\17\7\17\u00cd"+
		"\n\17\f\17\16\17\u00d0\13\17\5\17\u00d2\n\17\3\17\5\17\u00d5\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00dd\n\17\f\17\16\17\u00e0\13\17\5\17"+
		"\u00e2\n\17\3\17\3\17\5\17\u00e6\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\7\17\u00ef\n\17\f\17\16\17\u00f2\13\17\5\17\u00f4\n\17\3\17\5\17\u00f7"+
		"\n\17\3\20\6\20\u00fa\n\20\r\20\16\20\u00fb\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\5\21\u0112\n\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \2\b\6\2#$\'\'))++\3\2\21\22\3\2\23\24\4\2\7\13\r\16\3\2\25\26\4\2\17"+
		"\17\22\22\2\u0132\2:\3\2\2\2\4<\3\2\2\2\6D\3\2\2\2\bL\3\2\2\2\nO\3\2\2"+
		"\2\fW\3\2\2\2\16[\3\2\2\2\20t\3\2\2\2\22v\3\2\2\2\24\u0093\3\2\2\2\26"+
		"\u0095\3\2\2\2\30\u009a\3\2\2\2\32\u009f\3\2\2\2\34\u00f6\3\2\2\2\36\u00f9"+
		"\3\2\2\2 \u0111\3\2\2\2\"#\5\26\f\2#$\7\4\2\2$;\3\2\2\2%*\5\4\3\2&\'\5"+
		"\26\f\2\'(\7\4\2\2(+\3\2\2\2)+\5\36\20\2*&\3\2\2\2*)\3\2\2\2+;\3\2\2\2"+
		",.\5\22\n\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\608\3\2\2\2\61\66"+
		"\5\4\3\2\62\63\5\26\f\2\63\64\7\4\2\2\64\67\3\2\2\2\65\67\5\36\20\2\66"+
		"\62\3\2\2\2\66\65\3\2\2\2\679\3\2\2\28\61\3\2\2\289\3\2\2\29;\3\2\2\2"+
		":\"\3\2\2\2:%\3\2\2\2:-\3\2\2\2;\3\3\2\2\2<>\7\37\2\2=?\5\20\t\2>=\3\2"+
		"\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7 \2\2C\5\3\2\2\2DE\5\24"+
		"\13\2EH\7+\2\2FG\7\20\2\2GI\5\26\f\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7"+
		"\4\2\2K\7\3\2\2\2LM\5\24\13\2MN\7+\2\2N\t\3\2\2\2OQ\7\37\2\2PR\5\6\4\2"+
		"QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7 \2\2V\13\3\2\2"+
		"\2WX\7+\2\2XY\7\20\2\2YZ\5\26\f\2Z\r\3\2\2\2[\\\5\24\13\2\\]\7+\2\2]f"+
		"\7\27\2\2^c\5\b\5\2_`\7\6\2\2`b\5\b\5\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2"+
		"cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f^\3\2\2\2fg\3\2\2\2gh\3\2\2\2hj\7\30\2"+
		"\2ik\5\n\6\2ji\3\2\2\2jk\3\2\2\2kp\3\2\2\2lm\5\26\f\2mn\7\4\2\2nq\3\2"+
		"\2\2oq\5\36\20\2pl\3\2\2\2po\3\2\2\2q\17\3\2\2\2ru\5\6\4\2su\5\16\b\2"+
		"tr\3\2\2\2ts\3\2\2\2u\21\3\2\2\2vw\7%\2\2wz\7+\2\2xy\7&\2\2y{\7+\2\2z"+
		"x\3\2\2\2z{\3\2\2\2{\u0087\3\2\2\2|}\7\27\2\2}\u0082\5\b\5\2~\177\7\4"+
		"\2\2\177\u0081\5\b\5\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0086\7\30\2\2\u0086\u0088\3\2\2\2\u0087|\3\2\2\2\u0087\u0088\3\2\2\2"+
		"\u0088\u0091\3\2\2\2\u0089\u008d\7\31\2\2\u008a\u008c\5\16\b\2\u008b\u008a"+
		"\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\7\32\2\2\u0091\u0089\3"+
		"\2\2\2\u0091\u0092\3\2\2\2\u0092\23\3\2\2\2\u0093\u0094\t\2\2\2\u0094"+
		"\25\3\2\2\2\u0095\u0098\5\30\r\2\u0096\u0097\t\3\2\2\u0097\u0099\5\26"+
		"\f\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\27\3\2\2\2\u009a\u009d"+
		"\5\32\16\2\u009b\u009c\t\4\2\2\u009c\u009e\5\30\r\2\u009d\u009b\3\2\2"+
		"\2\u009d\u009e\3\2\2\2\u009e\31\3\2\2\2\u009f\u00a2\5\34\17\2\u00a0\u00a1"+
		"\t\5\2\2\u00a1\u00a3\5\34\17\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2"+
		"\u00a3\33\3\2\2\2\u00a4\u00a6\7\22\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00f7\7*\2\2\u00a8\u00aa\7\17\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00f7\t\6"+
		"\2\2\u00ac\u00f7\7\'\2\2\u00ad\u00f7\7)\2\2\u00ae\u00b0\t\7\2\2\u00af"+
		"\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\27"+
		"\2\2\u00b2\u00b3\5\26\f\2\u00b3\u00b4\7\30\2\2\u00b4\u00f7\3\2\2\2\u00b5"+
		"\u00b6\7\33\2\2\u00b6\u00b7\5\26\f\2\u00b7\u00b8\7\34\2\2\u00b8\u00b9"+
		"\7\31\2\2\u00b9\u00ba\5\26\f\2\u00ba\u00bb\7\32\2\2\u00bb\u00bc\7\35\2"+
		"\2\u00bc\u00bd\7\31\2\2\u00bd\u00be\5\26\f\2\u00be\u00bf\7\32\2\2\u00bf"+
		"\u00f7\3\2\2\2\u00c0\u00c2\t\7\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00f7\7+\2\2\u00c4\u00c6\t\7\2\2\u00c5"+
		"\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00d4\7+"+
		"\2\2\u00c8\u00d1\7\27\2\2\u00c9\u00ce\5\26\f\2\u00ca\u00cb\7\6\2\2\u00cb"+
		"\u00cd\5\26\f\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3"+
		"\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1"+
		"\u00c9\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\7\30"+
		"\2\2\u00d4\u00c8\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00f7\3\2\2\2\u00d6"+
		"\u00d7\7(\2\2\u00d7\u00d8\7+\2\2\u00d8\u00e1\7\27\2\2\u00d9\u00de\5\26"+
		"\f\2\u00da\u00db\7\6\2\2\u00db\u00dd\5\26\f\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00f7\7\30\2\2\u00e4\u00e6\t\7\2\2\u00e5\u00e4\3"+
		"\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7+\2\2\u00e8"+
		"\u00e9\7\3\2\2\u00e9\u00ea\7+\2\2\u00ea\u00f3\7\27\2\2\u00eb\u00f0\5\26"+
		"\f\2\u00ec\u00ed\7\6\2\2\u00ed\u00ef\5\26\f\2\u00ee\u00ec\3\2\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2"+
		"\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00eb\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f7\7\30\2\2\u00f6\u00a5\3\2\2\2\u00f6\u00a9\3"+
		"\2\2\2\u00f6\u00ac\3\2\2\2\u00f6\u00ad\3\2\2\2\u00f6\u00af\3\2\2\2\u00f6"+
		"\u00b5\3\2\2\2\u00f6\u00c1\3\2\2\2\u00f6\u00c5\3\2\2\2\u00f6\u00d6\3\2"+
		"\2\2\u00f6\u00e5\3\2\2\2\u00f7\35\3\2\2\2\u00f8\u00fa\5 \21\2\u00f9\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\37\3\2\2\2\u00fd\u00fe\5\f\7\2\u00fe\u00ff\7\4\2\2\u00ff\u0112\3\2\2"+
		"\2\u0100\u0101\7\36\2\2\u0101\u0102\7\27\2\2\u0102\u0103\5\26\f\2\u0103"+
		"\u0104\7\30\2\2\u0104\u0105\7\4\2\2\u0105\u0112\3\2\2\2\u0106\u0107\7"+
		"\33\2\2\u0107\u0108\5\26\f\2\u0108\u0109\7\34\2\2\u0109\u010a\7\31\2\2"+
		"\u010a\u010b\5\36\20\2\u010b\u010c\7\32\2\2\u010c\u010d\7\35\2\2\u010d"+
		"\u010e\7\31\2\2\u010e\u010f\5\36\20\2\u010f\u0110\7\32\2\2\u0110\u0112"+
		"\3\2\2\2\u0111\u00fd\3\2\2\2\u0111\u0100\3\2\2\2\u0111\u0106\3\2\2\2\u0112"+
		"!\3\2\2\2\'*/\668:@HScfjptz\u0082\u0087\u008d\u0091\u0098\u009d\u00a2"+
		"\u00a5\u00a9\u00af\u00c1\u00c5\u00ce\u00d1\u00d4\u00de\u00e1\u00e5\u00f0"+
		"\u00f3\u00f6\u00fb\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}