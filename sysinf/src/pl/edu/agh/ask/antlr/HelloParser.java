package pl.edu.agh.ask.antlr;

// Generated from Hello.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloParser extends Parser {
	//static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__33=1, T__32=2, T__31=3, T__30=4, T__29=5, T__28=6, T__27=7, T__26=8, 
		T__25=9, T__24=10, T__23=11, T__22=12, T__21=13, T__20=14, T__19=15, T__18=16, 
		T__17=17, T__16=18, T__15=19, T__14=20, T__13=21, T__12=22, T__11=23, 
		T__10=24, T__9=25, T__8=26, T__7=27, T__6=28, T__5=29, T__4=30, T__3=31, 
		T__2=32, T__1=33, T__0=34, INT=35, DOUBLE=36, NL=37, WS=38, ID=39, TEXT=40, 
		ATOM=41;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'ID'", "'{'", "';'", "'='", "'}'", "'^'", "'?'", 
		"'`'", "'\"'", "'Bus'", "'$'", "'&'", "'('", "'*'", "','", "'.'", "'Device'", 
		"'\\u005C'", "':'", "'['", "'|'", "'<'", "'~'", "'>'", "'_'", "'@'", "'!'", 
		"'#'", "'%'", "')'", "'Linux'", "'+'", "'-'", "INT", "DOUBLE", "NL", "WS", 
		"ID", "TEXT", "ATOM"
	};
	public static final int
		RULE_input = 0, RULE_row = 1, RULE_expr = 2, RULE_name = 3, RULE_atom = 4;
	public static final String[] ruleNames = {
		"input", "row", "expr", "name", "atom"
	};

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HelloParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToggleContext extends InputContext {
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public ToggleContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterToggle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitToggle(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_input);
		int _la;
		try {
			_localctx = new ToggleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10); row();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__23 || _la==NL );
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

	public static class RowContext extends ParserRuleContext {
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
	 
		public RowContext() { }
		public void copyFrom(RowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LineContext extends RowContext {
		public TerminalNode NL() { return getToken(HelloParser.NL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LineContext(RowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLine(this);
		}
	}
	public static class SameContext extends RowContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SameContext(RowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterSame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitSame(this);
		}
	}
	public static class NewLineContext extends RowContext {
		public TerminalNode NL() { return getToken(HelloParser.NL, 0); }
		public NewLineContext(RowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterNewLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitNewLine(this);
		}
	}
	public static class EndContext extends RowContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EndContext(RowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitEnd(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_row);
		try {
			setState(22);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new NewLineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(15); match(NL);
				}
				break;
			case 2:
				_localctx = new EndContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16); expr();
				}
				break;
			case 3:
				_localctx = new SameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(17); expr();
				}
				break;
			case 4:
				_localctx = new LineContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(18); expr();
				setState(20);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(19); match(NL);
					}
					break;
				}
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LolContext extends ExprContext {
		public TerminalNode INT(int i) {
			return getToken(HelloParser.INT, i);
		}
		public List<TerminalNode> ID() { return getTokens(HelloParser.ID); }
		public TerminalNode WS(int i) {
			return getToken(HelloParser.WS, i);
		}
		public List<TerminalNode> WS() { return getTokens(HelloParser.WS); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(HelloParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(HelloParser.INT); }
		public LolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLol(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		int _la;
		try {
			_localctx = new LolContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(24); match(T__23);
			setState(26);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(25); match(WS);
				}
			}

			setState(28); match(INT);
			setState(30);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(29); match(WS);
				}
			}

			setState(32); match(T__16);
			setState(34);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(33); match(WS);
				}
			}

			setState(36); match(INT);
			setState(37); match(T__14);
			setState(39);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(38); match(WS);
				}
			}

			setState(41); match(T__32);
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(42); match(WS);
				}
				break;
			}
			setState(46);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(45); match(INT);
				}
				break;
			}
			setState(49);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(48); match(WS);
				}
			}

			setState(51);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(52); match(T__14);
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(54); match(WS);
				}
				break;
			}
			setState(57); name();
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

	public static class NameContext extends ParserRuleContext {
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	 
		public NameContext() { }
		public void copyFrom(NameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SdfContext extends NameContext {
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public SdfContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterSdf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitSdf(this);
		}
	}
	public static class ThisContext extends NameContext {
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public ThisContext(NameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterThis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitThis(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_name);
		int _la;
		try {
			setState(72);
			switch (_input.LA(1)) {
			case EOF:
			case T__33:
			case T__31:
			case T__30:
			case T__29:
			case T__28:
			case T__27:
			case T__26:
			case T__25:
			case T__24:
			case T__23:
			case T__22:
			case T__21:
			case T__20:
			case T__19:
			case T__18:
			case T__17:
			case T__15:
			case T__14:
			case T__13:
			case T__12:
			case T__11:
			case T__10:
			case T__9:
			case T__8:
			case T__7:
			case T__6:
			case T__5:
			case T__4:
			case T__3:
			case T__1:
			case T__0:
			case INT:
			case DOUBLE:
			case NL:
			case WS:
			case ID:
				_localctx = new ThisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__31) | (1L << T__30) | (1L << T__29) | (1L << T__28) | (1L << T__27) | (1L << T__26) | (1L << T__25) | (1L << T__24) | (1L << T__22) | (1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__15) | (1L << T__14) | (1L << T__13) | (1L << T__12) | (1L << T__11) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__1) | (1L << T__0) | (1L << INT) | (1L << DOUBLE) | (1L << WS) | (1L << ID))) != 0)) {
					{
					{
					setState(59); atom();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__2:
				_localctx = new SdfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65); match(T__2);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__31) | (1L << T__30) | (1L << T__29) | (1L << T__28) | (1L << T__27) | (1L << T__26) | (1L << T__25) | (1L << T__24) | (1L << T__22) | (1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__15) | (1L << T__14) | (1L << T__13) | (1L << T__12) | (1L << T__11) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__1) | (1L << T__0) | (1L << INT) | (1L << DOUBLE) | (1L << WS) | (1L << ID))) != 0)) {
					{
					{
					setState(66); atom();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class L21Context extends AtomContext {
		public L21Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL21(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL21(this);
		}
	}
	public static class L20Context extends AtomContext {
		public L20Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL20(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL20(this);
		}
	}
	public static class L23Context extends AtomContext {
		public L23Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL23(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL23(this);
		}
	}
	public static class L22Context extends AtomContext {
		public L22Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL22(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL22(this);
		}
	}
	public static class L25Context extends AtomContext {
		public L25Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL25(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL25(this);
		}
	}
	public static class L24Context extends AtomContext {
		public L24Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL24(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL24(this);
		}
	}
	public static class L27Context extends AtomContext {
		public L27Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL27(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL27(this);
		}
	}
	public static class L26Context extends AtomContext {
		public L26Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL26(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL26(this);
		}
	}
	public static class L29Context extends AtomContext {
		public L29Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL29(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL29(this);
		}
	}
	public static class L28Context extends AtomContext {
		public L28Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL28(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL28(this);
		}
	}
	public static class L1Context extends AtomContext {
		public TerminalNode ID() { return getToken(HelloParser.ID, 0); }
		public L1Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL1(this);
		}
	}
	public static class L2Context extends AtomContext {
		public TerminalNode WS() { return getToken(HelloParser.WS, 0); }
		public L2Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL2(this);
		}
	}
	public static class L3Context extends AtomContext {
		public L3Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL3(this);
		}
	}
	public static class L4Context extends AtomContext {
		public L4Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL4(this);
		}
	}
	public static class L30Context extends AtomContext {
		public L30Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL30(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL30(this);
		}
	}
	public static class L5Context extends AtomContext {
		public L5Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL5(this);
		}
	}
	public static class L6Context extends AtomContext {
		public L6Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL6(this);
		}
	}
	public static class L10Context extends AtomContext {
		public L10Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL10(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL10(this);
		}
	}
	public static class L32Context extends AtomContext {
		public L32Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL32(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL32(this);
		}
	}
	public static class L7Context extends AtomContext {
		public L7Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL7(this);
		}
	}
	public static class L31Context extends AtomContext {
		public L31Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL31(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL31(this);
		}
	}
	public static class L8Context extends AtomContext {
		public L8Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL8(this);
		}
	}
	public static class L12Context extends AtomContext {
		public L12Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL12(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL12(this);
		}
	}
	public static class L34Context extends AtomContext {
		public L34Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL34(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL34(this);
		}
	}
	public static class L9Context extends AtomContext {
		public L9Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL9(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL9(this);
		}
	}
	public static class L11Context extends AtomContext {
		public L11Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL11(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL11(this);
		}
	}
	public static class L33Context extends AtomContext {
		public L33Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL33(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL33(this);
		}
	}
	public static class L14Context extends AtomContext {
		public TerminalNode DOUBLE() { return getToken(HelloParser.DOUBLE, 0); }
		public L14Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL14(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL14(this);
		}
	}
	public static class L13Context extends AtomContext {
		public TerminalNode INT() { return getToken(HelloParser.INT, 0); }
		public L13Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL13(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL13(this);
		}
	}
	public static class L35Context extends AtomContext {
		public L35Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL35(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL35(this);
		}
	}
	public static class L15Context extends AtomContext {
		public L15Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL15(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL15(this);
		}
	}
	public static class L18Context extends AtomContext {
		public L18Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL18(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL18(this);
		}
	}
	public static class L17Context extends AtomContext {
		public L17Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL17(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL17(this);
		}
	}
	public static class L19Context extends AtomContext {
		public L19Context(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterL19(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitL19(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atom);
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new L1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74); match(ID);
				}
				break;
			case 2:
				_localctx = new L2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75); match(WS);
				}
				break;
			case 3:
				_localctx = new L3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76); match(T__26);
				}
				break;
			case 4:
				_localctx = new L4Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77); match(T__1);
				}
				break;
			case 5:
				_localctx = new L5Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(78); match(T__18);
				}
				break;
			case 6:
				_localctx = new L6Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(79); match(T__17);
				}
				break;
			case 7:
				_localctx = new L7Context(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(80); match(T__0);
				}
				break;
			case 8:
				_localctx = new L8Context(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(81); match(T__11);
				}
				break;
			case 9:
				_localctx = new L9Context(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(82); match(T__9);
				}
				break;
			case 10:
				_localctx = new L10Context(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(83); match(T__26);
				}
				break;
			case 11:
				_localctx = new L11Context(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(84); match(T__24);
				}
				break;
			case 12:
				_localctx = new L12Context(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(85); match(T__14);
				}
				break;
			case 13:
				_localctx = new L13Context(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(86); match(INT);
				}
				break;
			case 14:
				_localctx = new L14Context(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(87); match(DOUBLE);
				}
				break;
			case 15:
				_localctx = new L15Context(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(88); match(T__30);
				}
				break;
			case 16:
				_localctx = new L17Context(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(89); match(T__31);
				}
				break;
			case 17:
				_localctx = new L18Context(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(90); match(T__28);
				}
				break;
			case 18:
				_localctx = new L19Context(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(91); match(T__13);
				}
				break;
			case 19:
				_localctx = new L20Context(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(92); match(T__12);
				}
				break;
			case 20:
				_localctx = new L21Context(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(93); match(T__15);
				}
				break;
			case 21:
				_localctx = new L22Context(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(94); match(T__29);
				}
				break;
			case 22:
				_localctx = new L23Context(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(95); match(T__8);
				}
				break;
			case 23:
				_localctx = new L24Context(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(96); match(T__3);
				}
				break;
			case 24:
				_localctx = new L25Context(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(97); match(T__20);
				}
				break;
			case 25:
				_localctx = new L26Context(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(98); match(T__6);
				}
				break;
			case 26:
				_localctx = new L27Context(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(99); match(T__7);
				}
				break;
			case 27:
				_localctx = new L28Context(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(100); match(T__5);
				}
				break;
			case 28:
				_localctx = new L29Context(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(101); match(T__22);
				}
				break;
			case 29:
				_localctx = new L30Context(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(102); match(T__4);
				}
				break;
			case 30:
				_localctx = new L31Context(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(103); match(T__27);
				}
				break;
			case 31:
				_localctx = new L32Context(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(104); match(T__21);
				}
				break;
			case 32:
				_localctx = new L33Context(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(105); match(T__19);
				}
				break;
			case 33:
				_localctx = new L33Context(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(106); match(T__10);
				}
				break;
			case 34:
				_localctx = new L34Context(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(107); match(T__25);
				}
				break;
			case 35:
				_localctx = new L35Context(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(108); match(T__33);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+r\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\3\3"+
		"\3\5\3\27\n\3\5\3\31\n\3\3\4\3\4\5\4\35\n\4\3\4\3\4\5\4!\n\4\3\4\3\4\5"+
		"\4%\n\4\3\4\3\4\3\4\5\4*\n\4\3\4\3\4\5\4.\n\4\3\4\5\4\61\n\4\3\4\5\4\64"+
		"\n\4\3\4\3\4\3\4\3\4\5\4:\n\4\3\4\3\4\3\5\7\5?\n\5\f\5\16\5B\13\5\3\5"+
		"\3\5\7\5F\n\5\f\5\16\5I\13\5\5\5K\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6p\n\6\3\6\2\2\7\2\4\6\b\n\2"+
		"\3\4\2%%))\u009e\2\r\3\2\2\2\4\30\3\2\2\2\6\32\3\2\2\2\bJ\3\2\2\2\no\3"+
		"\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2"+
		"\2\20\3\3\2\2\2\21\31\7\'\2\2\22\31\5\6\4\2\23\31\5\6\4\2\24\26\5\6\4"+
		"\2\25\27\7\'\2\2\26\25\3\2\2\2\26\27\3\2\2\2\27\31\3\2\2\2\30\21\3\2\2"+
		"\2\30\22\3\2\2\2\30\23\3\2\2\2\30\24\3\2\2\2\31\5\3\2\2\2\32\34\7\r\2"+
		"\2\33\35\7(\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2\2\36 \7%\2\2\37"+
		"!\7(\2\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"$\7\24\2\2#%\7(\2\2$#\3\2\2"+
		"\2$%\3\2\2\2%&\3\2\2\2&\'\7%\2\2\')\7\26\2\2(*\7(\2\2)(\3\2\2\2)*\3\2"+
		"\2\2*+\3\2\2\2+-\7\4\2\2,.\7(\2\2-,\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/\61"+
		"\7%\2\2\60/\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\64\7(\2\2\63\62\3\2"+
		"\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\t\2\2\2\66\67\7\26\2\2\679\t\2"+
		"\2\28:\7(\2\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\5\b\5\2<\7\3\2\2\2=?\5\n"+
		"\6\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AK\3\2\2\2B@\3\2\2\2CG\7\""+
		"\2\2DF\5\n\6\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2"+
		"\2\2J@\3\2\2\2JC\3\2\2\2K\t\3\2\2\2Lp\7)\2\2Mp\7(\2\2Np\7\n\2\2Op\7#\2"+
		"\2Pp\7\22\2\2Qp\7\23\2\2Rp\7$\2\2Sp\7\31\2\2Tp\7\33\2\2Up\7\n\2\2Vp\7"+
		"\f\2\2Wp\7\26\2\2Xp\7%\2\2Yp\7&\2\2Zp\7\6\2\2[p\7\5\2\2\\p\7\b\2\2]p\7"+
		"\27\2\2^p\7\30\2\2_p\7\25\2\2`p\7\7\2\2ap\7\34\2\2bp\7!\2\2cp\7\20\2\2"+
		"dp\7\36\2\2ep\7\35\2\2fp\7\37\2\2gp\7\16\2\2hp\7 \2\2ip\7\t\2\2jp\7\17"+
		"\2\2kp\7\21\2\2lp\7\32\2\2mp\7\13\2\2np\7\3\2\2oL\3\2\2\2oM\3\2\2\2oN"+
		"\3\2\2\2oO\3\2\2\2oP\3\2\2\2oQ\3\2\2\2oR\3\2\2\2oS\3\2\2\2oT\3\2\2\2o"+
		"U\3\2\2\2oV\3\2\2\2oW\3\2\2\2oX\3\2\2\2oY\3\2\2\2oZ\3\2\2\2o[\3\2\2\2"+
		"o\\\3\2\2\2o]\3\2\2\2o^\3\2\2\2o_\3\2\2\2o`\3\2\2\2oa\3\2\2\2ob\3\2\2"+
		"\2oc\3\2\2\2od\3\2\2\2oe\3\2\2\2of\3\2\2\2og\3\2\2\2oh\3\2\2\2oi\3\2\2"+
		"\2oj\3\2\2\2ok\3\2\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2p\13\3\2\2\2\21\17"+
		"\26\30\34 $)-\60\639@GJo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}