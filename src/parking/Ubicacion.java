package parking;

 
public class Ubicacion {
    private int planta;
    private int plaza;

    public Ubicacion(int planta, int plaza) {
        this.planta = planta+1;
        this.plaza = plaza+1;
    }

    

    
    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "planta=" + planta + ", plaza=" + plaza + '}';
    }
    
}
