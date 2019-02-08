/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle2.pkg0;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Pieza extends JButton implements ActionListener{
    public int indice_actual;
    public int indice_permanente;
    public boolean blank = false;
    public static ImageIcon iconos[];
    
    public Pieza() {
        iconos = new ImageIcon[16];
        for(int i=0; i<16;i++){
            if(i != 15){
                iconos[i]=new ImageIcon(this.getClass().getResource("puzzle\\"+(i+1)+".png"));
            }
        }
    }
    

    public void setIndice_actual(int indice_actual) {
        this.indice_actual = indice_actual;
    }

    public void setIndice_permanente(int indice_permanente) {
        this.indice_permanente = indice_permanente;
    }

    public void setBlank(boolean blank) {
        this.blank = blank;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ola"+this.indice_actual);
    }
    

}
