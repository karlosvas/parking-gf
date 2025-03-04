package com.gregorio.parking;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.time.Duration;

public class Maquina {
    /**
     * (deposito) Deposito de la maquina
     * (tickets) Array de tickets generados
     * (capacidad) Capacidad de la maquina
     * (MAX_CAPACIDAD) Capacidad maxima de la maquina
     */
    private Deposito deposito;
    private ArrayList<Ticket> tickets;   
    private int capacidad;
    private final int MAX_CAPACIDAD=60;
    private final double PRECIO_POR_MINUTO;
  
    public Maquina(double PRECIO_POR_MINUTO) {
        Deposito deposito = new Deposito();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        this.deposito = deposito;
        this.tickets = tickets;
        this.PRECIO_POR_MINUTO = PRECIO_POR_MINUTO;
    }

    /**
     * Metodo para generar un ticket
     * 
     * @param id Id del ticket
     * @param matricula Matricula del vehiculo
     * @param fecha Fecha y hora de entrada del vehÃ­culo
     * @param ubicacion Ubicacion del vehiculo
     * 
     * @return Ticket generado
     */	
    public Ticket generarTiket(int id, String matricula, LocalDateTime fecha, Ubicacion ubicacion) {
        // Creamos el ticket y lo anÂ±adimos al array de tickets
        Ticket ticket = new Ticket(id, matricula, fecha, ubicacion);
        this.tickets.add(ticket);

        // Devolvemos el ticket
        return ticket;
    }

    /**
     * Metodo para retirar un vehiculo del parking
     * 
     * @param tiket Ticket del vehiculo a retirar
     */
    public void retirarVehiculo(Ticket tiket) {
        // Eliminamos el ticket del array de tickets
        this.tickets.remove(tiket);
    }


    /**
     * Metodo para calcular el precio de un ticket
     * 
     * 
     * @param ticket Ticket del vehiculo
     * @param fechaSalida Fecha y hora de salida del vehiculo
     * @return Precio del ticket double
     */
    public double calcularPrecioTicket(Ticket ticket, LocalDateTime fechaSalida) {
        // Obtenemos el tiempo de estancia en el parking
        LocalDateTime fechaTicketEntrada = ticket.getFechaHoraEntrada();
        // Con duration obtenemos la diferencia entre dos fechas y obtenemos cuantos minutos son
        Duration duracion = java.time.Duration.between(fechaTicketEntrada, fechaSalida);
        int minutos = (int) duracion.toMinutes();
        // Calculamos el precio de todos los minutos trsncurridos
        return minutos* this.PRECIO_POR_MINUTO;
    }

    public Ticket generarTicket(Integer[][] parking, String matricula) {
        boolean encontrado = false;
        Ticket ticket = null;
        for (int y = 0; y < parking.length && !encontrado; y++) {
            for (int x = 0; x < parking[y].length && !encontrado; x++) {
                if (parking[y][x] == 0) {
                    // Obtenemos la ubicacion y el id si hay plaza libre, y actualizamos el array de parking
                    Ubicacion ubicacion = new Ubicacion(y,x);
                    int id = parking[y][x] = Ticket.generarIdParking(ubicacion);
                    // Verificamos que la matricula no este repetida si no lo esta salimos del bucle
                    ticket = new Ticket(id, matricula, LocalDateTime.now(), ubicacion);
                    encontrado = true;
                }
            }
        }
        return ticket;
    }

    // GETTERS Y SETTERS
    public Deposito getDeposito() {
        return deposito;
    }
    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Maquina [deposito=" + deposito + ", tickets=" + tickets + ", capacidad=" + capacidad
                + ", MAX_CAPACIDAD=" + MAX_CAPACIDAD + ", getClass()=" + getClass() + ", getDeposito()=" + getDeposito()
                + ", getTickets()=" + getTickets() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }
}
