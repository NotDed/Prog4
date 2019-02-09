/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto3.utp.isc.progra4;

import java.net.ContentHandlerFactory;
import java.util.ArrayList;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Gestion{
    
    public static int cuenta_prestado(GneralPublicaciones impresos[]){
        int contador = 0;
        for(int i = 0; i < impresos.length; i++){
            if(impresos[i].prestado){
                contador++;
            }
        }
        return contador;
    }
    
    public static int AnterioresA(GneralPublicaciones impresos[], int año){
        int contador = 0;        
        for(int i = 0; i < impresos.length; i++){
            if(impresos[i].año_publi < año){
                contador++;
            }
        }        
        return contador;
    }
    
    public static void printarr(GneralPublicaciones impresos[]){
        for(int i = 0; i < impresos.length; i++){
            System.out.println(impresos[i].toString());
        }        
    }
}
