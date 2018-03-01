package Clases;

import static Clases.FVentana.ALTO;
import static Clases.FVentana.ANCHO;
import java.awt.Color;
import java.net.URL;
import javax.swing.*;

public class Instrucciones {
    
    JPanel pnlInstruc;
    JLabel fondo,boton;
    ImageIcon imagen;
    URL url;

    public Instrucciones() {
        
        pnlInstruc = new JPanel();
        pnlInstruc.setLayout(null);
        pnlInstruc.setSize(ANCHO, ALTO);
        pnlInstruc.setBackground(Color.darkGray);
        fondo = new JLabel();
        boton = new JLabel();
        imagen = new ImageIcon();
        Instrucciones();
    }
    
    public void Instrucciones(){
        
        url = getClass().getResource("/Imagenes/regreso.png");
        imagen = new ImageIcon(url);
        boton = new JLabel(imagen);
        boton.setSize(252,138);
        boton.setVisible(true);
        boton.setLocation(125, 535);
        pnlInstruc.add(boton);
        
        url = getClass().getResource("/Imagenes/instrucciones.png");
        imagen = new ImageIcon(url);
        fondo = new JLabel(imagen);
        fondo.setSize(ANCHO, ALTO);
        fondo.setVisible(true);
        pnlInstruc.add(fondo);
    }   
}
