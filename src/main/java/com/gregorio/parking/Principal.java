package com.gregorio.parking;

/**
 * Clase principal que inicia la aplicacion
 */
public class Principal {
    /**
     * @UIManager.LookAndFeelInfo Busca y establece el aspecto y la sensación de la aplicación
     *  buscando si existe el aspecto Nimbus para establecerlo, si no, se establece el aspecto por defecto
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /**
         * Creamos una nueva instancia de la maquina y la terminal
         * y la hacemos visible
         * 
         * @EventQueue.invokeLater Ejecuta el hilo de la interfaz de usuario
         * @param maquina Maquina de la aplicacion, que se coumunica con la terminal
         * @param terminal Terminal de la aplicacion, que se comunica con la maquina
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Maquina maquina = new Maquina(0.50);
                new Terminal(maquina).setVisible(true);
            }
        });
    }
}