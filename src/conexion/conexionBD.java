/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author LAPTOP-404
 */
public class conexionBD {
    
    // Datos de conexión
    private static final String URL ="jdbc:mysql://localhost:3306/biblioteca";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";  // Si no tienes contraseña, dejar en blanco
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    // Instancia única de la conexión
    private static Connection conexion = null;
    
    /**
     * Constructor privado para evitar instanciación múltiple
     */
       private conexionBD() {
    }

     /**
     * Método para obtener la conexión a la base de datos
     * Si no existe una conexión activa, la crea
     * 
     * @return Connection - La conexión a la BD
     */
    public static Connection obtenerConexion() {
        if (conexion == null) {
        try {
             // Cargar el driver JDBC
             Class.forName(DRIVER);
            // Establecer la conexión
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✓ Conexión a la base de datos establecida correctamente");   
        }catch (ClassNotFoundException e) {
                System.err.println("✗ Error: Driver JDBC no encontrado");
                System.err.println("Asegúrate de agregar el JAR de MySQL al proyecto");
                e.printStackTrace();

        }catch (SQLException e) {
                System.err.println("✗ Error al conectar a la base de datos");
                System.err.println("Verifica que:");
                System.err.println("  1. MySQL está ejecutándose");
                System.err.println("  2. El usuario y contraseña son correctos");
                System.err.println("  3. La base de datos 'biblioteca' existe");
                e.printStackTrace();
            }
        }
        return conexion;
    }
    /**
     * Método para cerrar la conexión a la base de datos
    */
 public static void cerrarConexion() {
         if (conexion != null) {
           try {
                conexion.close();
                conexion = null;
                System.out.println("✓ Conexión cerrada correctamente");  
            } catch (SQLException e) {
                System.err.println("✗ Error al cerrar la conexión");
                e.printStackTrace();
            } 
         } 
 }
   

    /**
     * Método para verificar si la conexión está activa
     * 
     * @return boolean - true si la conexión está activa, false si no
     */
     public static boolean verificarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     
     
     

     /**
     * Método principal para probar la conexión
     * EJECUTAR ESTO PRIMERO para verificar que todo funciona
     */

        public static void main(String[] args) {
        System.out.println("=== PRUEBA DE CONEXIÓN A BASE DE DATOS ===");
        System.out.println();
        
        try {
            // Intentar conectar
            Connection conn = conexionBD.obtenerConexion();
            
            if (conn != null) {
                System.out.println("✓ PRUEBA EXITOSA: La conexión funciona correctamente");
                System.out.println("✓ Puedes comenzar a usar la base de datos");
                conexionBD.cerrarConexion();
                
            } else {
                System.out.println("✗ PRUEBA FALLIDA: No se pudo establecer conexión");
                System.out.println("Revisa los datos de conexión en esta clase");
            }
            
        } catch (Exception e) {
            System.out.println("✗ PRUEBA FALLIDA: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
}
