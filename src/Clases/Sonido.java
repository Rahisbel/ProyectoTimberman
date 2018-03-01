package Clases;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido {

    Clip golpe ;
    Clip fondo;
    Clip muerte;
    
    public Sonido() {
        
        try {
            golpe = AudioSystem.getClip();
            fondo = AudioSystem.getClip();
            muerte = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            System.out.println("Error!");
        }

        try {
            try {
                golpe.open(AudioSystem.getAudioInputStream(new File("src/Audio/golpe.wav")));
                fondo.open(AudioSystem.getAudioInputStream(new File("src/Audio/fondo.wav")));
                muerte.open(AudioSystem.getAudioInputStream(new File("src/Audio/muerte.wav")));
            } catch (LineUnavailableException ex) {
                System.out.println("Error!");
            }
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("El sonido no es soportado");
        } catch (IOException ex) {
            System.out.println("No se encontro el archivo.");
        }    
    }
    public void reproducirGolpe(){
        if(golpe.isRunning()){
            golpe.stop();
            golpe.setMicrosecondPosition(0);
            golpe.start();
        }else{
            golpe.setMicrosecondPosition(0);
            golpe.start();
        }
    }

    public void reproducirFondo(){
        fondo.start();
        fondo.loop(Clip.LOOP_CONTINUOUSLY);
    }
}


