package exception;

import org.antlr.v4.runtime.Token;

public class ClassMemberOverridingException extends CompileException
{
    private String varName;

    public ClassMemberOverridingException(Token token)
    {
        super(token);
        this.varName = token.getText();
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " member overriding forbidden: <" + varName + ">";
    }
}
