package exception;

import org.antlr.v4.runtime.Token;

public class MissingMemberException extends CompileException
{
    String className;
    String memberName;

    public MissingMemberException(Token token, String className, String memberName)
    {
        super(token);
        this.className = className;
        this.memberName = memberName;
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " missing member <"
                + this.memberName + "> in class: <"
                + className + ">";
    }
}
