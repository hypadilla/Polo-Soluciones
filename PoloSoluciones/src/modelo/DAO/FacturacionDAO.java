/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Entidades.Categorias;
import modelo.Entidades.Conceptos;
import modelo.Entidades.DetalleFacturacion;
import modelo.Entidades.Facturacion;
import modelo.Entidades.FacturacionDetalle;
import modelo.Entidades.Productos;
import modelo.Interfaces.IFacturacion;
import src.Constantes;

/**
 *
 * @author cdap_
 */
public class FacturacionDAO implements IFacturacion {

    @Override
    public Object RegistrarFactura(Object object, Object object2) {

        Facturacion var = (Facturacion) object;
        String QuerySQL = "INSERT INTO " + Constantes.TABLAFACTURACION + " VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)";
        String QueryFacturacionDetalle = "INSERT INTO " + Constantes.TABLADETALLEFACTURACION + " VALUES (NULL,?,?,?,?,?,?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementDetalle = null;
        Savepoint saveObj = null;
        Connection connection = Conexion.conectar();

        try {
            connection.setAutoCommit(false);
            saveObj = connection.setSavepoint();
            preparedStatement = connection.prepareStatement(QuerySQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, var.getIdConceptos());
            preparedStatement.setInt(2, var.getIdTerceros());
            preparedStatement.setInt(3, var.getIdUsuarios());
            //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
            //Date date;
            //date = sdf1.parse(var.getFecha());
            java.util.Date d = new java.util.Date();
            java.sql.Date date2 = new java.sql.Date(d.getTime());
            preparedStatement.setDate(4, date2);
            preparedStatement.setInt(5, var.getConsecutivo());
            preparedStatement.setString(6, var.getObservacion());
            preparedStatement.setDouble(7, var.getSubTotal());
            preparedStatement.setDouble(8, var.getIVA());
            preparedStatement.setDouble(9, var.getDescuento());
            preparedStatement.setString(10, var.getFormaPago());
            preparedStatement.setDouble(11, var.getTotal());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int llave = 0;
            if (rs != null && rs.next()) {
                llave = rs.getInt(1);
            }

            ArrayList<FacturacionDetalle> detalleFactura = new ArrayList();
            detalleFactura = (ArrayList<FacturacionDetalle>) object2;
            for (Object item : detalleFactura) {

                DetalleFacturacion var2 = (DetalleFacturacion) item;
                preparedStatementDetalle = connection.prepareStatement(QueryFacturacionDetalle);
                preparedStatementDetalle.setInt(1, llave);
                preparedStatementDetalle.setInt(2, var2.getIdProducto());
                preparedStatementDetalle.setDouble(3, var2.getCantidad());
                preparedStatementDetalle.setDouble(4, var2.getVrProducto());
                preparedStatementDetalle.setDouble(5, var2.getVrIVA());
                preparedStatementDetalle.setDouble(6, var2.getVrDescuento());
                preparedStatementDetalle.execute();

            }

            Rpta[1] = true;
            connection.commit();
        } catch (Exception sqlException) {
            Rpta[1] = false;
            sqlException.printStackTrace();
            try {
                connection.rollback(saveObj);
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                connection.setAutoCommit(true);
            } catch (Exception sqlException) {
                sqlException.printStackTrace();
            }
        }
        return Rpta;

    }

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
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
    public Object Mostrar(Object object) {
        /**
         * *
         * Resolviendo necesidad puntual de Insertar
         */
        ArrayList<String> ListaVariables = (ArrayList<String>) object;
        String CampoFiltro = ListaVariables.get(0);
        String ValorFiltro = ListaVariables.get(1);
        String TipoValorFiltro = ListaVariables.get(2);
        String QuerySQL = "SELECT * FROM " + Constantes.TABLAFACTURACION + " WHERE " + CampoFiltro + " = ? ORDER BY Consecutivo DESC";
        Facturacion facturacion = new Facturacion();

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
                facturacion.setId(resultSet.getInt("idFacturacion"));
                facturacion.setIdConceptos(resultSet.getInt("idConcepto"));
                facturacion.setIdTerceros(resultSet.getInt("idTercero"));
                facturacion.setIdUsuarios(resultSet.getInt("idUsuario"));
                facturacion.setFecha(resultSet.getString("fecha"));
                facturacion.setConsecutivo(resultSet.getInt("consecutivo"));
                facturacion.setObservacion(resultSet.getString("observacion"));
                facturacion.setSubTotal(resultSet.getDouble("subTotal"));
                facturacion.setIVA(resultSet.getDouble("iva"));
                facturacion.setFormaPago(resultSet.getString("formaPago"));
                facturacion.setTotal(resultSet.getDouble("total"));
            }
            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(FacturacionDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al consultar en " + FacturacionDAO.class
                    .getName() + " Método Mostrar(object)\n"
                    + "Parametros: Campo = " + CampoFiltro + "; Valor = " + ValorFiltro + "; Tipo = " + TipoValorFiltro);
        }
        return facturacion;
    }

    @Override
    public Boolean Existe(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Insertar(Object object) {
        ArrayList<Object> obj = (ArrayList<Object>) object;
        Facturacion facturacion = (Facturacion) obj.get(0);
        String QuerySQL = "INSERT INTO " + Constantes.TABLAFACTURACION + " VALUES (NULL,?,?,?,?,?,?,?,?,?,?)";
        String QueryUpdateProductos = "UPDATE " + Constantes.TABLAPRODUCTOS + " SET Cantidad = ? WHERE idProductos = ?";
        String QueryFacturacionDetalle = "INSERT INTO " + Constantes.TABLADETALLEFACTURACION + " VALUES (NULL,?,?,?,?,?,?)";
        String QuerySelectConceptos = "SELECT * FROM " + Constantes.TABLACONCEPTOS + " WHERE idConceptos = ?";
        String QuerySelectProductos = "SELECT * FROM " + Constantes.TABLAPRODUCTOS + " WHERE idProductos = ?";
        String QuerySelectFacturacion = "SELECT * FROM " + Constantes.TABLAFACTURACION + " WHERE idConcepto = ? ORDER BY Consecutivo DESC";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";
        PreparedStatement preparedStatementInsertFacturacion = null;
        PreparedStatement preparedStatementInsertDetalleFacturacion = null;
        PreparedStatement preparedStatementSelectConceptos = null;
        PreparedStatement preparedStatementSelectFacturacion = null;
        PreparedStatement preparedStatementSelectProducto = null;
        PreparedStatement preparedStatementUpdateProductos = null;
        Savepoint saveObj = null;
        Connection connection = Conexion.conectar();

        try {
            connection.setAutoCommit(false);
            saveObj = connection.setSavepoint();

            //Consulta el  Concepto
            preparedStatementSelectConceptos = connection.prepareStatement(QuerySelectConceptos);
            preparedStatementSelectConceptos.setInt(1, facturacion.getIdConceptos());

            ResultSet resultSetSelectConceptos = preparedStatementSelectConceptos.executeQuery();
            Conceptos conceptos = null;
            if (resultSetSelectConceptos.next()) {
                conceptos = new Conceptos();
                conceptos.setId(resultSetSelectConceptos.getInt("IdConceptos"));
                conceptos.setUltimoConsecutivo(resultSetSelectConceptos.getInt("UltimoConsecutivo"));
                conceptos.setManejaConsecutivo(resultSetSelectConceptos.getBoolean("ManejaConsecutivo"));
                conceptos.setNaturalezaDinero(resultSetSelectConceptos.getInt("NaturalezaDinero"));
                conceptos.setNaturalezaInventario(resultSetSelectConceptos.getInt("NaturalezaInventario"));
            }
            //Fin Consulta Concepto

            //Registro de Factura I
            preparedStatementInsertFacturacion = connection.prepareStatement(QuerySQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatementInsertFacturacion.setInt(1, facturacion.getIdConceptos());
            preparedStatementInsertFacturacion.setInt(2, facturacion.getIdTerceros());
            preparedStatementInsertFacturacion.setInt(3, facturacion.getIdUsuarios());
            //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
            //Date date;
            //date = sdf1.parse(var.getFecha());
            java.util.Date d = new java.util.Date();
            java.sql.Date date2 = new java.sql.Date(d.getTime());
            preparedStatementInsertFacturacion.setDate(4, date2);
            //Fin Registro de Factura I

            //Inicio de Consulta ultimo Consecutivo
            if (conceptos.isManejaConsecutivo()) {
                preparedStatementSelectFacturacion = connection.prepareStatement(QuerySelectFacturacion);
                preparedStatementSelectFacturacion.setInt(1, facturacion.getIdConceptos());
                
                ResultSet resultSet = preparedStatementSelectFacturacion.executeQuery();
                Facturacion facturacionTMP = null;
                if (resultSet.next()) {
                    facturacionTMP = new Facturacion();
                    facturacionTMP.setConsecutivo(resultSet.getInt("consecutivo"));
                }
                if (facturacionTMP == null) {
                    preparedStatementInsertFacturacion.setInt(5, conceptos.getUltimoConsecutivo() + 1);
                } else {
                    preparedStatementInsertFacturacion.setInt(5, facturacionTMP.getConsecutivo() + 1);
                }
            } else {
                preparedStatementInsertFacturacion.setInt(5, facturacion.getConsecutivo());
            }
            //Fin Consulta ultimo Consecutivo

            //Registro de Factura II
            preparedStatementInsertFacturacion.setString(6, facturacion.getObservacion());
            preparedStatementInsertFacturacion.setDouble(7, facturacion.getSubTotal());
            preparedStatementInsertFacturacion.setDouble(8, facturacion.getIVA());
            //preparedStatementInsertFacturacion.setDouble(9, facturacion.getDescuento());
            preparedStatementInsertFacturacion.setString(9, facturacion.getFormaPago());
            preparedStatementInsertFacturacion.setDouble(10, facturacion.getTotal());

            preparedStatementInsertFacturacion.executeUpdate();
            ResultSet rs = preparedStatementInsertFacturacion.getGeneratedKeys();
            int llave = 0;
            if (rs != null && rs.next()) {
                llave = rs.getInt(1);
            }
            //Fin de Factura II

            ArrayList<FacturacionDetalle> detalleFactura;
            detalleFactura = (ArrayList<FacturacionDetalle>) obj.get(1);
            for (Object item : detalleFactura) {

                DetalleFacturacion detalleFacturacion = (DetalleFacturacion) item;
                preparedStatementInsertDetalleFacturacion = connection.prepareStatement(QueryFacturacionDetalle);
                preparedStatementInsertDetalleFacturacion.setInt(1, llave);
                preparedStatementInsertDetalleFacturacion.setInt(2, detalleFacturacion.getIdProducto());
                preparedStatementInsertDetalleFacturacion.setDouble(3, detalleFacturacion.getCantidad());
                preparedStatementInsertDetalleFacturacion.setDouble(4, detalleFacturacion.getVrProducto());
                preparedStatementInsertDetalleFacturacion.setDouble(5, detalleFacturacion.getVrIVA());
                preparedStatementInsertDetalleFacturacion.setDouble(6, detalleFacturacion.getVrDescuento());
                preparedStatementInsertDetalleFacturacion.execute();

                if (conceptos.getNaturalezaInventario() != 3) {
                    //Consultar cantidad del producto
                    preparedStatementSelectProducto = connection.prepareStatement(QuerySelectProductos);
                    preparedStatementSelectProducto.setInt(1, detalleFacturacion.getIdProducto());
                    ResultSet resultSet = preparedStatementSelectProducto.executeQuery();
                    Productos productoTMP = null;
                    if (resultSet.next()) {
                        productoTMP = new Productos();
                        productoTMP.setCantidad(resultSet.getDouble("Cantidad"));
                    }
                    //Fin consulta de prodcuto

                    preparedStatementUpdateProductos = connection.prepareStatement(QueryUpdateProductos);

                    if (conceptos.getNaturalezaInventario() == 1) { // Entrada de producto
                        preparedStatementUpdateProductos.setDouble(1, detalleFacturacion.getCantidad() + productoTMP.getCantidad());
                    } else if (conceptos.getNaturalezaInventario() == 2) {//Sale Cantidad
                        preparedStatementUpdateProductos.setDouble(1, productoTMP.getCantidad() - detalleFacturacion.getCantidad());
                    }
                    preparedStatementUpdateProductos.setInt(2, detalleFacturacion.getIdProducto());
                    preparedStatementUpdateProductos.execute();
                }

            }

            Rpta[1] = true;
            connection.commit();
        } catch (Exception sqlException) {
            Rpta[1] = false;
            sqlException.printStackTrace();
            try {
                connection.rollback(saveObj);
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        } finally {
            try {
                if (preparedStatementInsertFacturacion != null) {
                    preparedStatementInsertFacturacion.close();
                }

                connection.setAutoCommit(true);
            } catch (Exception sqlException) {
                sqlException.printStackTrace();
            }
        }
        return Rpta;

    }

    @Override
    public Object MostrarTodoEnCaja(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object MostrarResumenEnCaja(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
