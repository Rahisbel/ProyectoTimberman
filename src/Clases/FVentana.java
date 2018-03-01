package Clases;                                                     /**Rahisbel  Herrera**/     

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Creacion de la ventana principal, en esta clase se aplican los cambios de paneles accediendo a ellos desde 
 * los respectivos botones, ademas de proporcionar las principales caracteristicas de la ventana
 */

public class FVentana{
    
    int tipo;
    Menu mnu;
    Panel pnl;
    String n;
    Creditos cred;
    Nombre nbre;
    JFrame Fventana;
    Instrucciones instruc;
    public static final int ANCHO = 505;
    public static final int ALTO = 645;

    public FVentana() {
   
        tipo = 0;
        n =" ";
        mnu = new Menu();
        nbre = new Nombre();
        cred = new Creditos();
        Fventana = new JFrame();
        instruc = new Instrucciones();
        inicio();
    }

    public void inicio() {
       
        Fventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Fventana.setLayout(null);
        Fventana.setSize(ANCHO, ALTO);             
        Fventana.setUndecorated(true);              
        Fventana.setLocationRelativeTo(null);      
        Fventana.setResizable(false);               
        Fventana.setVisible(true);                  
        Fventana.add(mnu.menu);
     
        mnu.btnJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==mnu.btnJugar){
                    mnu.menu.setVisible(false);
                    Fventana.remove(mnu.menu);
                    Fventana.add(nbre.inicio);
                    nbre.inicio.setVisible(true); 
                }
            }
        });
        
        nbre.boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==nbre.boton){
                    n=nbre.nombre.getText();
                    if(n.length()>8){
                        JOptionPane.showMessageDialog(Fventana, "El nombre debe tener maximo 8 letras");
                    }
                    else{
                        
                        mnu.menu.setVisible(false);
                        nbre.inicio.setVisible(false);
                        Fventana.remove(nbre.inicio);     
                        pnl = new Panel(Fventana,n,tipo);
                        System.out.println(""+tipo);
                    }
                 
                }
            }
        });
        
        nbre.regreso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==nbre.regreso){
                    nbre.inicio.setVisible(false);
                    Fventana.remove(nbre.inicio);
                    Fventana.add(mnu.menu);
                    mnu.menu.setVisible(true);
                }
            }
        });
        
        nbre.esc1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==nbre.esc1){
                    tipo=1;
                }
            }
        });
                        
        nbre.esc2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==nbre.esc2){
                    tipo=2;
                }
            }
        });
                        
        nbre.esc3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==nbre.esc3){
                    tipo=3;
                }
            }
        });
           
        mnu.btnInstruc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==mnu.btnInstruc){
                    mnu.menu.setVisible(false);
                    Fventana.add(instruc.pnlInstruc);
                    instruc.pnlInstruc.setVisible(true);
                    
                }
            }
        });
        
        instruc.boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==instruc.boton){
                    instruc.pnlInstruc.setVisible(false);
                    Fventana.remove(instruc.pnlInstruc);
                    mnu.menu.setVisible(true);
                }
            }
        });
        
        mnu.btnCreditos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==mnu.btnCreditos){
                    mnu.menu.setVisible(false);
                    Fventana.add(cred.credits);
                    cred.credits.setVisible(true);
                }
            }
        });
        
        cred.boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==cred.boton){
                    cred.credits.setVisible(false);
                    Fventana.remove(cred.credits);
                    mnu.menu.setVisible(true);
                }
            }
        });
        
        mnu.btnSalir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getSource()==mnu.btnSalir){
                    System.exit(0);
                }
            }
        });      
    }
}
