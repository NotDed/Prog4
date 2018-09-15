/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.utp.isc.progra4.seman4;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Clase1 {
    
    private static int num;
    private String nombre;
    
    public Clase1(){
        num++;
    }
    
    public Clase1(String nom){
        this();//ejecuar el constructor vacío
        nombre = nom;
    }
    
    public Clase1(int numero){
        this("");
        num += numero;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Clase1.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

}
