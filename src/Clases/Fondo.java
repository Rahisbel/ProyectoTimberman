package Clases;                                                     /**Rahisbel  Herrera**/    

import static Clases.FVentana.ALTO;
import static Clases.FVentana.ANCHO;
import java.net.URL;
import javax.swing.*;

/**
 *  
 * Aquí se asigna el fondo que el usuario escoja al panel de juego
 * 
 */
public class Fondo {

    URL url;
    ImageIcon Ifondo;
    JLabel Jfondo;

    public Fondo(int n) {
        
        if(n==1){
            url = getClass().getResource("/Imagenes/fondo1.png"); // soleado
            Ifondo = new ImageIcon(url);
            Jfondo = new JLabel(Ifondo);
            Jfondo.setSize(ANCHO, ALTO);
        }
        else if(n==2){
            url = getClass().getResource("/Imagenes/fondo2.png"); // atardecer
            Ifondo = new ImageIcon(url);
            Jfondo = new JLabel(Ifondo);
            Jfondo.setSize(ANCHO, ALTO);
        }
        else if(n==3){
            url = getClass().getResource("/Imagenes/fondo3.png"); // noche
            Ifondo = new ImageIcon(url);
            Jfondo = new JLabel(Ifondo);
            Jfondo.setSize(ANCHO, ALTO);
        }
        else{
             url = getClass().getResource("/Imagenes/fondo1.png"); // por defecto es el soleado
            Ifondo = new ImageIcon(url);
            Jfondo = new JLabel(Ifondo);
            Jfondo.setSize(ANCHO, ALTO); 
        }
    }
}
