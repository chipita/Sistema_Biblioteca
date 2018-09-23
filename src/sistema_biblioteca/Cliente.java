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
public class Cliente extends Persona{
    public String direccion;
    public String email;
    public int telefono;
    private Connection conectar = null;

    public Cliente(String direccion, String email, int telefono, String nombre, String apellido, int edad, int cedula) {
        super(nombre, apellido, edad, cedula);
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente() {
        
    }

    @Override
    public int getCedula() {
        return cedula;
    }

    @Override
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }   

    @Override
    public void crearNuevaPersona() throws IOException, SQLException {
        System.out.println("Ingrese datos del nuevo cliente: \n");
        System.out.println("Ingrese el numero de cedula del cliente \n");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int cedula = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese el nombre del cliente");
        String nombre = entrada.readLine();
        System.out.println("Ingrese el apellido del cliente");
        String apellido = entrada.readLine();
        System.out.println("Ingrese la edad del cliente");
        int edad = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese la direccion del cliente");
        String direccion = entrada.readLine();
        System.out.println("Ingrese el email del cliente");
        String email = entrada.readLine();
        System.out.println("Ingrese el telefono del cliente");
        int telefono = Integer.parseInt(entrada.readLine());
        String sql = "INSERT INTO public.Cliente(\n" +
"	cedula, nombre, apellido, edad, direccion, email, telefono)\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement st = conectar.prepareStatement(sql);
        st.setInt(1, cedula);
        st.setString(2,nombre);
        st.setString(3,apellido);
        st.setInt(4,edad);
        st.setString(5,direccion);
        st.setString(6,email);
        st.setInt(7, telefono);
        st.executeUpdate();
        st.close();
    }

    @Override
    public void consultarPersona(int cedula) throws SQLException, IOException {
       String sql = "SEELCT * FROM public.Cliente WHERE <cedula= ?>(/n";
       PreparedStatement st = conectar.prepareStatement(sql);
       st.setInt(1,cedula);
       System.out.println("Los datos del cliente a consultar son: " + sql);
    }

    @Override
    public void eliminarPersona(int cedula) throws IOException, SQLException {
        String sql = "DELETE FROM public.cliente\n" +
        "WHERE <cedula=?>;";
        PreparedStatement st = conectar.prepareStatement(sql);
        st.setInt(1,cedula);
        int valor = st.executeUpdate();
        if(valor < 1)
            System.err.println("No existe el cliente en la base de datos");
        st.close();
    }
    
}
