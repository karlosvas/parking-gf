package parking;

public class Principal {
    private double precioPorMinuto;      // Precio por minuto de estacionamiento
    private Maquina maquina;             // Maquina de estacionamiento

    // public Máquina(double precio, double minuto, ArrayList<Ticket> tickets, ArrayList<int[]> ticketsActivos) {
    public Principal(double precioPorMinuto) {
        maquina = new Maquina(precioPorMinuto);
    }

    public static void main(String[] args) {
        
    }
}