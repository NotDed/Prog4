/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puzzle4.pkg0;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Vistas extends JFrame{
    
    public static  JPanel p;

    public Vistas(){
        JFrame Cuadro = new JFrame("ventana");
        JPanel Panel = new JPanel();
        Cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cuadro.setSize(400,400);
        Cuadro.setResizable(false);
        Cuadro.add(Panel);
        Panel.setLayout(new GridLayout(4,4));
        Mayas m = new Mayas();
        Mayas.llenar_en_orden(Mayas.gridBotones, true);
        Mayas.shuffle();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
               Panel.add(Mayas.gridBotones[i][j]); 
            }
        }
        Cuadro.add(Panel);
        Cuadro.setVisible(true);
    }
    
    

}
