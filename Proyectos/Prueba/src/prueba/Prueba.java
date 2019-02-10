/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame Cuadro = new JFrame("ventana");
        JPanel Panel = new JPanel();
        Cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cuadro.setSize(730,730);
        Cuadro.setResizable(false);
        Cuadro.add(Panel);
        Panel.setLayout(new GridLayout(4,4));
        Boton but[][] = new Boton[4][4];
        ImageIcon img = new ImageIcon("1.png");
        
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                but[i][j]= new Boton(i, j);
            }
        }
        
        Boton.shuffle(but);
        
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                but[i][j].controladores(true, but);
                Panel.add(but[i][j]);
            }
        }
        
        Cuadro.setVisible(true);
    }
    
}
