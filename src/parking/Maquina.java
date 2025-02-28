package parking;

import java.util.ArrayList;

public class Maquina {
    private Terminal terminal;
    private Deposito deposito;
    private ArrayList<Ticket> tickets;
    private final int[][] parking = new int[2][19];
    private int capacidad;
    
    //Crear atributo capacidad int, método q devuelva booleano (True<60) sino false
    
     
    
    public Maquina(double precioPorMinuto) {
        Terminal terminal = new Terminal();
        Deposito deposito = new Deposito();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        this.terminal = terminal;
        this.deposito = deposito;
        this.tickets = tickets;
    }

    // Método que devuelve booleano según la capacidad
    
    public Terminal getTerminal() {
        return terminal;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public boolean capacidad() {
        return capacidad < 60;
    }
    
    
    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

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
        return "Maquina [terminal=" + terminal + ", deposito=" + deposito + ", tickets=" + tickets +  ", getTerminal()=" + getTerminal() + ", getDeposito()=" + getDeposito()
                + ", getTickets()=" + getTickets() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
}
