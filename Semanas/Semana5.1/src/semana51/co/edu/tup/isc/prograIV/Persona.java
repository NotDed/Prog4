/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package semana51.co.edu.tup.isc.prograIV;

/**
 * 
 * @author Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
 */
public class Persona {
    
    public final char Hombre = 'H';
    public final char Mujer = 'M';
    
    public final int BAJO_PESO = -1;
    public final int IDEAL = 0;
    public final int SOBREPESO = 1;
    
    private String nombre = "";
    private int edad = 0;
    private long id;
    private char gen = 'H';
    private double peso = 0d;
    private double altura = 0d;

    public Persona() {
        
    }

    public Persona(String nombre, int edad, char gen) {
        this.nombre = nombre;
        this.edad = edad;
        this.gen = gen;
    }

    public Persona(String nombre, int edad, char gen, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.gen = gen;
        this.peso = peso;
        this.altura = altura;
    }
    
    public int CalcularIMC(){
        int imc = (int) (peso/Math.pow(altura, 2));
        if (imc < 20){
            return BAJO_PESO;
        }
        else if(imc >= 20 && imc <= 25){
            return  IDEAL;
        }
        else{
            return SOBREPESO;
        }
    }
    
    public boolean MayorDeEdad(){
        return edad >= 18;
    }
    
    public boolean VerifGen(int genero){
        return this.gen == genero;        
    }

    @Override
    public String toString() {
        return "Persona{"
                +", nombre=" + nombre
                +", edad=" + edad
                +", id=" + id
                +", gen=" + gen
                +", peso=" + peso
                +", altura=" + altura + '}';
    }
    
    private void generarID(){
        
    }
    
}
