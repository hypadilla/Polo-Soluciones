/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cdap_
 */
public class Conexion {

    public static Connection conectar() {
        Connection con = null;
        // Librería de MySQL
        String driver = "com.mysql.jdbc.Driver";

        // Nombre de la base de datos
        String database = "sql10279128";

        // Host
        String hostname = "sql10.freemysqlhosting.net";
        //String hostname = "localhost";

        // Nombre de usuario
        String username = "sql10279128";

        // Clave de usuario
        String password = "r3UxKqFz9D";
        // Puerto

        String port = "3306";

        // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
        String url = driver + ";Server=" + hostname + ";Database=" + database + ";User=" + username + ";Password=" + password + ";Option=3";
        String url2 = "jdbc:mysql://"+hostname+":" + port + "/" + database;
        
        //String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=true";

        try {
            con = DriverManager.getConnection(url2, username, password);

            if (con != null) {
                System.out.println(con);
            }else{
                System.out.println("Null");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexión fallida a base de datos");
            e.printStackTrace();
        }

        return con;
    }

}
