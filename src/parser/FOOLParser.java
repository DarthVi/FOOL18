// Generated from C:/Users/Lorenzo/Desktop/src/parser\FOOL.g4 by ANTLR 4.6
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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterLetInExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitLetInExp(this);
		}
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
<<<<<<< HEAD
=======
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
>>>>>>> master
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public ClassdecExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterClassdecExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitClassdecExp(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterSingleExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitSingleExp(this);
		}
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
<<<<<<< HEAD
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << LET) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
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

					setState(54);
=======
				if (_la==LET) {
					{
					setState(47);
					let();
					setState(52);
>>>>>>> master
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(48);
						exp();
<<<<<<< HEAD
						setState(51);
=======
						setState(49);
>>>>>>> master
						match(SEMIC);
						}
						break;
					case 2:
						{
						setState(53);
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
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitLet(this);
		}
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0) );
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitVardec(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterArgdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitArgdec(this);
		}
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
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public FunletContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funlet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterFunlet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitFunlet(this);
		}
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
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				vardec();
				setState(79);
				match(SEMIC);
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0) );
			setState(85);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterVarasm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitVarasm(this);
		}
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
			setState(87);
			match(ID);
			setState(88);
			match(ASM);
			setState(89);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitFun(this);
		}
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
			setState(91);
			type();
			setState(92);
			match(ID);
			setState(93);
			match(LPAR);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << NULL) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(94);
				argdec();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(95);
					match(COMMA);
					setState(96);
					argdec();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(104);
			match(RPAR);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(105);
				funlet();
				}
			}

			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(108);
				exp();
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterFunDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitFunDeclaration(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitVarDeclaration(this);
		}
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
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public TerminalNode CRPAR() { return getToken(FOOLParser.CRPAR, 0); }
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public ClassdecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterClassdec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitClassdec(this);
		}
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

			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLPAR) {
				{
				setState(135);
				match(CLPAR);
				setState(136);
				fun();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMIC) {
					{
					{
					setState(137);
					match(SEMIC);
					setState(138);
					fun();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitType(this);
		}
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
			setState(148);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitExp(this);
		}
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
<<<<<<< HEAD
			setState(156);
			((ExpContext)_localctx).left = term();
			setState(159);
=======
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(150);
				match(MINUS);
				}
			}

			setState(153);
			((ExpContext)_localctx).left = term();
			setState(156);
>>>>>>> master
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
<<<<<<< HEAD
				setState(157);
=======
				setState(154);
>>>>>>> master
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
<<<<<<< HEAD
				setState(158);
=======
				setState(155);
>>>>>>> master
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitTerm(this);
		}
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
<<<<<<< HEAD
			setState(161);
			((TermContext)_localctx).left = factor();
			setState(164);
=======
			setState(158);
			((TermContext)_localctx).left = factor();
			setState(161);
