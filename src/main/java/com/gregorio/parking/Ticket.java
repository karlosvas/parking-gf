package com.gregorio.parking;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ticket {
    private int id;
    private String matricula;
    private LocalDateTime fechaHoraEntrada; 
    private Ubicacion Ubicacion;

    /**
     * Constructor de la clase Ticket
     * 
     * @param id identificador uncio del ticket
     * @param matricula matricula del vehiculo
     * @param fechaHoraEntrada fecha y hora de entrada del vehiculo
     * @param Ubicacion ubicacion del vehiculo en el parking
     */
    public Ticket(int id, String matricula, LocalDateTime fechaHoraEntrada, Ubicacion Ubicacion) {
        this.matricula = matricula;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.Ubicacion = Ubicacion;
        this.id=id;
    }

    /**
     * Metodo que busca un ticket por su id en una lista de tickets
     * 
     * @param id identificador del ticket
     * @param listaTickets lista de tickets en la que buscar
     * @return ticket encontrado o null si no se encuentra
     */
    public static Ticket getTicketById(Integer id, ArrayList<Ticket> listaTickets){
        for (Ticket ticket : listaTickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    /**
     * Metodo que genera un id unico para un parking en funcion de su ubicacion
     * 
     * @param ubicacion ubicacion del parking
     * @return id unico del parking
     */
    public static int generarIdParking(Ubicacion ubicacion){
        return (ubicacion.getPlanta()-1) * 20 + (ubicacion.getPlaza()-1) + 1; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public Ubicacion getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(Ubicacion Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", matricula=" + matricula + ", fechaHoraEntrada=" + fechaHoraEntrada + ", Ubicacion=" + Ubicacion + '}';
    }
}
