/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Gauto
 */
public class Sistema_Biblioteca {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        Prestamo prestamo = new Prestamo();
        Persona cliente = new Cliente();
        Persona empleado = new Empleado();
        Libro libro = new Libro();
        System.out.print("Bienvenidos al Sistema de biblioteca Ingrese su opcion \n");
        System.out.print("1 Para nuevo prestamo \n");
        System.out.print("2 para consulta de prestamo \n");
        System.out.print("3 para cliente nuevo \n");
        System.out.print("4 para consulta de cliente \n" );
        System.out.print("5 para eliminar un cliente \n" );
        System.out.print("6 para empleado nuevo \n" );
        System.out.print("7 para consulta de empleado \n" );
        System.out.print("8 para eliminar un empleado \n" );
        System.out.print("9 para libro nuevo \n" );
        System.out.print("10 para consulta de libro \n");
        System.out.print("11 para eliminar un libro \n");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int opcion = Integer.parseInt(entrada.readLine());
        
        
        switch (opcion){
            case 1:
                prestamo.crearNuevoPrestamo();
            case 2:
                System.out.println("Ingrese el prestamo a consultar");
                BufferedReader opPrestamo = new BufferedReader(new InputStreamReader(System.in));
                int numPrestamo = Integer.parseInt(opPrestamo.readLine());
        {
            try {
                prestamo.consultarPrestamo(numPrestamo);
            } catch (SQLException ex) {
                System.out.println("ERROR en la base de datos");
            }
            
            
        }
            case 3:
        {
            try {
                cliente.crearNuevaPersona();
            } catch (SQLException ex) {
                System.out.println("ERROR en la base de datos");
            }
        }
        
            case 4:
                System.out.println("Ingrese el numero de cedula del cliente a consultar");
                BufferedReader opCliente = new BufferedReader(new InputStreamReader(System.in));
                int cedCliente = Integer.parseInt(opCliente.readLine());
        {
            try {
                cliente.consultarPersona(cedCliente);
            } catch (SQLException ex) {
                 System.out.println("ERROR en la base de datos");
            }
        }
        
            case 5:
                System.out.println("Ingrese el numero de cedula del cliente a eliminar");
                BufferedReader opClienteEliminar = new BufferedReader(new InputStreamReader(System.in));
                int cedClienteEliminar = Integer.parseInt(opClienteEliminar.readLine());
        {
            try {
                cliente.eliminarPersona(cedClienteEliminar);
            } catch (SQLException ex) {
                System.out.println("ERROR en la base de datos");
            }
        }
            case 6:
        {
            try {
                empleado.crearNuevaPersona();
            } catch (SQLException ex) {
                System.out.println("ERROR en la base de datos");
            }
        }
            case 7:
                System.out.println("Ingrese el numero de cedula del empleado a consultar");
                BufferedReader opEmpleado = new BufferedReader(new InputStreamReader(System.in));
                int cedEmpleado = Integer.parseInt(opEmpleado.readLine());
        {
            try {
                empleado.consultarPersona(cedEmpleado);
            } catch (SQLException ex) {
               System.out.println("ERROR en la base de datos");
            }
        }
            case 8:
                System.out.println("Ingrese el numero de cedula del empleado a eliminar");
                BufferedReader opEmpleadoEliminar = new BufferedReader(new InputStreamReader(System.in));
                int cedEmpleadoEliminar = Integer.parseInt(opEmpleadoEliminar.readLine());
        {
            try {
                empleado.eliminarPersona(cedEmpleadoEliminar);
            } catch (SQLException ex) {
                System.out.println("ERROR en la base de datos");
            }
        }
        
            case 9:
        {
            try {
                libro.nuevoLibro();
            } catch (SQLException ex) {
                System.out.println("ERROR en la base de datos");
            }
        }
            case 10:
                System.out.println("Ingrese el codigo del libro a consultar");
                BufferedReader opLibro = new BufferedReader(new InputStreamReader(System.in));
                int codLibro = Integer.parseInt(opLibro.readLine());
        {
            try {
                libro.consultarLibro(codLibro);
            } catch (SQLException ex) {
                System.out.println("ERROR en la base de datos");
            }
        }
            case 11:
                System.out.println("Ingrese el codigo del libro a eliminar");
                BufferedReader opLibroEliminar = new BufferedReader(new InputStreamReader(System.in));
                int codLibroEliminar = Integer.parseInt(opLibroEliminar.readLine());
        {
            try {
                libro.eliminarlibro(codLibroEliminar);
            } catch (SQLException ex) {
                 System.out.println("ERROR en la base de datos");
            }
        }
        }
        
        
        
        
    }
    
}
