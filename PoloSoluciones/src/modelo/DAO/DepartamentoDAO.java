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
import modelo.Entidades.Departamentos;
import modelo.Interfaces.IDepartamentos;
import src.Constantes;

/**
 *
 * @author hypadilla
 */
public class DepartamentoDAO implements IDepartamentos{
  
    
   
    @Override
    public Object Insertar(Object object) {
        
        Departamentos var = (Departamentos) object;
        String QuerySQL = "INSERT INTO " + Constantes.TABLADEPARTAMENTOS + " VALUES (NULL,?,?,?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";

        try (Connection connection = Conexion.conectar(); 
            PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getCodigo());
            preparedStatement.setString(2, var.getDepartamento());
            preparedStatement.setString(3, var.getDescripcion());
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
        String QuerySQL = "SELECT * FROM " + Constantes.TABLADEPARTAMENTOS + " WHERE " + CampoFiltro + " = ?";
        Departamentos departamento = new Departamentos();

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
                departamento.setId(resultSet.getInt("idDepartamentos"));
                departamento.setCodigo(resultSet.getString("Codigo"));
                departamento.setDepartamento(resultSet.getString("Departamento"));
                departamento.setDescripcion(resultSet.getString("Descripcion"));
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + DepartamentoDAO.class
                    .getName() + " Método Mostrar(object)\n"
                    + "Parametros: Campo = " + CampoFiltro + "; Valor = " + ValorFiltro + "; Tipo = " + TipoValorFiltro);
        }
        return departamento;
    }

    @Override
    public Object Eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Editar(Object object) {
        Departamentos var = (Departamentos) object;
        String QuerySQL = "UPDATE " + Constantes.TABLADEPARTAMENTOS + " SET Codigo = ?, Departamento = ?, Descripcion = ?   WHERE(idDepartamentos = ?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";

        try (Connection connection = Conexion.conectar(); 
            PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getCodigo());
            preparedStatement.setString(2, var.getDepartamento());
            preparedStatement.setString(3, var.getDescripcion());
            preparedStatement.setInt(4, var.getId());
            preparedStatement.execute();

            Rpta[1] = true;
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Rpta;
    }

    

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
        String QuerySQL = "SELECT * FROM Departamentos WHERE ((Codigo like ?)|| (Departamento like ?) )";
        ResultSet resultSet;
        ArrayList<Object> Respuesta = new ArrayList<>();
        try (Connection connection = Conexion.conectar(); 
            PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, "%"+ String.valueOf(object) + "%");
            preparedStatement.setString(2, "%"+ String.valueOf(object) + "%");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Departamentos departamentos = new Departamentos();
                departamentos.setId(resultSet.getInt("idDepartamentos"));
                departamentos.setCodigo(resultSet.getString("Codigo"));
                departamentos.setDepartamento(resultSet.getString("Departamento"));
                departamentos.setDescripcion(resultSet.getString("Descripcion"));                
                Respuesta.add(departamentos);
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + DepartamentoDAO.class.getName() + " Método Mostrar(object)");
        }
        return Respuesta;
    }

    @Override
    public Boolean Existe(Object object) {
        ArrayList<String> ListaVariables = (ArrayList<String>) object;
        String CampoFiltro = ListaVariables.get(0);
        String ValorFiltro = ListaVariables.get(1);
        String TipoValorFiltro = ListaVariables.get(2);
        String QuerySQL = "SELECT * FROM " + Constantes.TABLADEPARTAMENTOS + " WHERE " + CampoFiltro + " = ?";
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
            Logger.getLogger(DepartamentoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + DepartamentoDAO.class
                    .getName() + " Método Mostrar(object)\n"
                    + "Parametros: Campo = " + CampoFiltro + "; Valor = " + ValorFiltro + "; Tipo = " + TipoValorFiltro);
        }
        return Respuesta;
    }
    
}
