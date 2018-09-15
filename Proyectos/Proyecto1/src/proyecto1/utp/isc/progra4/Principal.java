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
public class Principal {
    
    public static void main(String[] args) {
        Pelicula VanDamn = new Pelicula("van dame", true, "van dame", "capheus", "mp3", 36);
        Pelicula Dracula = new Pelicula("albert einstein", "marie curie", "dracula", "hans zimmer", "wav", 5000);
        Pelicula Titanic = new Pelicula("dicaprio", true, "Titanic", "albert einstein", "mp4", 8000);
        ListaMultimedia listaPeliculas = new ListaMultimedia(10);
        listaPeliculas.add(VanDamn);
        listaPeliculas.add(Dracula);
        listaPeliculas.add(Titanic);
        System.out.println(listaPeliculas.toString());
        //
        Disco Goodmorning_Restrained = new Disco("Goodmorning Restrained", "Magna Carta Cartel");
        ListaMultimedia listaDiscos= new ListaMultimedia(20);
        listaDiscos.add(Goodmorning_Restrained);
        System.out.println(listaDiscos.toString());
    }

}
