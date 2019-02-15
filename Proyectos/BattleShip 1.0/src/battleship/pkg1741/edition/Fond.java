/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship.pkg1741.edition;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Fond extends JPanel{
    private Image fond;
    
    public Fond() {
        PreInit();
        initComponent();
    }

    private void PreInit() {
        fond = new ImageIcon("bg.png").getImage();
    }

    private void initComponent() {
        
    }
    
    public void paintBorder (Graphics g){
        super.paintComponent(g);
        g.drawImage(fond,0,0, getWidth(), getHeight(), this);
    }

}
