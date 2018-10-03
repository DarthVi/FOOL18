package exception;

import org.antlr.v4.runtime.Token;

public class NullPointerException extends CompileException
{
    private String varName;

    public NullPointerException(Token token)
    {
        super(token);
        this.varName = token.getText();
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " impossibile chiamare un metodo di un oggetto null: <" + varName + ">";
    }
}
