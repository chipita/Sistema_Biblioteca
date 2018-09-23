/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Carlos Gauto
 */
public class Empleado extends Persona{
    public String turno;
    public String diaLibre;
    private Connection conectar = null;

    public Empleado() {
        
    }
    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDiaLibre() {
        return diaLibre;
    }

    public void setDiaLibre(String diaLibre) {
        this.diaLibre = diaLibre;
    }

    @Override
    public int getCedula() {
        return cedula;
    }

    @Override
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Empleado(String turno, String diaLibre, String nombre, String apellido, int edad, int cedula) {
        super(nombre, apellido, edad, cedula);
        this.turno = turno;
        this.diaLibre = diaLibre;
    }

    @Override
    public void crearNuevaPersona() throws IOException, SQLException {
        System.out.println("Ingrese datos del nuevo empleado: \n");
        System.out.println("Ingrese el numero de cedula del empleado \n");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int cedula = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese el nombre del empleado");
        String nombre = entrada.readLine();
        System.out.println("Ingrese el apellido del empleado");
        String apellido = entrada.readLine();
        System.out.println("Ingrese la edad del empleado");
        int edad = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese el turno del empleado");
        String turno = entrada.readLine();
        System.out.println("Ingrese el dia libre del empleado");
        String diaLibre = entrada.readLine();
        String sql = "INSERT INTO public.Empleado(\n" +
"	cedula, nombre, apellido, edad, turno, diaLibre)\n" +
"	VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement st = conectar.prepareStatement(sql);
        st.setInt(1, cedula);
        st.setString(2,nombre);
        st.setString(3,apellido);
        st.setInt(4,edad);
        st.setString(5,turno);
        st.setString(6,diaLibre);
        st.executeUpdate();
        st.close();  
    }

    @Override
    public void consultarPersona(int cedula) throws IOException, SQLException {
       String sql = "SEELCT * FROM public.Empleado WHERE <cedula= ?>(/n";
       PreparedStatement st = conectar.prepareStatement(sql);
       st.setInt(1,cedula);
       System.out.println("Los datos del cliente a consultar son: " + sql);
    }

    @Override
    public void eliminarPersona(int cedula) throws IOException, SQLException {
        String sql = "DELETE FROM public.Empleado\n" +
        "WHERE <cedula=?>;";
        PreparedStatement st = conectar.prepareStatement(sql);
        st.setInt(1,cedula);
        int valor = st.executeUpdate();
        if(valor < 1)
            System.err.println("No existe el empleado en la base de datos");
        st.close(); 
    }
    
}
