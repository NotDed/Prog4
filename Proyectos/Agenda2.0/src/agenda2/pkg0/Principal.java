/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda2.pkg0;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Principal extends Generadores{

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void main (String[] args) throws ClassNotFoundException, IOException{

        File a;
        a = new File("agenda2.txt");
	menu(a);       

    }

}