>>>>>>> master
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES || _la==DIV) {
				{
<<<<<<< HEAD
				setState(162);
=======
				setState(159);
>>>>>>> master
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
<<<<<<< HEAD
				setState(163);
=======
				setState(160);
>>>>>>> master
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitFactor(this);
		}
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
<<<<<<< HEAD
			setState(166);
			((FactorContext)_localctx).left = value();
			setState(169);
=======
			setState(163);
			((FactorContext)_localctx).left = value();
			setState(166);
>>>>>>> master
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << DEQ) | (1L << LQ) | (1L << GQ) | (1L << GREATER) | (1L << AND) | (1L << OR))) != 0)) {
				{
<<<<<<< HEAD
				setState(167);
=======
				setState(164);
>>>>>>> master
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
<<<<<<< HEAD
				setState(168);
=======
				setState(165);
>>>>>>> master
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterBaseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitBaseExp(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterVarExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitVarExp(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterObjCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitObjCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitObjCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValContext extends ValueContext {
		public boolean optionalMinus;

		public TerminalNode INTEGER() { return getToken(FOOLParser.INTEGER, 0); }
		public TerminalNode MINUS() { return getToken(FOOLParser.MINUS, 0); }
		public IntValContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterIntVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitIntVal(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterNullVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitNullVal(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterVoidExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitVoidExp(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterIfExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitIfExp(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterObjInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitObjInst(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterBoolVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitBoolVal(this);
		}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterFunExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitFunExp(this);
		}
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
<<<<<<< HEAD
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
=======
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
>>>>>>> master
			case 1:
				_localctx = new IntValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< HEAD
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(171);
					match(MINUS);
					}
				}

				setState(174);
=======
				setState(168);
>>>>>>> master
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new BoolValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(169);
					((BoolValContext)_localctx).optionalNot = match(NOT);
					}
				}

				setState(172);
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
				setState(173);
				match(NULL);
				}
				break;
			case 4:
				_localctx = new VoidExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				match(VOID);
				}
				break;
			case 5:
				_localctx = new BaseExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
<<<<<<< HEAD
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT || _la==MINUS) {
					{
					setState(181);
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

				setState(184);
				match(LPAR);
				setState(185);
				exp();
				setState(186);
=======
				setState(175);
				match(LPAR);
				setState(176);
				exp();
				setState(177);
>>>>>>> master
				match(RPAR);
				}
				break;
			case 6:
				_localctx = new IfExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
<<<<<<< HEAD
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
=======
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
>>>>>>> master
				match(CRPAR);
				}
				break;
			case 7:
				_localctx = new VarExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
<<<<<<< HEAD
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT || _la==MINUS) {
					{
					setState(199);
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

				setState(202);
=======
				setState(190);
>>>>>>> master
				match(ID);
				}
				break;
			case 8:
				_localctx = new FunExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
<<<<<<< HEAD
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT || _la==MINUS) {
					{
					setState(203);
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

				setState(206);
				match(ID);
				setState(219);
=======
				setState(191);
				match(ID);
				setState(204);
>>>>>>> master
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
<<<<<<< HEAD
					setState(207);
					match(LPAR);
					setState(216);
=======
					setState(192);
					match(LPAR);
					setState(201);
>>>>>>> master
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << NULL) | (1L << NEW) | (1L << VOID) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
<<<<<<< HEAD
						setState(208);
						exp();
						setState(213);
=======
						setState(193);
						exp();
						setState(198);
>>>>>>> master
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
<<<<<<< HEAD
							setState(209);
							match(COMMA);
							setState(210);
							exp();
							}
							}
							setState(215);
=======
							setState(194);
							match(COMMA);
							setState(195);
							exp();
							}
							}
							setState(200);
>>>>>>> master
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

<<<<<<< HEAD
					setState(218);
=======
					setState(203);
>>>>>>> master
					match(RPAR);
					}
				}

				}
				break;
			case 9:
				_localctx = new ObjInstContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
<<<<<<< HEAD
				setState(221);
				match(NEW);
				setState(222);
				match(ID);
				setState(223);
				match(LPAR);
				setState(232);
=======
				setState(206);
				match(NEW);
				setState(207);
				match(ID);
				setState(208);
				match(LPAR);
				setState(217);
>>>>>>> master
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
<<<<<<< HEAD
					setState(224);
					match(ID);
					setState(229);
=======
					setState(209);
					match(ID);
					setState(214);
>>>>>>> master
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
<<<<<<< HEAD
						setState(225);
						match(COMMA);
						setState(226);
						match(ID);
						}
						}
						setState(231);
=======
						setState(210);
						match(COMMA);
						setState(211);
						match(ID);
						}
						}
						setState(216);
>>>>>>> master
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

<<<<<<< HEAD
				setState(234);
=======
				setState(219);
>>>>>>> master
				match(RPAR);
				}
				break;
			case 10:
				_localctx = new ObjCallContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
<<<<<<< HEAD
				setState(235);
				match(ID);
				setState(236);
				match(T__0);
				setState(237);
				match(ID);
				setState(238);
				match(LPAR);
				setState(247);
=======
				setState(220);
				match(ID);
				setState(221);
				match(T__0);
				setState(222);
				match(ID);
				setState(223);
				match(LPAR);
				setState(232);
