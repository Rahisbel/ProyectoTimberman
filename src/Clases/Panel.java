package Clases;                                                     /**Rahisbel  Herrera**/    

import static Clases.FVentana.ALTO;
import static Clases.FVentana.ANCHO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

/**
 * 
 * Básicamente todo se implementa en esta clase, el movimiento de Wolverine, el de las cajas, las animaciones
 * en éste panel se agrega todo
 * 
 */

public class Panel extends JPanel implements KeyListener {
       
    URL url;
    Fondo fnd;
    String aux;
    JPanel pnl;
    Sonido obj;
    Font fuente,fuenteNombre;
    Caja [] cajas; 
    Wolverine wol;
    ImageIcon imagen;
    GameOver gmeover;
    ExplosionCaja exp;
    JLabel boton,puntos,puntosAux,tiemp,energia,nomb;
    int wolframe = 0,numero=0,auxnum=0,j=0,expframe=0,cajaux=0,numMuerte=0,puntaje=0,tiempo=30;
    Timer timer,tiempoReposoWol,tiempoGolpe,tiempoCaja,tiempoMuerte,tiempoExplosion; /** los tiempos de ejecucion */
    boolean derecha = false,GolpeIzquierda = false,GolpeDerecha = false,MuerteI = false,MuerteD = false;  

    public Panel(){}
    
    /** el constructor revise el frame, el nombre del usuario y el tipo de escenario e inicializa todos los atributos*/
    public Panel(JFrame frame, String n, int tipo){

        pnl = new JPanel();
        pnl.setLayout(null);
        pnl.setSize(ANCHO, ALTO);
        pnl.setBackground(Color.darkGray);
        
        fnd   = new Fondo(tipo);
        cajas = new Caja[6];
        boton = new JLabel();
        energia = new JLabel();
        obj = new Sonido();
        nomb = new JLabel(n);
        tiemp = new JLabel("30");
        puntos = new JLabel("0");
        puntosAux = new JLabel("0");
        gmeover = new GameOver();
        wol   = new Wolverine();
        exp   = new ExplosionCaja();
        fuente = new Font("OCR A Std",Font.BOLD,40); 
        fuenteNombre = new Font("OCR A Std",Font.BOLD,16); 
        
        frame.getContentPane().add(pnl);
        Cargar();
    }

