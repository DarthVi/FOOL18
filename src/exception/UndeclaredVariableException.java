package exception;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class UndeclaredVariableException extends CompileException
{
    private String varName;
    private boolean useToken;

    public UndeclaredVariableException(Token varNameToken) {
        super(varNameToken);
        varName = varNameToken.getText();
        this.useToken = true;
    }

    public UndeclaredVariableException(String varNameToken)
    {
        super(new CommonToken(0));
        this.varName = varNameToken;
        this.useToken = false;
    }

    @Override
    public String getMessage() {
        if(useToken)
            return line + ":" + column + " undeclared variable <" + varName + ">";
        else
            return "Undeclared variable <" + varName + ">";
    }
}
