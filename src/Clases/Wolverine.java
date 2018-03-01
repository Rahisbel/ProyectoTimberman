package Clases;                                                     /**Rahisbel  Herrera**/    

import java.net.URL;
import javax.swing.*;

/**
 *
 * Clase Wolverine encargada de cargar cada uno de sus movimientos, es decir las imágenes 
 * 
 */
public class Wolverine {

    static final int TAMANO = 58;              /** total de fotos utilizadas para los movimientos de Wolverine */

    ImageIcon imagenes[] = new ImageIcon[TAMANO];
    JLabel etiqueta;
    URL url;

    public Wolverine() {
        
        for (int i = 0; i < imagenes.length; i++) {
            url = getClass().getResource("/Imagenes/"+(i + 1) + ".png");
            imagenes[i] = new ImageIcon(url);
        }
        etiqueta = new JLabel(imagenes[0]);     /** Imagen inicial del Wolverine */
        etiqueta.setSize(172, 100);             /** Tamaño */
        etiqueta.setLocation(55, 440);          /** posicion inicial */
    }
      
}
