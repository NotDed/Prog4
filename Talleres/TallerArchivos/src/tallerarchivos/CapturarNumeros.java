/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tallerarchivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class CapturarNumeros {

    public static void Ingresar(String path){
        try{
            File archivo = new File(path);
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner reader = new Scanner(System.in);
            String numero;
            for(int i=0; i < 10; i++){
                System.out.println("ingrese un numero: ");
                numero = reader.next();
                bw.write(numero);
                bw.newLine();
            }
            bw.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static double Promediar(String path) {
        int total = 0, contador=0;
        try{
            File archivo = new File(path);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String cadena;
            
            while((cadena = br.readLine())!=null){
                total += Integer.parseInt(cadena);
                System.out.println(total);
                contador++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total/contador;
    }
    
}
