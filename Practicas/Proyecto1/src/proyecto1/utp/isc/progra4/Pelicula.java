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
public class Pelicula extends Multimedia {
    protected String actor_pricnipal;
    protected String actriz_principal;
    
    //constructores
    
    /**constructor de la clase pelicula el cual puede recibir un solo actor
     * <p>si el valor booleano de actor_o_actriz es true entonces se toma como que el valor de la variable actor
     * se asigna a actor_principal.
     * en caso contrario se asignara el valor de la variable actor a actriz_principal
     * </p>
     */
    public Pelicula(String actor, boolean  actor_o_actriz, String titulo, String autor, String formato, int duracion) {
        
        super(titulo, autor, formato, duracion);
        if(actor_o_actriz){
            this.actor_pricnipal = actor;
        }
        else{
            this.actriz_principal = actor;
        }
    }
    
    /**constructor de la clase pelicula el cual puede recibir todos los atributos de la clase peliculaper
     */    
    public Pelicula(String actor_pricnipal, String actriz_principal, String titulo, String autor, String formato, int duracion) {
        super(titulo, autor, formato, duracion);
        this.actor_pricnipal = actor_pricnipal;
        this.actriz_principal = actriz_principal;
    }

    public String getActor_pricnipal() {
        return actor_pricnipal;
    }

    public String getActriz_principal() {
        return actriz_principal;
    }
    
    
    
    @Override
    public String toString() {
        return  "\n\ttitulo = " + titulo 
                + "\n\tautor = " + autor
                + "\n\tactor pricnipal = " + actor_pricnipal 
                + "\n\tactriz principal = " + actriz_principal 
                + "\n\tformato = " + formato 
                + "\n\tduracion = " + duracion 
                + "segundos\n";
    }
    
    
    
}
