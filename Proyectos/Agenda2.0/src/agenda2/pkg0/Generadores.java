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

    
    /**
     * Este método verifica que el archivo haya sido creado con una arraylist 
     * en el previniendo errores por la inexistencia del archivo sobre el cual
     * se trabajará
     * @param a archivo principal
     * @throws IOException 
     */
    public static void verificar(File a)
    		throws IOException{

        ArrayList<Contacto> arreglo = new ArrayList<>();

        if(!a.exists()){

            escritura(a, arreglo);

        }
    }
    
    
    /**
     * Este método extrae el arraylist de el archivo.
     * @param a archivo principal
     * @return
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static ArrayList<Contacto> extraer(File a)
    		throws ClassNotFoundException, IOException{

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
    
    
    /**
     * Este método reescribe el arraylist sobre el archivo.
     * @param a archivo principal
     * @param v arraylist principal
     * @throws IOException 
     */
    public static void escritura(File a, ArrayList<Contacto> v)
    		throws  IOException{

        FileOutputStream fos = new FileOutputStream(a);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(v);
        oos.close();

    }
    
    
    /**
     * Este método extrae el arraylist del archivo le añade un nuevo
     * objeto(insercion) y finalmente lo reescribe sobre el archivo.
     * @param a archivo principal
     * @param insercion objeto que se desea insertar
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void agregar(File a, Contacto insercion)
    		throws ClassNotFoundException, IOException {

       ArrayList<Contacto> v;
       verificar(a);
        v = extraer(a);
        v.add(insercion);

        escritura(a, v);

    }
    
    
    /**
     * Este método extrae el arraylist del archivo le elimina un elemento
     * (el que este en la posicion index) y finalment lo reescribe.
     * @param a archivo principal
     * @param index indice de posición del elemento que se desea eliminar
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void eliminar(File a,int index)
    		throws ClassNotFoundException, IOException{

        ArrayList<Contacto> v;
        verificar(a);
        v = extraer(a);

        System.out.println("el elemento que se elimino fue: "
                +v.remove(index).toString());

        escritura(a, v);

    }
    
    
    /**
     * Este método retorna el indice de un contacto relacionado a un telefono
     * en especifico en caso de que exista, de lo contrario se retornará -1
     * indicando que el telefono no se encontró.
     * @param a archivo principal
     * @param telefono telefono al cual se le hará la busqueda
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static int buscar_numero(File a, String telefono)
    		throws ClassNotFoundException, IOException{
        
        verificar(a);
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
    
    
    /**
     * Este método retorna el indice de un telefono buscado en un sub arraylist
     * dentro de el objeto, en caso de que no exista dicho telefono se retornara
     * -1 indicando que no se encontró.
     * @param telf sub-arraylist sobre la cual se hará la busqueda
     * @param telefono telefono al cual se le hará la busqueda
     * @return 
     */
    public static int buscar_numero_local(ArrayList<String> telf
    		,String telefono){

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

    
    /**
     * Este método muestra los contactos registrados hasta el momento en el archivo
     * se pueden listar los contactos ya sea por nombre, alias, direccion o
     * correo electrónico.<p>
     * Si se realiza la busqueda por telefono solo se mostrará el contacto
     * relacionado a ese número telefónico.
     * @param a archivo principal
     * @param consulta valor con el cual se hará la busqueda
     * @param tipo opcion de listado
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void listar(File a,String consulta,int tipo)
    		throws ClassNotFoundException, IOException{
        
        verificar(a);
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

                }else{

                    System.out.println("Contacto encontrado");
                    System.out.println(v.get(index).toString());

                }

                break;

            case 6:

                System.out.println("Contactos actuales");

                for(int i = 0; i<v.size();i++){

                    System.out.println(v.get(i).toString());

                }
                break;

            default:

                System.out.println("Contactos encontrados");

                for(int i = 0; i<v.size();i++){

                    temporal = v.get(i);

                    switch(tipo){

                        case 1:

                        	temporalstr = temporal.nombre;

                        	break;

                        case 2:

                        	temporalstr = temporal.alias;

                        	break;

                        case 3:

                        	temporalstr = temporal.direccion;

                        	break;

                        case 4:

                        	temporalstr = temporal.correo;

                        	break;

                        default:

                        	System.out.println("opcion no disponible");

                        	break;
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
    

    /**
     * Este método se encarga de dividir y traducir en subcadenas el texto
     * generado al exportar los contactos, que se encuentran en un bloque de
     * texto delimitado por corchetes "[]" y se divide internamente con comas
     * y un espacio seguido ", " y agregar estas subcadenas como elementos de la
     * sub-arraylist(contacto.telefono).<p>
     * Este metodo solo se encarga de traducir el artibuto "telefono", para el
     * resto de atributos esta el metodo "reconContacto".
     * @see Generadores.reconContacto
     * @param importarray array desde la cual se van a importar los telefonos
     * @return 
     */
    public static  ArrayList<String> reconTelf(String importarray){
                
        ArrayList<String> telefonos = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        int i ;

        index.add(0);

        for(i = 0; i< importarray.length(); i++){

            if(importarray.charAt(i) == ','){

                index.add(i);

            }

        }
        
        for(i = 0; i<index.size(); i++){

            if(i == 0 && index.size()>1){

                telefonos.add(importarray.substring(index.get(0)
                		,index.get(1)));

            }else if(i == 0 && index.size()==1){

                telefonos.add(importarray.substring(index.get(0)));

            }else if(i == index.size()-1){

                telefonos.add(importarray.substring(index.get(i)+2));

            }else{

                telefonos.add(importarray.substring(index.get(i)+2
                		,index.get(i+1)));

            }

        }

        return telefonos;

    }
    
    
    /**
     * Este método se encarga de dividir y traducir en subcadenas el texto
     * generado al exportar los contactos, que se encuentran se divididas con 
     * punto y coma ";" y agregar estas subcadenas como atributos de el 
     * objeto(contatco).<p> 
     * Este método solo reconoce los campos "nombre", "alias", "direccion"
     * y "correo" directamente, para la traduccion del campo "telefono" se usa
     * la funcion reconTelf.
     * @see Generadores.reconTelf
     * @param importline lineal de texto desde la cual se traduciran los datos
     * @return 
     */
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

        importado.alias = importline.substring(indices[0]+1
        		, indices[1]);

        importado.direccion = importline.substring(indices[2]+1
        		,indices[3]);

        importado.correo = importline.substring(indices[3]+1);

        if((indices[1]+1)-(indices[2])!=-1){

            importado.telefono = reconTelf(importline.substring(indices[1]+2
            		,indices[2]-1));

        }else{

            importado.telefono = new ArrayList<>();

        }

        return importado;

    }
    
    
    /**
     * Este método se encarga de traducir y agregar uno a uno los contactos previamente
     * exportados y reintegrarlos al archivo principal, si algún contacto a importar
     * posee un numero telefónico relacionado a un contacto que ya se encuentre
     * en el archivo, este será omitidio.<p>
     * Este método no reescribe los contactos que se encuentren actualmente en
     * el archivo, solo agrega los presentes en el archivo exportado.
     * @see Generadores.reconContacto
     * @see Generadores.reconTelf
     * @param a archivo principal
     * @param importadopath archivo desde el cual se van a importar los contactos
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void importar(File a,String importadopath)
    		throws ClassNotFoundException, IOException{

        verificar(a);
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

	                       System.out.println("el contacto a importar contiene un numero"
	                               +" telefonico ya relacionado a otro contacto");
                           condicion = false;

                           break;

                       }

                   }

        
                   if(condicion){

                       agregar(a, temporal);

                   }

                }

            }catch(IOException | ClassNotFoundException e){

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
    
    
    /**
     * Este método se encarga de llevar a un archivo de texto plano, la información
     * de los contactos almacenada hasta el momento en el archivo.<p>
     * Los contactos en texto plano tendrán el siguiente formato:
     * Nombre;Alias;[111, 222, ...];Direccion;Correo_electrónico<p>
     * @see Contacto.toExport
     * @param a archivo principal
     * @param exportpath archivo sobre el cual se va a exportar
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void exportar(File a,String exportpath)
    		throws ClassNotFoundException, IOException{
        
        verificar(a);
        FileWriter fichero = null;
        PrintWriter pw = null;
        ArrayList<Contacto> v = extraer(a);

        try{

            fichero = new FileWriter(exportpath);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < v.size(); i++){

                pw.println(v.get(i).toExport());

            }

        } catch (IOException e) {

        } finally {

            try {

                if (null != fichero){

                   fichero.close();

                }

            } catch (IOException e2) {

            }

        }

    }
    
    
    /**
     *Este método permite modificar total o parcialmente un elemento, o en caso
     * de que el usuario lo desee también puede eliminar un contacto, se buscara
     * el contacto a modificar estrictamente mediante el telefono del mismo.
     * @param a archivo principal
     * @param tipo numero de la opcion seleccionada
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void modificar(File a, int tipo)
    		throws ClassNotFoundException, IOException{
        
        verificar(a);
        Scanner l = new Scanner(System.in);
        String temporal = null;
        String busqueda = null;
        ArrayList<Contacto> v = extraer(a);
        int op;

        if(tipo == 7){

            System.out.println("ingrese el numero del contacto que desea eliminar");

        }else{

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

                case 1:

                	v.get(index).setNombre(temporal);

                	break;

                case 2:

                	v.get(index).setAlias(temporal);

                	break;

                case 3:

                	v.get(index).setDireccion(temporal);

                	break;

                case 4:

                	v.get(index).setCorreo(temporal);

                	break;

                case 5:

                    System.out.println("Agregar numeros: 1\nReemplazar un numero: 2");
                    op = l.nextInt();

                    switch(op){
                        case 1:

                        	v.get(index).setTelefono(verificar_telefonos(a
                        			,v.get(index)));

                        	break;

                        case 2:

                            System.out.println("ingrese el numero que desea cambiar");
                            l.nextLine();
                            temporal = l.nextLine();
                            int sub = buscar_numero_local(v.get(index).telefono, temporal);

                            if(sub>=0){

                                v.get(index).telefono.remove(sub);
                                System.out.println("capturando el nuevo numero");
                                v.get(index).setTelefono(verificar_telefonos(a,v.get(index)));

                            }else{

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
            
            verificar(a);
            escritura(a, v);

        }else{

            System.out.println("el contacto no se encontro");

        }

    }
    
    
    /**
     *Este método se encarga de registrar los números telefónicos de un contacto
     * teniendo en cuenta si se repiten o no, se puede guardar una cantidad
     * indefinida de números telefonicos siempre y cuando sean diferentes.<p>
     * tambien permite modificar los números telefonicos de un contacto.
     * @param a archivo principal
     * @param insercion elemento el cual se va a registrar y verificar
     * @return
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static ArrayList<String> verificar_telefonos(File a, Contacto insercion)
    		throws ClassNotFoundException, IOException{

        boolean condicion = true;
        String temp;
        Scanner l = new Scanner(System.in);

        while (condicion){

            System.out.println("ingrese un numero telefonico valido");
            temp = l.nextLine();

            if(buscar_numero(a, temp) == -1){

                condicion = insercion.Pedirtelefonos(temp);

                if(!condicion){

                    System.out.println("desea ingresar otro numero telefonico?\nsi: true\tno: false");
                    condicion = l.nextBoolean();

                }

            }else{

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
    
    
    /**
     * Este método se encarga de pedir en conjunto todos los datos de un contacto
     * y agregar dicho contacto al archivo
     * @param a archivo principal
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void crearcontacto(File a)
    		throws ClassNotFoundException, IOException{

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
        
        verificar(a);
        agregar(a, insercion);

    }
    

    /**
     * Este método muestra el menú principal y lee un número que representa la
     * operacion que se desea realizar.
     * @return 
     */
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
    
    
    /**
     * Este método usa el conjunto de los métodos anteriores y genera una agenda
     * funcional, permitiendo agregar, eliminar, modificar, exportar, importar
     * y listar los contactos almacenados en un archivo el cual se actualiza con
     * cada acción.
     * @param a archivo principal
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void menu(File a)
    		throws ClassNotFoundException, IOException{

        verificar(a);

        int tipo = 0,op = 0;
        String consulta = "";
        Scanner l = new Scanner(System.in);
        boolean condicion = true;

        while (condicion) {
            
            op = mostrarmenu();
            verificar(a);
            
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

                    verificar(a);
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