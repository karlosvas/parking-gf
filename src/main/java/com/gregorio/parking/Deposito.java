package com.gregorio.parking;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import com.gregorio.parking.exception.DineroInsuficiente;

public class Deposito {
    /**
     * (dinero) Map de monedas y billetes en el deposito.
     * (tiposCambio) Array de tipos de cambio de monedas y billetes.
     * (CANTIDAD_POR_DEFECTO) Cantidad por defecto de monedas y billetes en el deposito.
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
     * Metodo para procesar el pago de un ticket, guardando los billetes correspondientes 
     * y utilizamos el cambio disponible en el deposito
     * 
     * @param dineroIntroducido Dinero que da el usuario para pagar el ticket
     * @param precioTicket Dinero tiene que pagar para el ticket
     * @throws DineroInsuficiente si no hay suficiente cambio en la maquina, es utilizado porque estos errores
     * pueden producirse en los metodos a los que llama, como darCambio
     * @return boleano que indica si todo ha salido bien
     */
    public boolean procesarPago(double dineroIntroducido, double precioTicket, Double[] listaDineroIntroducido) {
        // Si son valores invalidos, o el dinero introducido es menor que el precio del ticket lanzamos un mensaje de error
        if(dineroIntroducido < 0.0 || precioTicket < 0.0){
            JOptionPane.showMessageDialog(null, "No puedes introducir valores negativos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(dineroIntroducido < precioTicket){
            JOptionPane.showMessageDialog(null, "Dinero insuficiente te faltan " + (precioTicket - dineroIntroducido) + "€", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Creamos una copia de seguridad del dinero en caso de que no se pueda devolver el cambio
        Map<Double, Double> backup = new HashMap<>(dinero);
        try {
            // Recibimos el dinero y lo guardamos en el deposito
            this.recibirDinero(listaDineroIntroducido);

            // Cambio que debe devolver la maquina (cambio)
            double cambio =  dineroIntroducido - precioTicket;

            if(cambio > 0.0){
                // Mostramos el cambio con el dinero disponible en el deposito
                JOptionPane.showMessageDialog(null, "Tu cambio es " + cambio + "€", "Cambio", JOptionPane.INFORMATION_MESSAGE);
                this.darCambio(cambio);
            }

            return true;
        } catch (DineroInsuficiente e) {
            dinero = backup;
            JOptionPane.showMessageDialog(null, "No hay cambio suficiente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            dinero = backup;
            JOptionPane.showMessageDialog(null, "Error inesperado procesar el pago", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

     /**
     * Metodo para recibir el dinero y guardarlo en el deposito
     * 
     * @param listaDineroIntroducido Dinero que da el usuario para pagar el ticket, en formato arry double donde cada posicion es la cantidad de * cambio que da de cada billete ordenado de mayor a menor
     */
    public void recibirDinero(Double[] listaDineroIntroducido) {
        int i = 0;
        for (Double tipo  : tiposCambio) 
            dinero.put(tipo, dinero.get(tipo) + listaDineroIntroducido[i++]);
    }

    /**
     * Metodo para almacenar el cambio que se devuelve al usuario en el deposito
     * 
     * @param cambio Dinero que se tiene que devolver al usuario
    *  @throws DineroInsuficiente si no hay suficiente cambio en la maquina
    */
    public void darCambio(double cambio) throws DineroInsuficiente {
        // Recorremos los tipos de cambio para cada billete y moneda,
        // mientras haya mÃ¡s por devolver, y queden billetes o monedas continuamos.
        int i = 0;
        while(cambio > 0.0 && i < tiposCambio.length) {
            // Si el cambio es mayor o igual al tipo de cambio actual podemos utilizarlo, ademas devera haber de ese tipo en el deposito
            if(cambio >= tiposCambio[i] && this.dinero.containsKey(tiposCambio[i]) && this.dinero.get(tiposCambio[i]) > 0) {
                // Actualizamos el deposito, restandole una unidad al billete o moneda que utiliza
                this.dinero.put(tiposCambio[i], this.dinero.get(tiposCambio[i]) - 1);
                // Se resta del cambio el tipo de cambio actual
                cambio -= tiposCambio[i];
            } else {
                i++;
            }
        }

        // Si no hemos podido dar el cambio, es que no hay suficiente cambio en la maquina lanzamos un error al padre
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
    StringBuilder sb = new StringBuilder("Depósito:\n");
    sb.append("╔════════╦═════════════╗\n");
    sb.append("║ Valor  ║  Cantidad   ║\n");
    sb.append("╠════════╬═════════════╣\n");
    double total = 0;
    for (Map.Entry<Double, Double> entry : dinero.entrySet()) {
        sb.append(String.format("║ %5.2f€ ║  %10.0f ║\n", 
                  entry.getKey(), entry.getValue()));
                  total += entry.getKey() * entry.getValue();
    }
    sb.append("╠════════╬═════════════╣\n");
    sb.append(String.format("║ TOTAL  ║ %10.2f€ ║\n", total));
    sb.append("╚════════╩═════════════╝");
    return sb.toString();
}
}
