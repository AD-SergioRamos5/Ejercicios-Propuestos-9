
package ejercicio4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void Mostrar() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario    
        
        while (!salir) {
            UtilString.Linea();
            System.out.println("1. Añadir datos de persona");
            System.out.println("2. Mostrar todas las personas");
            System.out.println("3. Buscar persona por nombre");
            System.out.println(UtilString.StrRepetir('-',20));
            System.out.println("0. Salir");
            System.out.println(UtilString.StrRepetir('-',20));

            try {
                
                System.out.print("Escribe una de las opciones: ");
                opcion = sn.nextInt();

                UtilString.Linea();
                switch (opcion) {
                    case 1:
                        Opciones.AddPersona();
                        break;  
                    case 2:
                        Opciones.MostrarPersonas();
                        break;  
                    case 3:
                        Opciones.BuscaPersona();
                        break;  
                        
                    // **************************
                    // SALIR
                    // **************************
                    case 0:
                        salir = true;
                        System.out.println("Terminado");
                        UtilString.Linea();
                        break;                        
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
        } catch (InputMismatchException e) {
                UtilString.Linea();
                System.out.println("Debe insertar un numero");
                sn.next();
            }
        }               
              
    }
}
