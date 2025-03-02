package com.gregorio.parking;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import com.gregorio.parking.exception.DineroInsuficiente;

public class Deposito {
    /**
     * (dinero) Map de monedas y billetes en el depÃ³sito.
     * (tiposCambio) Array de tipos de cambio de monedas y billetes.
     * (CANTIDAD_POR_DEFECTO) Cantidad por defecto de monedas y billetes en el depÃ³sito.
     * */
    private Map<Double, Double> dinero = new HashMap<>();
    static final Double[] tiposCambio = {20.0, 10.0, 5.0, 2.0, 1.0, 0.5, 0.2, 0.1, 0.05};
    static final double CANTIDAD_POR_DEFECTO = 100.0;
    

    /**
     * Constructor de la clase Deposito por defecto
     * da un valor inicial a los billetes y monedas.
     */
    public Deposito() {
       // 100 unidades de cada billete y moneda
        for (double valor : tiposCambio)
            dinero.put(valor, CANTIDAD_POR_DEFECTO);
    }

    /**
     * MÃ©todo para procesar el pago de un ticket, guardando los billetes correspondientes 
     * y utilizamos el cambio disponible en el depÃ³sito
     * 
     * @param dineroIntroducido Dinero que da el usuario para pagar el ticket
     * @param precioTicket Dinero tiene que pagar para el ticket
     * @return cambio que se devuelve al usuario
     */
    public double procesarPago(double dineroIntroducido, double precioTicket) {
        // Si son valores invalidos, o el dinero introducido es menor que el precio del ticket lanzamos un mensaje de error
        if(dineroIntroducido > 0.0 && precioTicket > 0.0)
            JOptionPane.showMessageDialog(null, "No puedes introducir valores negativos", "Error", JOptionPane.ERROR_MESSAGE);
        else if(dineroIntroducido < precioTicket)
            JOptionPane.showMessageDialog(null, "Dinero insuficiente te faltan " + (precioTicket - dineroIntroducido) + "â¬");

            // Creamos una copia de seguridad del dinero en caso de que no se pueda devolver el cambio
        Map<Double, Double> backup = new HashMap<>(dinero);
        try {
            // Recivimos el dinero y lo guardamos en el depÃ³sito
            this.recibirDinero(precioTicket);

            // Cambio que deve devolber la mÃ¡quina (cambio)
            double cambio = dineroIntroducido - precioTicket;

            // Damos el cambio con el dinero disponible en el depÃ³sito
            this.darCambio(cambio);
            return cambio;
        } catch (DineroInsuficiente e) {
            dinero = backup;
            JOptionPane.showMessageDialog(null, "No hay cambio suficiente");
        } catch (Exception e) {
            dinero = backup;
            JOptionPane.showMessageDialog(null, "Error inesperado procesar el pago");
        }
        return 0.0;
    }

     /**
     * MÃ©todo para recibir el dinero y guardarlo en el depÃ³sito
     * 
     * @param dineroRecivido Dinero que da el usuario
     */
    public void recibirDinero(double dineroRecivido) {
        for (Double tipo : tiposCambio) {
            while(dineroRecivido >= tipo && dinero.containsKey(tipo) && dinero.get(tipo) > 0) {
                dineroRecivido -= tipo;
                dinero.put(tipo, dinero.get(tipo) + 1);
            }
        }
    }

    /**
     * MÃ©todo para almacenar el cambio que se devuelve al usuario en el deposito
     * 
     * @param cambio Dinero que se tiene que devolver al usuario
     * @param precioTicket Dinero tiene que pagar para el ticket
    * @throws DineroInsuficiente si no hay suficiente cambio en la mÃ¡quina
    */
    public void darCambio(double cambio) throws DineroInsuficiente {
        // Recorremos los tipos de cambio para cada billete y moneda,
        // mientras haya mÃ¡s por devolber, y queden billetes o monedas continuamos.
        int i = 0;
        while(cambio > 0.0 && i < tiposCambio.length) {
            // Si el cambio es mayor o igual al tipo de cambio actual podemos utilizarlo, ademÃ¡s deverÃ¡ haber de ese tipo en el depÃ³sito
            if(cambio >= tiposCambio[i] && this.dinero.containsKey(tiposCambio[i]) && this.dinero.get(tiposCambio[i]) > 0) {
                // Actualizamos el depÃ³sito, restandole una unidad al billete o moneda que utiliza
                this.dinero.put(tiposCambio[i], this.dinero.get(tiposCambio[i]) - 1);
                // Se resta del cambio el tipo de cambio actual
                cambio -= tiposCambio[i];
            } else {
                i++;
            }
        }

        // Si no hemos podido dar el cambio, es que no hay suficiente cambio en la mÃ¡quina
        if(cambio > 0){
            throw new DineroInsuficiente("No hay cambio suficiente");
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

    @Override
    public String toString() {
        return "Deposito [dinero=" + dinero + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", getDinero()=" + getDinero() + ", toString()=" + super.toString() + "]";
    }
}
