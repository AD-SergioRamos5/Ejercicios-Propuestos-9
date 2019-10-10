
package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejercicio1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fichero = new File("./datos/personas.dat");
        FileOutputStream ficheroSalida = new FileOutputStream(fichero);
        ObjectOutputStream ficheroObjeto = new ObjectOutputStream(ficheroSalida);
        
        Persona p;
        p = new Persona("Sergio", "sergioRamos@gmail.com","1997");
        ficheroObjeto.writeObject(p);
        p = new Persona("Paula", "paulaValero@gmail.com","1997");
        ficheroObjeto.writeObject(p);
        
        ficheroObjeto.close();
    }
    
}
