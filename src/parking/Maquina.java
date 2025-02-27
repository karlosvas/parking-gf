package parking;

import java.util.ArrayList;

public class Maquina {
    private Terminal terminal;
    private Deposito deposito;
    private ArrayList<Ticket> tickets;
    private final int[][] parking = new int[2][19];

    public Maquina(double precioPorMinuto) {
        Terminal terminal = new Terminal();
        Deposito deposito = new Deposito();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        this.terminal = terminal;
        this.deposito = deposito;
        this.tickets = tickets;
    }

    public Terminal getTerminal() {
        return terminal;
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
                + ", getTickets()=" + getTickets() + ", getTicketsActivos()=" + getTicketsActivos() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
}
