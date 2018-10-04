package exception;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class InvalidObjectInstantiation extends CompileException
{
    private String className;
    private boolean useToken;

    public InvalidObjectInstantiation(Token variableNameToken) {
        super(variableNameToken);
        className = variableNameToken.getText();
        this.useToken = true;
    }

    public InvalidObjectInstantiation(String varName)
    {
        super(new CommonToken(0));
        this.className = varName;
        this.useToken = false;
    }

    @Override
    public String getMessage()
    {
        if(useToken)
            return line + ":" + column + " incorrect number of arguments in instantiation of class " + className;
        else
            return "incorrect number of arguments in instantiation of class " + className;
    }
}
