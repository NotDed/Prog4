/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.pkg1741.edition;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class BattleShip1741Edition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame Cuadro = new JFrame("ventana");
        Fond Panel = new Fond();
        JPanel Panel2 = new JPanel();
        Fond Panel3 = new Fond();
        Cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Cuadro.setSize(1366,600);
        Cuadro.setResizable(true);
        Cuadro.add(Panel2);
        Panel2.setLayout(new GridLayout());
        Panel.setLayout(new GridLayout(15,15));
        Panel3.setLayout(new GridLayout(15,15));
        Barcos mar[][] = new Barcos[15][15];
        Barcos mar2[][] = new Barcos[15][15];
        for(int i = 0; i <= 15; i++){
            ImageIcon image = new ImageIcon("Battleship\\"+i+".png");
            Barcos.img.add(image);
        }
        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){
                mar[i][j]= new Barcos(i, j);
                mar[i][j].acciones(mar,i,j);
                //mar2[i][j]= new Barcos(i, j);
                //mar2[i][j].acciones(mar,i,j);
            }
        }
        mar[0][0].llenar(mar, 44);
        
        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){
                Panel.add(mar[i][j]);
                //Panel3.add(mar2[i][j]);
            }
        }
        Panel2.add(Panel);
        Panel2.add(new JLabel("ola"));
        //Panel2.add(Panel3);
        Cuadro.setVisible(true);
    }
    
}
