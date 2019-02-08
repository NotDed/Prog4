/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle5.pkg0;

import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Accionadores extends JButton{
    public static Pieza gridPiezas[][] = new Pieza[4][4];
    public static boolean win = false;
    public static ImageIcon icons[] = new ImageIcon[16];

    public Accionadores() {
        for(int k=0; k<16; k++){
            icons[k]=new ImageIcon(this.getClass().getResource("puzzle\\"+(k+1)+".png"));
        }
    }
    
    public static void llenar_spot(Pieza p){
        gridPiezas[p.pos_i][p.pos_j] = p;
    }
    
    
    
    public static void llenar_en_orden(Pieza grid[][], boolean tipo){
        for(int j=0; j<4; j++)  {
            for(int i=0; i<4; i++){
                if(tipo){
                    grid[i][j]= new Pieza(i, j);
                    if(i*j == 9){
                        grid[i][j].setEnabled(false);
                    }
                }
                else{
                    grid[i][j]= new Pieza();
                }
            }
        }      
    }
    
    public static void shuffle(){
        int placed = 0;
        int i = 0;
        int j = 0;
        int k;
        int l;
        Random r = new Random();
        Pieza gridTemporal[][] = new Pieza[4][4];
        llenar_en_orden(gridTemporal, false);
        llenar_en_orden(Accionadores.gridPiezas, true);
        System.out.println(Arrays.toString(gridTemporal));
        for(int q=0; q<4; q++){
            for(int e=0; e<4; e++){
                System.out.print(gridTemporal[q][e].toString()+"\t");
            }
            System.out.println("\n");
        }
        while(i*j != 9){
            k = r.nextInt(4);
            l = r.nextInt(4);
            if(!gridTemporal[k][l].placed){
                Accionadores.gridPiezas[i][j].pos_i = k;
                Accionadores.gridPiezas[i][j].pos_j = l;
                Accionadores.gridPiezas[i][j].valor = (4*l)+k;
                gridTemporal[k][l] = Accionadores.gridPiezas[i][j];
                i++;
                if(i>3){
                    i = 0;
                    j++;
                }
                gridTemporal[k][l].placed = true;
                gridTemporal[k][l].well_placed = gridTemporal[k][l].valor_fijo == gridTemporal[k][l].valor;
            }
        }
        Accionadores.gridPiezas = gridTemporal;
    }
    
    public static int adyacentes(Pieza p){
        if(p.pos_i + 1 < 4 && gridPiezas[p.pos_i+1][p.pos_j].blank){
            return 6;
        }
        else if(p.pos_i - 1 > -1 && gridPiezas[p.pos_i-1][p.pos_j].blank){
            return 4;
        }
        else if(p.pos_j - 1 > -1 && gridPiezas[p.pos_i][p.pos_j-1].blank){
            return 8;
        }
        else if(p.pos_i + 1 < 4 && gridPiezas[p.pos_i][p.pos_j+1].blank){
            return 2;
        }
        else{
            return 5;
        }
    }
    
    public static void mover(int i, int j){
        Pieza temporal = gridPiezas[i][j];
        int direccion = adyacentes(gridPiezas[i][j]);
        switch(direccion){
            case 2:
                gridPiezas[i][j]=gridPiezas[i][j+1];
                gridPiezas[i][j+1] = temporal;
                break;
            case 4:
                gridPiezas[i][j]=gridPiezas[i-1][j];
                gridPiezas[i-1][j] = temporal;
                break;
            case 8:
                gridPiezas[i][j]=gridPiezas[i][j-1];
                gridPiezas[i][j-1] = temporal;
                break;
            case 6:
                gridPiezas[i][j]=gridPiezas[i+1][j];
                gridPiezas[i+1][j] = temporal;
                break;
            default:
                break;
        }
    }
    
}
