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

        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
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
    public ArrayList<Object> MostrarTodos(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
