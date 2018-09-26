package exception;

import org.antlr.v4.runtime.Token;

public class ClassMemberOverridingException extends CompileException
{
    private String className;

    public ClassMemberOverridingException(Token token)
    {
        super(token);
        this.className = token.getText();
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " overriding type member is forbidden in class: <" + className + ">";
    }
}