    public void Cargar(){
        
        url = getClass().getResource("/Imagenes/boton.png"); /** boton cerrar */
        imagen = new ImageIcon(url);
        boton = new JLabel(imagen);
        boton.setSize(46, 48);
        boton.setLocation(455,5);
        pnl.add(boton);
        
        boton.addMouseListener(new MouseAdapter() { /** evento del boton cerrar */
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==boton){
                    System.exit(0);
                }
            }
        });
  
        nomb.setSize(100, 100); /** caracteristicas del nombre del usuario */
        nomb.setForeground(new Color(34, 153, 84));
        nomb.setFont(fuenteNombre);
        nomb.setLocation(395, 20);
        nomb.setVisible(true);
        pnl.add(nomb);
        
        puntosAux.setSize(100,100); /** puntos del GameOver*/
        puntosAux.setForeground(new Color(245, 176, 65));
        puntosAux.setFont(fuente);
        puntosAux.setLocation(232, 265);
        pnl.add(puntosAux);
        puntosAux.setVisible(false);
        pnl.add(gmeover.etiqueta);
        gmeover.etiqueta.setVisible(false);
        
        puntos.setSize(100, 100); /** puntos */
        puntos.setForeground(new Color(34, 153, 84));
        puntos.setFont(fuente);
        puntos.setLocation(410, 90);
        pnl.add(puntos);
        
        tiemp.setSize(100, 100); /** tiempo de energia */
        tiemp.setForeground(new Color(231, 76, 60));
        tiemp.setFont(fuente);
        tiemp.setLocation(30, 35);
        pnl.add(tiemp);
        
        url = getClass().getResource("/Imagenes/energia.png"); /** fondo del tiempo de energia */
        imagen = new ImageIcon(url);
        energia = new JLabel(imagen);
        energia.setSize(116, 122);
        energia.setLocation(5, 0);
        energia.setVisible(true);
        pnl.add(energia);
        
        pnl.add(wol.etiqueta); /** personaje*/
        pnl.add(exp.etiqueta); /** explosion de cajas */
        
        for(int i=0;i<cajas.length;i++){ /** cajas */
            if(i==0){
               cajas[i] = new Caja(55, 428 - (i * 100),1);  /** Para que la 1ra caja sea la normal"*/
            }
            else{
                do{
                    numero=(int)(Math.random()*3)+1;
                }while((auxnum==2 && numero==3) || (auxnum==3 && numero==2));
                    
                auxnum=numero;  
                    
                cajas[i] = new Caja(55, 428 - (i * 100),numero);
            }
            pnl.add(cajas[i].etiqueta);
        }    
        
        pnl.add(fnd.Jfondo); // fondo
        pnl.addKeyListener(this);
        pnl.setFocusable(true);
        pnl.setVisible(true);
        pnl.requestFocus();

        timer = new Timer(200, new Tiempo());
        tiempoCaja = new Timer(10, new BloqueCaja());
        tiempoGolpe = new Timer(50, new AnimacionGolpe());
        tiempoMuerte = new Timer(100, new AnimacionMuerte());
        tiempoReposoWol = new Timer(80, new AnimacionReposo());          
        tiempoExplosion = new Timer(15,new AnimacionExplosion());
        
        tiempoReposoWol.start();   
        obj.reproducirFondo(); /** sonido de fondo*/
    }

    /** Movimiento del personaje */
    
    @Override
    public void keyPressed(KeyEvent e){
  
        if (e.getKeyCode() == 39) {
                
            obj.reproducirGolpe(); /** sonido del golpe*/
            if(!timer.isRunning()){ /** iniciar tiempo de energia*/
                timer.start();
            }
            GolpeDerecha=true;
            GolpeIzquierda=false;
                
            if(GolpeDerecha){
                tiempo++;
                tiempo = Integer.parseInt(tiemp.getText())+1;
                aux = Integer.toString(tiempo);
                tiemp.setText(aux);
                    
                tiempoReposoWol.stop();
                wolframe=38;
                tiempoGolpe.start();
                wol.etiqueta.setLocation(274, 440);
                    
                puntaje = Integer.parseInt(puntos.getText())+1;
                aux = Integer.toString(puntaje);
                puntos.setText(aux);
                    
                puntaje = Integer.parseInt(puntosAux.getText())+1;
                aux = Integer.toString(puntaje);
                puntosAux.setText(aux);
                 
               /** Validacion de la muerte de Wolverine derecha*/ 
                for (int i = 0; i < cajas.length; i++) {
                    if (cajas[i].etiqueta.getY() >= 328 && cajas[i].etiqueta.getY() <= 428 && cajas[i].numero == 3) {
                        MuerteD = true;
                        tiempoReposoWol.stop();
                        tiempoGolpe.stop();
                        wolframe = 51;
                        tiempoMuerte.start();
                        wol.etiqueta.setLocation(274, 440);
                        }
                    }
                }
             
            /** movimiento de las cajas */
            for (int i = 0; i < cajas.length; i++) {
                if (i == 0) {
                    tiempoCaja.restart();
                }
            }
        }

        if (e.getKeyCode() == 37){
            obj.reproducirGolpe();    
            
            if(!timer.isRunning()){
                timer.start();
            }
            
            GolpeIzquierda=true;
            GolpeDerecha=false;
        
            if(GolpeIzquierda){
                tiempo++;
                tiempo = Integer.parseInt(tiemp.getText())+1;
                aux = Integer.toString(tiempo);
                tiemp.setText(aux);
                
                tiempoReposoWol.stop();
                wolframe = 32;
                tiempoGolpe.start();
                wol.etiqueta.setLocation(55, 440); 
                
                puntaje = Integer.parseInt(puntos.getText())+1;
                aux = Integer.toString(puntaje);
                puntos.setText(aux);
                
                puntaje = Integer.parseInt(puntosAux.getText())+1;
                aux = Integer.toString(puntaje);
                puntosAux.setText(aux);
                
                int j = 0;
                for (int i = 0; i < cajas.length; i++) {
                    if (cajas[i].etiqueta.getY() >= 328 && cajas[i].etiqueta.getY() <= 428 && cajas[i].numero == 2) {
                        MuerteI = true;
                        tiempoReposoWol.stop();
                        tiempoGolpe.stop();
                        wolframe = 44;
                        tiempoMuerte.start();
                        wol.etiqueta.setLocation(55, 440);   
                    }
                }
            }
            
            for (int i = 0; i < cajas.length; i++){
                if (i == 0) {
                    tiempoCaja.restart();
                }
            }
        }
    }
    
    /** Animacion del personaje cuando está en reposo */

    class AnimacionReposo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            wolframe++;
           
            if (derecha) {
                if (wolframe > 31) {
                    wolframe = 16;
                }
            } else {
                 if (wolframe > 15) {
                    wolframe = 0;
                }
                
            }
            wol.etiqueta.setIcon(wol.imagenes[wolframe]);
        }
    }
    
    /** Animacion del personaje cuando golpea */
    
    class AnimacionGolpe implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            wolframe++;
          
            if (GolpeIzquierda) {
                if (wolframe > 37) {
                    wolframe = 0;
                    GolpeIzquierda = false;
                    tiempoGolpe.stop();
                    tiempoReposoWol.start();
                    derecha = false;
                }
            } else {
                if (GolpeDerecha) {
                    if (wolframe > 43) {
                        wolframe = 16;
                        GolpeDerecha = false;
                        tiempoGolpe.stop();
                        tiempoReposoWol.start();
                        derecha = true;
                    }
                }
            }
            wol.etiqueta.setIcon(wol.imagenes[wolframe]);
        }
    }
    
    /** Animacion de la explosion */
    class AnimacionExplosion implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) { 
            expframe++;
            
            if(expframe>13){
                expframe=0;
                exp.etiqueta.setVisible(false);
                cajas[cajaux].etiqueta.setVisible(true);
                tiempoExplosion.stop();  
            }
            exp.etiqueta.setIcon(exp.imagenes[expframe]);
        }
    }
    
    /** Animacion de la muerte*/
    class AnimacionMuerte implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            obj.fondo.stop();
            obj.muerte.start(); // sonido de muerte
            
            wolframe++;
            pnl.setFocusable(false);
            timer.stop();
            
            if(MuerteI){
                if(wolframe>50){
                    numMuerte++;
                    wolframe=44;
                    MuerteD = false;
                }
                if(numMuerte==3){
                    numMuerte=0;
                    tiempoMuerte.stop();
                    puntosAux.setVisible(true);
                    gmeover.etiqueta.setVisible(true);
                  
                }
            }
            else if(MuerteD){
                if(wolframe>57){
                    numMuerte++;
                    wolframe=51;
                    MuerteI=false;
                }
                if(numMuerte==3){
                    numMuerte=0;
                    tiempoMuerte.stop();
                    puntosAux.setVisible(true);
                    gmeover.etiqueta.setVisible(true);
                }
            } 
            wol.etiqueta.setIcon(wol.imagenes[wolframe]);
        }
    }
 
    /** Animacion de las cajas, para que éstas bajen a medida de que se rompan */ 
    
    class BloqueCaja implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < cajas.length; i++) {
                   if(cajas[i].etiqueta.getY()>=430){
                        cajas[i].etiqueta.setVisible(false);
                        expframe=0;
                        exp.etiqueta.setVisible(true);
                        cajaux=i;
                        tiempoExplosion.restart();   
                    }
                cajas[i].etiqueta.setLocation(cajas[i].etiqueta.getX(), cajas[i].etiqueta.getY() + 10);
            }
            for (int i = 0; i < cajas.length; i++) {
                if (cajas[i].etiqueta.getY() >= 427 + 100) {
                    cajas[i].etiqueta.setLocation(cajas[i].etiqueta.getX(), cajas[i].etiqueta.getY());

                    if (cajas[i].etiqueta.getY() >= 427 + 100) {

                        do {
                            numero = (int) (Math.random() * 3) + 1;

                        } while ((auxnum == 2 && numero == 3) || (auxnum == 3 && numero == 2));

                        if (j > 0) {
                            auxnum = numero;
                        }

                        j += 1;

                        cajas[i].cambiarCaja(numero);
                        cajas[i].etiqueta.setLocation(cajas[i].etiqueta.getX(), -70);
                        cajas[i].etiqueta.setVisible(true);
                    }
                    tiempoCaja.stop();
                }
            }   
        }
    }
    
    class Tiempo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            tiempo--;
            tiempo = Integer.parseInt(tiemp.getText())-1;
            aux = Integer.toString(tiempo);
            tiemp.setText(aux);
            
            if(tiempo==0){
                if(!derecha){
                    MuerteI = true;
                    tiempoReposoWol.stop();
                    tiempoGolpe.stop();
                    wolframe = 44;
                    tiempoMuerte.start();
                    wol.etiqueta.setLocation(55, 440);
                    pnl.setFocusable(false);
                }
                else{
                    MuerteD = true;
                    tiempoReposoWol.stop();
                    tiempoGolpe.stop();
                    wolframe = 51;
                    tiempoMuerte.start();
                    wol.etiqueta.setLocation(274, 440);
                    pnl.setFocusable(false);
                }
            } 
        }  
    }
     
    @Override
    public void keyReleased(KeyEvent e){}
  
    @Override
    public void keyTyped(KeyEvent e){}
}
