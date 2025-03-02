package com.gregorio.parking;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private String matricula;
    private LocalDateTime fechaHoraEntrada; 
    private Ubicacion Ubicacion;
    
    // public void generarTicket(){
    // }

    public Ticket(int id, String matricula, LocalDateTime fechaHoraEntrada, Ubicacion Ubicacion) {
        this.matricula = matricula;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.Ubicacion = Ubicacion;
        this.id=id;
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
