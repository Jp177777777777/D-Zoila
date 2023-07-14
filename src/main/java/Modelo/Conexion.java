
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    //Primero creamos una variable de conexion a BD
    private static Connection conexion;
    //Creamos variable para conectar en una instancia
    private static Conexion instancia;
    //Creamos variables para concetar a la BD
    private static final String URL = "jdbc:mysql://localhost/dzoilarecetario";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    //Creamos el metodo para conectar a BD
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexion a la BD Exitosa !!");
            return conexion;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " +e);
        }
        return conexion;
    }
    //Creamos el metodo para cerrar la BD
    public void cerrarConexion() throws SQLException {
        try {
            conexion.close();
            //JOptionPane.showMessageDialog(null, "Se Desconecto de la BD .");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            conexion.close();
        } finally {
            conexion.close();
        }
    }
    //Patron para conectar(SINGLETON)
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }   
}
