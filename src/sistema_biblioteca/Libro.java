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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Carlos Gauto
 */
public class Libro {
    public int codigo;
    public String titulo;
    public String autor;
    public String genero;
    public String editorial;
    public int año;
    public int edicion;
    private Connection conectar = null;
    
    public Libro(String titulo, String autor, String genero, String editorial, int año, int edicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.año = año;
        this.edicion = edicion;
    }

    Libro() {
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
    
    public void nuevoLibro() throws IOException, SQLException{
        System.out.println("Ingrese datos de nuevo libro: \n");
        System.out.println("Ingrese el codigo del libro \n");
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int codigo = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese el titulo del libro");
        String titulo = entrada.readLine();
        System.out.println("Ingrese el autor del libro");
        String autor = entrada.readLine();
        System.out.println("Ingrese el genero del libro");
        String genero = entrada.readLine();
        System.out.println("Ingrese la editorial del libro");
        String editorial = entrada.readLine();
        System.out.println("Ingrese el año del libro");
        int año = Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese la edicion del libro");
        int edicion = Integer.parseInt(entrada.readLine());
        String sql = "INSERT INTO public.libro(\n" +
"	codigo, titulo, autor, genero, editorial, año, edicion)\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement st = conectar.prepareStatement(sql);
        st.setInt(1, codigo);
        st.setString(2,titulo);
        st.setString(3,autor);
        st.setString(4,genero);
        st.setString(5,editorial);
        st.setInt(6,año);
        st.setInt(7, edicion);
        st.executeUpdate();
        st.close();
     }    
    
     public void consultarLibro(int codigo) throws SQLException{
       String sql = "SEELCT * FROM public.libro WHERE <codLibro= ?>(/n";
       PreparedStatement st = conectar.prepareStatement(sql);
       st.setInt(1,codigo);
       System.out.println("Los datos del libro a consultar son: " + sql);
    }
    
     public void eliminarlibro(int codigo) throws IOException, SQLException {
        String sql = "DELETE FROM public.productos\n" +
        "WHERE <titulo=?>;";
        PreparedStatement st = conectar.prepareStatement(sql);
        st.setInt(1,codigo);
        int valor = st.executeUpdate();
        if(valor < 1)
            System.err.println("No existe el libro en la base de datos");
        st.close();
     } 
    
            
}
