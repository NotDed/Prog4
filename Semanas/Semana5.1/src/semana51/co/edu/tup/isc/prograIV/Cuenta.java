/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package semana51.co.edu.tup.isc.prograIV;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Cuenta {
       private String titular;
       private double cantidad;
       
       public Cuenta(String titular){
           this(titular,0d);
       }
       public Cuenta(String titular, double cantidad){
           this.titular = titular;
           this.cantidad = cantidad;
       }
       
       public void ingresar(double cantidad){
           this.cantidad += cantidad;
       }
       
       public void retirar(double cantidad){
           this.cantidad -= cantidad;
           if (this.cantidad <= 0){
               this.cantidad = 0 ;
           }
       }
}
