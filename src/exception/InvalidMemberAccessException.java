package exception;

import org.antlr.v4.runtime.Token;

public class InvalidMemberAccessException extends CompileException
{
    int selector;

    public InvalidMemberAccessException(Token token, int selector)
    {
        super(token);
        this.selector = selector;
    }

    @Override
    public String getMessage()
    {
        if(selector == 0)
            return line + ":" + column + " non è possibile modificare membri di variabili che non sono oggetti";
        else
            return line + ":" + column + " non è possibile modificare membri di oggetti non inizializzati";
    }
}
