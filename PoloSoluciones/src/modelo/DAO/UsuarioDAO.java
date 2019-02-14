/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Entidades.Usuarios;
import modelo.Interfaces.IUsuario;

public class UsuarioDAO implements IUsuario {

    public boolean IfExist(String usuario) {
        boolean Rpta = false;
        PreparedStatement ps = null;
            Connection acceDB = null;
            String consultarSQL = "SELECT Usuario from usuario where (Usuario=?)";
        try {
            acceDB = Conexion.conectar();
            ps = acceDB.prepareStatement(consultarSQL);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                Rpta = true;
            }else{
                Rpta = false;
            }
            ps.close();
            acceDB.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase UsuarioDAO, método ifExist");
            e.printStackTrace();
            Rpta = false;
        }
        return Rpta;
    }

    @Override
    public Object Insertar(Object object) {
        Usuarios usuario = (Usuarios) object;
        Object[] Rpta = new Object[2];
        PreparedStatement ps = null;
        Connection acceDB = null;
        if (IfExist(usuario.getUsuario())) {
            Rpta[0] = "String";
            Rpta[1] = "El usuario ya existe";
        } else {
            
            String registrarSQL = "INSERT INTO usuario values (null,?,?,?,?,?)";

            try {
                acceDB = Conexion.conectar();
                ps = acceDB.prepareStatement(registrarSQL);
                ps.setString(1, usuario.getUsuario());
                ps.setString(2, usuario.getClave());
                ps.setString(3, usuario.getCorreoElectronico());
                ps.setString(4, usuario.getPregunta());
                ps.setString(5, usuario.getRespuestaSecreta());
                ps.execute();
                ps.close();
                acceDB.close();
                Rpta[0] = "Boolean";
                Rpta[1] = true;
            } catch (SQLException e) {
                System.out.println("Error: Clase UsuarioDAO, método insertar");
                e.printStackTrace();
                Rpta[0] = "Boolean";
                Rpta[1] = false;
            }

            
        }
        return Rpta;
    }

    @Override
    public ArrayList<Object> Mostrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Object Eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Editar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> MostrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
