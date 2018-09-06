package exception;

import util.SemanticError;

import java.util.ArrayList;

public class SemanticException extends Exception {

    public SemanticException(ArrayList<SemanticError> errors) {
        // TODO controllare la bontà della linea seguente
        super(errors.stream().toString());
    }

}
