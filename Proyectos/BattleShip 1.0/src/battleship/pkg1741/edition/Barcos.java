/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.pkg1741.edition;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import jdk.management.resource.internal.inst.SocketDispatcherRMHooks;
import sun.audio.AudioStream;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Barcos extends JButton{
    public int indi;
    public int indj;
    public int direccion;
    public int click;
    public long tiempo_click;
    public boolean placed;
    public boolean hundido;
    public AudioClip sonido;
    public static int disparos = 0;
    public static int hundidos = 0;
    public static int barcos = 0;
    public static int horizontales= 0;
    public static int verticales = 0;
    public static ArrayList<ImageIcon> img = new ArrayList<ImageIcon>();

    public Barcos(int indi, int indj) {
        this.indi = indi;
        this.indj = indj;
        this.direccion = 0;
        this.placed = false;
        this.click = 0;
        this.tiempo_click = 0;
        this.sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
        this.setIcon(img.get(0));
    }
    
    public boolean poner(Barcos mar[][], int i, int j,int tipo){
        try {
            if(!mar[i][j].placed){
                if(tipo == 1){
                    mar[i][j].direccion = -1;
                    mar[i][j].placed = true;
                    mar[i][j].hundido= false;
                    mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                    mar[i][j].setIcon(img.get(1));
                    barcos++;
                    return true;
                }else{
                    if(tipo == 2){
                        mar[i][j].placed = true;
                        mar[i][j].hundido = false;
                        mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                        if(j-1 >= 0 && !mar[i][j-1].placed){
                            mar[i][j].direccion = 4;
                            mar[i][j-1].direccion = 6;
                            mar[i][j-1].placed = true;
                            mar[i][j-1].hundido = false;
                            mar[i][j-1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                            mar[i][j].setIcon(img.get(4));
                            mar[i][j-1].setIcon(img.get(3));
                            barcos++;
                            return true;
                        }else{
                            if(!mar[i][j+1].placed){
                                mar[i][j].direccion = 6;
                                mar[i][j+1].direccion = 4;
                                mar[i][j+1].placed = true;
                                mar[i][j+1].hundido = false;
                                mar[i][j+1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                                mar[i][j].setIcon(img.get(3));
                                mar[i][j+1].setIcon(img.get(4));
                                barcos++;
                                return true;
                            }
                        }
                    }else{
                        if(tipo == 3){
                            mar[i][j].placed = true;
                            mar[i][j].hundido = false;
                            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                            if(j >= 0 && !mar[i-1][j].placed){
                                mar[i][j].direccion = 8;
                                mar[i-1][j].direccion = 2;
                                mar[i-1][j].placed = true;
                                mar[i-1][j].hundido = false;
                                mar[i-1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                                mar[i][j].setIcon(img.get(10));
                                mar[i-1][j].setIcon(img.get(9));
                                barcos++;
                                return true;
                            }else{
                                if(!mar[i+1][j].placed){
                                    mar[i][j].direccion = 2;
                                    mar[i+1][j].direccion = 8;
                                    mar[i+1][j].placed = true;
                                    mar[i+1][j].hundido = false;
                                    mar[i+1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                                    mar[i][j].setIcon(img.get(9));
                                    mar[i+1][j].setIcon(img.get(10));
                                    barcos++;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    public void disparo(Barcos mar[][], int i, int j){
        AudioClip cannon = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Shot.wav"));
        cannon.play();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Barcos.class.getName()).log(Level.SEVERE, null, ex);
        }
        mar[i][j].sonido.play();
        if(mar[i][j].direccion == -1){
            mar[i][j].direccion = 0;
            mar[i][j].setIcon(img.get(2));
            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
            mar[i][j].sonido.play();
            barcos--;
        }else{
            if(direccion == 6){
                mar[i][j].hundido = true;
                mar[i][j].setIcon(img.get(5));
                mar[i][j].sonido.play();
                mar[i][j+1].setIcon(img.get(4));
                mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                if(mar[i][j+1].hundido){
                    mar[i][j].direccion = 0;
                    mar[i][j].setIcon(img.get(7));
                    mar[i][j+1].direccion = 0;
                    mar[i][j+1].setIcon(img.get(8));
                    mar[i][j].sonido.play();
                    mar[i][j+1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                    mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                    barcos--;
                }
            }else{
                if(direccion == 4){
                    mar[i][j].hundido = true;
                    mar[i][j].setIcon(img.get(6));
                    mar[i][j].sonido.play();
                    mar[i][j-1].setIcon(img.get(3));
                    mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                    if(mar[i][j-1].hundido){
                        mar[i][j].direccion = 0;
                        mar[i][j].setIcon(img.get(8));
                        mar[i][j-1].direccion = 0;
                        mar[i][j-1].setIcon(img.get(7));
                        mar[i][j].sonido.play();
                        mar[i][j-1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        barcos--;
                    }
                }else{
                    if(direccion == 2){
                        mar[i][j].hundido = true;
                        mar[i][j].setIcon(img.get(11));
                        mar[i][j].sonido.play();
                        mar[i+1][j].setIcon(img.get(10));
                        mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        if(mar[i+1][j].hundido){
                            mar[i][j].direccion = 0;
                            mar[i][j].setIcon(img.get(13));
                            mar[i+1][j].direccion = 0;
                            mar[i+1][j].setIcon(img.get(14));
                            mar[i][j].sonido.play();
                            mar[i+1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            barcos--;
                        }
                    }else{
                        if(direccion == 8){
                            mar[i][j].hundido = true;
                            mar[i][j].setIcon(img.get(12));
                            mar[i][j].sonido.play();
                            mar[i-1][j].setIcon(img.get(9));
                            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            if(mar[i-1][j].hundido){
                                mar[i][j].direccion = 0;
                                mar[i][j].setIcon(img.get(14));
                                mar[i-1][j].direccion = 0;
                                mar[i-1][j].setIcon(img.get(13));
                                mar[i][j].sonido.play();
                                mar[i-1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                barcos--;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void llenar (Barcos mar[][], int cantidad){
        int puestos = 0;
        Random r = new Random();
        int n, m;
        boolean p;
        while(puestos < (cantidad/2)){
            n= r.nextInt(14);
            m = r.nextInt(14);
            //System.out.println(mar[n][m].placed);
            p = poner(mar, n, m, 1);
            
            System.out.println("p: "+p);
            System.out.println("puesto"+puestos);
            if(p){
                puestos++;
            } 
        }
        puestos = 0;
        while(puestos < (cantidad/4)){
            n = r.nextInt(15);
            m = r.nextInt(15);
            if(poner(mar, n, m, 2)){
                puestos++;
            }
            System.out.println("puesto"+puestos);
        }
        puestos = 0;
        while(puestos < (cantidad/4)){
            n = r.nextInt(15);
            m = r.nextInt(15);
            if(poner(mar,n, m, 3)){
                puestos++;
            }
            System.out.println("puesto"+puestos);
        }
    }
    
    public void acciones(Barcos mar[][], int i, int j){
        ActionListener accion;
        //ActionListener accion2;
        accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int n = 0;
                mar[i][j].click ++;
                switch(mar[i][j].click){
                    case 1: mar[i][j].tiempo_click = System.currentTimeMillis(); break;
                    case 2:
                        if((System.currentTimeMillis()-mar[i][j].tiempo_click < 300)){
                            disparo(mar, i, j);
                            System.out.println("Boom en: i: "+i+" j: "+j);
                            mar[i][j].click = 0;
                        }else{
                            mar[i][j].click =1;
                            mar[i][j].tiempo_click = System.currentTimeMillis();
                        }
                        
                        break;
                }
            }
        };
        this.addActionListener(accion);
    }
    
}
