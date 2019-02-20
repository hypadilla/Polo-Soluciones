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
import modelo.Entidades.Terceros;
import modelo.Entidades.Usuarios;
import modelo.Interfaces.ITerceros;
import src.Constantes;

/**
 *
 * @author hypadilla
 */
public class TerceroDAO implements ITerceros {

    @Override
    public Object Insertar(Object object) {
        Terceros var = (Terceros) object;
        String QuerySQL = "INSERT INTO " + Constantes.TABLATERCEROS + " VALUES (NULL,?,?,?,?,?,?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";

        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getTipoTercero());
            preparedStatement.setString(2, var.getDocumento());
            preparedStatement.setString(3, var.getNombre());
            preparedStatement.setString(4, var.getDireccion());
            preparedStatement.setString(5, var.getCorreo());
            preparedStatement.setString(6, var.getTelefono());
            preparedStatement.execute();

            Rpta[1] = true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Rpta;
    }

    @Override
    public Object Mostrar(Object object) {
        ArrayList<String> ListaVariables = (ArrayList<String>) object;
        String CampoFiltro = ListaVariables.get(0);
        String ValorFiltro = ListaVariables.get(1);
        String TipoValorFiltro = ListaVariables.get(2);
        String QuerySQL = "SELECT * FROM " + Constantes.TABLATERCEROS + " WHERE " + CampoFiltro + " = ?";
        Terceros tercero = new Terceros();

        ResultSet resultSet;
        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            switch (TipoValorFiltro) {
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
                tercero.setIdTerceros(resultSet.getInt("idTerceros"));
                tercero.setTipoTercero(resultSet.getString("TipoTercero"));
                tercero.setDocumento(resultSet.getString("Documento"));
                tercero.setNombre(resultSet.getString("Nombre"));
                tercero.setDireccion(resultSet.getString("Direccion"));
                tercero.setCorreo(resultSet.getString("Correo"));
                tercero.setTelefono(resultSet.getString("Telefono"));
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(TerceroDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + TerceroDAO.class
                    .getName() + " Método Mostrar(object)\n"
                    + "Parametros: Campo = " + CampoFiltro + "; Valor = " + ValorFiltro + "; Tipo = " + TipoValorFiltro);
        }
        return tercero;
    }

    @Override
    public Object Eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Editar(Object object) {
        Terceros var = (Terceros) object;
        String QuerySQL = "UPDATE " + Constantes.TABLATERCEROS + " SET TipoTercero = ?, Nombre = ?, Direccion = ?,Correo = ?, Telefono = ?  WHERE idTerceros = ?";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";

        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getTipoTercero());
            preparedStatement.setString(2, var.getNombre());
            preparedStatement.setString(3, var.getDireccion());
            preparedStatement.setString(4, var.getCorreo());
            preparedStatement.setString(5, var.getTelefono());
            preparedStatement.setInt(6, var.getIdTerceros());
            preparedStatement.execute();

            Rpta[1] = true;
        } catch (SQLException ex) {
            Logger.getLogger(TerceroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Rpta;
    }

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
        String QuerySQL = "SELECT * FROM Terceros WHERE ((Documento like ?)|| (Nombre like ?) )";
        ResultSet resultSet;
        ArrayList<Object> Respuesta = new ArrayList<>();
        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, "%"+ String.valueOf(object) + "%");
            preparedStatement.setString(2, "%"+ String.valueOf(object) + "%");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Terceros terceros = new Terceros();
                terceros.setIdTerceros(resultSet.getInt("idTerceros"));
                terceros.setTipoTercero(resultSet.getString("TipoTercero"));
                terceros.setDocumento(resultSet.getString("Documento"));
                terceros.setNombre(resultSet.getString("Nombre"));
                terceros.setDireccion(resultSet.getString("Direccion"));
                terceros.setCorreo(resultSet.getString("Correo"));
                terceros.setTelefono(resultSet.getString("Telefono"));
                Respuesta.add(terceros);
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(TerceroDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + TerceroDAO.class.getName() + " Método Mostrar(object)");
        }
        return Respuesta;
    }

    @Override
    public Boolean Existe(Object object) {
        ArrayList<String> ListaVariables = (ArrayList<String>) object;
        String CampoFiltro = ListaVariables.get(0);
        String ValorFiltro = ListaVariables.get(1);
        String TipoValorFiltro = ListaVariables.get(2);
        String QuerySQL = "SELECT * FROM " + Constantes.TABLATERCEROS + " WHERE " + CampoFiltro + " = ?";
        boolean Respuesta = false;

        ResultSet resultSet;
        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            switch (TipoValorFiltro) {
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
                Respuesta = true;
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(TerceroDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + TerceroDAO.class
                    .getName() + " Método Mostrar(object)\n"
                    + "Parametros: Campo = " + CampoFiltro + "; Valor = " + ValorFiltro + "; Tipo = " + TipoValorFiltro);
        }
        return Respuesta;
    }

}
