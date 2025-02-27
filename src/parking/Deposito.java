package parking;

import java.util.ArrayList;
import java.util.Arrays;

public class Deposito {
    private ArrayList<Double> monedas;
    private ArrayList<Integer> billetes;
    private final int[] tiposBilletes = {5, 10, 20};
    private final double[] tiposMonedas = {1, 2, 0,50 ,0.20, 0.10, 0.05};

    public Deposito(){}
    public Deposito(ArrayList<Double> monedas, ArrayList<Integer> billetes) {
        this.monedas = monedas;
        this.billetes = billetes;
    }

    public Deposito(double monedasIntroducidas, int billetes) {
        ArrayList<Double> cantidadBilletes = new ArrayList<Double>();
        for (double moneda : tiposMonedas) {

            double defecto = 100.0;
            if(moneda == monedasIntroducidas){
                defecto += monedasIntroducidas;
            }

            cantidadBilletes.add(Double.valueOf(defecto));
        }

        ArrayList<Integer> cantidadMonedas = new ArrayList<Integer>();
        for(int billete : tiposBilletes){
            int defecto=100;
            if(billete == billetes){
                defecto += billetes;
            }
            cantidadMonedas.add(Integer.valueOf(defecto));
        }

        this.monedas = cantidadBilletes;
        this.billetes = cantidadMonedas;
    }

    public ArrayList<Double> getMonedas() {
        return monedas;
    }

    public void setMonedas(ArrayList<Double> monedas) {
        this.monedas = monedas;
    }

    public ArrayList<Integer> getBilletes() {
        return billetes;
    }

    public void setBilletes(ArrayList<Integer> billetes) {
        this.billetes = billetes;
    }

    public int[] getTiposBilletes() {
        return tiposBilletes;
    }

    public double[] getTiposMonedas() {
        return tiposMonedas;
    }

    @Override
    public String toString() {
        return "Deposito [monedas=" + monedas + ", billetes=" + billetes + ", tiposBilletes="
                + Arrays.toString(tiposBilletes) + ", tiposMonedas=" + Arrays.toString(tiposMonedas) + ", getMonedas()="
                + getMonedas() + ", getBilletes()=" + getBilletes() + ", getClass()=" + getClass()
                + ", getTiposBilletes()=" + Arrays.toString(getTiposBilletes()) + ", getTiposMonedas()="
                + Arrays.toString(getTiposMonedas()) + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

    
}
