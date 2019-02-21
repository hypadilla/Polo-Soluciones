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
import modelo.Entidades.Productos;
import modelo.Interfaces.IProductos;
import src.Constantes;

/**
 *
 * @author hypadilla
 */
public class ProductoDAO implements IProductos {

    @Override
    public Object Insertar(Object object) {
        Productos var = (Productos) object;
        String QuerySQL = "INSERT INTO " + Constantes.TABLAPRODUCTOS + " VALUES (NULL,?,?,?,?,?,?,?,?,?,?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";

        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getCodigo());
            preparedStatement.setString(2, var.getReferencia());
            preparedStatement.setString(3, var.getDescripcion());
            preparedStatement.setString(4, var.getRutaImagen());
            preparedStatement.setDouble(5, var.getCantidad());//cantidad
            preparedStatement.setDouble(6, var.getCostoNeto());
            preparedStatement.setDouble(7, var.getPorcCostoIva());
            preparedStatement.setDouble(8, var.getVentaNeto());
            preparedStatement.setDouble(9, var.getPorcVentaIva());
            preparedStatement.setDouble(10, var.getVentaUtilidad());
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
        String QuerySQL = "SELECT * FROM " + Constantes.TABLAPRODUCTOS + " WHERE " + CampoFiltro + " = ?";
        Productos producto = new Productos();

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
                producto.setId(resultSet.getInt("idProductos"));
                producto.setCodigo(resultSet.getString("Codigo"));
                producto.setReferencia(resultSet.getString("Referencia"));
                producto.setDescripcion(resultSet.getString("Descripcion"));
                producto.setRutaImagen(resultSet.getString("RutaImagen"));
                producto.setCantidad(resultSet.getDouble("Cantidad"));
                producto.setCostoNeto(resultSet.getDouble("CostoNeto"));
                producto.setPorcCostoIva(resultSet.getDouble("PorcCostoIVA"));
                producto.setVentaNeto(resultSet.getDouble("VentaNeto"));
                producto.setPorcVentaIva(resultSet.getDouble("PorcVentaIVA"));
                producto.setVentaUtilidad(resultSet.getDouble("VentaUtilidad"));
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + ProductoDAO.class
                    .getName() + " Método Mostrar(object)\n"
                    + "Parametros: Campo = " + CampoFiltro + "; Valor = " + ValorFiltro + "; Tipo = " + TipoValorFiltro);
        }
        return producto;
    }

    @Override
    public Object Eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Editar(Object object) {
        Productos var = (Productos) object;
        String QuerySQL = "UPDATE " + Constantes.TABLAPRODUCTOS + " SET Referencia = ?, Descripcion = ?, RutaImagen = ?,Cantidad = ?, CostoNeto = ?, PorcCostoIVA = ?, VentaNeto = ?, PorcVentaIVA = ?, VentaUtilidad = ?  WHERE Codigo = ?";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";

        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getReferencia());
            preparedStatement.setString(2, var.getDescripcion());
            preparedStatement.setString(3, var.getRutaImagen());
            preparedStatement.setDouble(4, var.getCantidad());
            preparedStatement.setDouble(5, var.getCostoNeto());
            preparedStatement.setDouble(6, var.getPorcCostoIva());
            preparedStatement.setDouble(7, var.getVentaNeto());
            preparedStatement.setDouble(8, var.getPorcVentaIva());
            preparedStatement.setDouble(9, var.getVentaUtilidad());
            preparedStatement.execute();

            Rpta[1] = true;
        } catch (SQLException ex) {
            Logger.getLogger(TerceroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Rpta;
    }

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
        String QuerySQL = "SELECT * FROM Productos WHERE ((Codigo like ?)|| (Referencia like ?)|| (Descripcion like ?) )";
        ResultSet resultSet;
        ArrayList<Object> Respuesta = new ArrayList<>();
        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, "%" + String.valueOf(object) + "%");
            preparedStatement.setString(2, "%" + String.valueOf(object) + "%");
            preparedStatement.setString(3, "%" + String.valueOf(object) + "%");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Productos productos = new Productos();
                productos.setId(resultSet.getInt("idProductos"));
                productos.setCodigo(resultSet.getString("Codigo"));
                productos.setReferencia(resultSet.getString("Referencia"));
                productos.setDescripcion(resultSet.getString("Descripcion"));
                productos.setRutaImagen(resultSet.getString("RutaImagen"));
                productos.setCantidad(resultSet.getDouble("Cantidad"));
                productos.setCostoNeto(resultSet.getDouble("CostoNeto"));
                productos.setCostoIva(resultSet.getDouble("PorcCostoIva"));
                productos.setVentaNeto(resultSet.getDouble("VentaNeto"));
                productos.setVentaIva(resultSet.getDouble("PorcVentaIva"));
                productos.setVentaUtilidad(resultSet.getDouble("VentaUtilidad"));
                Respuesta.add(productos);
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
        String QuerySQL = "SELECT * FROM " + Constantes.TABLAPRODUCTOS + " WHERE " + CampoFiltro + " = ?";
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
