package com.gregorio.parking.exception;

/**
 * Excepción que se lanza cuando el dinero introducido no es suficiente para pagar el ticket
 */
public class DineroInsuficiente extends Exception {
    public DineroInsuficiente(String message) {
        super(message);
    }
}
