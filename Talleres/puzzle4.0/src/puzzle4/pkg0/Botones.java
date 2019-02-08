/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle4.pkg0;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import static puzzle4.pkg0.Mayas.ganar;
import static puzzle4.pkg0.Mayas.mostrar;
import static puzzle4.pkg0.Mayas.mover;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Botones extends JButton implements ActionListener{

    public int index_i;
    public int index_j;
    public int value;//i*4+j
    public boolean placed;
    public boolean blank;//if value == 15 -> true
    public ImageIcon icons[] = new ImageIcon[16];
    
    public Botones(){
        this.index_i = -1;
        this.index_j = -1;
        this.value = -1;
        this.placed = false;
        this.blank = true;
    }
    
    public Botones(int i, int j){
        this.index_i = i;
        this.index_j = j;
        this.value = (4*j) + i;
        this.placed = true;
        for(int k=0; k<16; k++){
            icons[k]=new ImageIcon(this.getClass().getResource((k+1)+".png"));
        }
        this.setIcon(this.icons[this.value]);
        this.addActionListener(this);
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
