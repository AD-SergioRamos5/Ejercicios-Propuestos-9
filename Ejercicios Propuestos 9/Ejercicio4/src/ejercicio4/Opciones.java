
package ejercicio4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Opciones {
    public static void AddPersona() throws FileNotFoundException, IOException, ClassNotFoundException {
      Scanner entrada = new Scanner(System.in);        
        
        System.out.print("Introduce el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Introduce el E-mail: ");
        String email = entrada.nextLine();
        System.out.print("Introduce el año de nacimiento: ");
        String year = entrada.nextLine();
        
        File fichero = new File("E:/2 DAM/AD/Tema 2/Ejercicios Propuestos 9/Ejercicio4/datos/personas.dat");
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
   
   public static void BuscaPersona() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("Opcion 3");

        Scanner entrada = new Scanner(System.in);      
        System.out.print("Introduce el nombre de la persona a buscar: ");
        String nombre = entrada.nextLine();

        File fichero = new File("./datos/personas.dat");
        FileInputStream ficheroEntrada = new FileInputStream(fichero);
        ObjectInputStream ficheroObjeto2 = new ObjectInputStream(ficheroEntrada);

        Persona p;
        ArrayList<Persona> per = new ArrayList<Persona>();
        
        while (ficheroEntrada.available() > 0) {
            p = (Persona)ficheroObjeto2.readObject();
            per.add(p);            
        }
        ficheroObjeto2.close();    
        
        for(Persona p1 : per)
        {
            if(p1.getNombre() == nombre)
                System.out.println(p1);
            
        }
   }

   public static void MostrarPersonas() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("Opcion 2");
      
        File fichero = new File("./datos/personas.dat");
        FileInputStream ficheroEntrada = new FileInputStream(fichero);
        ObjectInputStream ficheroObjeto2 = new ObjectInputStream(ficheroEntrada);

        Persona p;
        ArrayList<Persona> per = new ArrayList<Persona>();
        
        while (ficheroEntrada.available() > 0) {
            p = (Persona)ficheroObjeto2.readObject();
            per.add(p);            
        }
        ficheroObjeto2.close();    
        
        for(Persona p1 : per)
        {
           System.out.println(p1);
        }
   }
}
