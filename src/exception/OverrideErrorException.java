package exception;

import org.antlr.v4.runtime.Token;

public class OverrideErrorException extends CompileException
{
    private String methodName;

    public OverrideErrorException(Token token)
    {
        super(token);
        this.methodName = token.getText();
    }

    @Override
    public String getMessage()
    {
        return line + ":" + column + " errors overriding method: <" + methodName + ">";
    }
}
