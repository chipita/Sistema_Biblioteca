/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Carlos Gauto
 */
public abstract class Persona {
    public int cedula;
    public String nombre;
    public String apellido;
    public int edad;
    
    public Persona(String nombre, String apellido, int edad,int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula=cedula;
    }

    public Persona(){
        
    }
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public abstract void crearNuevaPersona() throws IOException,SQLException;
    
     
    public abstract void consultarPersona(int cedula) throws IOException,SQLException;
    
    public abstract void eliminarPersona(int cedula) throws IOException, SQLException;
}
