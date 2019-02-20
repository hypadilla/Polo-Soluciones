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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Entidades.Usuarios;
import modelo.Interfaces.IUsuario;
import src.Constantes;

public class UsuarioDAO implements IUsuario {

    @Override
    public Object Insertar(Object object) {
        Usuarios usuario = (Usuarios) object;
        Object[] Rpta = new Object[2];
        PreparedStatement ps = null;
        Connection acceDB = null;

        String registrarSQL = "INSERT INTO " +Constantes.TABLAUSUARIOS+ " values (null,?,?,?,?,?)";

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
        return Rpta;
    }

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
        String QuerySQL = "SELECT * FROM Usuario WHERE ((Usuario like ?)|| (Correo like ?) )";
        ResultSet resultSet;
        ArrayList<Object> Respuesta = new ArrayList<>();
        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, "%"+ String.valueOf(object) + "%");
            preparedStatement.setString(2, "%"+ String.valueOf(object) + "%");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setId(resultSet.getInt("IdUsuario"));
                usuarios.setUsuario(resultSet.getString("Usuario"));
                usuarios.setClave(resultSet.getString("Contraseña"));
                usuarios.setCorreoElectronico(resultSet.getString("Correo"));
                usuarios.setPregunta(resultSet.getString("PreguntaSecreta"));
                usuarios.setRespuestaSecreta(resultSet.getString("RespuestaSecreta"));                
                Respuesta.add(usuarios);
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + UsuarioDAO.class.getName() + " Método Mostrar(object)");
        }
        return Respuesta;
    }

    @Override
    public Object Eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Editar(Object object) {
       Usuarios usuario = (Usuarios) object;
        Object[] Rpta = new Object[2];
        PreparedStatement ps = null;
        Connection acceDB = null;

        String registrarSQL = "UPDATE "  +Constantes.TABLAUSUARIOS+ " SET Contraseña = ?,Correo = ?,PreguntaSecreta = ?,RespuestaSecreta = ? WHERE Usuario = ?";
        Rpta[0] = "Boolean";
        try {
            acceDB = Conexion.conectar();
            ps = acceDB.prepareStatement(registrarSQL);            
            ps.setString(1, usuario.getClave());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setString(3, usuario.getPregunta());
            ps.setString(4, usuario.getRespuestaSecreta());
            ps.setString(5, usuario.getUsuario());
            ps.execute();
            ps.close();
            acceDB.close();
            
            Rpta[1] = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return Rpta;
    }

    @Override
    public Object Mostrar(Object object) {
        ArrayList<String> ListaVariables = (ArrayList<String>) object;
        String CampoFiltro = ListaVariables.get(0);
        String ValorFiltro = ListaVariables.get(1);
        String TipoValorFiltro = ListaVariables.get(2);
        String QuerySQL = "SELECT * FROM " + Constantes.TABLAUSUARIOS + " WHERE " + CampoFiltro + " = ?";
        Usuarios Respuesta = null;

        ResultSet resultSet;
        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            switch(TipoValorFiltro){
                case "String":
                    preparedStatement.setString(1, ValorFiltro);
                    break;
                case "Int":
                    preparedStatement.setInt(1, Integer.parseInt(ValorFiltro));
                    break;
                case "Boolean":
                    preparedStatement.setBoolean(1, Boolean.parseBoolean(ValorFiltro));
                    break;
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Respuesta = new Usuarios();
                Respuesta.setId(resultSet.getInt("IdUsuario"));
                Respuesta.setUsuario(resultSet.getString("Usuario"));
                Respuesta.setClave(resultSet.getString("Contraseña"));
                Respuesta.setCorreoElectronico(resultSet.getString("Correo"));
                Respuesta.setPregunta(resultSet.getString("PreguntaSecreta"));
                Respuesta.setRespuestaSecreta(resultSet.getString("RespuestaSecreta"));
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + UsuarioDAO.class
                    .getName() + " Método Mostrar(object)\n"
                    + "Parametros: Campo = " + CampoFiltro + "; Valor = " + ValorFiltro + "; Tipo = " + TipoValorFiltro);
        }
        return Respuesta;
    }

    @Override
    public Boolean Existe(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
