/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2.utp.isc.progra4;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class PruebaPila{
    
    public static void fill(Pila entrada){
        for(int i = 1; i <= 10 ; i++){
            entrada.añadir(i);
        }
    }
    
    public static void emptyprint(Pila entrada){
        while(!entrada.estaVacia()){
            System.out.println(entrada.extraer());
        }    
    }

}
