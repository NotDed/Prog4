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
public class Principal extends Gestion{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GneralPublicaciones jarri_poter = new GneralPublicaciones("asdd111", "jarri poter y la orden del fenis", 1990);
        GneralPublicaciones The_prince = new GneralPublicaciones("asdd112", "the prince", 1532);
        GneralPublicaciones Semanal = new GneralPublicaciones(25, "asdd113", "semanal #25", 1989);
        GneralPublicaciones Anual = new GneralPublicaciones(1,"asdd114", "Year Zero",500);
        jarri_poter.prestar();
        GneralPublicaciones biblio[] = {jarri_poter,The_prince,Semanal,Anual};
        Gestion.printarr(biblio);
        System.out.println("Número de libros con fecha de publicacion anterior a 1990: " + Gestion.AnterioresA(biblio, 1990));
        System.out.println("Número de libros Prestados: " + Gestion.cuenta_prestado(biblio));        
    }
    
}
