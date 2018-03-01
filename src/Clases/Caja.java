package Clases;                                                     /**Rahisbel  Herrera**/    

import java.net.URL;
import javax.swing.*;

/**
 *
 * Clase caja encargada de cargar las respectivas cajas para el escenario 
 * 
 */
public class Caja {

    ImageIcon imagen;
    JLabel etiqueta;
    URL url;
    int numero;

    public Caja(int xCaja, int yCaja, int numero){ 

        for(int i=0;i<3;i++){
            if(numero==1){
                url = getClass().getResource("/Imagenes/Caja.png"); /** Ruta de la caja gris */
            }
            else if(numero==2){
                url = getClass().getResource("/Imagenes/CajaReforzada2.0.png"); // izquierda
            }
            else if(numero==3){
                url = getClass().getResource("/Imagenes/CajaReforzada3.0.png"); // derecha
            }
           
        }   
            
        imagen = new ImageIcon(url);
        etiqueta = new JLabel(imagen);
        etiqueta.setLocation(xCaja, yCaja);     
        etiqueta.setSize(315, 100);             
        this.numero=numero;
    }
  
    public void cambiarCaja(int numero){
        if(numero==1){
             url = getClass().getResource("/Imagenes/Caja.png"); 
        }
         else if(numero==2){
           url = getClass().getResource("/Imagenes/CajaReforzada2.0.png");
        }
         else if(numero==3){
            url = getClass().getResource("/Imagenes/CajaReforzada3.0.png");
        } 
        
        imagen = new ImageIcon(url);
        etiqueta.setIcon(imagen);
        this.numero=numero;
    }
    
    public Caja(){}
    
}
