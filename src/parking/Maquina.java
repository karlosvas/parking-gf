package parking;

import java.time.LocalDate;
import java.util.ArrayList;

public class Maquina {
    private Deposito deposito;
    private ArrayList<Ticket> tickets;

    public Maquina(double precioPorMinuto) {
        Deposito deposito = new Deposito();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        this.deposito = deposito;
        this.tickets = tickets;
    }

    /**
     * Metodo para generar un ticket
     * 
     * @param matricula Matricula del vehiculo
     * @param fecha Fecha de entrada del vehiculo
     * @param ubicacion Ubicacion del vehiculo
     * (id) Calculamos el id del ticket a partir de la planta y la plaza, en el plano cartesiano
     * 
     * @return Ticket generado
     */	
    public Ticket generarTiket(String matricula, LocalDate fecha, Ubicacion ubicacion) {
        // Calculamos el id del ticket en el plano cartesiano
        int id = ubicacion.getPlanta() * 20 + ubicacion.getPlaza();
        
        // Creamos el ticket y lo añadimos al array de tickets
        Ticket ticket = new Ticket(id, matricula, fecha, ubicacion);
        this.tickets.add(ticket);

        // Devolvemos el ticket
        return ticket;
    }

    // public void retirarTicket(int id) {
    // }

    // public void caluclarPrecio(Ticket ticket) {
    // }

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
}
