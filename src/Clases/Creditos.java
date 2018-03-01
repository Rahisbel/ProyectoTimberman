package Clases;

import static Clases.FVentana.ALTO;
import static Clases.FVentana.ANCHO;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**  La clase credito carga un JLabel con mi informacion, se le dan los valores básicos y se agrega al panel*/

public class Creditos {
    
    JPanel credits;
    JLabel fondo,boton;
    ImageIcon imagen;
    URL url;
    
    public Creditos(){
        
       credits = new JPanel();
       credits.setLayout(null);
       credits.setSize(ANCHO, ALTO);
       credits.setBackground(Color.darkGray);
       fondo = new JLabel();
       boton = new JLabel();
       imagen = new ImageIcon();
       creditos();
    }
    
    public void creditos(){
     
        url = getClass().getResource("/Imagenes/regreso.png");
        imagen = new ImageIcon(url);
        boton = new JLabel(imagen);
        boton.setSize(252,138);
        boton.setVisible(true);
        boton.setLocation(125, 535);
        credits.add(boton);
        
        url = getClass().getResource("/Imagenes/creditos.png");
        imagen = new ImageIcon(url);
        fondo = new JLabel(imagen);
        fondo.setSize(ANCHO, ALTO);
        fondo.setVisible(true);
        credits.add(fondo);
    }
}