>>>>>>> master
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
<<<<<<< HEAD
					setState(239);
					match(ID);
					setState(244);
=======
					setState(224);
					match(ID);
					setState(229);
>>>>>>> master
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
<<<<<<< HEAD
						setState(240);
						match(COMMA);
						setState(241);
						match(ID);
						}
						}
						setState(246);
=======
						setState(225);
						match(COMMA);
						setState(226);
						match(ID);
						}
						}
						setState(231);
>>>>>>> master
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

<<<<<<< HEAD
				setState(249);
=======
				setState(234);
>>>>>>> master
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterStats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitStats(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitStats(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatsContext stats() throws RecognitionException {
		StatsContext _localctx = new StatsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(255); 
=======
			setState(240); 
>>>>>>> master
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
<<<<<<< HEAD
				setState(252);
				stat();
				setState(253);
				match(SEMIC);
				}
				}
				setState(257); 
=======
				setState(237);
				stat();
				setState(238);
				match(SEMIC);
				}
				}
				setState(242); 
>>>>>>> master
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << ID))) != 0) );
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitIfStat(this);
		}
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
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
<<<<<<< HEAD
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitPrintStat(this);
		}
		@Override
=======
>>>>>>> master
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOOLVisitor ) return ((FOOLVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarasmStatContext extends StatContext {
		public VarasmContext varasm() {
			return getRuleContext(VarasmContext.class,0);
		}
		public VarasmStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).enterVarasmStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOOLListener ) ((FOOLListener)listener).exitVarasmStat(this);
		}
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
<<<<<<< HEAD
			setState(276);
=======
			setState(261);
>>>>>>> master
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarasmStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< HEAD
				setState(259);
=======
				setState(244);
>>>>>>> master
				varasm();
				}
				break;
			case PRINT:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< HEAD
				setState(260);
				match(PRINT);
				setState(261);
				match(LPAR);
				setState(262);
				exp();
				setState(263);
=======
				setState(245);
				match(PRINT);
				setState(246);
				match(LPAR);
				setState(247);
				exp();
				setState(248);
>>>>>>> master
				match(RPAR);
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< HEAD
				setState(265);
				match(IF);
				setState(266);
				((IfStatContext)_localctx).cond = exp();
				setState(267);
				match(THEN);
				setState(268);
				match(CLPAR);
				setState(269);
				((IfStatContext)_localctx).thenBranch = stats();
				setState(270);
				match(CRPAR);
				setState(271);
				match(ELSE);
				setState(272);
				match(CLPAR);
				setState(273);
				((IfStatContext)_localctx).elseBranch = stats();
				setState(274);
=======
				setState(250);
				match(IF);
				setState(251);
				((IfStatContext)_localctx).cond = exp();
				setState(252);
				match(THEN);
				setState(253);
				match(CLPAR);
				setState(254);
				((IfStatContext)_localctx).thenBranch = stats();
				setState(255);
				match(CRPAR);
				setState(256);
				match(ELSE);
				setState(257);
				match(CLPAR);
				setState(258);
				((IfStatContext)_localctx).elseBranch = stats();
				setState(259);
