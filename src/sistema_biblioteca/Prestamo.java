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
public class Prestamo {
    public int codigoPrestamo;
    public String fechaPrestamo;
    public int montoPrestamo;
    public String fechaLimite;
    public int porcentageRecargo;
    private Connection conectar = null;

    public Prestamo(int codigoPrestamo, String fechaPrestamo, int montoPrestamo, String fechaLimite, int porcentageRecargo) {
        this.codigoPrestamo = codigoPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.montoPrestamo = montoPrestamo;
        this.fechaLimite = fechaLimite;
        this.porcentageRecargo = porcentageRecargo;
    }
    
    

    Prestamo() {
        
    }

    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(int codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(int montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getPorcentageRecargo() {
        return porcentageRecargo;
    }

    public void setPorcentageRecargo(int porcentageRecargo) {
        this.porcentageRecargo = porcentageRecargo;
    }
    
     public void crearNuevoPrestamo() throws IOException{
        System.out.println("Ingrese datos del prestamo \n");
        System.out.println("Ingrese el codigo del prestamo \n");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int codigoPrestamo = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese la fecha del prestamo");
        String fechaPrestamo = entrada.readLine();
        System.out.println("Ingrese el monto del prestamo");
        int montoPrestamo = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese la fecha limite del prestamo");
        String fechaLimite = entrada.readLine();
        System.out.println("Ingrese cel porcentaje de recargo");
        int porcentaje = Integer.parseInt(entrada.readLine());
        try {
            insertar(codigoPrestamo,fechaPrestamo, montoPrestamo, fechaLimite, porcentaje);
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
    }
    
    public void insertar(int codigoPrestamo,String fechaPrestamo,int montoPrestamo,String fechaLimite,int porcentaje) throws SQLException{
        String sql = "INSERT INTO public.prestamo(\n" +
"	codigoPrestamo, fechaPrestamo, montoPrestamo, fechaLimite, porcentaje, marca)\n" +
"	VALUES (?, ?, ?, ?, ?, ?);";;
        PreparedStatement st = conectar.prepareStatement(sql);
        st.setInt(1, codigoPrestamo);
        st.setString(2,fechaPrestamo);
        st.setInt(3,montoPrestamo);
        st.setString(4, fechaLimite);
        st.setInt(5, porcentaje);
        st.executeUpdate();
        st.close();
     }    
     
    public void consultarPrestamo(int codigoPrestamo) throws SQLException{
       String sql = "SEELCT * FROM public.prestamo WHERE codPrestamo = ?(/n";
       PreparedStatement st = conectar.prepareStatement(sql);
       st.setInt(1,codigoPrestamo);
       System.out.println("Los datos del prestamo a consultar son: " + sql);
    }
    
    
    
}
