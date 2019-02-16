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
import modelo.Entidades.Conceptos;
import modelo.Interfaces.IConceptos;
import src.Constantes;

/**
 *
 * @author hypadilla
 */
public class ConceptosDAO implements IConceptos{

    @Override
    public Object Insertar(Object object) {
        Conceptos var = (Conceptos) object;
        String QuerySQL = "INSERT INTO " + Constantes.TABLACONCEPTOS + " VALUES (null,?,?,?,?,?,?,?,?,?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";

        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getCodigo());
            preparedStatement.setString(2, var.getDescripcion());
            preparedStatement.setString(3, var.getEtiqueta());
            preparedStatement.setInt(4, var.getNaturalezaDinero());
            preparedStatement.setInt(5, var.getNaturalezaInventario());
            preparedStatement.setBoolean(6, var.isManejaConsecutivo());
            preparedStatement.setString(7, var.getPrefijo());
            preparedStatement.setInt(8, var.getUltimoConsecutivo());
            preparedStatement.setString(9, var.getResolucionDIAN());
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
        String QuerySQL = "SELECT * FROM " + Constantes.TABLACONCEPTOS + " WHERE " + CampoFiltro + " = ?";
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
