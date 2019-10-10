
package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio2 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File fichero = new File("./datos/personas.dat");
        FileOutputStream ficheroSalida = new FileOutputStream(fichero);
        ObjectOutputStream ficheroObjeto = new ObjectOutputStream(ficheroSalida);
        
        Persona p;
        p = new Persona("Sergio", "sergioRamos@gmail.com","1997");
        ficheroObjeto.writeObject(p);
        p = new Persona("Paula", "paulaValero@gmail.com","1997");
        ficheroObjeto.writeObject(p);
        
        ficheroObjeto.close();
       
        FileInputStream ficheroEntrada = new FileInputStream(fichero);
        ObjectInputStream ficheroObjeto2 = new ObjectInputStream(ficheroEntrada);
        
        while (ficheroEntrada.available() > 0) {
            p = (Persona)ficheroObjeto2.readObject();
            System.out.println(p.toString());
        }
    }
    
}