>>>>>>> master
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u0119\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2+\n\2\3\2\6\2.\n\2\r\2\16\2/\3\2\5\2\63\n\2"+
		"\3\2\3\2\3\2\3\2\5\29\n\2\5\2;\n\2\5\2=\n\2\3\3\3\3\3\3\3\3\6\3C\n\3\r"+
		"\3\16\3D\3\3\3\3\3\4\3\4\3\4\3\4\5\4M\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\6\6V\n\6\r\6\16\6W\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7"+
		"\bf\n\b\f\b\16\bi\13\b\5\bk\n\b\3\b\3\b\5\bo\n\b\3\b\3\b\5\bs\n\b\3\t"+
		"\3\t\5\tw\n\t\3\n\3\n\3\n\3\n\5\n}\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0085"+
		"\n\n\f\n\16\n\u0088\13\n\3\n\3\n\5\n\u008c\n\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\7\n\u0094\n\n\f\n\16\n\u0097\13\n\3\n\3\n\5\n\u009b\n\n\3\13\3\13\3\f"+
		"\3\f\3\f\5\f\u00a2\n\f\3\r\3\r\3\r\5\r\u00a7\n\r\3\16\3\16\3\16\5\16\u00ac"+
		"\n\16\3\17\5\17\u00af\n\17\3\17\3\17\5\17\u00b3\n\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00b9\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cb\n\17\3\17\3\17\5\17\u00cf\n"+
		"\17\3\17\3\17\3\17\3\17\3\17\7\17\u00d6\n\17\f\17\16\17\u00d9\13\17\5"+
		"\17\u00db\n\17\3\17\5\17\u00de\n\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u00e6\n\17\f\17\16\17\u00e9\13\17\5\17\u00eb\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u00f5\n\17\f\17\16\17\u00f8\13\17\5\17\u00fa"+
		"\n\17\3\17\5\17\u00fd\n\17\3\20\3\20\3\20\6\20\u0102\n\20\r\20\16\20\u0103"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u0117\n\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \2\b\6\2#$\'\'))++\3\2\21\22\3\2\23\24\4\2\7\13\r\16\3\2"+
		"\25\26\4\2\17\17\22\22\u0137\2<\3\2\2\2\4>\3\2\2\2\6H\3\2\2\2\bN\3\2\2"+
		"\2\nQ\3\2\2\2\f[\3\2\2\2\16_\3\2\2\2\20v\3\2\2\2\22x\3\2\2\2\24\u009c"+
		"\3\2\2\2\26\u009e\3\2\2\2\30\u00a3\3\2\2\2\32\u00a8\3\2\2\2\34\u00fc\3"+
		"\2\2\2\36\u0101\3\2\2\2 \u0116\3\2\2\2\"#\5\26\f\2#$\7\4\2\2$=\3\2\2\2"+
		"%*\5\4\3\2&\'\5\26\f\2\'(\7\4\2\2(+\3\2\2\2)+\5\36\20\2*&\3\2\2\2*)\3"+
		"\2\2\2+=\3\2\2\2,.\5\22\n\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2"+
		"\60:\3\2\2\2\61\63\5\4\3\2\62\61\3\2\2\2\62\63\3\2\2\2\638\3\2\2\2\64"+
		"\65\5\26\f\2\65\66\7\4\2\2\669\3\2\2\2\679\5\36\20\28\64\3\2\2\28\67\3"+
		"\2\2\29;\3\2\2\2:\62\3\2\2\2:;\3\2\2\2;=\3\2\2\2<\"\3\2\2\2<%\3\2\2\2"+
		"<-\3\2\2\2=\3\3\2\2\2>B\7\37\2\2?@\5\20\t\2@A\7\4\2\2AC\3\2\2\2B?\3\2"+
		"\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7 \2\2G\5\3\2\2\2HI\5\24"+
		"\13\2IL\7+\2\2JK\7\20\2\2KM\5\26\f\2LJ\3\2\2\2LM\3\2\2\2M\7\3\2\2\2NO"+
		"\5\24\13\2OP\7+\2\2P\t\3\2\2\2QU\7\37\2\2RS\5\6\4\2ST\7\4\2\2TV\3\2\2"+
		"\2UR\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7 \2\2Z\13\3\2"+
		"\2\2[\\\7+\2\2\\]\7\20\2\2]^\5\26\f\2^\r\3\2\2\2_`\5\24\13\2`a\7+\2\2"+
		"aj\7\27\2\2bg\5\b\5\2cd\7\6\2\2df\5\b\5\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2"+
		"\2gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jb\3\2\2\2jk\3\2\2\2kl\3\2\2\2ln\7\30"+
		"\2\2mo\5\n\6\2nm\3\2\2\2no\3\2\2\2or\3\2\2\2ps\5\26\f\2qs\5\36\20\2rp"+
		"\3\2\2\2rq\3\2\2\2s\17\3\2\2\2tw\5\6\4\2uw\5\16\b\2vt\3\2\2\2vu\3\2\2"+
		"\2w\21\3\2\2\2xy\7%\2\2y|\7+\2\2z{\7&\2\2{}\7+\2\2|z\3\2\2\2|}\3\2\2\2"+
		"}\u008b\3\2\2\2~\177\7\27\2\2\177\u0080\5\6\4\2\u0080\u0086\7\4\2\2\u0081"+
		"\u0082\5\6\4\2\u0082\u0083\7\4\2\2\u0083\u0085\3\2\2\2\u0084\u0081\3\2"+
		"\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\30\2\2\u008a\u008c\3"+
		"\2\2\2\u008b~\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u009a\3\2\2\2\u008d\u008e"+
		"\7\31\2\2\u008e\u008f\5\16\b\2\u008f\u0095\7\4\2\2\u0090\u0091\5\16\b"+
		"\2\u0091\u0092\7\4\2\2\u0092\u0094\3\2\2\2\u0093\u0090\3\2\2\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u0099\7\32\2\2\u0099\u009b\3\2\2\2\u009a\u008d\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\23\3\2\2\2\u009c\u009d\t\2\2\2\u009d"+
		"\25\3\2\2\2\u009e\u00a1\5\30\r\2\u009f\u00a0\t\3\2\2\u00a0\u00a2\5\26"+
		"\f\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\27\3\2\2\2\u00a3\u00a6"+
		"\5\32\16\2\u00a4\u00a5\t\4\2\2\u00a5\u00a7\5\30\r\2\u00a6\u00a4\3\2\2"+
		"\2\u00a6\u00a7\3\2\2\2\u00a7\31\3\2\2\2\u00a8\u00ab\5\34\17\2\u00a9\u00aa"+
		"\t\5\2\2\u00aa\u00ac\5\34\17\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2"+
		"\u00ac\33\3\2\2\2\u00ad\u00af\7\22\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00fd\7*\2\2\u00b1\u00b3\7\17\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00fd\t\6"+
		"\2\2\u00b5\u00fd\7\'\2\2\u00b6\u00fd\7)\2\2\u00b7\u00b9\t\7\2\2\u00b8"+
		"\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7\27"+
		"\2\2\u00bb\u00bc\5\26\f\2\u00bc\u00bd\7\30\2\2\u00bd\u00fd\3\2\2\2\u00be"+
		"\u00bf\7\33\2\2\u00bf\u00c0\5\26\f\2\u00c0\u00c1\7\34\2\2\u00c1\u00c2"+
		"\7\31\2\2\u00c2\u00c3\5\26\f\2\u00c3\u00c4\7\32\2\2\u00c4\u00c5\7\35\2"+
		"\2\u00c5\u00c6\7\31\2\2\u00c6\u00c7\5\26\f\2\u00c7\u00c8\7\32\2\2\u00c8"+
		"\u00fd\3\2\2\2\u00c9\u00cb\t\7\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00fd\7+\2\2\u00cd\u00cf\t\7\2\2\u00ce"+
		"\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00dd\7+"+
		"\2\2\u00d1\u00da\7\27\2\2\u00d2\u00d7\5\26\f\2\u00d3\u00d4\7\6\2\2\u00d4"+
		"\u00d6\5\26\f\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3"+
		"\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00d2\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\7\30"+
		"\2\2\u00dd\u00d1\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00fd\3\2\2\2\u00df"+
		"\u00e0\7(\2\2\u00e0\u00e1\7+\2\2\u00e1\u00ea\7\27\2\2\u00e2\u00e7\7+\2"+
		"\2\u00e3\u00e4\7\6\2\2\u00e4\u00e6\7+\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\u00fd\7\30\2\2\u00ed\u00ee\7+\2\2\u00ee\u00ef\7\3\2\2\u00ef"+
		"\u00f0\7+\2\2\u00f0\u00f9\7\27\2\2\u00f1\u00f6\7+\2\2\u00f2\u00f3\7\6"+
		"\2\2\u00f3\u00f5\7+\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f9\u00f1\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fd\7\30\2\2\u00fc\u00ae\3\2\2\2\u00fc\u00b2\3\2\2\2\u00fc\u00b5\3"+
		"\2\2\2\u00fc\u00b6\3\2\2\2\u00fc\u00b8\3\2\2\2\u00fc\u00be\3\2\2\2\u00fc"+
		"\u00ca\3\2\2\2\u00fc\u00ce\3\2\2\2\u00fc\u00df\3\2\2\2\u00fc\u00ed\3\2"+
		"\2\2\u00fd\35\3\2\2\2\u00fe\u00ff\5 \21\2\u00ff\u0100\7\4\2\2\u0100\u0102"+
		"\3\2\2\2\u0101\u00fe\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\37\3\2\2\2\u0105\u0117\5\f\7\2\u0106\u0107\7\36\2"+
		"\2\u0107\u0108\7\27\2\2\u0108\u0109\5\26\f\2\u0109\u010a\7\30\2\2\u010a"+
		"\u0117\3\2\2\2\u010b\u010c\7\33\2\2\u010c\u010d\5\26\f\2\u010d\u010e\7"+
		"\34\2\2\u010e\u010f\7\31\2\2\u010f\u0110\5\36\20\2\u0110\u0111\7\32\2"+
		"\2\u0111\u0112\7\35\2\2\u0112\u0113\7\31\2\2\u0113\u0114\5\36\20\2\u0114"+
		"\u0115\7\32\2\2\u0115\u0117\3\2\2\2\u0116\u0105\3\2\2\2\u0116\u0106\3"+
		"\2\2\2\u0116\u010b\3\2\2\2\u0117!\3\2\2\2\'*/\628:<DLWgjnrv|\u0086\u008b"+
		"\u0095\u009a\u00a1\u00a6\u00ab\u00ae\u00b2\u00b8\u00ca\u00ce\u00d7\u00da"+
		"\u00dd\u00e7\u00ea\u00f6\u00f9\u00fc\u0103\u0116";
