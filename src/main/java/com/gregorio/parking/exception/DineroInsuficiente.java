package com.gregorio.parking.exception;

/**
 * Excepcion que se lanza cuando el dinero introducido no es suficiente para pagar el ticket
 */
public class DineroInsuficiente extends Exception {
    /**
     * Constructor de la excepcion
     * @param message mensaje de error que se pasa por parametro que se mostrara
     */
    public DineroInsuficiente(String message) {
        super(message);
    }
}
