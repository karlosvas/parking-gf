package com.gregorio.parking;

public class Ubicacion {
    private int planta;
    private int plaza;

    /**
     * Clase ubicacion con planta y plaza
     * 
     * @param planta ubicacion en el eje y
     * @param plaza ubicacion en el eje x
     */
    //Constructor de la clase Ubicacion
    public Ubicacion(int planta, int plaza) {
        this.planta = planta+1;
        this.plaza = plaza+1;
    }

    public int getPlanta() {
        return planta;
    }

    public int getPlaza() {
        return plaza;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "planta=" + planta + ", plaza=" + plaza + '}';
    }
    
}
