/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle5.pkg0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Pieza extends Accionadores implements ActionListener{
    public int pos_i;
    public int pos_j;
    public int valor;
    public int valor_fijo;
    public boolean placed;
    public boolean well_placed;
    public boolean blank;

    public Pieza(int pos_i, int pos_j) {
        super();
        this.pos_i = pos_i;
        this.pos_j = pos_j;
        this.valor = (4*pos_j) + pos_i;
        this.valor_fijo = this.valor;
        this.placed = true;
        this.well_placed = true;
        if(this.valor == 15){
            this.blank = true;
            this.setEnabled(false);
        }
        this.setIcon(Pieza.icons[this.valor]);
        this.addActionListener(this);
    }
    
    public Pieza() {
        super();
        this.pos_i = -1;
        this.pos_j = -1;
        this.valor = -1;
        this.valor_fijo = -1;
        this.placed = false;
        this.well_placed = false;
    }   


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hi");
    }
}
