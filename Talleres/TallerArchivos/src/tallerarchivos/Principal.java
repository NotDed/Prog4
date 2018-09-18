/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerarchivos;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Principal {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
public static void main(String[] args) throws ClassNotFoundException {
        //Ejercicio 1
        CapturarNumeros.Ingresar("texto.txt");
        //Ejercicio 2
        System.out.println("el promedio de los datos ingresados al archivo es de: "+CapturarNumeros.Promediar("texto.txt"));
        //Ejercicio 3
        AutoMovil A = null;
        Vector v = new Vector();
        Vector v2 = new Vector();
        int Cantidad, modelo;
        String marca, placa;
        Scanner reader = new Scanner(System.in);
        try{
            File Archivo = new File("texto2.txt");
            FileOutputStream Fos = new FileOutputStream(Archivo);
            ObjectOutputStream Oss = new ObjectOutputStream(Fos);
            System.out.println("\ningrese cuantos vehiculos desea archivar:\n");
            Cantidad = Integer.parseInt(reader.next());
            for (int i = 0; i < Cantidad; i++) {
                System.out.println("ingrese la placa de el vehiculo:");
                placa = reader.next();
                System.out.println("ingrese el modelo de el vehiculo:");
                modelo = reader.nextInt();
                System.out.println("ingrese la marca de el vehiculo:");
                marca = reader.next();
                A = new AutoMovil(marca, modelo, placa);
                v.add(A);
            }
            Oss.writeObject(A);
            Fos.close();
            Oss.close();
            System.out.println("\nLos datos que ser archivaron fueron:");
            FileInputStream Fis = new FileInputStream(Archivo);
            ObjectInputStream Ois = new ObjectInputStream(Fis);
            Iterator iterator = v.iterator();
            while(iterator.hasNext()){
                A=(AutoMovil)iterator.next();
                System.out.println(A.toString());
            }
            Fis.close();
            //Ois.close();
                    
        }catch (FileNotFoundException e) {
            e.printStackTrace();            
        }catch (IOException e){
            e.printStackTrace();
        }         
    }
    
}
