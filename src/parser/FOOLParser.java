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
		ELSE=27, LET=28, IN=29, VAR=30, FUN=31, INT=32, BOOL=33, CLASS=34, EXTENDS=35, 
		NULL=36, NEW=37, VOID=38, INTEGER=39, ID=40, WS=41, LINECOMENTS=42, BLOCKCOMENTS=43, 
		ERR=44;
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
		"'false'", "'('", "')'", "'{'", "'}'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'var'", "'fun'", "'int'", "'bool'", "'class'", "'extends'", "'null'", 
		"'new'", "'void'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "SEMIC", "COLON", "COMMA", "EQ", "DEQ", "LQ", "GQ", "GREATER", 
		"LESS", "AND", "OR", "NOT", "ASM", "PLUS", "MINUS", "TIMES", "DIV", "TRUE", 
		"FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", "LET", 
		"IN", "VAR", "FUN", "INT", "BOOL", "CLASS", "EXTENDS", "NULL", "NEW", 
		"VOID", "INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", "ERR"
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
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
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
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
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
			setState(58);
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
				setState(38);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					exp();
					}
					break;
				case 2:
					{
					setState(37);
					stats();
					}
					break;
				}
				setState(40);
				match(SEMIC);
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
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << LET) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(47);
						let();
						}
					}

					setState(52);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(50);
						exp();
						}
						break;
					case 2:
						{
						setState(51);
						stats();
						}
						break;
					}
					setState(54);
					match(SEMIC);
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
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
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
			setState(60);
			match(LET);
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				dec();
				setState(62);
				match(SEMIC);
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(68);
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
			setState(70);
			type();
			setState(71);
			match(ID);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASM) {
				{
				setState(72);
				match(ASM);
				setState(73);
				exp();
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
			setState(76);
			type();
			setState(77);
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
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
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
			setState(79);
			match(LET);
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(80);
				vardec();
				setState(81);
				match(SEMIC);
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(87);
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
			setState(89);
			match(ID);
			setState(90);
			match(ASM);
			setState(91);
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
		public List<ArgdecContext> argdec() {
			return getRuleContexts(ArgdecContext.class);
		}
		public ArgdecContext argdec(int i) {
			return getRuleContext(ArgdecContext.class,i);
		}
		public FunletContext funlet() {
			return getRuleContext(FunletContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<StatsContext> stats() {
			return getRuleContexts(StatsContext.class);
		}
		public StatsContext stats(int i) {
			return getRuleContext(StatsContext.class,i);
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
			setState(93);
			type();
			setState(94);
			match(ID);
			setState(95);
			match(LPAR);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(96);
				argdec();
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(97);
					match(COMMA);
					setState(98);
					argdec();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(106);
			match(RPAR);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(107);
				funlet();
				}
			}

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
				{
				setState(112);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(110);
					exp();
					}
					break;
				case 2:
					{
					setState(111);
					stats();
					}
					break;
				}
				}
				setState(116);
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
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new VarDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				vardec();
				}
				break;
			case 2:
				_localctx = new FunDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
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
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public TerminalNode CLPAR() { return getToken(FOOLParser.CLPAR, 0); }
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public TerminalNode CRPAR() { return getToken(FOOLParser.CRPAR, 0); }
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
			setState(121);
			match(CLASS);
			setState(122);
			match(ID);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(123);
				match(EXTENDS);
				setState(124);
				match(ID);
				}
			}

			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(127);
				match(LPAR);
				setState(128);
				vardec();
				setState(129);
				match(SEMIC);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					{
					setState(130);
					vardec();
					setState(131);
					match(SEMIC);
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(RPAR);
				}
				break;
			}
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLPAR) {
				{
				setState(142);
				match(CLPAR);
				setState(143);
				fun();
				setState(144);
				match(SEMIC);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					{
					setState(145);
					fun();
					setState(146);
					match(SEMIC);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
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
			setState(157);
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
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(159);
				match(MINUS);
				}
			}

			setState(162);
			((ExpContext)_localctx).left = term();
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(163);
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
				setState(164);
				((ExpContext)_localctx).right = exp();
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
			setState(167);
			((TermContext)_localctx).left = factor();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES || _la==DIV) {
				{
				setState(168);
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
				setState(169);
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
			setState(172);
			((FactorContext)_localctx).left = value();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << DEQ) | (1L << LQ) | (1L << GQ) | (1L << GREATER) | (1L << AND) | (1L << OR))) != 0)) {
				{
				setState(173);
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
				setState(174);
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
		public BaseExpContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitBaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExpContext extends ValueContext {
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
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
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
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
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
<<<<<<< HEAD
					setState(178);
=======
					setState(173);
>>>>>>> origin/LorenzoMass
					((BoolValContext)_localctx).optionalNot = match(NOT);
					}
				}

<<<<<<< HEAD
				setState(181);
=======
				setState(176);
>>>>>>> origin/LorenzoMass
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
				setState(182);
				match(NULL);
				}
				break;
			case 4:
				_localctx = new VoidExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(VOID);
				}
				break;
			case 5:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(184);
				match(LPAR);
				setState(185);
				exp();
				setState(186);
				match(RPAR);
				}
				break;
			case 6:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				match(IF);
				setState(189);
				((IfExpContext)_localctx).cond = exp();
				setState(190);
				match(THEN);
				setState(191);
				match(CLPAR);
				setState(192);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(193);
				match(CRPAR);
				setState(194);
				match(ELSE);
				setState(195);
				match(CLPAR);
				setState(196);
				((IfExpContext)_localctx).elseBranch = exp();
				setState(197);
				match(CRPAR);
				}
				break;
			case 7:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(199);
				match(ID);
				}
				break;
			case 8:
				_localctx = new FunExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(200);
				match(ID);
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(201);
					match(LPAR);
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(202);
						exp();
						setState(207);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(203);
							match(COMMA);
							setState(204);
							exp();
							}
							}
							setState(209);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(212);
					match(RPAR);
					}
					break;
				}
				}
				break;
			case 9:
				_localctx = new ObjInstContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(215);
				match(NEW);
				setState(216);
				match(ID);
				setState(217);
				match(LPAR);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(218);
					match(ID);
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(219);
						match(COMMA);
						setState(220);
						match(ID);
						}
						}
						setState(225);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(228);
				match(RPAR);
				}
				break;
			case 10:
				_localctx = new ObjCallContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
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
				if (_la==ID) {
					{
					setState(233);
					match(ID);
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(234);
						match(COMMA);
						setState(235);
						match(ID);
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
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
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
			setState(246);
			stat();
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(247);
					match(SEMIC);
					setState(248);
					stat();
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
	public static class VarasmStatContext extends StatContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
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
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarasmStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				varasm();
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(IF);
				setState(256);
				((IfStatContext)_localctx).cond = exp();
				setState(257);
				match(THEN);
				setState(258);
				match(CLPAR);
				setState(259);
				((IfStatContext)_localctx).thenBranch = stats();
				setState(260);
				match(CRPAR);
				setState(261);
				match(ELSE);
				setState(262);
				match(CLPAR);
				setState(263);
				((IfStatContext)_localctx).elseBranch = stats();
				setState(264);
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
<<<<<<< HEAD
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u010f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\2)\n\2\3\2\3\2\3\2\6\2.\n\2\r\2\16\2/\3\2\5\2\63\n\2"+
		"\3\2\3\2\5\2\67\n\2\3\2\3\2\5\2;\n\2\5\2=\n\2\3\3\3\3\3\3\3\3\6\3C\n\3"+
		"\r\3\16\3D\3\3\3\3\3\4\3\4\3\4\3\4\5\4M\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\6\6V\n\6\r\6\16\6W\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\bf\n\b\f\b\16\bi\13\b\5\bk\n\b\3\b\3\b\5\bo\n\b\3\b\3\b\7\bs\n\b\f"+
		"\b\16\bv\13\b\3\t\3\t\5\tz\n\t\3\n\3\n\3\n\3\n\5\n\u0080\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u0088\n\n\f\n\16\n\u008b\13\n\3\n\3\n\5\n\u008f\n\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0097\n\n\f\n\16\n\u009a\13\n\3\n\3\n\5\n"+
		"\u009e\n\n\3\13\3\13\3\f\5\f\u00a3\n\f\3\f\3\f\3\f\5\f\u00a8\n\f\3\r\3"+
		"\r\3\r\5\r\u00ad\n\r\3\16\3\16\3\16\5\16\u00b2\n\16\3\17\3\17\5\17\u00b6"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00d0\n\17"+
		"\f\17\16\17\u00d3\13\17\5\17\u00d5\n\17\3\17\5\17\u00d8\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u00e0\n\17\f\17\16\17\u00e3\13\17\5\17\u00e5"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00ef\n\17\f\17\16"+
		"\17\u00f2\13\17\5\17\u00f4\n\17\3\17\5\17\u00f7\n\17\3\20\3\20\3\20\7"+
		"\20\u00fc\n\20\f\20\16\20\u00ff\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\5\21\u010d\n\21\3\21\2\2\22\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \2\7\6\2\"#&&((**\3\2\21\22\3\2\23\24\4\2\7\13"+
		"\r\16\3\2\25\26\2\u012a\2<\3\2\2\2\4>\3\2\2\2\6H\3\2\2\2\bN\3\2\2\2\n"+
		"Q\3\2\2\2\f[\3\2\2\2\16_\3\2\2\2\20y\3\2\2\2\22{\3\2\2\2\24\u009f\3\2"+
		"\2\2\26\u00a2\3\2\2\2\30\u00a9\3\2\2\2\32\u00ae\3\2\2\2\34\u00f6\3\2\2"+
		"\2\36\u00f8\3\2\2\2 \u010c\3\2\2\2\"#\5\26\f\2#$\7\4\2\2$=\3\2\2\2%(\5"+
		"\4\3\2&)\5\26\f\2\')\5\36\20\2(&\3\2\2\2(\'\3\2\2\2)*\3\2\2\2*+\7\4\2"+
		"\2+=\3\2\2\2,.\5\22\n\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60:"+
		"\3\2\2\2\61\63\5\4\3\2\62\61\3\2\2\2\62\63\3\2\2\2\63\66\3\2\2\2\64\67"+
		"\5\26\f\2\65\67\5\36\20\2\66\64\3\2\2\2\66\65\3\2\2\2\678\3\2\2\289\7"+
		"\4\2\29;\3\2\2\2:\62\3\2\2\2:;\3\2\2\2;=\3\2\2\2<\"\3\2\2\2<%\3\2\2\2"+
		"<-\3\2\2\2=\3\3\2\2\2>B\7\36\2\2?@\5\20\t\2@A\7\4\2\2AC\3\2\2\2B?\3\2"+
		"\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7\37\2\2G\5\3\2\2\2HI\5"+
		"\24\13\2IL\7*\2\2JK\7\20\2\2KM\5\26\f\2LJ\3\2\2\2LM\3\2\2\2M\7\3\2\2\2"+
		"NO\5\24\13\2OP\7*\2\2P\t\3\2\2\2QU\7\36\2\2RS\5\6\4\2ST\7\4\2\2TV\3\2"+
		"\2\2UR\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\37\2\2Z\13"+
		"\3\2\2\2[\\\7*\2\2\\]\7\20\2\2]^\5\26\f\2^\r\3\2\2\2_`\5\24\13\2`a\7*"+
		"\2\2aj\7\27\2\2bg\5\b\5\2cd\7\6\2\2df\5\b\5\2ec\3\2\2\2fi\3\2\2\2ge\3"+
		"\2\2\2gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jb\3\2\2\2jk\3\2\2\2kl\3\2\2\2ln\7"+
		"\30\2\2mo\5\n\6\2nm\3\2\2\2no\3\2\2\2ot\3\2\2\2ps\5\26\f\2qs\5\36\20\2"+
		"rp\3\2\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\17\3\2\2\2vt\3\2\2"+
		"\2wz\5\6\4\2xz\5\16\b\2yw\3\2\2\2yx\3\2\2\2z\21\3\2\2\2{|\7$\2\2|\177"+
		"\7*\2\2}~\7%\2\2~\u0080\7*\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u008e"+
		"\3\2\2\2\u0081\u0082\7\27\2\2\u0082\u0083\5\6\4\2\u0083\u0089\7\4\2\2"+
		"\u0084\u0085\5\6\4\2\u0085\u0086\7\4\2\2\u0086\u0088\3\2\2\2\u0087\u0084"+
		"\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7\30\2\2\u008d\u008f\3"+
		"\2\2\2\u008e\u0081\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u009d\3\2\2\2\u0090"+
		"\u0091\7\31\2\2\u0091\u0092\5\16\b\2\u0092\u0098\7\4\2\2\u0093\u0094\5"+
		"\16\b\2\u0094\u0095\7\4\2\2\u0095\u0097\3\2\2\2\u0096\u0093\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\32\2\2\u009c\u009e\3\2\2\2\u009d"+
		"\u0090\3\2\2\2\u009d\u009e\3\2\2\2\u009e\23\3\2\2\2\u009f\u00a0\t\2\2"+
		"\2\u00a0\25\3\2\2\2\u00a1\u00a3\7\22\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7\5\30\r\2\u00a5\u00a6\t\3\2\2"+
		"\u00a6\u00a8\5\26\f\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\27"+
		"\3\2\2\2\u00a9\u00ac\5\32\16\2\u00aa\u00ab\t\4\2\2\u00ab\u00ad\5\30\r"+
		"\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\31\3\2\2\2\u00ae\u00b1"+
		"\5\34\17\2\u00af\u00b0\t\5\2\2\u00b0\u00b2\5\34\17\2\u00b1\u00af\3\2\2"+
		"\2\u00b1\u00b2\3\2\2\2\u00b2\33\3\2\2\2\u00b3\u00f7\7)\2\2\u00b4\u00b6"+
		"\7\17\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2"+
		"\u00b7\u00f7\t\6\2\2\u00b8\u00f7\7&\2\2\u00b9\u00f7\7(\2\2\u00ba\u00bb"+
		"\7\27\2\2\u00bb\u00bc\5\26\f\2\u00bc\u00bd\7\30\2\2\u00bd\u00f7\3\2\2"+
		"\2\u00be\u00bf\7\33\2\2\u00bf\u00c0\5\26\f\2\u00c0\u00c1\7\34\2\2\u00c1"+
		"\u00c2\7\31\2\2\u00c2\u00c3\5\26\f\2\u00c3\u00c4\7\32\2\2\u00c4\u00c5"+
		"\7\35\2\2\u00c5\u00c6\7\31\2\2\u00c6\u00c7\5\26\f\2\u00c7\u00c8\7\32\2"+
		"\2\u00c8\u00f7\3\2\2\2\u00c9\u00f7\7*\2\2\u00ca\u00d7\7*\2\2\u00cb\u00d4"+
		"\7\27\2\2\u00cc\u00d1\5\26\f\2\u00cd\u00ce\7\6\2\2\u00ce\u00d0\5\26\f"+
		"\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00cc\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\7\30\2\2\u00d7\u00cb\3"+
		"\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00f7\3\2\2\2\u00d9\u00da\7\'\2\2\u00da"+
		"\u00db\7*\2\2\u00db\u00e4\7\27\2\2\u00dc\u00e1\7*\2\2\u00dd\u00de\7\6"+
		"\2\2\u00de\u00e0\7*\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00dc\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00f7\7\30\2\2\u00e7\u00e8\7*\2\2\u00e8\u00e9\7\3\2\2\u00e9\u00ea\7*"+
		"\2\2\u00ea\u00f3\7\27\2\2\u00eb\u00f0\7*\2\2\u00ec\u00ed\7\6\2\2\u00ed"+
		"\u00ef\7*\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2"+
		"\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00eb\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\7\30"+
		"\2\2\u00f6\u00b3\3\2\2\2\u00f6\u00b5\3\2\2\2\u00f6\u00b8\3\2\2\2\u00f6"+
		"\u00b9\3\2\2\2\u00f6\u00ba\3\2\2\2\u00f6\u00be\3\2\2\2\u00f6\u00c9\3\2"+
		"\2\2\u00f6\u00ca\3\2\2\2\u00f6\u00d9\3\2\2\2\u00f6\u00e7\3\2\2\2\u00f7"+
		"\35\3\2\2\2\u00f8\u00fd\5 \21\2\u00f9\u00fa\7\4\2\2\u00fa\u00fc\5 \21"+
		"\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe"+
		"\3\2\2\2\u00fe\37\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u010d\5\f\7\2\u0101"+
		"\u0102\7\33\2\2\u0102\u0103\5\26\f\2\u0103\u0104\7\34\2\2\u0104\u0105"+
		"\7\31\2\2\u0105\u0106\5\36\20\2\u0106\u0107\7\32\2\2\u0107\u0108\7\35"+
		"\2\2\u0108\u0109\7\31\2\2\u0109\u010a\5\36\20\2\u010a\u010b\7\32\2\2\u010b"+
		"\u010d\3\2\2\2\u010c\u0100\3\2\2\2\u010c\u0101\3\2\2\2\u010d!\3\2\2\2"+
		"%(/\62\66:<DLWgjnrty\177\u0089\u008e\u0098\u009d\u00a2\u00a7\u00ac\u00b1"+
		"\u00b5\u00d1\u00d4\u00d7\u00e1\u00e4\u00f0\u00f3\u00f6\u00fd\u010c";
=======
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\'\n\2\3\2\3\2\3\2\6\2,\n\2\r\2\16\2-\3\2\5\2\61\n\2\3\2\3\2\5"+
		"\2\65\n\2\3\2\3\2\5\29\n\2\5\2;\n\2\3\3\3\3\3\3\3\3\6\3A\n\3\r\3\16\3"+
		"B\3\3\3\3\3\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\5\6\5Q\n\5\r\5\16\5R"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7d\13"+
		"\7\5\7f\n\7\3\7\3\7\5\7j\n\7\3\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\b\3\b\5"+
		"\bu\n\b\3\t\3\t\3\t\3\t\5\t{\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0083\n\t"+
		"\f\t\16\t\u0086\13\t\3\t\3\t\5\t\u008a\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u0092\n\t\f\t\16\t\u0095\13\t\3\t\3\t\5\t\u0099\n\t\3\n\3\n\3\13\5\13"+
		"\u009e\n\13\3\13\3\13\3\13\5\13\u00a3\n\13\3\f\3\f\3\f\5\f\u00a8\n\f\3"+
		"\r\3\r\3\r\5\r\u00ad\n\r\3\16\3\16\5\16\u00b1\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00cb\n\16\f\16\16\16\u00ce\13\16"+
		"\5\16\u00d0\n\16\3\16\5\16\u00d3\n\16\3\16\3\16\3\16\3\16\3\16\3\16\7"+
		"\16\u00db\n\16\f\16\16\16\u00de\13\16\5\16\u00e0\n\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u00ea\n\16\f\16\16\16\u00ed\13\16\5\16\u00ef"+
		"\n\16\3\16\5\16\u00f2\n\16\3\17\3\17\3\17\7\17\u00f7\n\17\f\17\16\17\u00fa"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u0108\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\7\6\2"+
		"\"#&&((**\3\2\21\22\3\2\23\24\4\2\7\13\r\16\3\2\25\26\2\u0126\2:\3\2\2"+
		"\2\4<\3\2\2\2\6F\3\2\2\2\bL\3\2\2\2\nV\3\2\2\2\fZ\3\2\2\2\16t\3\2\2\2"+
		"\20v\3\2\2\2\22\u009a\3\2\2\2\24\u009d\3\2\2\2\26\u00a4\3\2\2\2\30\u00a9"+
		"\3\2\2\2\32\u00f1\3\2\2\2\34\u00f3\3\2\2\2\36\u0107\3\2\2\2 !\5\24\13"+
		"\2!\"\7\4\2\2\";\3\2\2\2#&\5\4\3\2$\'\5\24\13\2%\'\5\34\17\2&$\3\2\2\2"+
		"&%\3\2\2\2\'(\3\2\2\2()\7\4\2\2);\3\2\2\2*,\5\20\t\2+*\3\2\2\2,-\3\2\2"+
		"\2-+\3\2\2\2-.\3\2\2\2.8\3\2\2\2/\61\5\4\3\2\60/\3\2\2\2\60\61\3\2\2\2"+
		"\61\64\3\2\2\2\62\65\5\24\13\2\63\65\5\34\17\2\64\62\3\2\2\2\64\63\3\2"+
		"\2\2\65\66\3\2\2\2\66\67\7\4\2\2\679\3\2\2\28\60\3\2\2\289\3\2\2\29;\3"+
		"\2\2\2: \3\2\2\2:#\3\2\2\2:+\3\2\2\2;\3\3\2\2\2<@\7\36\2\2=>\5\16\b\2"+
		">?\7\4\2\2?A\3\2\2\2@=\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2"+
		"DE\7\37\2\2E\5\3\2\2\2FG\5\22\n\2GJ\7*\2\2HI\7\20\2\2IK\5\24\13\2JH\3"+
		"\2\2\2JK\3\2\2\2K\7\3\2\2\2LP\7\36\2\2MN\5\6\4\2NO\7\4\2\2OQ\3\2\2\2P"+
		"M\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\37\2\2U\t\3\2\2"+
		"\2VW\7*\2\2WX\7\20\2\2XY\5\24\13\2Y\13\3\2\2\2Z[\5\22\n\2[\\\7*\2\2\\"+
		"e\7\27\2\2]b\5\6\4\2^_\7\6\2\2_a\5\6\4\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2"+
		"bc\3\2\2\2cf\3\2\2\2db\3\2\2\2e]\3\2\2\2ef\3\2\2\2fg\3\2\2\2gi\7\30\2"+
		"\2hj\5\b\5\2ih\3\2\2\2ij\3\2\2\2jo\3\2\2\2kn\5\24\13\2ln\5\34\17\2mk\3"+
		"\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\r\3\2\2\2qo\3\2\2\2ru"+
		"\5\6\4\2su\5\f\7\2tr\3\2\2\2ts\3\2\2\2u\17\3\2\2\2vw\7$\2\2wz\7*\2\2x"+
		"y\7%\2\2y{\7*\2\2zx\3\2\2\2z{\3\2\2\2{\u0089\3\2\2\2|}\7\27\2\2}~\5\6"+
		"\4\2~\u0084\7\4\2\2\177\u0080\5\6\4\2\u0080\u0081\7\4\2\2\u0081\u0083"+
		"\3\2\2\2\u0082\177\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\30"+
		"\2\2\u0088\u008a\3\2\2\2\u0089|\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0098"+
		"\3\2\2\2\u008b\u008c\7\31\2\2\u008c\u008d\5\f\7\2\u008d\u0093\7\4\2\2"+
		"\u008e\u008f\5\f\7\2\u008f\u0090\7\4\2\2\u0090\u0092\3\2\2\2\u0091\u008e"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\32\2\2\u0097\u0099\3"+
		"\2\2\2\u0098\u008b\3\2\2\2\u0098\u0099\3\2\2\2\u0099\21\3\2\2\2\u009a"+
		"\u009b\t\2\2\2\u009b\23\3\2\2\2\u009c\u009e\7\22\2\2\u009d\u009c\3\2\2"+
		"\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\5\26\f\2\u00a0"+
		"\u00a1\t\3\2\2\u00a1\u00a3\5\24\13\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3"+
		"\2\2\2\u00a3\25\3\2\2\2\u00a4\u00a7\5\30\r\2\u00a5\u00a6\t\4\2\2\u00a6"+
		"\u00a8\5\26\f\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\27\3\2\2"+
		"\2\u00a9\u00ac\5\32\16\2\u00aa\u00ab\t\5\2\2\u00ab\u00ad\5\32\16\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\31\3\2\2\2\u00ae\u00f2\7)\2\2"+
		"\u00af\u00b1\7\17\2\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00f2\t\6\2\2\u00b3\u00f2\7&\2\2\u00b4\u00f2\7(\2\2\u00b5"+
		"\u00b6\7\27\2\2\u00b6\u00b7\5\24\13\2\u00b7\u00b8\7\30\2\2\u00b8\u00f2"+
		"\3\2\2\2\u00b9\u00ba\7\33\2\2\u00ba\u00bb\5\24\13\2\u00bb\u00bc\7\34\2"+
		"\2\u00bc\u00bd\7\31\2\2\u00bd\u00be\5\24\13\2\u00be\u00bf\7\32\2\2\u00bf"+
		"\u00c0\7\35\2\2\u00c0\u00c1\7\31\2\2\u00c1\u00c2\5\24\13\2\u00c2\u00c3"+
		"\7\32\2\2\u00c3\u00f2\3\2\2\2\u00c4\u00f2\7*\2\2\u00c5\u00d2\7*\2\2\u00c6"+
		"\u00cf\7\27\2\2\u00c7\u00cc\5\24\13\2\u00c8\u00c9\7\6\2\2\u00c9\u00cb"+
		"\5\24\13\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2"+
		"\u00cc\u00cd\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00c7"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\7\30\2\2"+
		"\u00d2\u00c6\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00f2\3\2\2\2\u00d4\u00d5"+
		"\7\'\2\2\u00d5\u00d6\7*\2\2\u00d6\u00df\7\27\2\2\u00d7\u00dc\7*\2\2\u00d8"+
		"\u00d9\7\6\2\2\u00d9\u00db\7*\2\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2"+
		"\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00d7\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00f2\7\30\2\2\u00e2\u00e3\7*\2\2\u00e3\u00e4\7\3\2\2\u00e4"+
		"\u00e5\7*\2\2\u00e5\u00ee\7\27\2\2\u00e6\u00eb\7*\2\2\u00e7\u00e8\7\6"+
		"\2\2\u00e8\u00ea\7*\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ee\u00e6\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f2\7\30\2\2\u00f1\u00ae\3\2\2\2\u00f1\u00b0\3\2\2\2\u00f1\u00b3\3"+
		"\2\2\2\u00f1\u00b4\3\2\2\2\u00f1\u00b5\3\2\2\2\u00f1\u00b9\3\2\2\2\u00f1"+
		"\u00c4\3\2\2\2\u00f1\u00c5\3\2\2\2\u00f1\u00d4\3\2\2\2\u00f1\u00e2\3\2"+
		"\2\2\u00f2\33\3\2\2\2\u00f3\u00f8\5\36\20\2\u00f4\u00f5\7\4\2\2\u00f5"+
		"\u00f7\5\36\20\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3"+
		"\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\35\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb"+
		"\u0108\5\n\6\2\u00fc\u00fd\7\33\2\2\u00fd\u00fe\5\24\13\2\u00fe\u00ff"+
		"\7\34\2\2\u00ff\u0100\7\31\2\2\u0100\u0101\5\34\17\2\u0101\u0102\7\32"+
		"\2\2\u0102\u0103\7\35\2\2\u0103\u0104\7\31\2\2\u0104\u0105\5\34\17\2\u0105"+
		"\u0106\7\32\2\2\u0106\u0108\3\2\2\2\u0107\u00fb\3\2\2\2\u0107\u00fc\3"+
		"\2\2\2\u0108\37\3\2\2\2%&-\60\648:BJRbeimotz\u0084\u0089\u0093\u0098\u009d"+
		"\u00a2\u00a7\u00ac\u00b0\u00cc\u00cf\u00d2\u00dc\u00df\u00eb\u00ee\u00f1"+
		"\u00f8\u0107";
>>>>>>> origin/LorenzoMass
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}