package parking;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Deposito {
    /**
     * (monedas) Map de monedas en el depósito.
     * (biletes) Map de billetes en el depósito.
     * */
    private final Map<Double, Double> billetes = new HashMap<>();
    private final Map<Double, Double> monedas = new HashMap<>();
    private final double CANTIDAD_POR_DEFECTO = 100.0;
    

    /**
     * Constructor de la clase Deposito por defecto
     * da un valor inicial a los billetes y monedas por defecto
     */
    public Deposito() {
        billetes.put(5.0, CANTIDAD_POR_DEFECTO);
        billetes.put(10.0, CANTIDAD_POR_DEFECTO);
        billetes.put(20.0, CANTIDAD_POR_DEFECTO);
        monedas.put(1.0, CANTIDAD_POR_DEFECTO);
        monedas.put(2.0, CANTIDAD_POR_DEFECTO);
        monedas.put(0.5, CANTIDAD_POR_DEFECTO);
        monedas.put(0.10, CANTIDAD_POR_DEFECTO);
        monedas.put(0.20, CANTIDAD_POR_DEFECTO);
        monedas.put(0.05, CANTIDAD_POR_DEFECTO);
    }

    /**
     * Metodo para introducir monedas en el deposito
     * 
     * @param moneda Moneda a introducir en el deposito por el usuario
     *
     */
    public void introducirMoneda(double nuevaMoneda) {
        // Recorremos el array de monedas y si la moneda introducida es igual a la moneda del array actualizamos la cantidad
        this.monedas.put(nuevaMoneda, monedas.get(nuevaMoneda) + nuevaMoneda);
    }

    /**
     * Metodo para introducir billetes en el deposito
     * 
     * @param billete Billete a introducir en el deposito por el usuario
     */
    public void introducirBillete(int billete) {
        // Recorremos el array de billetes y si el billete introducido es igual al billete del array actualizamos la cantidad
        this.billetes.put((double) billete, billetes.get((double) billete) + 1);
    }

    /**
     * Método para procesar el pago de un ticket
     * 
     * @param dinero Dinero introducido por el usuario
     * @param pagar Dinero a pagar por el ticket
     */
    public void procesarPagoTicket(double dinero, double pagar) {
        if(dinero < pagar && dinero > 0 && pagar > 0) {
            JOptionPane.showMessageDialog(null, "Dinero insuficiente te faltan " + (pagar - dinero) + "€");
            return;
        } else if(dinero >= pagar){
            double cambio
        } else {
            JOptionPane.showMessageDialog(null, "Dinero introducido incorrecto");
        }
    }

    public Map<Double, Double> getBilletes() {
        return billetes;
    }

    public Map<Double, Double> getMonedas() {
        return monedas;
    }

    @Override
    public String toString() {
        return "Deposito [billetes=" + billetes + ", monedas=" + monedas + ", CANTIDAD_POR_DEFECTO="
                + CANTIDAD_POR_DEFECTO + ", getClass()=" + getClass() + ", getBilletes()=" + getBilletes()
                + ", getMonedas()=" + getMonedas() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }
}
