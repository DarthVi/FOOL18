package exception;

import org.antlr.v4.runtime.Token;

public class ClassAlreadyDefinedException extends CompileException
{
    private String className;

    public ClassAlreadyDefinedException(Token token)
    {
        super(token);
        this.className = token.getText();
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " class already defined: <" + className + ">";
    }
}
