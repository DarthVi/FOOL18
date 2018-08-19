package exception;

import org.antlr.v4.runtime.Token;

public class UndeclaredVariableException extends RuntimeException
{
    private int line;
    private int column;
    private String varName;

    public UndeclaredVariableException(Token varNameToken)
    {
        this.line = varNameToken.getLine();
        this.column = varNameToken.getCharPositionInLine();
        this.varName = varNameToken.getText();
    }

    @Override
    public String getMessage()
    {
        return line + ":" + column + " undeclared variable <" + varName + ">";
    }
}
