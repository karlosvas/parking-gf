package com.gregorio.parking.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase que permite poner una imagen de fondo a un JPanel
 */
public class FondoPanel extends JPanel {
    private Image imagen;
    
    public FondoPanel(String imagePath) {
        try {
            URL url = getClass().getResource(imagePath);
            if(url != null)
                imagen = new ImageIcon(url).getImage();
            else 
                System.err.println("No se pudo cargar la imagen de fondo" + imagePath);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen de fondo: " + e.toString());
        }
    }

    @Override
    public void paint(Graphics g) {
        if (imagen != null) 
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}