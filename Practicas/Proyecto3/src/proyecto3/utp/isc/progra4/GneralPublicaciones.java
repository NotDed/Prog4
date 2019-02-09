/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto3.utp.isc.progra4;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class GneralPublicaciones extends Impreso implements Prestable{

    protected int numero;
    protected boolean prestado;

    public GneralPublicaciones(int numero, String codigo, String titulo, int año_publi) {
        super(codigo, titulo, año_publi);
        this.numero = numero;
    }

    public GneralPublicaciones(String codigo, String titulo, int año_publi) {
        super(codigo, titulo, año_publi);
        this.prestado = false;
        this.numero = -1;
    }

    @Override
    public void prestar() {
        this.prestado = true;
        
    }

    @Override
    public void devolver() {
        this.prestado = false;
        
    }

    public String prestado() {
        if(this.prestado){
            return "El libro ha sido prestado.";
        }
        else{
            return "El libro aun no ha sido prestado.";
        }
    }

    @Override
    public String toString() {
        if(this.numero >= 0){
           return  "\n\tRevista:\ncodigo:\t\t" + codigo
                + "\ntitulo:\t\t" + titulo
                + "\na\u00f1o_publi:\t" + año_publi
                + "\nnumero:\t\t" + numero + "\n"; 
        }
        else{
            return  "\n\tLibro\ncodigo:\t\t" + codigo
                + "\ntitulo:\t\t" + titulo
                + "\na\u00f1o_publi:\t" + año_publi + "\n"
                + this.prestado(); 
        }
        
    } 

}
