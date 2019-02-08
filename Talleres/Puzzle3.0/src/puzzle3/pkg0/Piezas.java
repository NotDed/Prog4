/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle3.pkg0;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Piezas extends JButton{
    public int matriz_consola[][] = new int[4][4];
    public int jugables[][] = new int[4][4];
    public JButton Botones[][] = new JButton[4][4];
    public ImageIcon iconos[] = new ImageIcon[16];
    
    
    public Piezas(JPanel p){
        int n = 0;
        for(int i=0; i<16;i++){
            if(i != 15){
                iconos[i]=new ImageIcon(this.getClass().getResource("puzzle\\"+(i+1)+".png"));
            }
        }
        for(int i=0; i<4; i++){
           for(int j=0; j<4; j++){
                Botones[i][j].setIcon(iconos[n]);
                p.add(Botones[i][j]);
                n++;
           } 
        }
    }
    
    public int[][] adyacentes(int Matrizconsola[][]){
        
    }
}
