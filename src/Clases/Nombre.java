package Clases;

import static Clases.FVentana.ALTO;
import static Clases.FVentana.ANCHO;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** En esta clase no sólo se pide el nombre al usuario sino tambien se escoje el escenario*/

public class Nombre {
    
    URL url;
    JLabel etiqueta,boton,regreso,esc1,esc2,esc3;
    ImageIcon imagen;
    JPanel inicio;
    JTextField nombre;
 
    public Nombre(){
    
        inicio = new JPanel();
        inicio.setLayout(null);
        inicio.setSize(ANCHO, ALTO);
        inicio.setBackground(Color.darkGray);
        nombre = new JTextField("");
        regreso = new JLabel();
        boton = new JLabel();
        esc1 = new JLabel();
        esc2 = new JLabel();
        esc3 = new JLabel();
        etiqueta = new JLabel();
        cargar();
    }
    
    public void cargar(){
        
        nombre.setSize(135, 30);
        nombre.setLocation(180, 230);
        inicio.add(nombre);
   
        url = getClass().getResource("/Imagenes/botonContinuar.png"); // boton continuar para iniciar el juego
        imagen = new ImageIcon(url);
        boton = new JLabel(imagen);
        boton.setSize(145, 55);
        boton.setLocation(170, 290);
        inicio.add(boton);
        
        url = getClass().getResource("/Imagenes/regresar.png");  // boton para regresar al menu
        imagen = new ImageIcon(url);
        regreso = new JLabel(imagen);
        regreso.setSize(252, 138);
        regreso.setLocation(120, 320);
        inicio.add(regreso);
        
        url = getClass().getResource("/Imagenes/escenario1.png"); // soleado
        imagen = new ImageIcon(url);
        esc1 = new JLabel(imagen);
        esc1.setSize(88, 122);
        esc1.setLocation(50, 510);
        inicio.add(esc1);
        
        url = getClass().getResource("/Imagenes/escenario2.png"); // atardecer
        imagen = new ImageIcon(url);
        esc2 = new JLabel(imagen);
        esc2.setSize(88, 122);
        esc2.setLocation(210, 510);
        inicio.add(esc2);
        
        url = getClass().getResource("/Imagenes/escenario3.png"); // noche
        imagen = new ImageIcon(url);
        esc3 = new JLabel(imagen);
        esc3.setSize(88, 122);
        esc3.setLocation(365, 510);
        inicio.add(esc3);
        
        url = getClass().getResource("/Imagenes/inicio.png"); // fondo
        imagen = new ImageIcon(url);
        etiqueta = new JLabel(imagen);
        etiqueta.setSize(ANCHO, ALTO);
        inicio.add(etiqueta);
              
    }
}
