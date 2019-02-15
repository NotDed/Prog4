/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package batallanaval3.pkg0;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Vistas {
    public JFrame ventana_principal;
    public PanelFondo aliados;
    public PanelFondo enemigos;
    public JPanel Contenedor_texto;
    public JPanel Separador;
    public Barcos mar_aliado[][];
    public Barcos mar_enemigo[][];
    public static Controlador controles = new Controlador(44);
    
    public Vistas() {
        this.Iniciar_ventana();
        this.Iniciar_Aliado();
        this.Iniciar_Enemigo();
        this.Iniciar_Informacio();
        this.Separador.add(this.aliados);
        this.Separador.add(Contenedor_texto);
        this.Separador.add(this.enemigos);
        this.ventana_principal.setVisible(true);
        controles.llenar(mar_enemigo, 44);
        mostrar_array_direcciones();
        
    }
    
    public void mostrar_array_direcciones() {
        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){
                System.out.print(mar_enemigo[i][j].direccion+"\t");
            }
            System.out.println("");
        }        
    }

    public void Iniciar_ventana() {
        this.ventana_principal = new JFrame("BattleSip: 1741 edition");
        this.ventana_principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.ventana_principal.setSize(1366,500);
        this.ventana_principal.setResizable(false);
        this.Separador = new JPanel();
        this.Separador.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
        this.Separador.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        this.Separador.setLayout(new GridLayout(1, 3));
        this.ventana_principal.add(this.Separador);
        for(int i = 0; i <= 15; i++){
            ImageIcon image = new ImageIcon("Battleship\\"+i+".png");
            Barcos.img.add(image);
        }
    }
    
    public void Iniciar_Informacio(){
        this.Contenedor_texto = new JPanel();
        this.Contenedor_texto.setLayout(new GridLayout(6,1));
        for(int i = 0; i < 6; i++){
            Controlador.informacion[i].setHorizontalAlignment(JLabel.CENTER);
            this.Contenedor_texto.add(Controlador.informacion[i]);
        }
        controles.informe(Controlador.informacion);
    }
    
    public void Iniciar_Aliado() {
        this.mar_aliado = new Barcos[15][15];
        this.aliados = new PanelFondo();
        this.aliados.setLayout(new GridLayout(15,15));
        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){
                mar_aliado[i][j] = new Barcos(i, j);
                controles.PonerBarcos(this.mar_aliado, this.mar_enemigo, i, j);
                this.aliados.add(mar_aliado[i][j]);
            }
        }
        
    }
    
    public void Iniciar_Enemigo() {
        this.mar_enemigo = new Barcos[15][15];
        this.enemigos = new PanelFondo();
        this.enemigos.setLayout(new GridLayout(15,15));
        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){
                mar_enemigo[i][j] = new Barcos(i, j);
                controles.DispararaEnemigos(this.mar_aliado, this.mar_enemigo, i, j);
                this.enemigos.add(mar_enemigo[i][j]);
            }
        }
    }
    
    
}
