package com.gregorio.parking.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ParseType {
    public static Integer parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        } catch (Error e) {
            return null;
        }
    }

    public static Double parseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return null;
        } catch (Error e) {
            return null;
        }
    }

    public static LocalDateTime parseLocalDateTime(String input) {
        try {
            return LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        } catch (DateTimeParseException e) {
            return null;
        } catch (Error e) {
            return null;
        }
    }
}
