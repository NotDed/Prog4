/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle5.pkg0;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame Cuadro = new JFrame("ventana");
        JPanel Panel = new JPanel();
        Cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cuadro.setSize(400,400);
        Cuadro.setResizable(false);
        Cuadro.add(Panel);
        Panel.setLayout(new GridLayout(4,4));
        Panel.add(new Pieza(0, 0));
        
        Cuadro.setVisible(true);
        
    }
    
}
