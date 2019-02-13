/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cdap_
 */
public class Conexion {
      public  static Connection conectar() {
        Connection con = null;
         // Librería de MySQL
        String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
         String database = "FaroBD";

    // Host
         String hostname = "localhost";

    // Puerto
         String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
         String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
         String username = "root";

    // Clave de usuario
         String password = "";

        try {
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
				
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexión fallida a base de datos");
            e.printStackTrace();
        }

        return con;
    }
}
