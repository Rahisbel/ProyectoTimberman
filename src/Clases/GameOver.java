package Clases;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** Esta clase carga el JLabel de GameOver y lo agrega al panel*/

public class GameOver {
  
    URL url;
    JLabel etiqueta,salir;
    ImageIcon imagen;   
    
    public GameOver(){
        
        etiqueta = new JLabel();
        imagen = new ImageIcon();
        cargar();
    }
    
    public void cargar(){
        
        url = getClass().getResource("/Imagenes/gameover.png");
        imagen = new ImageIcon(url);
        etiqueta = new JLabel(imagen);
        etiqueta.setSize(415, 307);
        etiqueta.setLocation(45, 100);
        etiqueta.setVisible(true);
        
        url = getClass().getResource("/Imagenes/salir.png");
        imagen = new ImageIcon(url);
        salir = new JLabel(imagen);
        salir.setSize(80, 80);
        salir.setLocation(300, 200);
        salir.setVisible(true);
       
        etiqueta.add(salir);
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==salir){
                    System.exit(0);
                }
            }
        });
    }
}
