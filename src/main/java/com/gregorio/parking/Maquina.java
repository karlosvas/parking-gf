package com.gregorio.parking;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
  
    public Maquina(double precioPorMinuto) {
        Deposito deposito = new Deposito();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        this.deposito = deposito;
        this.tickets = tickets;
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

    // public Ticket mostrarTicket(int id) {
    // }

    // public void retirarTicket(int id) {
    // }

    // public void caluclarPrecio(Ticket ticket) {
    // }

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
