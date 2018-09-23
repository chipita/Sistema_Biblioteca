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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Gauto
 */
public class TransaccionBD {
    private final String driverBD = "org.SqlServer.Driver";
    private final String ubicacion = "jdbc:sqlserver://localhost:5432/biblioteca_java";
    private final String user = "admin";
    private final String pass = "1234";
    private Connection conectar = null;
    
    public void conectarBD() throws SQLException{
        try {
            Class.forName(driverBD);
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo conectar a la base de datos");
        }
            conectar = DriverManager.getConnection(ubicacion,user,pass);
    }

    public void cerrarBD() throws SQLException{
        if (conectar == null)
            conectar.close();
        }
      
       
    }

