package exception;

import org.antlr.v4.runtime.Token;

public class UndeclaredVariException extends CompileException
{
    private String varName;

    public UndeclaredVariException(Token varNameToken) {
        super(varNameToken);
        varName = varNameToken.getText();
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " undeclared variable <" + varName + ">";
    }
}
