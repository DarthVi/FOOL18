package exception;

import org.antlr.v4.runtime.Token;

public class UndeclaredClassException extends CompileException
{
    private String className;

    public UndeclaredClassException(Token token)
    {
        super(token);
        this.className = token.getText();
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " undeclared class: <" + className + ">";
    }
}
