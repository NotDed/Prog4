/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda2.pkg0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Contacto implements Serializable{
    protected String nombre;
    protected String alias;    
    protected ArrayList<String>telefono = new ArrayList<String>();
    protected String direccion;
    protected String correo;

    public Contacto() {
        this.nombre = "";
        this.alias = "";
        this.telefono = new ArrayList<>();
        this.direccion = "";
        this.correo = "";
    }

    public Contacto(String nombre, String alias, String direccion, String correo) {
        this.nombre = nombre;
        this.alias = alias;
        this.direccion = direccion;
        this.correo = correo;
    }
    
    public boolean Pedirtelefonos(String temp){
        boolean condicion = true;
        boolean digitos = true;
        for(int i=0; i<temp.length(); i++){
            if(!(Character.isDigit(temp.charAt(i)))){
                digitos = false;
                break;
            }
        }
        if(temp.length() == 10 && digitos){
            this.telefono.add(temp);
            return false;
        }
        else{
            System.out.println("NUMERO TELEFONICO INVALIDO");
            return true;
        }
    }

    public String getNombre(){return nombre;}
    public String getAlias(){return alias;}
    public ArrayList<String> getTelefono(){return telefono;}
    public String getDireccion(){return direccion;}
    public String getCorreo(){return correo;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setAlias(String alias){this.alias = alias;}
    public void setTelefono(ArrayList<String> telefono){this.telefono = telefono;}
    public void setDireccion(String direccion){this.direccion = direccion;}
    public void setCorreo(String correo){this.correo = correo;}

    @Override
    public String toString() {
        return "//////////////////////////////"
                + "\nnombre:\t\t" + nombre 
                + "\nalias:\t\t" + alias 
                + "\ntelefono:\t" + telefono 
                + "\ndireccion:\t" + direccion 
                + "\ncorreo:\t\t" + correo +'\n';
    }
    
    public String toExport(){
        return  nombre 
                + ';' + alias 
                + ';' + telefono 
                + ';' + direccion 
                + ';' + correo ;
    }
}
