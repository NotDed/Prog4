/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package batallanaval3.pkg0;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class PanelFondo extends JPanel{
        private Image fond;

        public PanelFondo () {
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
