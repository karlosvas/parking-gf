package com.gregorio.parking.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import com.gregorio.parking.Ticket;

/**
 * Clase que contiene métodos para validar datos
 */
public class Validation {
    /**
     * Metodo que valida si un String es un número entero
     * 
     * @param input String a validar
     * @return Integer si el String es un número entero, null si no lo es
     */
    public static Integer parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);            
            return null;
        } catch (Error e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    /**
     * Método que valida si un String es un número decimal
     * 
     * @param input String a validar
     * @return Double si el String es un número decimal, null si no lo es
     */
    public static Double parseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return null;
        } catch (Error e) {
            return null;
        }
    }

    /**
     * Método que valida si un String es una fecha y hora en formato dd/MM/yyyy HH:mm:ss
     * 
     * @param input String a validar
     * @return LocalDateTime si el String es una fecha y hora en formato dd/MM/yyyy HH:mm:ss, null si no lo es
     */
    public static LocalDateTime parseLocalDateTime(String input) {
        try {
            return LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        } catch (DateTimeParseException e) {
            return null;
        } catch (Error e) {
            return null;
        }
    }

    /**
     *Método que valida si un String es una matrícula en formato cuatro numeros y tres letras mayusculas
     * 
     * @param matricula String a validar
     * @return true si el String es una matrícula en formato cuatro números y tres letras mayúsculas, false si no lo es
     */
    public static boolean validarMatricula(String matricula) {
        return matricula.matches("[0-9]{4}[A-Z]{3}");
    }

    public static boolean matriculaRepettida(String matricula, ArrayList<Ticket> listaTickets) {
        for (Ticket ticket : listaTickets) {
            if(ticket.getMatricula().equals(matricula)){
                return true;
            }
        }
        return false;
    }
}
