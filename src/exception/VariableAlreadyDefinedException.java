package exception;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

public class VariableAlreadyDefinedException extends CompileException {
    private String varName;
    private boolean useToken;

    public VariableAlreadyDefinedException(Token variableNameToken) {
        super(variableNameToken);
        varName = variableNameToken.getText();
        this.useToken = true;
    }

    public VariableAlreadyDefinedException(String varName)
    {
        super(new CommonToken(0));
        this.varName = varName;
        this.useToken = false;
    }

    @Override
    public String getMessage()
    {
        if(useToken)
            return line + ":" + column + " variable already defined: <" + varName + ">";
        else
            return "variable already defined: <" + varName + ">";
    }
}
