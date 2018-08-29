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
		T__0=1, SEMIC=2, COLON=3, COMMA=4, EQ=5, ASM=6, PLUS=7, MINUS=8, TIMES=9, 
		DIV=10, TRUE=11, FALSE=12, LPAR=13, RPAR=14, CLPAR=15, CRPAR=16, IF=17, 
		THEN=18, ELSE=19, LET=20, IN=21, VAR=22, FUN=23, INT=24, BOOL=25, CLASS=26, 
		EXTENDS=27, NULL=28, NEW=29, VOID=30, INTEGER=31, ID=32, WS=33, LINECOMENTS=34, 
		BLOCKCOMENTS=35, ERR=36;
	public static final int
		RULE_prog = 0, RULE_let = 1, RULE_vardec = 2, RULE_funlet = 3, RULE_varasm = 4, 
		RULE_fun = 5, RULE_dec = 6, RULE_classdec = 7, RULE_type = 8, RULE_exp = 9, 
		RULE_term = 10, RULE_factor = 11, RULE_value = 12, RULE_stats = 13, RULE_stat = 14;
	public static final String[] ruleNames = {
		"prog", "let", "vardec", "funlet", "varasm", "fun", "dec", "classdec", 
		"type", "exp", "term", "factor", "value", "stats", "stat"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "';'", "':'", "','", "'=='", "'='", "'+'", "'-'", "'*'", 
		"'/'", "'true'", "'false'", "'('", "')'", "'{'", "'}'", "'if'", "'then'", 
		"'else'", "'let'", "'in'", "'var'", "'fun'", "'int'", "'bool'", "'class'", 
		"'extends'", "'null'", "'new'", "'void'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "SEMIC", "COLON", "COMMA", "EQ", "ASM", "PLUS", "MINUS", "TIMES", 
		"DIV", "TRUE", "FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", 
		"ELSE", "LET", "IN", "VAR", "FUN", "INT", "BOOL", "CLASS", "EXTENDS", 
		"NULL", "NEW", "VOID", "INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", 
		"ERR"
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
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
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
				setState(30);
				exp();
				setState(31);
				match(SEMIC);
				}
				break;
			case LET:
				_localctx = new LetInExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				let();
				setState(36);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(34);
					exp();
					}
					break;
				case 2:
					{
					setState(35);
					stats();
					}
					break;
				}
				setState(38);
				match(SEMIC);
				}
				break;
			case CLASS:
				_localctx = new ClassdecExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(40);
					classdec();
					}
					}
					setState(43); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CLASS );
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << LET) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(45);
						let();
						}
					}

					setState(50);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(48);
						exp();
						}
						break;
					case 2:
						{
						setState(49);
						stats();
						}
						break;
					}
					setState(52);
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
			setState(58);
			match(LET);
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				dec();
				setState(60);
				match(SEMIC);
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(66);
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
			setState(68);
			type();
			setState(69);
			match(ID);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASM) {
				{
				setState(70);
				match(ASM);
				setState(71);
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
		enterRule(_localctx, 6, RULE_funlet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(LET);
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				vardec();
				setState(76);
				match(SEMIC);
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(82);
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
		enterRule(_localctx, 8, RULE_varasm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(ID);
			setState(85);
			match(ASM);
			setState(86);
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
		public List<VardecContext> vardec() {
			return getRuleContexts(VardecContext.class);
		}
		public VardecContext vardec(int i) {
			return getRuleContext(VardecContext.class,i);
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
		enterRule(_localctx, 10, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			type();
			setState(89);
			match(ID);
			setState(90);
			match(LPAR);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(91);
				vardec();
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(92);
					match(COMMA);
					setState(93);
					vardec();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(101);
			match(RPAR);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(102);
				funlet();
				}
			}

			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
				{
				setState(107);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(105);
					exp();
					}
					break;
				case 2:
					{
					setState(106);
					stats();
					}
					break;
				}
				}
				setState(111);
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
		enterRule(_localctx, 12, RULE_dec);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
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
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
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
		enterRule(_localctx, 14, RULE_classdec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(CLASS);
			setState(117);
			match(ID);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(118);
				match(EXTENDS);
				setState(119);
				match(ID);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(120);
					match(COMMA);
					setState(121);
					match(ID);
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(129);
				match(LPAR);
				setState(130);
				vardec();
				setState(131);
				match(SEMIC);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					{
					setState(132);
					vardec();
					setState(133);
					match(SEMIC);
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(RPAR);
				}
				break;
			}
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLPAR) {
				{
				setState(144);
				match(CLPAR);
				setState(145);
				fun();
				setState(146);
				match(SEMIC);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) {
					{
					{
					setState(147);
					fun();
					setState(148);
					match(SEMIC);
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(155);
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
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << VOID) | (1L << ID))) != 0)) ) {
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
		public ExpContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FOOLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(161);
				match(MINUS);
				}
			}

			setState(164);
			((ExpContext)_localctx).left = term();
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(165);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(166);
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
		public TermContext right;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(FOOLParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(FOOLParser.DIV, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((TermContext)_localctx).left = factor();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES || _la==DIV) {
				{
				setState(170);
				_la = _input.LA(1);
				if ( !(_la==TIMES || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(171);
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
		public ValueContext right;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ() { return getToken(FOOLParser.EQ, 0); }
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
		enterRule(_localctx, 22, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((FactorContext)_localctx).left = value();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(175);
				match(EQ);
				setState(176);
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
		public TerminalNode TRUE() { return getToken(FOOLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOOLParser.FALSE, 0); }
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
		enterRule(_localctx, 24, RULE_value);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
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
				setState(181);
				match(NULL);
				}
				break;
			case 4:
				_localctx = new VoidExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(VOID);
				}
				break;
			case 5:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				match(LPAR);
				setState(184);
				exp();
				setState(185);
				match(RPAR);
				}
				break;
			case 6:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(187);
				match(IF);
				setState(188);
				((IfExpContext)_localctx).cond = exp();
				setState(189);
				match(THEN);
				setState(190);
				match(CLPAR);
				setState(191);
				((IfExpContext)_localctx).thenBranch = exp();
				setState(192);
				match(CRPAR);
				setState(193);
				match(ELSE);
				setState(194);
				match(CLPAR);
				setState(195);
				((IfExpContext)_localctx).elseBranch = exp();
				setState(196);
				match(CRPAR);
				}
				break;
			case 7:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(198);
				match(ID);
				}
				break;
			case 8:
				_localctx = new FunExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(199);
				match(ID);
				setState(212);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(200);
					match(LPAR);
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(201);
						exp();
						setState(206);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(202);
							match(COMMA);
							setState(203);
							exp();
							}
							}
							setState(208);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(211);
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
				setState(214);
				match(NEW);
				setState(215);
				match(ID);
				setState(216);
				match(LPAR);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(217);
					match(ID);
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(218);
						match(COMMA);
						setState(219);
						match(ID);
						}
						}
						setState(224);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(227);
				match(RPAR);
				}
				break;
			case 10:
				_localctx = new ObjCallContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(228);
				match(ID);
				setState(229);
				match(T__0);
				setState(230);
				match(ID);
				setState(231);
				match(LPAR);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(232);
					match(ID);
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(233);
						match(COMMA);
						setState(234);
						match(ID);
						}
						}
						setState(239);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(242);
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
		enterRule(_localctx, 26, RULE_stats);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			stat();
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(246);
					match(SEMIC);
					setState(247);
					stat();
					}
					} 
				}
				setState(252);
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
		enterRule(_localctx, 28, RULE_stat);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarasmStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				varasm();
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(IF);
				setState(255);
				((IfStatContext)_localctx).cond = exp();
				setState(256);
				match(THEN);
				setState(257);
				match(CLPAR);
				setState(258);
				((IfStatContext)_localctx).thenBranch = stats();
				setState(259);
				match(CRPAR);
				setState(260);
				match(ELSE);
				setState(261);
				match(CLPAR);
				setState(262);
				((IfStatContext)_localctx).elseBranch = stats();
				setState(263);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u010e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\'\n\2\3\2\3\2\3\2\6\2,\n\2\r\2\16\2-\3\2\5\2\61\n\2\3\2\3\2\5"+
		"\2\65\n\2\3\2\3\2\5\29\n\2\5\2;\n\2\3\3\3\3\3\3\3\3\6\3A\n\3\r\3\16\3"+
		"B\3\3\3\3\3\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\5\6\5Q\n\5\r\5\16\5R"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7d\13"+
		"\7\5\7f\n\7\3\7\3\7\5\7j\n\7\3\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\b\3\b\5"+
		"\bu\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\5\t\u0082"+
		"\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u008a\n\t\f\t\16\t\u008d\13\t\3\t\3\t"+
		"\5\t\u0091\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0099\n\t\f\t\16\t\u009c\13"+
		"\t\3\t\3\t\5\t\u00a0\n\t\3\n\3\n\3\13\5\13\u00a5\n\13\3\13\3\13\3\13\5"+
		"\13\u00aa\n\13\3\f\3\f\3\f\5\f\u00af\n\f\3\r\3\r\3\r\5\r\u00b4\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00cf\n\16\f\16"+
		"\16\16\u00d2\13\16\5\16\u00d4\n\16\3\16\5\16\u00d7\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u00df\n\16\f\16\16\16\u00e2\13\16\5\16\u00e4\n\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00ee\n\16\f\16\16\16\u00f1"+
		"\13\16\5\16\u00f3\n\16\3\16\5\16\u00f6\n\16\3\17\3\17\3\17\7\17\u00fb"+
		"\n\17\f\17\16\17\u00fe\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u010c\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36\2\6\5\2\32\33  \"\"\3\2\t\n\3\2\13\f\3\2\r\16\2\u012a"+
		"\2:\3\2\2\2\4<\3\2\2\2\6F\3\2\2\2\bL\3\2\2\2\nV\3\2\2\2\fZ\3\2\2\2\16"+
		"t\3\2\2\2\20v\3\2\2\2\22\u00a1\3\2\2\2\24\u00a4\3\2\2\2\26\u00ab\3\2\2"+
		"\2\30\u00b0\3\2\2\2\32\u00f5\3\2\2\2\34\u00f7\3\2\2\2\36\u010b\3\2\2\2"+
		" !\5\24\13\2!\"\7\4\2\2\";\3\2\2\2#&\5\4\3\2$\'\5\24\13\2%\'\5\34\17\2"+
		"&$\3\2\2\2&%\3\2\2\2\'(\3\2\2\2()\7\4\2\2);\3\2\2\2*,\5\20\t\2+*\3\2\2"+
		"\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.8\3\2\2\2/\61\5\4\3\2\60/\3\2\2\2\60"+
		"\61\3\2\2\2\61\64\3\2\2\2\62\65\5\24\13\2\63\65\5\34\17\2\64\62\3\2\2"+
		"\2\64\63\3\2\2\2\65\66\3\2\2\2\66\67\7\4\2\2\679\3\2\2\28\60\3\2\2\28"+
		"9\3\2\2\29;\3\2\2\2: \3\2\2\2:#\3\2\2\2:+\3\2\2\2;\3\3\2\2\2<@\7\26\2"+
		"\2=>\5\16\b\2>?\7\4\2\2?A\3\2\2\2@=\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2"+
		"\2\2CD\3\2\2\2DE\7\27\2\2E\5\3\2\2\2FG\5\22\n\2GJ\7\"\2\2HI\7\b\2\2IK"+
		"\5\24\13\2JH\3\2\2\2JK\3\2\2\2K\7\3\2\2\2LP\7\26\2\2MN\5\6\4\2NO\7\4\2"+
		"\2OQ\3\2\2\2PM\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\27"+
		"\2\2U\t\3\2\2\2VW\7\"\2\2WX\7\b\2\2XY\5\24\13\2Y\13\3\2\2\2Z[\5\22\n\2"+
		"[\\\7\"\2\2\\e\7\17\2\2]b\5\6\4\2^_\7\6\2\2_a\5\6\4\2`^\3\2\2\2ad\3\2"+
		"\2\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2\2db\3\2\2\2e]\3\2\2\2ef\3\2\2\2fg\3\2"+
		"\2\2gi\7\20\2\2hj\5\b\5\2ih\3\2\2\2ij\3\2\2\2jo\3\2\2\2kn\5\24\13\2ln"+
		"\5\34\17\2mk\3\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\r\3\2\2"+
		"\2qo\3\2\2\2ru\5\6\4\2su\5\f\7\2tr\3\2\2\2ts\3\2\2\2u\17\3\2\2\2vw\7\34"+
		"\2\2w\u0081\7\"\2\2xy\7\35\2\2y~\7\"\2\2z{\7\6\2\2{}\7\"\2\2|z\3\2\2\2"+
		"}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2"+
		"\2\u0081x\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0090\3\2\2\2\u0083\u0084"+
		"\7\17\2\2\u0084\u0085\5\6\4\2\u0085\u008b\7\4\2\2\u0086\u0087\5\6\4\2"+
		"\u0087\u0088\7\4\2\2\u0088\u008a\3\2\2\2\u0089\u0086\3\2\2\2\u008a\u008d"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u008f\7\20\2\2\u008f\u0091\3\2\2\2\u0090\u0083\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0091\u009f\3\2\2\2\u0092\u0093\7\21\2\2\u0093"+
		"\u0094\5\f\7\2\u0094\u009a\7\4\2\2\u0095\u0096\5\f\7\2\u0096\u0097\7\4"+
		"\2\2\u0097\u0099\3\2\2\2\u0098\u0095\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009d\u009e\7\22\2\2\u009e\u00a0\3\2\2\2\u009f\u0092\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\21\3\2\2\2\u00a1\u00a2\t\2\2\2\u00a2\23\3\2\2\2\u00a3"+
		"\u00a5\7\n\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a9\5\26\f\2\u00a7\u00a8\t\3\2\2\u00a8\u00aa\5\24\13\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\25\3\2\2\2\u00ab\u00ae\5\30\r"+
		"\2\u00ac\u00ad\t\4\2\2\u00ad\u00af\5\26\f\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\27\3\2\2\2\u00b0\u00b3\5\32\16\2\u00b1\u00b2\7\7"+
		"\2\2\u00b2\u00b4\5\32\16\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\31\3\2\2\2\u00b5\u00f6\7!\2\2\u00b6\u00f6\t\5\2\2\u00b7\u00f6\7\36\2"+
		"\2\u00b8\u00f6\7 \2\2\u00b9\u00ba\7\17\2\2\u00ba\u00bb\5\24\13\2\u00bb"+
		"\u00bc\7\20\2\2\u00bc\u00f6\3\2\2\2\u00bd\u00be\7\23\2\2\u00be\u00bf\5"+
		"\24\13\2\u00bf\u00c0\7\24\2\2\u00c0\u00c1\7\21\2\2\u00c1\u00c2\5\24\13"+
		"\2\u00c2\u00c3\7\22\2\2\u00c3\u00c4\7\25\2\2\u00c4\u00c5\7\21\2\2\u00c5"+
		"\u00c6\5\24\13\2\u00c6\u00c7\7\22\2\2\u00c7\u00f6\3\2\2\2\u00c8\u00f6"+
		"\7\"\2\2\u00c9\u00d6\7\"\2\2\u00ca\u00d3\7\17\2\2\u00cb\u00d0\5\24\13"+
		"\2\u00cc\u00cd\7\6\2\2\u00cd\u00cf\5\24\13\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d7\7\20\2\2\u00d6\u00ca\3\2\2\2\u00d6\u00d7\3"+
		"\2\2\2\u00d7\u00f6\3\2\2\2\u00d8\u00d9\7\37\2\2\u00d9\u00da\7\"\2\2\u00da"+
		"\u00e3\7\17\2\2\u00db\u00e0\7\"\2\2\u00dc\u00dd\7\6\2\2\u00dd\u00df\7"+
		"\"\2\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00db\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00f6\7\20\2\2\u00e6"+
		"\u00e7\7\"\2\2\u00e7\u00e8\7\3\2\2\u00e8\u00e9\7\"\2\2\u00e9\u00f2\7\17"+
		"\2\2\u00ea\u00ef\7\"\2\2\u00eb\u00ec\7\6\2\2\u00ec\u00ee\7\"\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00ea\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\7\20\2\2\u00f5\u00b5\3"+
		"\2\2\2\u00f5\u00b6\3\2\2\2\u00f5\u00b7\3\2\2\2\u00f5\u00b8\3\2\2\2\u00f5"+
		"\u00b9\3\2\2\2\u00f5\u00bd\3\2\2\2\u00f5\u00c8\3\2\2\2\u00f5\u00c9\3\2"+
		"\2\2\u00f5\u00d8\3\2\2\2\u00f5\u00e6\3\2\2\2\u00f6\33\3\2\2\2\u00f7\u00fc"+
		"\5\36\20\2\u00f8\u00f9\7\4\2\2\u00f9\u00fb\5\36\20\2\u00fa\u00f8\3\2\2"+
		"\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\35"+
		"\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u010c\5\n\6\2\u0100\u0101\7\23\2\2"+
		"\u0101\u0102\5\24\13\2\u0102\u0103\7\24\2\2\u0103\u0104\7\21\2\2\u0104"+
		"\u0105\5\34\17\2\u0105\u0106\7\22\2\2\u0106\u0107\7\25\2\2\u0107\u0108"+
		"\7\21\2\2\u0108\u0109\5\34\17\2\u0109\u010a\7\22\2\2\u010a\u010c\3\2\2"+
		"\2\u010b\u00ff\3\2\2\2\u010b\u0100\3\2\2\2\u010c\37\3\2\2\2%&-\60\648"+
		":BJRbeimot~\u0081\u008b\u0090\u009a\u009f\u00a4\u00a9\u00ae\u00b3\u00d0"+
		"\u00d3\u00d6\u00e0\u00e3\u00ef\u00f2\u00f5\u00fc\u010b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}