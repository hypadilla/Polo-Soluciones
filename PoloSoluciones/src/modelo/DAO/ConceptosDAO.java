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
    public Object Mostrar(Object object) {
       ArrayList<String> ListaVariables = (ArrayList<String>) object;
        String CampoFiltro = ListaVariables.get(0);
        String ValorFiltro = ListaVariables.get(1);
        String TipoValorFiltro = ListaVariables.get(2);
        String QuerySQL = "SELECT * FROM " + Constantes.TABLACONCEPTOS + " WHERE " + CampoFiltro + " = ?";
        Conceptos conceptos = new Conceptos();

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
                conceptos.setId(resultSet.getInt("idConceptos"));
                conceptos.setCodigo(resultSet.getString("Codigo"));                
                conceptos.setDescripcion(resultSet.getString("Descripcion"));
                conceptos.setEtiqueta(resultSet.getString("Etiqueta"));
                conceptos.setNaturalezaDinero(resultSet.getInt("NaturalezaDinero"));
                conceptos.setNaturalezaInventario(resultSet.getInt("NaturalezaInventario"));
                conceptos.setManejaConsecutivo(resultSet.getBoolean("ManejaConsecutivo"));
                conceptos.setPrefijo(resultSet.getString("Prefijo"));
                conceptos.setUltimoConsecutivo(resultSet.getInt("UltimoConsecutivo"));
                conceptos.setResolucionDIAN(resultSet.getString("ResolucionDIAN"));
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConceptosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + ConceptosDAO.class
                    .getName() + " Método Mostrar(object)\n"
                    + "Parametros: Campo = " + CampoFiltro + "; Valor = " + ValorFiltro + "; Tipo = " + TipoValorFiltro);
        }
        return conceptos;  
    }

    @Override
    public Object Eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Editar(Object object) {
        Conceptos var = (Conceptos) object;
        String QuerySQL = "UPDATE " + Constantes.TABLACONCEPTOS + " SET Codigo = ?, Descripcion = ?, Etiqueta = ?, NaturalezaDinero = ?, NaturalezaInventario = ?,ManejaConsecutivo = ?, Prefijo = ?, UltimoConsecutivo = ?, ResolucionDIAN = ?   WHERE(idConceptos = ?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";

        try (Connection connection = Conexion.conectar(); 
            PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getCodigo());
            preparedStatement.setString(2, var.getDescripcion());
            preparedStatement.setString(3, var.getEtiqueta());
            preparedStatement.setInt(4, var.getNaturalezaDinero());
            preparedStatement.setInt(5, var.getNaturalezaInventario());
            preparedStatement.setBoolean(6, var.isManejaConsecutivo());
            preparedStatement.setString(7, var.getPrefijo());
            preparedStatement.setInt(8, var.getUltimoConsecutivo());
            preparedStatement.setString(9, var.getResolucionDIAN());
            preparedStatement.setInt(10, var.getId());
            preparedStatement.execute();

            Rpta[1] = true;
        } catch (SQLException ex) {
            Logger.getLogger(ConceptosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Rpta;
    }

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
        String QuerySQL = "SELECT * FROM " + Constantes.TABLACONCEPTOS + " WHERE ((Descripcion like ?)|| (Codigo like ?) )";
        ResultSet resultSet;
        ArrayList<Object> Respuesta = new ArrayList<>();
        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, "%"+ String.valueOf(object) + "%");
            preparedStatement.setString(2, "%"+ String.valueOf(object) + "%");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Conceptos concepto = new Conceptos();
                concepto.setId(resultSet.getInt("idConceptos"));
                concepto.setCodigo(resultSet.getString("Codigo"));
                concepto.setDescripcion(resultSet.getString("Descripcion"));
                concepto.setEtiqueta(resultSet.getString("Etiqueta"));
                concepto.setNaturalezaDinero(resultSet.getInt("NaturalezaDinero"));
                concepto.setNaturalezaInventario(resultSet.getInt("NaturalezaInventario"));
                concepto.setManejaConsecutivo(resultSet.getBoolean("ManejaConsecutivo"));
                concepto.setPrefijo(resultSet.getString("Prefijo"));
                concepto.setUltimoConsecutivo(resultSet.getInt("UltimoConsecutivo"));
                concepto.setResolucionDIAN(resultSet.getString("ResolucionDIAN"));
                Respuesta.add(concepto);
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConceptosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + ConceptosDAO.class.getName() + " Método Mostrar(object)");
        }
        return Respuesta;
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
