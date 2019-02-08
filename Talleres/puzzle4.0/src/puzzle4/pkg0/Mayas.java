/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle4.pkg0;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Mayas extends Botones implements ActionListener{
    public static Botones gridBotones[][] = new Botones[4][4];
    public static boolean win = false;
    
    public Mayas() {
        super();
        llenar_en_orden(gridBotones, true);
    }
    
    public static void llenar_matriz(Botones entradaBotones){
        gridBotones[entradaBotones.index_i][entradaBotones.index_j] = entradaBotones;
    }
    
    public static int adyacentes(Botones entradaBotones){
        int direccion = 5;
        if(entradaBotones.index_i + 1 < 4 && gridBotones[entradaBotones.index_i+1][entradaBotones.index_j].blank){
            direccion = 6;
        }
        else if(entradaBotones.index_i - 1 > -1 && gridBotones[entradaBotones.index_i-1][entradaBotones.index_j].blank){
            direccion = 4;
        }
        else if(entradaBotones.index_j - 1 > -1 && gridBotones[entradaBotones.index_i][entradaBotones.index_j-1].blank){
            direccion = 8;
        }
        else if(entradaBotones.index_i + 1 < 4 && gridBotones[entradaBotones.index_i][entradaBotones.index_j+1].blank){
            direccion = 2;
        }
        return direccion;
    }
    
    public static void llenar_en_orden(Botones grid[][], boolean tipo){
        for(int j=0; j<4; j++)  {
            for(int i=0; i<4; i++){
                if(tipo){
                    grid[i][j]= new Botones(i, j);
                    if(i*j == 9){
                        grid[i][j].setEnabled(false);
                    }
                    
                }
                else{
                    grid[i][j]= new Botones();
                }
            }
        }      
    }
    
    public static void shuffle(){
        Random r = new Random();
        Botones gridTemporal[][] = new Botones[4][4];
        llenar_en_orden(gridTemporal, false);
        llenar_en_orden(gridBotones, true);
        System.out.println(Arrays.toString(gridTemporal));
        for(int q=0; q<4; q++){
            for(int e=0; e<4; e++){
                System.out.print(gridTemporal[q][e].toString()+"\t");
            }
            System.out.println("\n");
        }
        int placed = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        while(i*j != 9){
            k = r.nextInt(4);
            l = r.nextInt(4);
            if(!gridTemporal[k][l].placed){
                gridTemporal[k][l] = gridBotones[i][j];
                i++;
                if(i>3){
                    i = 0;
                    j++;
                }
                gridTemporal[k][l].placed = true;
            }
        }
        gridBotones = gridTemporal;
    }
    
    public static void mover(int i, int j){
        Botones temporal = gridBotones[i][j];
        int direccion = adyacentes(gridBotones[i][j]);
        switch(direccion){
            case 2:
                gridBotones[i][j]=gridBotones[i][j+1];
                gridBotones[i][j+1] = temporal;
                break;
            case 4:
                gridBotones[i][j]=gridBotones[i-1][j];
                gridBotones[i-1][j] = temporal;
                break;
            case 8:
                gridBotones[i][j]=gridBotones[i][j-1];
                gridBotones[i][j-1] = temporal;
                break;
            case 6:
                gridBotones[i][j]=gridBotones[i+1][j];
                gridBotones[i+1][j] = temporal;
                break;
            default:
                break;
        }
    }
    
    public static boolean ganar(){
        boolean bandera = true;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(gridBotones[i][j].value != (4*j)+i){
                    bandera = false;
                }
            }
        }
        return bandera;
    }
    
    public static void mostrar(){
        for(int j=0; j<4; j++){
            for(int i=0; i<4; i++){
                System.out.print(gridBotones[i][j].value+"\t");
            }
            System.out.println("\n");
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        int i = this.index_i;
        int j = this.index_j;
        mostrar();
        System.out.println("asdasd");
        if(!ganar()){
            mover(i, j);
        }
        else{
            System.out.println("GANAMOS");
        }
    }
      
}
