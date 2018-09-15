/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2.utp.isc.progra4;
import java.util.ArrayList;
/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Pila implements ColeccionInterface{
    ArrayList<Object> pila = new ArrayList();
    protected static int Contenidos = 0;

    public Pila() {
    }

    @Override
    public boolean estaVacia() {
        return pila.isEmpty();
    }

    @Override
    public Object extraer() {
        return pila.remove(0);
    }

    @Override
    public Object primero() {
        return pila.get(0);
    }

    @Override
    public boolean añadir(Object i) {
        return pila.add(i);
    }

    @Override
    public String toString() {
        return "Pila{" + "pila=" + pila + '}';
    }
    
}
