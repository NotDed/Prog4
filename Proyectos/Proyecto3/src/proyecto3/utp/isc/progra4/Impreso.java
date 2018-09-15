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
public class Impreso {
    
    protected String codigo;
    protected String titulo;
    protected int año_publi;

    public Impreso(String codigo, String titulo, int año_publi) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.año_publi = año_publi;
    }

    @Override
    public String toString() {
        return  "codigo:\t" + codigo
                + "\ntitulo:\t" + titulo
                + "\na\u00f1o_publi:\t" + año_publi;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getAño_publi() {
        return año_publi;
    }
    
}
