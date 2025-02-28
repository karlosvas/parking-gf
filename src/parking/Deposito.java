package parking;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Deposito {
    /**
     * (dinero) Map de monedas y billetes en el depósito.
     * (tiposCambio) Array de tipos de cambio de monedas y billetes.
     * (CANTIDAD_POR_DEFECTO) Cantidad por defecto de monedas y billetes en el depósito.
     * */
    private final Map<Double, Double> dinero = new HashMap<>();
    static final Double[] tiposCambio = {20.0, 10.0, 5.0, 2.0, 1.0, 0.5, 0.2, 0.1, 0.05};
    static final double CANTIDAD_POR_DEFECTO = 100.0;
    

    /**
     * Constructor de la clase Deposito por defecto
     * da un valor inicial a los billetes y monedas por defecto
     */
    public Deposito() {
       // Lo inicializamos con sus valores por defecto, 100 unidades de cada billete y moneda
        for (double valor : tiposCambio)
            dinero.put(valor, CANTIDAD_POR_DEFECTO);
    }

    /**
     * Metodo para introducir monedas y billetes en el deposito
     * 
     * @param dineroIntroducido Moneda o billet a introducir en el deposito por el usuario
     *
     */
    public void introducirDinero(double dineroIntroducido) {
        if(!dinero.containsKey(dineroIntroducido)) {
            JOptionPane.showMessageDialog(null, "Moneda o billete no valido");
            return;
        }
        // Recorremos el array de monedas y si la moneda introducida es igual a la moneda del array actualizamos la cantidad
        this.dinero.put(dineroIntroducido, dinero.get(dineroIntroducido) + dineroIntroducido);
    }

    /**
     * Método para procesar el pago de un ticket, utilizando el cambio disponible en el depósito
     * 
     * @param dinero Dinero que da el usuario
     * @param precioTicket Dinero tiene que pagar para el ticket
     */
    public void procesarPago(double dinero, double precioTicket) {
        if(dinero < precioTicket && dinero > 0 && precioTicket > 0) {
            JOptionPane.showMessageDialog(null, "Dinero insuficiente te faltan " + (precioTicket - dinero) + "€");
            return;
        } else if(dinero >= precioTicket) {
            double cambio = dinero - precioTicket;
            System.out.printf("Cambio a devolver: %.2f€%n", cambio);

            // Recivimos el dinero

            // Damos el cambio
            this.darCambio(dinero, precioTicket);
           
        } else {
            JOptionPane.showMessageDialog(null, "Dinero introducido incorrecto");
        }
    }

     /**
     * Método para recibir el dinero del usuario
     * 
     * @param dineroRecivido Dinero que da el usuario
     */
    public void recibirDinero(int dineroRecivido){
        // Reccoremos los tipos de moneda para ver cual le gusta mas
        for (Double tipo : tiposCambio) {
            while(dineroRecivido >= tipo && dinero.containsKey(tipo) && dinero.get(tipo) > 0){
                dineroRecivido -= tipo;
                dinero.put(tipo, dinero.get(tipo) + 1);
            }
        }
    }

    /**
     * Método para dar cambio al usuario
     * 
     * @param cambio Dinero que se tiene que devolver al usuario
     * @param precioTicket Dinero tiene que pagar para el ticket
     */
    public void darCambio(double cambio, double precioTicket) {
        // Recorremos los tipos de cambio para cada billete y moneda,
        // mientras haya mas por pagar, tenga dinero y  queden billetes o monedas continuamos.
        int i = 0;
        while(precioTicket > 0.0 && cambio > 0 && i < tiposCambio.length) {
            // Si el cambio es mayor o igual al tipo de cambio actual podemos utilizarlo, ademas deverá estar en el map y ser mayor que 0
            if(precioTicket >= tiposCambio[i] && this.dinero.containsKey(tiposCambio[i]) && this.dinero.get(tiposCambio[i]) > 0) {
                // Actualizamos el deposito, restandole una unidad al billete o moneda que utiliza
                this.dinero.put(tiposCambio[i], this.dinero.get(tiposCambio[i]) - 1);
                // Se resta del tiket y del dinero del usuario
                precioTicket -= tiposCambio[i];
                cambio -= tiposCambio[i];
                System.out.printf("Cambio recibido por la maquina: %d€%n", tiposCambio[i]);
            } else {
                i++;
            }
        }
        if(precioTicket > 0){
            JOptionPane.showMessageDialog(null, "No hay cambio suficiente");
            return;
        } else
            JOptionPane.showMessageDialog(null, "Ticket pagado correctamente", "Pago", JOptionPane.INFORMATION_MESSAGE);
    }

    // Getters
    public Map<Double, Double> getDinero() {
        return dinero;
    }

    public static Double[] getTiposcambio() {
        return tiposCambio;
    }
}
