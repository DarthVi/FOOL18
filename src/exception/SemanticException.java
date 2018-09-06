package exception;

import util.SemanticError;

import java.util.ArrayList;

public class SemanticException extends Exception {

    public SemanticException(ArrayList<SemanticError> errors) {
        super(errors.stream().map(SemanticError::toString).reduce("", (prev, curr) -> prev + "\n" + curr));
    }

}
