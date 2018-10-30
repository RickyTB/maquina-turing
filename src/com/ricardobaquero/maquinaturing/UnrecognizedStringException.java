package com.ricardobaquero.maquinaturing;

/**
 *
 * @author ricardobaquero
 */
public class UnrecognizedStringException extends RuntimeException {
    private final String message = "Esta cadena no se acepta en la Máquina de Turing.";

    @Override
    public String getMessage() {
        return message;
    }
    
}
