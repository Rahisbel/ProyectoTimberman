package Clases;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** Clase encargada de cargar las imagenes para la animacion de la explosion */

public class ExplosionCaja {
    public static final int MAX = 14;
    ImageIcon []imagenes;
    JLabel etiqueta;
    URL url;
    
    public ExplosionCaja(){
        
        imagenes = new ImageIcon[MAX];
        etiqueta = new JLabel();
        
        for(int i=0;i<imagenes.length;i++){
            url= getClass().getResource("/Imagenes/c"+(i+1)+".png");
            imagenes[i]= new ImageIcon(url);
            
        }
        etiqueta = new JLabel(imagenes[0]);
        etiqueta.setSize(100, 100);
        etiqueta.setLocation(200, 428);
        etiqueta.setVisible(false);
    }
}
