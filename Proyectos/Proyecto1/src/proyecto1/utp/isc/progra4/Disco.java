/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto1.utp.isc.progra4;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Disco extends Multimedia {
    
    protected String genero;

    public Disco() {
    }  

    public Disco(String titulo, String autor) {
        super(titulo, autor);
    }
    
    
    
    public Disco(String genero, String titulo, String autor, String formato, int duracion) {
        super(titulo, autor, formato, duracion);
        this.genero = genero;
    }
    
    

    @Override
    public String toString() {
        return  "\n\ttitulo = " + titulo 
                + "\n\tautor = " + autor
                + "\n\tgenero = " + genero 
                + "\n\tformato = " + formato 
                + "\n\tduracion = " + duracion 
                + "segundos\n";
    } 
}
