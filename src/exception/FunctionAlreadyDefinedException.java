package exception;

import org.antlr.v4.runtime.Token;

public class FunctionAlreadyDefinedException extends CompileException {

	protected final String functionName;
	
	public FunctionAlreadyDefinedException(Token functionNameToken) {
		super(functionNameToken);
		this.functionName = functionNameToken.getText();
	}
	
	@Override
	public String getMessage() {
		return line + ":" + column + " function already defined: <" + functionName + ">";
	}
}
