package exception;

import util.SemanticError;

import java.util.ArrayList;

public class SemanticException extends Exception {

    public ArrayList<SemanticError> errors;

    public SemanticException(ArrayList<SemanticError> errors) {
        super(errors.stream().map(SemanticError::toString).reduce("", (prev, curr) -> prev + "\n" + curr));
        this.errors = errors;
    }

}
