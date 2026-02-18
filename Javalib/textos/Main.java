import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromStream(System.in);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                                    Object offendingSymbol,
                                    int line,
                                    int charPositionInLine,
                                    String msg,
                                    RecognitionException e) {
                System.out.println("Error de sintaxis en linea "
                        + line + ":" + charPositionInLine + " " + msg);
            }
        });

        ParseTree tree = parser.prog();

        if (parser.getNumberOfSyntaxErrors() == 0) {

            EvalVisitor eval = new EvalVisitor();

            for (int i = 0; i < tree.getChildCount(); i++) {

                ParseTree child = tree.getChild(i);

                if (child instanceof ExprParser.StatContext) {

                    try {
                        Double result = eval.visit(child);
                        System.out.println("Resultado: " + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
