/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2.utp.isc.progra4;

import java.util.LinkedList;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Cola implements ColeccionInterface{
    
    LinkedList<Object> queue;

    public Cola(){
        queue = new LinkedList<>();
    }
    @Override
    public boolean estaVacia() {
        return queue.isEmpty();
    }
    @Override
    public Object extraer() {
        Object remove = queue.removeFirst();
        return remove;
    }
    @Override
    public Object primero() {
        return queue.getFirst();
    }
    @Override
    public boolean añadir(Object i) {
        queue.addLast(i);
        return true;
    }
}
