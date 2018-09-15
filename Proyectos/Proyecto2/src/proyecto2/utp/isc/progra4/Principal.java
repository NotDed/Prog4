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
public class Principal{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila stackP = new Pila();
        PruebaPila.fill(stackP);
        PruebaPila.emptyprint(stackP);
        System.out.println(stackP.estaVacia());        
    }
    
}
