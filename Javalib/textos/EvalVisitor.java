import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends ExprBaseVisitor<Double> {

    private Map<String, Double> memory = new HashMap<>();

    @Override
    public Double visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Double value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Double visitPrintExpr(ExprParser.PrintExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitNumber(ExprParser.NumberContext ctx) {
        return Double.parseDouble(ctx.NUMBER().getText());
    }

    @Override
    public Double visitId(ExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        }
        throw new RuntimeException("Variable no definida: " + id);
    }

    @Override
    public Double visitAddSub(ExprParser.AddSubContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));

        if (ctx.getChild(1).getText().equals("+")) {
            return left + right;
        } else {
            return left - right;
        }
    }

    @Override
    public Double visitMultDiv(ExprParser.MultDivContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));

        if (ctx.getChild(1).getText().equals("*")) {
            return left * right;
        } else {
            if (right == 0) {
                throw new ArithmeticException("Error: Division por cero");
            }
            return left / right;
        }
    }

    @Override
    public Double visitParens(ExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}
