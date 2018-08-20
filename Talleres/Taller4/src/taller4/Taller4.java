/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller4;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Taller4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        parimpar(a);
        parimpar(b);
        System.out.println("el factorial de 5 es: "+factorial(5));
        System.out.println("el valor de la serie de fibonacci en la posicion 7 es: "+fibonacci(7));
        System.out.println(pot(2, 8));;
        primo(8);
        primo(7);
        hora(1000);
        cuadratica(32, 56, 16);
    }
    public static void parimpar(int a) {
        if(a%2==0){
            System.out.println(a+" es par");
        }
        else{
            System.out.println(a+" es impar");
        }
    }
    
    
    public static int factorial(int a) {
        if(a==0){
            return 1;
        }
        else{
            return a*=factorial(a-1);
        }
    }
    
    public static int fibonacci(int a){
        if(a>1){
            return fibonacci(a-1)+fibonacci(a-2);
        }
        else if(a==1){
            return 1;
        }
        else if(a==0){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    public static int pot(int a, int p){
        int i,t=1;
        for(i=0;i<p;i++){
            t*=a;
        }
        return t;
    }
    
    public static void primo(int a) {
        int i, conta=0;
        for(i=2; i<a; i++){
            if(a%i==0){
                conta++;
            }
        }
        if(conta!=0){
            System.out.println("El numero "+a+" no es primo");
        }
        else{
            System.out.println("El numero "+a+" es primo");
        }
        
    }
    
    public static void hora(int a){
        int semana, dias;
        semana = a/168;
        a-=semana*168;
        dias = a/24;
        a-=dias*24;
        System.out.println(semana+" Semanas,"+dias+" Dias,"+a+" Horas.");
    }
    
    public static void cuadratica(double a, double b, double c){
        double x1, x2;
        x1=((-b)+Math.sqrt(b*b-4*a*c))/(2*a);
        x2=((-b)-Math.sqrt(b*b-4*a*c))/(2*a);
        System.out.println("x= "+x1+" ó x="+x2);
    }
    
}
