package exception;

import org.antlr.v4.runtime.Token;

public class IncorrectOrderConstructorException extends CompileException
{
    private String className;

    public IncorrectOrderConstructorException(Token token)
    {
        super(token);
        this.className = token.getText();
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " constructor order differs from parent: <" + className + ">";
    }
}
