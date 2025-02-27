package parking;

import java.time.LocalDate;

public class Ticket {
    private final int id;
    private String matricula;
    private LocalDate fechaHoraEntrada; 
    private Ubicacion Ubicacion;

    public Ticket(int id, String matricula, LocalDate fechaHoraEntrada, Ubicacion Ubicacion) {
        this.id = id;
        this.matricula = matricula;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.Ubicacion = Ubicacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(LocalDate fechaHoraEntrada) {
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
