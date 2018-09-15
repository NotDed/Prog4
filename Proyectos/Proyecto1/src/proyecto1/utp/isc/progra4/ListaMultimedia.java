/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto1.utp.isc.progra4;
import java.util.ArrayList;


/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class ListaMultimedia {
    protected int id_actual;
    protected int id_maximo;
    protected ArrayList<Object> lista_multi = new ArrayList();

    public ListaMultimedia(int id_maximo) {
        this.id_actual = 0;
        this.id_maximo = id_maximo;
    }
    
    public boolean add(Object añadir){
        if(this.id_actual < this.id_maximo){
            if(lista_multi.add(añadir)){
                this.id_actual ++;
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    
    public int size(){
        return this.id_actual;
    }

    @Override
    public String toString() {
        return  "ListaMultimedia{"
                + "\nid_actual=" + id_actual
                + "\nid_maximo=" + id_maximo
                + "\nlista_multi=" + lista_multi + "\n}";
    }

    public Object getMultimedia(int i) {
        return lista_multi.get(i);
    }
}
