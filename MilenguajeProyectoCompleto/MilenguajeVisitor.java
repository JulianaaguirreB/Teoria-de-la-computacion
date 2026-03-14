// Generated from Milenguaje.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MilenguajeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MilenguajeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MilenguajeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(MilenguajeParser.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(MilenguajeParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(MilenguajeParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#imprimir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImprimir(MilenguajeParser.ImprimirContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(MilenguajeParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#cicloMientras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloMientras(MilenguajeParser.CicloMientrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#cicloPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloPara(MilenguajeParser.CicloParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(MilenguajeParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(MilenguajeParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(MilenguajeParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vectorExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorExpr(MilenguajeParser.VectorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecExpr(MilenguajeParser.DecExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(MilenguajeParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(MilenguajeParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(MilenguajeParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(MilenguajeParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(MilenguajeParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(MilenguajeParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(MilenguajeParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(MilenguajeParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(MilenguajeParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code matrizExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrizExpr(MilenguajeParser.MatrizExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(MilenguajeParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MilenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(MilenguajeParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(MilenguajeParser.VectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#matriz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatriz(MilenguajeParser.MatrizContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#listaExpresiones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExpresiones(MilenguajeParser.ListaExpresionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MilenguajeParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(MilenguajeParser.FuncionContext ctx);
}