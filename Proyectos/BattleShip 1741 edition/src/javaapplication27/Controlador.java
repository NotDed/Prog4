/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication27;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;



/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Controlador {
    public static int CantidadInicialBarcos;
    public static int Balzas;
    public static int BarcosHorizontales;
    public static int BarcosVerticales;
    public static int BarcosAliados;
    public static int BarcosEnemigos;
    public static int HundidosAliados;
    public static int HundidosEnemigos;
    public static int DisparosAliados;
    public static int DisparosEnemigos;
    public static int enabled;
    public static JLabel informacion[];

    public Controlador(int CantidadBarcos) {
        CantidadInicialBarcos = CantidadBarcos;
        Balzas = CantidadBarcos/2;
        BarcosHorizontales = CantidadBarcos/4;
        BarcosVerticales = CantidadBarcos/4;
        BarcosAliados = 0;
        BarcosEnemigos = 0;
        DisparosAliados = CantidadBarcos *2;
        DisparosEnemigos = CantidadBarcos *2;
        HundidosAliados = 0;
        HundidosEnemigos = 0;
        enabled = 0;
        informacion = new JLabel[6];
        for (int i = 0; i<6; i++){
            informacion[i] = new JLabel();
        }
        informe(informacion);
    }
    
    public boolean poner(Barcos mar[][], int i, int j ,int tipo, boolean aliado){
        try {
            if(aliado){
                    if(!mar[i][j].placed){
                        if(tipo == 1){
                            mar[i][j].direccion = -1;
                            mar[i][j].placed = true;
                            mar[i][j].hundido= false;
                            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                            mar[i][j].setIcon(Barcos.img.get(1));
                            BarcosAliados++;
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
                                    mar[i][j].setIcon(Barcos.img.get(4));
                                    mar[i][j-1].setIcon(Barcos.img.get(3));
                                    BarcosAliados++;
                                    return true;
                                }else{
                                    if(!mar[i][j+1].placed){
                                        mar[i][j].direccion = 6;
                                        mar[i][j+1].direccion = 4;
                                        mar[i][j+1].placed = true;
                                        mar[i][j+1].hundido = false;
                                        mar[i][j+1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                                        mar[i][j].setIcon(Barcos.img.get(3));
                                        mar[i][j+1].setIcon(Barcos.img.get(4));
                                        BarcosAliados++;
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
                                        mar[i][j].setIcon(Barcos.img.get(10));
                                        mar[i-1][j].setIcon(Barcos.img.get(9));
                                        BarcosAliados++;
                                        return true;
                                    }else{
                                        if(!mar[i+1][j].placed){
                                            mar[i][j].direccion = 2;
                                            mar[i+1][j].direccion = 8;
                                            mar[i+1][j].placed = true;
                                            mar[i+1][j].hundido = false;
                                            mar[i+1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                                            mar[i][j].setIcon(Barcos.img.get(9));
                                            mar[i+1][j].setIcon(Barcos.img.get(10));
                                            BarcosAliados++;
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                }
            }
            else{
                if(!mar[i][j].placed){
                    if(tipo == 1){
                        mar[i][j].direccion = -1;
                        mar[i][j].placed = true;
                        mar[i][j].hundido= false;
                        mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                        BarcosEnemigos++;
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
                                BarcosEnemigos++;
                                return true;
                            }else{
                                if(!mar[i][j+1].placed){
                                    mar[i][j].direccion = 6;
                                    mar[i][j+1].direccion = 4;
                                    mar[i][j+1].placed = true;
                                    mar[i][j+1].hundido = false;
                                    mar[i][j+1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                                    BarcosEnemigos++;
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
                                    BarcosEnemigos++;
                                    return true;
                                }else{
                                    if(!mar[i+1][j].placed){
                                        mar[i][j].direccion = 2;
                                        mar[i+1][j].direccion = 8;
                                        mar[i+1][j].placed = true;
                                        mar[i+1][j].hundido = false;
                                        mar[i+1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Hit.wav"));
                                        BarcosEnemigos++;
                                        return true;
                                    }
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
    
    public void disparo(Barcos mar[][], int i, int j, boolean aliado){
        AudioClip cannon = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Shot.wav"));
        cannon.play();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Barcos.class.getName()).log(Level.SEVERE, null, ex);
        }
        mar[i][j].sonido.play();
        if(aliado){
            if(mar[i][j].direccion == -1){
                mar[i][j].direccion = 0;
                mar[i][j].setIcon(Barcos.img.get(2));
                mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                mar[i][j].sonido.play();
                BarcosAliados--;
                HundidosAliados++;   
            }else{
                if(mar[i][j].direccion == 6){
                    mar[i][j].hundido = true;
                    mar[i][j].setIcon(Barcos.img.get(5));
                    mar[i][j].sonido.play();
                    mar[i][j+1].setIcon(Barcos.img.get(4));
                    mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                    if(mar[i][j+1].hundido){
                        mar[i][j].direccion = 0;
                        mar[i][j].setIcon(Barcos.img.get(7));
                        mar[i][j+1].direccion = 0;
                        mar[i][j+1].setIcon(Barcos.img.get(8));
                        mar[i][j].sonido.play();
                        mar[i][j+1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        BarcosAliados--;
                        HundidosAliados++;   
                    }
                }else{
                    if(mar[i][j].direccion == 4){
                        mar[i][j].hundido = true;
                        mar[i][j].setIcon(Barcos.img.get(4));
                        mar[i][j].sonido.play();
                        mar[i][j-1].setIcon(Barcos.img.get(5));
                        mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        if(mar[i][j-1].hundido){
                            mar[i][j].direccion = 0;
                            mar[i][j].setIcon(Barcos.img.get(8));
                            mar[i][j-1].direccion = 0;
                            mar[i][j-1].setIcon(Barcos.img.get(7));
                            mar[i][j].sonido.play();
                            mar[i][j-1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            BarcosAliados--;
                            HundidosAliados++;   
                        }
                    }else{
                        if(mar[i][j].direccion == 2){
                            mar[i][j].hundido = true;
                            mar[i][j].setIcon(Barcos.img.get(11));
                            mar[i][j].sonido.play();
                            mar[i+1][j].setIcon(Barcos.img.get(10));
                            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            if(mar[i+1][j].hundido){
                                mar[i][j].direccion = 0;
                                mar[i][j].setIcon(Barcos.img.get(13));
                                mar[i+1][j].direccion = 0;
                                mar[i+1][j].setIcon(Barcos.img.get(14));
                                mar[i][j].sonido.play();
                                mar[i+1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                BarcosAliados--;
                                HundidosAliados++;                                   
                            }
                        }else{
                            if(mar[i][j].direccion == 8){
                                mar[i][j].hundido = true;
                                mar[i][j].setIcon(Barcos.img.get(12));
                                mar[i][j].sonido.play();
                                mar[i-1][j].setIcon(Barcos.img.get(9));
                                mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                if(mar[i-1][j].hundido){
                                    mar[i][j].direccion = 0;
                                    mar[i][j].setIcon(Barcos.img.get(14));
                                    mar[i-1][j].direccion = 0;
                                    mar[i-1][j].setIcon(Barcos.img.get(13));
                                    mar[i][j].sonido.play();
                                    mar[i-1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                    mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                    BarcosAliados--;
                                    HundidosAliados++;
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            if(mar[i][j].direccion == -1){
                mar[i][j].direccion = 0;
                mar[i][j].setIcon(Barcos.img.get(2));
                mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                mar[i][j].sonido.play();
                BarcosEnemigos--;
                HundidosEnemigos++;
            }else{
                if(mar[i][j].direccion == 6){
                    mar[i][j].hundido = true;
                    mar[i][j].setIcon(Barcos.img.get(15));
                    mar[i][j].sonido.play();
                    mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                    if(mar[i][j+1].hundido){
                        mar[i][j].direccion = 0;
                        mar[i][j].setIcon(Barcos.img.get(7));
                        mar[i][j+1].direccion = 0;
                        mar[i][j+1].setIcon(Barcos.img.get(8));
                        mar[i][j].sonido.play();
                        mar[i][j+1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        BarcosEnemigos--;
                        HundidosEnemigos++;
                    }
                }else{
                    if(mar[i][j].direccion == 4){
                        mar[i][j].hundido = true;
                        mar[i][j].setIcon(Barcos.img.get(15));
                        mar[i][j].sonido.play();
                        mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                        if(mar[i][j-1].hundido){
                            mar[i][j].direccion = 0;
                            mar[i][j].setIcon(Barcos.img.get(8));
                            mar[i][j-1].direccion = 0;
                            mar[i][j-1].setIcon(Barcos.img.get(7));
                            mar[i][j].sonido.play();
                            mar[i][j-1].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            BarcosEnemigos--;
                            HundidosEnemigos++;
                        }
                    }else{
                        if(mar[i][j].direccion == 2){
                            mar[i][j].hundido = true;
                            mar[i][j].setIcon(Barcos.img.get(15));
                            mar[i][j].sonido.play();
                            mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                            if(mar[i+1][j].hundido){
                                mar[i][j].direccion = 0;
                                mar[i][j].setIcon(Barcos.img.get(13));
                                mar[i+1][j].direccion = 0;
                                mar[i+1][j].setIcon(Barcos.img.get(14));
                                mar[i][j].sonido.play();
                                mar[i+1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                BarcosEnemigos--;
                                HundidosEnemigos++;
                            }
                        }else{
                            if(mar[i][j].direccion == 8){
                                mar[i][j].hundido = true;
                                mar[i][j].setIcon(Barcos.img.get(15));
                                mar[i][j].sonido.play();
                                mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                if(mar[i-1][j].hundido){
                                    mar[i][j].direccion = 0;
                                    mar[i][j].setIcon(Barcos.img.get(14));
                                    mar[i-1][j].direccion = 0;
                                    mar[i-1][j].setIcon(Barcos.img.get(13));
                                    mar[i][j].sonido.play();
                                    mar[i-1][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                    mar[i][j].sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
                                    BarcosEnemigos--;
                                    HundidosEnemigos++;
                                }
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
            p = poner(mar, n, m, 1, false);
            
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
            if(poner(mar, n, m, 2, false)){
                puestos++;
            }
            System.out.println("puesto"+puestos);
        }
        puestos = 0;
        while(puestos < (cantidad/4)){
            n = r.nextInt(15);
            m = r.nextInt(15);
            if(poner(mar,n, m, 3, false)){
                puestos++;
            }
            System.out.println("puesto"+puestos);
        }
    }
     
    public void DisparoEnemigo (Barcos mar[][]){
        Random r = new Random();
        int n, m;
        n= r.nextInt(14);
        m = r.nextInt(14);
        disparo(mar, n, m, true);
        DisparosEnemigos--;         
    }
    
    public void informe(JLabel infromacion[]){
        infromacion[0].setText("Barcos aliados en pie: "+BarcosAliados);
        infromacion[1].setText("Barcos aliados hundidos: "+HundidosAliados);
        infromacion[2].setText("Disparos restantes: "+DisparosAliados);
        
        infromacion[3].setText("Barcos enemigos en pie: "+BarcosEnemigos);
        infromacion[4].setText("Barcos enemigos hundidos: "+HundidosEnemigos);
        infromacion[5].setText("Disparos del enemigo restantes: "+DisparosEnemigos);
    }
    
    public void PonerBarcos(Barcos maraliado[][], Barcos marenemigo[][], int i, int j){
        ActionListener accion;
        //ActionListener accion2;
        accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    if(Balzas > 0){
                        if(poner(maraliado, i, j, 1, true))
                            Balzas --;
                    }else if(BarcosHorizontales > 0){
                        if(poner(maraliado, i, j, 2, true))
                            BarcosHorizontales--;
                    }else if(BarcosVerticales > 0){
                        if(poner(maraliado, i, j, 3, true))
                            BarcosVerticales--;
                        if(BarcosVerticales == 0)
                            enabled = 1;
                    }
                    informe(informacion);
            }     
        };
        maraliado[i][j].addActionListener(accion);
    }
    
    public void DispararaEnemigos(Barcos maraliado[][], Barcos marenemigo[][], int i, int j){
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                marenemigo[i][j].click ++;
                switch(marenemigo[i][j].click){
                    case 1: marenemigo[i][j].tiempo_click = System.currentTimeMillis(); break;
                    case 2: 
                        if((System.currentTimeMillis()-marenemigo[i][j].tiempo_click < 300) && enabled == 1){
                            DisparosAliados--;
                            DisparoEnemigo(maraliado);
                            disparo(marenemigo, i, j, false);
                            marenemigo[i][j].click = 0;
                        }else{
                            marenemigo[i][j].click =1;
                            marenemigo[i][j].tiempo_click = System.currentTimeMillis();
                        }
                        break;
                }
                informe(informacion);
            }
        };
        marenemigo[i][j].addActionListener(accion);
    }
    
}
