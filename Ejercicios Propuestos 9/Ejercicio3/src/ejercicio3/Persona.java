
package ejercicio3;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String email;
    private String añoNacimiento;

    public Persona(){
    }

    public Persona(String nombre, String email, String añoNacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.añoNacimiento = añoNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(String añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }
    
    @Override
    public String toString(){
        return nombre + " - " + email + " - " + añoNacimiento;
    }
}
