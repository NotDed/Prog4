/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto1.utp.isc.progra4;

import java.util.Objects;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Multimedia {
    
    protected String titulo;
    protected String autor;
    protected String formato;
    protected int duracion;
    
    //constructores
    public Multimedia() {
        this.titulo = "";
        this.autor = "";
        this.formato = "";
        this.duracion = 0;
    }
        
    public Multimedia(String titulo, String autor, String formato, int duracion) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.duracion = duracion;
    }

    public Multimedia(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    

    @Override
    public String toString() {
        return  "Multimedia{" 
                + "\ntitulo = " + titulo 
                + "\nautor = " + autor 
                + "\nformato = " + formato 
                + "\nduracion = " + duracion 
                + "\nsegundos\n}";
    }
    
    public boolean equals(Multimedia a){
        if(Objects.equals(a.autor, a.titulo)){
            System.out.println("si");
            return true;
        }
        else{
            System.out.println("no");
            return false;
        }
    }
    
    

}
