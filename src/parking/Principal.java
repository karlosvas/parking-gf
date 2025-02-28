package parking;

public class Principal {
    private static double PRECIO_POR_MINUTO = 0.50;

    public static void main(String[] args) {
        Maquina maquina = new Maquina(PRECIO_POR_MINUTO);
        Terminal terminal = new Terminal(maquina);
    }
}