package Clases;

import static Clases.FVentana.ALTO;
import static Clases.FVentana.ANCHO;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
    
    URL url;
    JPanel menu;
    ImageIcon imagen;
    JLabel btnJugar, btnInstruc,btnCreditos,btnSalir,fondo; 
    
    public Menu(){
        
        fondo = new JLabel();
        btnJugar = new JLabel();
        btnInstruc = new JLabel();
        btnCreditos = new JLabel();
        btnSalir = new JLabel();
        imagen = new ImageIcon();
     
        menu = new JPanel();
        menu.setLayout(null); 
        menu.setVisible(true);
        menu.setSize(ANCHO, ALTO);
        menu.setBackground(Color.darkGray);
      
        cargar();     
    }
    
    public void cargar(){
        
        url = getClass().getResource("/Imagenes/b1.png"); // boton jugar
        imagen = new ImageIcon(url);
        btnJugar = new JLabel(imagen);
        btnJugar.setSize(252, 138);
        btnJugar.setVisible(true);
        btnJugar.setLocation(125, 150);
        menu.add(btnJugar);
        
        url = getClass().getResource("/Imagenes/b2.png"); // boton instrucciones 
        imagen = new ImageIcon(url);
        btnInstruc = new JLabel(imagen);
        btnInstruc.setSize(252, 138);
        btnInstruc.setVisible(true);
        btnInstruc.setLocation(125, 240);
        menu.add(btnInstruc);
        
        url = getClass().getResource("/Imagenes/b3.png"); // boton creditos
        imagen = new ImageIcon(url);
        btnCreditos = new JLabel(imagen);
        btnCreditos.setSize(252, 138);
        btnCreditos.setVisible(true);
        btnCreditos.setLocation(125, 330);
        menu.add(btnCreditos);
        
        url = getClass().getResource("/Imagenes/b4.png"); // boton salir
        imagen = new ImageIcon(url);
        btnSalir = new JLabel(imagen);
        btnSalir.setSize(252, 138);
        btnSalir.setVisible(true);
        btnSalir.setLocation(125, 425);
        menu.add(btnSalir);
        
        url = getClass().getResource("/Imagenes/fondomenu.png"); // fondo
        imagen = new ImageIcon(url);
        fondo = new JLabel(imagen);
        fondo.setSize(ANCHO, ALTO);
        menu.add(fondo);
    }   
}
