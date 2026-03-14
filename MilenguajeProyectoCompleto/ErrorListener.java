import org.antlr.v4.runtime.*;
import java.util.*;

public class ErrorListener extends BaseErrorListener {
    
    private List<String> errores = new ArrayList<>();
    
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                           Object offendingSymbol,
                           int line,
                           int charPositionInLine,
                           String msg,
                           RecognitionException e) {
        
        String error = String.format("Error sintáctico en línea %d, posición %d: %s", 
                                    line, charPositionInLine, msg);
        errores.add(error);
    }
    
    public List<String> getErrores() {
        return errores;
    }
    
    public boolean hayErrores() {
        return !errores.isEmpty();
    }
}