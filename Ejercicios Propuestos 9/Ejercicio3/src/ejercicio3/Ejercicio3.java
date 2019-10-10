
package ejercicio3;

import com.sun.java.accessibility.util.EventID;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    //Leer y meter los datos del fichero en una lista. Despues añadir todos al fichero nuevo y añadir la nueva.
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Scanner entrada = new Scanner(System.in);        
        
        System.out.print("Introduce el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Introduce el E-mail: ");
        String email = entrada.nextLine();
        System.out.print("Introduce el año de nacimiento: ");
        String year = entrada.nextLine();
        
        File fichero = new File("E:/2 DAM/AD/Tema 2/Ejercicios Propuestos 9/Ejercicio3/datos/personas.dat");
        if(!fichero.exists())
            fichero.createNewFile();
        
        Persona p;
        ArrayList<Persona> per = new ArrayList<>();
            
        if(fichero.length() != 0)
        {
            FileInputStream ficheroEntrada = new FileInputStream(fichero);
            ObjectInputStream ficheroObjeto2 = new ObjectInputStream(ficheroEntrada);
            

            while (ficheroEntrada.available() > 0) {
                p = (Persona)ficheroObjeto2.readObject();
                per.add(p);            
            }
            ficheroObjeto2.close();
        }
            

        FileOutputStream ficheroSalida = new FileOutputStream(fichero);
        ObjectOutputStream ficheroObjeto = new ObjectOutputStream(ficheroSalida);      
        
        per.add(new Persona(nombre,email,year));
        
        for(Persona p1 : per)
        {
            ficheroObjeto.writeObject(p1);
        }
        
        ficheroObjeto.close();   
    }
}
