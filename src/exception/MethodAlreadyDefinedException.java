package exception;

import org.antlr.v4.runtime.Token;

public class MethodAlreadyDefinedException extends FunctionAlreadyDefinedException
{
    public MethodAlreadyDefinedException(Token functionNameToken)
    {
        super(functionNameToken);
    }

    @Override
    public String getMessage()
    {
        return line + ":" + column + " method already defined: <" + this.functionName + ">";
    }
}
