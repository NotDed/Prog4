package co.edu.utp.isc.progra4.seman4;

/**
 * 
 * @author Daniel Alejandro Serna Olarte
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        for(int i=0; i<args.length; i++){
            System.out.println(""+args[i]);
        }
        
        Clase1 cesar = new Clase1();
        cesar.setNombre("daniel");
        
        System.out.println("cesar.nombre: "+cesar.getNombre());
        System.out.println("cesar.num: "+cesar.getNum());
        
        Clase1 augusto = new Clase1("puto");
        //augusto.nombre="augusto";
        
        System.out.println("augusto.nombre: "+augusto.getNombre());
        System.out.println("augusto.num: "+augusto.getNum());
        
        System.out.println("num "+Clase1.getNum());
        
        Clase1 andres = new Clase1(25);
        andres.setNombre("andres");
        System.out.println("andres.nombre: "+andres.getNombre());
        System.out.println("andres.num: "+andres.getNum());
        //cualquier atributo estatico es unico para todos los objetos
        //todo constructor es exclusivo y un objeto solo ejecuta el constructor indicado
        
    }

}
