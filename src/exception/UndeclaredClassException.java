package exception;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class UndeclaredClassException extends CompileException
{
    private String className;
    private boolean useToken;

    public UndeclaredClassException(Token token)
    {
        super(token);
        this.className = token.getText();
        this.useToken = true;
    }

    public UndeclaredClassException(String name)
    {
        super(new CommonToken(0));
        this.className = name;
        this.useToken = false;
    }

    @Override
    public String getMessage() {
        if(useToken)
            return line + ":" + column + " undeclared class: <" + className + ">";
        else
            return "Undeclared class: <" + className + ">";
    }
}