=======
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2+\n\2\3\2\6\2.\n\2\r\2\16\2/\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\67\n\2\5\29\n\2\5\2;\n\2\3\3\3\3\3\3\3\3\6\3A\n\3\r\3\16\3B\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\6\6T\n\6\r"+
		"\6\16\6U\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bd\n\b\f\b"+
		"\16\bg\13\b\5\bi\n\b\3\b\3\b\5\bm\n\b\3\b\3\b\5\bq\n\b\3\t\3\t\5\tu\n"+
		"\t\3\n\3\n\3\n\3\n\5\n{\n\n\3\n\3\n\3\n\3\n\7\n\u0081\n\n\f\n\16\n\u0084"+
		"\13\n\3\n\3\n\5\n\u0088\n\n\3\n\3\n\3\n\3\n\7\n\u008e\n\n\f\n\16\n\u0091"+
		"\13\n\3\n\3\n\5\n\u0095\n\n\3\13\3\13\3\f\5\f\u009a\n\f\3\f\3\f\3\f\5"+
		"\f\u009f\n\f\3\r\3\r\3\r\5\r\u00a4\n\r\3\16\3\16\3\16\5\16\u00a9\n\16"+
		"\3\17\3\17\5\17\u00ad\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u00c7\n\17\f\17\16\17\u00ca\13\17\5\17\u00cc\n\17\3\17\5\17"+
		"\u00cf\n\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00d7\n\17\f\17\16\17\u00da"+
		"\13\17\5\17\u00dc\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00e6"+
		"\n\17\f\17\16\17\u00e9\13\17\5\17\u00eb\n\17\3\17\5\17\u00ee\n\17\3\20"+
		"\3\20\3\20\6\20\u00f3\n\20\r\20\16\20\u00f4\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0108"+
		"\n\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\7\6\2#$\'"+
		"\'))++\3\2\21\22\3\2\23\24\4\2\7\13\r\16\3\2\25\26\2\u0124\2:\3\2\2\2"+
		"\4<\3\2\2\2\6F\3\2\2\2\bL\3\2\2\2\nO\3\2\2\2\fY\3\2\2\2\16]\3\2\2\2\20"+
		"t\3\2\2\2\22v\3\2\2\2\24\u0096\3\2\2\2\26\u0099\3\2\2\2\30\u00a0\3\2\2"+
		"\2\32\u00a5\3\2\2\2\34\u00ed\3\2\2\2\36\u00f2\3\2\2\2 \u0107\3\2\2\2\""+
		"#\5\26\f\2#$\7\4\2\2$;\3\2\2\2%*\5\4\3\2&\'\5\26\f\2\'(\7\4\2\2(+\3\2"+
		"\2\2)+\5\36\20\2*&\3\2\2\2*)\3\2\2\2+;\3\2\2\2,.\5\22\n\2-,\3\2\2\2./"+
		"\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\608\3\2\2\2\61\66\5\4\3\2\62\63\5\26\f"+
		"\2\63\64\7\4\2\2\64\67\3\2\2\2\65\67\5\36\20\2\66\62\3\2\2\2\66\65\3\2"+
		"\2\2\679\3\2\2\28\61\3\2\2\289\3\2\2\29;\3\2\2\2:\"\3\2\2\2:%\3\2\2\2"+
		":-\3\2\2\2;\3\3\2\2\2<@\7\37\2\2=>\5\20\t\2>?\7\4\2\2?A\3\2\2\2@=\3\2"+
		"\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\7 \2\2E\5\3\2\2\2FG\5\24"+
		"\13\2GJ\7+\2\2HI\7\20\2\2IK\5\26\f\2JH\3\2\2\2JK\3\2\2\2K\7\3\2\2\2LM"+
		"\5\24\13\2MN\7+\2\2N\t\3\2\2\2OS\7\37\2\2PQ\5\6\4\2QR\7\4\2\2RT\3\2\2"+
		"\2SP\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7 \2\2X\13\3\2"+
		"\2\2YZ\7+\2\2Z[\7\20\2\2[\\\5\26\f\2\\\r\3\2\2\2]^\5\24\13\2^_\7+\2\2"+
		"_h\7\27\2\2`e\5\b\5\2ab\7\6\2\2bd\5\b\5\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2"+
		"\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2h`\3\2\2\2hi\3\2\2\2ij\3\2\2\2jl\7\30"+
		"\2\2km\5\n\6\2lk\3\2\2\2lm\3\2\2\2mp\3\2\2\2nq\5\26\f\2oq\5\36\20\2pn"+
		"\3\2\2\2po\3\2\2\2q\17\3\2\2\2ru\5\6\4\2su\5\16\b\2tr\3\2\2\2ts\3\2\2"+
		"\2u\21\3\2\2\2vw\7%\2\2wz\7+\2\2xy\7&\2\2y{\7+\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{\u0087\3\2\2\2|}\7\27\2\2}\u0082\5\b\5\2~\177\7\4\2\2\177\u0081\5\b\5"+
		"\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\30\2\2"+
		"\u0086\u0088\3\2\2\2\u0087|\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0094\3"+
		"\2\2\2\u0089\u008a\7\31\2\2\u008a\u008f\5\16\b\2\u008b\u008c\7\4\2\2\u008c"+
		"\u008e\5\16\b\2\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\7\32\2\2\u0093\u0095\3\2\2\2\u0094\u0089\3\2\2\2\u0094\u0095\3"+
		"\2\2\2\u0095\23\3\2\2\2\u0096\u0097\t\2\2\2\u0097\25\3\2\2\2\u0098\u009a"+
		"\7\22\2\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2"+
		"\u009b\u009e\5\30\r\2\u009c\u009d\t\3\2\2\u009d\u009f\5\26\f\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\27\3\2\2\2\u00a0\u00a3\5\32\16\2\u00a1"+
		"\u00a2\t\4\2\2\u00a2\u00a4\5\30\r\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3"+
		"\2\2\2\u00a4\31\3\2\2\2\u00a5\u00a8\5\34\17\2\u00a6\u00a7\t\5\2\2\u00a7"+
		"\u00a9\5\34\17\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\33\3\2"+
		"\2\2\u00aa\u00ee\7*\2\2\u00ab\u00ad\7\17\2\2\u00ac\u00ab\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ee\t\6\2\2\u00af\u00ee\7\'"+
		"\2\2\u00b0\u00ee\7)\2\2\u00b1\u00b2\7\27\2\2\u00b2\u00b3\5\26\f\2\u00b3"+
		"\u00b4\7\30\2\2\u00b4\u00ee\3\2\2\2\u00b5\u00b6\7\33\2\2\u00b6\u00b7\5"+
		"\26\f\2\u00b7\u00b8\7\34\2\2\u00b8\u00b9\7\31\2\2\u00b9\u00ba\5\26\f\2"+
		"\u00ba\u00bb\7\32\2\2\u00bb\u00bc\7\35\2\2\u00bc\u00bd\7\31\2\2\u00bd"+
		"\u00be\5\26\f\2\u00be\u00bf\7\32\2\2\u00bf\u00ee\3\2\2\2\u00c0\u00ee\7"+
		"+\2\2\u00c1\u00ce\7+\2\2\u00c2\u00cb\7\27\2\2\u00c3\u00c8\5\26\f\2\u00c4"+
		"\u00c5\7\6\2\2\u00c5\u00c7\5\26\f\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3"+
		"\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00c3\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00cf\7\30\2\2\u00ce\u00c2\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00ee\3\2\2\2\u00d0\u00d1\7(\2\2\u00d1\u00d2\7+\2\2\u00d2\u00db\7\27"+
		"\2\2\u00d3\u00d8\7+\2\2\u00d4\u00d5\7\6\2\2\u00d5\u00d7\7+\2\2\u00d6\u00d4"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00d3\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00ee\7\30\2\2\u00de\u00df\7+\2\2\u00df"+
		"\u00e0\7\3\2\2\u00e0\u00e1\7+\2\2\u00e1\u00ea\7\27\2\2\u00e2\u00e7\7+"+
		"\2\2\u00e3\u00e4\7\6\2\2\u00e4\u00e6\7+\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00eb\3\2"+
		"\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ee\7\30\2\2\u00ed\u00aa\3\2\2\2\u00ed\u00ac\3"+
		"\2\2\2\u00ed\u00af\3\2\2\2\u00ed\u00b0\3\2\2\2\u00ed\u00b1\3\2\2\2\u00ed"+
		"\u00b5\3\2\2\2\u00ed\u00c0\3\2\2\2\u00ed\u00c1\3\2\2\2\u00ed\u00d0\3\2"+
		"\2\2\u00ed\u00de\3\2\2\2\u00ee\35\3\2\2\2\u00ef\u00f0\5 \21\2\u00f0\u00f1"+
		"\7\4\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\37\3\2\2\2\u00f6\u0108\5\f\7"+
		"\2\u00f7\u00f8\7\36\2\2\u00f8\u00f9\7\27\2\2\u00f9\u00fa\5\26\f\2\u00fa"+
		"\u00fb\7\30\2\2\u00fb\u0108\3\2\2\2\u00fc\u00fd\7\33\2\2\u00fd\u00fe\5"+
		"\26\f\2\u00fe\u00ff\7\34\2\2\u00ff\u0100\7\31\2\2\u0100\u0101\5\36\20"+
		"\2\u0101\u0102\7\32\2\2\u0102\u0103\7\35\2\2\u0103\u0104\7\31\2\2\u0104"+
		"\u0105\5\36\20\2\u0105\u0106\7\32\2\2\u0106\u0108\3\2\2\2\u0107\u00f6"+
		"\3\2\2\2\u0107\u00f7\3\2\2\2\u0107\u00fc\3\2\2\2\u0108!\3\2\2\2#*/\66"+
		"8:BJUehlptz\u0082\u0087\u008f\u0094\u0099\u009e\u00a3\u00a8\u00ac\u00c8"+
		"\u00cb\u00ce\u00d8\u00db\u00e7\u00ea\u00ed\u00f4\u0107";
>>>>>>> master
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}