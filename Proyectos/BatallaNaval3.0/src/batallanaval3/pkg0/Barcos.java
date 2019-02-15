/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package batallanaval3.pkg0;

import java.applet.AudioClip;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Barcos extends JButton{
    public int indi;
    public int indj;
    public int direccion;
    public int click;
    public long tiempo_click;
    public boolean placed;
    public boolean hundido;
    public AudioClip sonido;
    public static int disparos = 0;
    public static int hundidos = 0;
    public static int barcos = 0;
    public static ArrayList<ImageIcon> img = new ArrayList<ImageIcon>();

    public Barcos(int indi, int indj) {
        this.indi = indi;
        this.indj = indj;
        this.direccion = 0;
        this.placed = false;
        this.click = 0;
        this.tiempo_click = 0;
        this.sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonidos\\Mar.wav"));
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
        this.setIcon(img.get(0));
    }
}

