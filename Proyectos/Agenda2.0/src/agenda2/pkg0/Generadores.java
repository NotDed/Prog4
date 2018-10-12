/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda2.pkg0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Generadores {
    
    public static void verificar(File a) throws IOException{
        ArrayList<Contacto> arreglo = new ArrayList<>();
        if(!a.exists()){
            escritura(a, arreglo);
        }
    }
    
    public static ArrayList<Contacto> extraer(File a) throws ClassNotFoundException, IOException{
        ObjectInputStream ois = null;
        ArrayList<Contacto> v = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(a);
            ois = new ObjectInputStream(fis);
            v = (ArrayList<Contacto>)ois.readObject();
        } catch (IOException e) {
            System.out.println("error");
        }finally{
            ois.close();
        }
        return v;
    } 
    
    
    public static void escritura(File a, ArrayList<Contacto> v)throws  IOException{
        FileOutputStream fos = new FileOutputStream(a);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(v);
        oos.close();
    }
    
    
    public static void agregar(File a, Contacto insercion) throws ClassNotFoundException, IOException {
       ArrayList<Contacto> v;
        v = extraer(a);
        v.add(insercion);
        escritura(a, v);
    }
    
    public static void eliminar(File a,int index) throws ClassNotFoundException, IOException{
        ArrayList<Contacto> v;
        v = extraer(a);
        System.out.println("el elemento que se elimino fue: "+v.remove(index).toString());
        escritura(a, v);
    }
    
    public static int buscar_numero(File a, String telefono) throws ClassNotFoundException, IOException{
        ArrayList<Contacto> v = extraer(a);
        Contacto temporal;
        boolean found = false;
        for(int i = 0; i < v.size();i++){
            temporal = v.get(i);
            for(String tempo : temporal.telefono){
                if(tempo.compareTo(telefono) == 0){
                    found = true;
                    break;
                }
            }
            if(found){
                return i;
            }
        }
        return -1;
    }
    
    public static int buscar_numero_local(ArrayList<String> telf,String telefono) {
        boolean found = false;
        int i;
        for(i = 0; i<telf.size(); i++){
            if(telf.get(i).compareTo(telefono) == 0){
                    found = true;
                    break;
                }
        }
        if(found){
            return i;
        }
        else{
            return -1;
        }
    }
    
    public static void listar(File a,String consulta,int tipo)throws ClassNotFoundException, IOException{
        ArrayList<Contacto> v = extraer(a);
        Contacto temporal;
        String temporalstr = null;
        boolean found = false;
        int index;
        switch (tipo) {
            case 5:
                index = buscar_numero(a, consulta);
                if(index<0){
                    System.out.println("no se encuentra ningun registro con este numero");
                }
                else{
                    System.out.println("Contacto encontrado");
                    System.out.println(v.get(index).toString());
                }    break;
            case 6:
                System.out.println("Contactos actuales");
                for(int i = 0; i<v.size();i++){
                    System.out.println(v.get(i).toString());
                }   break;   
            default:
                System.out.println("Contactos encontrados");
                for(int i = 0; i<v.size();i++){
                    temporal = v.get(i);
                    switch(tipo){
                        case 1:temporalstr = temporal.nombre; break;
                        case 2:temporalstr = temporal.alias; break;
                        case 3:temporalstr = temporal.direccion; break;
                        case 4:temporalstr = temporal.correo; break;
                        default:System.out.println("opcion no disponible");break;
                    }
                    if(consulta.compareTo(temporalstr) == 0){
                        System.out.println(temporal.toString());
                        found = true;
                    }
                }
                if(!found){
                    System.out.println("no se encuentran registros");
                }
                break;
        }
    }
    
    public static  ArrayList<String> reconTelf(String importarray){
        ArrayList<String> telefonos = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        index.add(0);
        int i ;
        for(i = 0; i< importarray.length(); i++){
            if(importarray.charAt(i) == ','){
                index.add(i);
            }  
        }
        
        for(i = 0; i<index.size(); i++){
            if(i == 0 && index.size()>1){
                telefonos.add(importarray.substring(index.get(0),index.get(1)));
            }
            else if(i == 0 && index.size()==1){
                telefonos.add(importarray.substring(index.get(0)));
            }
            else if(i == index.size()-1){
                telefonos.add(importarray.substring(index.get(i)+2));
            }
            else{
                telefonos.add(importarray.substring(index.get(i)+2,index.get(i+1)));
            }
        }
        return telefonos;
    }
    
    public static Contacto reconContacto(String importline){
        int[] indices = new int[4];
        Contacto importado = new Contacto();
        int subi=0;
        for(int i = 0; i< importline.length(); i++){
            if(importline.charAt(i) == ';'){
                indices[subi]=i;
                subi++;
            }
            
        }
        importado.nombre = importline.substring(0, indices[0]);
        importado.alias = importline.substring(indices[0]+1, indices[1]);
        importado.direccion = importline.substring(indices[2]+1,indices[3]);
        importado.correo = importline.substring(indices[3]+1);
        if((indices[1]+1)-(indices[2])!=-1){
            importado.telefono = reconTelf(importline.substring(indices[1]+2,indices[2]-1));
        }
        else{
            importado.telefono = new ArrayList<>();
        }
        return importado;
    }
    public static void importar(File a,String importadopath) throws ClassNotFoundException, IOException {
        File importado = new File(importadopath);
        FileReader fr = null;
        BufferedReader br = null;
        boolean condicion = true;
        ArrayList<Contacto> v = extraer(a);
        if(importado.exists()){
            try {
                Contacto temporal;
                fr = new FileReader (importado);
                br = new BufferedReader(fr);
                String importline;
                while((importline=br.readLine())!=null){
                   temporal = reconContacto(importline);
                   for(String tmp: temporal.telefono){
                       if(buscar_numero(a, tmp)>=0){
                           System.out.println("el contacto a importar contiene un numero telefonico ya relacionado a otro contacto");
                           condicion = false;
                           break;
                       }
                   }
                   if(condicion){
                       agregar(a, temporal);
                   }                   
                }
            }
            catch(IOException | ClassNotFoundException e){
            }finally{
                try{
                    if( null != fr ){   
                       fr.close();     
                    }                  
                }catch (IOException e2){ 
                }
            }
        }
    }
    
    public static void exportar(File a,String exportpath) throws ClassNotFoundException, IOException{;
        FileWriter fichero = null;
        PrintWriter pw = null;
        ArrayList<Contacto> v = extraer(a);
        try
        {
            fichero = new FileWriter(exportpath);
            pw = new PrintWriter(fichero);
            for (int i = 0; i < v.size(); i++)
                pw.println(v.get(i).toExport());

        } catch (IOException e) {
        } finally {
            try {
                if (null != fichero)
                   fichero.close();
            } catch (IOException e2) {
            }
        }
    }
    
    public static void modificar(File a, int tipo) throws ClassNotFoundException, IOException{
        Scanner l = new Scanner(System.in);
        Contacto modificar;
        String temporal = null;
        String busqueda = null;
        int op;
        ArrayList<Contacto> v = extraer(a);
        if(tipo == 7){
            System.out.println("ingrese el numero del contacto que desea eliminar");
        }
        else{
            System.out.println("ingrese el numero del contacto que desea modificar");
        }
        busqueda = l.nextLine();
        int index = buscar_numero(a, busqueda);
        if(index != -1){
            if(tipo != 5 && tipo != 6 && tipo != 7){
                System.out.println("ingrese el elemento por el cual quiere reemplazar");
                temporal = l.nextLine();
            }
            switch(tipo){
                case 1:v.get(index).setNombre(temporal);break;
                case 2:v.get(index).setAlias(temporal); break;
                case 3:v.get(index).setDireccion(temporal);break;
                case 4:v.get(index).setCorreo(temporal);break;
                case 5:
                    System.out.println("Agregar numeros: 1\nReemplazar un numero: 2");
                    op = l.nextInt();
                    switch(op){
                        case 1: v.get(index).setTelefono(verificar_telefonos(a, v.get(index))); break;
                        case 2: 
                            System.out.println("ingrese el numero que desea cambiar");
                            l.nextLine();
                            temporal = l.nextLine();
                            int sub = buscar_numero_local(v.get(index).telefono, temporal);
                            if(sub>=0){
                                v.get(index).telefono.remove(sub);
                                System.out.println("capturando el nuevo numero");
                                v.get(index).setTelefono(verificar_telefonos(a, v.get(index)));
                            }
                            else{
                                System.out.println("el elemento no se encontro");
                            }
                            break;
                        default:
                            System.out.println("opcion no disponible");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("ingrese el nuevo nombre");
                    v.get(index).setNombre(l.nextLine());
                    System.out.println("ingrese el nuevo alias");
                    v.get(index).setAlias(l.nextLine());
                    System.out.println("ingrese la nueva direccion");
                    v.get(index).setDireccion(l.nextLine());
                    System.out.println("ingrse el nuevo correo electronico");
                    v.get(index).setCorreo(l.nextLine());
                    v.get(index).telefono = new ArrayList<>();
                    v.get(index).setTelefono(verificar_telefonos(a,v.get(index)));
                    break;
                case 7:
                    System.out.println("el elemento que se elimino fue:\n" + v.remove(index).toString());
                    break;
                default:
                    System.out.println("opcion no disponible");
                    break;
            }
            escritura(a, v);
        }
        else{
            System.out.println("el contacto no se encontro");
        }
    }
    
    public static ArrayList<String> verificar_telefonos(File a, Contacto insercion) throws ClassNotFoundException, IOException{
        boolean condicion = true;
        String temp;
        Scanner l = new Scanner(System.in);
        while (condicion) { 
            System.out.println("ingrese un numero telefonico valido");
            temp = l.nextLine();
            if(buscar_numero(a, temp) == -1){
                condicion = insercion.Pedirtelefonos(temp);
                if(!condicion){
                    System.out.println("desea ingresar otro numero telefonico?\nsi: true\tno: false");
                    condicion = l.nextBoolean();
                }
            }
            else{
                System.out.println("EL NUMERO YA ESTA ASOCIADO A OTRO CONTACTO");
                if(insercion.telefono.size()>0){
                    System.out.println("Desea no modificar mas los telefonos del contacto?\nsi: true\tno: false");
                    if(l.nextBoolean()){
                        break;
                    }
                }
            }
        }
        return insercion.telefono;
    }
    
    public static void crearcontacto(File a) throws ClassNotFoundException, IOException{
        Scanner l = new Scanner(System.in);
        boolean condicion = true;
        String temp;
        Contacto insercion = new Contacto();
        System.out.println("ingrese el nombre de contacto");
        insercion.setNombre(l.nextLine());
        System.out.println("ingrese el alias de contacto");
        insercion.setAlias(l.nextLine());
        System.out.println("ingrese la direccion del contacto");
        insercion.setDireccion(l.nextLine());
        System.out.println("ingrse el correo electronico de contacto");
        insercion.setCorreo(l.nextLine());
        insercion.telefono = new ArrayList<>();
        System.out.println("EL CAMPO DE TELEFONOS ES OBLIGATORIO Y NO PUEDE ESTAR REPETIDO");
        insercion.setTelefono(verificar_telefonos(a, insercion));
        agregar(a, insercion);
    }
    
    public static int mostrarmenu(){
        System.out.println("AGENDA 2.0 (la 1.0 se fue con mis ganas de vivir)");
        System.out.println("\tMENU");
        System.out.println("1.CREAR NUEVO CONTACTO");
        System.out.println("2.BUSCAR CONTACTOS");
        System.out.println("3.MODIFICAR CONTACTOS");
        System.out.println("4.ELIMINAR CONTACTO");
        System.out.println("5.EXPORTAR CONTACTOS");
        System.out.println("6.IMPORTAR CONTACTOS");
        System.out.println("7.SALIR");
        System.out.println("ingrese una opcion");
        Scanner l = new Scanner(System.in);
        return l.nextInt();
    }
    
    public static void menu(File a) throws ClassNotFoundException, IOException{
        verificar(a);
        int tipo = 0,op = 0;
        String consulta = "";
        Scanner l = new Scanner(System.in);
        boolean condicion = true;
        while (condicion) {
            op = mostrarmenu();
            switch(op){
                case 1:
                    System.out.println("\tCREAR NUEVO CONTACTO");
                    crearcontacto(a);
                    break;
                case 2:
                    System.out.println("\tLISTAR POR:\n1.nombre\n2.alias\n3.direccion\n4.correo\n5.telefono\n6.mostrar todos los contactos".toUpperCase());
                    System.out.println("ingrese una opcion:");
                    tipo = l.nextInt();
                    l.nextLine();
                    listar(a, consulta, tipo);
                    break;
                case 3: 
                    System.out.println("\tOPCIONES PARA MODIFICAR\n1.nombre\n2.alias\n3.direccion\n4.correo\n5.telefono\n6.modificar por completo un contactos".toUpperCase());
                    System.out.println("ingrese una opcion:");
                    tipo = l.nextInt();
                    l.nextLine();
                    modificar(a, tipo);
                    break;
                case 4:
                    System.out.println("\tELIMINAR UN CONTACTO");
                    modificar(a, 7);
                    break;
                case 5:
                    System.out.println("\tEXPORTAR CONTACTOS");
                    System.out.println("ingrese el path del archivo al cual quiere exportar:");
                    consulta = l.nextLine();
                    exportar(a, consulta);
                    break;
                case 6:
                    System.out.println("\tIMPORTAR CONTACTOS");
                    System.out.println("ingrese el path de el archivo que quiere importar:");
                    consulta = l.nextLine();
                    importar(a, consulta);
                    break;
                case 7:
                    System.out.println("\tADIOS.");
                    condicion = false;
                    break;
            }            
        }
    }
}
