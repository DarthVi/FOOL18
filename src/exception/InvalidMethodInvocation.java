package exception;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class InvalidMethodInvocation extends CompileException
{
    private String varName;
    private boolean useToken;

    public InvalidMethodInvocation(Token variableNameToken) {
        super(variableNameToken);
        varName = variableNameToken.getText();
        this.useToken = true;
    }

    public InvalidMethodInvocation(String varName)
    {
        super(new CommonToken(0));
        this.varName = varName;
        this.useToken = false;
    }

    @Override
    public String getMessage()
    {
        if(useToken)
            return line + ":" + column + " invalid method invocation on a variable which is not an object: <" + varName + ">";
        else
            return "invalid method invocation on a variable which is not an object: <" + varName + ">";
    }
}
