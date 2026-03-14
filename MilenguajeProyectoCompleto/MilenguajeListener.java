// Generated from Milenguaje.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MilenguajeParser}.
 */
public interface MilenguajeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(MilenguajeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(MilenguajeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(MilenguajeParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(MilenguajeParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(MilenguajeParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(MilenguajeParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(MilenguajeParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(MilenguajeParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#imprimir}.
	 * @param ctx the parse tree
	 */
	void enterImprimir(MilenguajeParser.ImprimirContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#imprimir}.
	 * @param ctx the parse tree
	 */
	void exitImprimir(MilenguajeParser.ImprimirContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(MilenguajeParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(MilenguajeParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#cicloMientras}.
	 * @param ctx the parse tree
	 */
	void enterCicloMientras(MilenguajeParser.CicloMientrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#cicloMientras}.
	 * @param ctx the parse tree
	 */
	void exitCicloMientras(MilenguajeParser.CicloMientrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#cicloPara}.
	 * @param ctx the parse tree
	 */
	void enterCicloPara(MilenguajeParser.CicloParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#cicloPara}.
	 * @param ctx the parse tree
	 */
	void exitCicloPara(MilenguajeParser.CicloParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(MilenguajeParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(MilenguajeParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(MilenguajeParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(MilenguajeParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(MilenguajeParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(MilenguajeParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vectorExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterVectorExpr(MilenguajeParser.VectorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vectorExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitVectorExpr(MilenguajeParser.VectorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterDecExpr(MilenguajeParser.DecExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitDecExpr(MilenguajeParser.DecExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MilenguajeParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MilenguajeParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(MilenguajeParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(MilenguajeParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(MilenguajeParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(MilenguajeParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MilenguajeParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MilenguajeParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(MilenguajeParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(MilenguajeParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(MilenguajeParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(MilenguajeParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(MilenguajeParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(MilenguajeParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(MilenguajeParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(MilenguajeParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(MilenguajeParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(MilenguajeParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matrizExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMatrizExpr(MilenguajeParser.MatrizExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matrizExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMatrizExpr(MilenguajeParser.MatrizExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(MilenguajeParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(MilenguajeParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(MilenguajeParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(MilenguajeParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(MilenguajeParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(MilenguajeParser.VectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#matriz}.
	 * @param ctx the parse tree
	 */
	void enterMatriz(MilenguajeParser.MatrizContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#matriz}.
	 * @param ctx the parse tree
	 */
	void exitMatriz(MilenguajeParser.MatrizContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#listaExpresiones}.
	 * @param ctx the parse tree
	 */
	void enterListaExpresiones(MilenguajeParser.ListaExpresionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#listaExpresiones}.
	 * @param ctx the parse tree
	 */
	void exitListaExpresiones(MilenguajeParser.ListaExpresionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MilenguajeParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(MilenguajeParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MilenguajeParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(MilenguajeParser.FuncionContext ctx);
}