/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Boton extends JButton{
    public int index_i;
    public int index_j;
    public boolean blank;//if value == 15 -> true
    public ImageIcon img;
    public static int movidas = 0;
    public static ImageIcon imgarr[][]= new ImageIcon[4][4];
    public boolean placed;
    

    public Boton(int index_i, int index_j) {
        //super(index_i*4+index_j+"");
        this.index_i = index_i;
        this.index_j = index_j;
        this.img = new ImageIcon(index_i*4+index_j+1+".png");
        this.blank = false;
        if(index_i*4+index_j==15){
            this.blank=true;
            this.setEnabled(false);
        }
        this.setIcon(img);
        this.placed = false;
        imgarr[index_i][index_j] = img;
    }

    
    
    public static void shuffle(Boton butar[][]){
        int k, l;
        int n = -1;
        int m = 0;
        Boton temporal[][] = new Boton[4][4];
        Random r = new Random();
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                temporal[i][j] = new Boton(i, j);
            }
        }
        
        while(n*m != 9){
            k = r.nextInt(4);
            l = r.nextInt(4);
            if(!temporal[k][l].placed){
                n++;
                if(n>3){
                    n = 0;
                    m++;
                }
                butar[n][m]=temporal[k][l];
                butar[n][m].index_i= n;
                butar[n][m].index_j= m;
                butar[n][m].setEnabled(!butar[n][m].blank);
                temporal[k][l].placed = true;
                
            }
        }
        
    }
    
    public boolean verificar (Boton butar[][]){
        boolean ganar = true;
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                ganar = ganar && butar[i][j].img == imgarr[i][j];
            }
        }
        return ganar;
    }
    
    public void mover(Boton butar[][], int i, int j){
       int arriba, abajo;
       int derecha, izquierda;
       
       arriba = j - 1;
       abajo = j + 1;
       derecha = i + 1;
       izquierda = i - 1;
       ImageIcon temp = img;
       if(arriba >= 0 && butar[i][arriba].blank){
            movidas ++;
            butar[i][j].setIcon(butar[i][arriba].img);
            butar[i][j].img=butar[i][arriba].img;
            butar[i][j].blank= true;
            butar[i][j].setEnabled(false);
            butar[i][arriba].setIcon(temp);
            butar[i][arriba].img=temp;
            butar[i][arriba].blank=false;
            butar[i][arriba].setEnabled(true);
           
       }else{
           if(abajo <= 3 && butar[i][abajo].blank){
                movidas ++;
                butar[i][j].setIcon(butar[i][abajo].img);
                butar[i][j].img=butar[i][abajo].img;
                butar[i][j].blank= true;
                butar[i][j].setEnabled(false);
                butar[i][abajo].setIcon(temp);
                butar[i][abajo].img=temp;
                butar[i][abajo].blank=false;
                butar[i][abajo].setEnabled(true);
           }else{
               if(derecha <= 3 && butar[derecha][j].blank){
                    movidas ++;
                    butar[i][j].setIcon(butar[derecha][j].img);
                    butar[i][j].img=butar[derecha][j].img;
                    butar[i][j].blank= true;
                    butar[i][j].setEnabled(false);
                    butar[derecha][j].setIcon(temp);
                    butar[derecha][j].img=temp;
                    butar[derecha][j].blank=false;
                    butar[derecha][j].setEnabled(true);
               }else{
                   if(izquierda >= 0 && butar[izquierda][j].blank){
                        movidas ++;
                        butar[i][j].setIcon(butar[izquierda][j].img);
                        butar[i][j].img=butar[izquierda][j].img;
                        butar[i][j].blank= true;
                        butar[i][j].setEnabled(false);
                        butar[izquierda][j].setIcon(temp);
                        butar[izquierda][j].img=temp;
                        butar[izquierda][j].blank=false;
                        butar[izquierda][j].setEnabled(true);
                   }
               }
           }
       }
       
    }

    @Override
    public String toString() {
        return "Boton{" + "index_i=" + index_i + ", index_j=" + index_j + ", blank=" + blank + ", img=" + img + ", placed=" + placed + '}';
    }
    
    
    
    public void controladores(boolean cond,Boton butar[][]) {
            ActionListener letra;
            letra = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    mover(butar, index_i, index_j);
                    if(verificar(butar)){
                        JFrame Cuadro = new JFrame("ventana");
                        JPanel Panel = new JPanel();
                        Cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        Cuadro.setSize(250,100);
                        Cuadro.setResizable(false);
                        Cuadro.add(Panel);
                        Panel.setLayout(new GridLayout(2,0));
                        Label l = new Label("HAS GANADO!!!");
                        Label l2 = new Label("movimientos totales: "+movidas);
                        Panel.add(l);
                        Panel.add(l2);
                        Cuadro.setVisible(true);
                    }
                }
            };
            this.addActionListener(letra);
    }

    
    
}
