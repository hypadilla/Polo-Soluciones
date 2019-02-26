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
                facturacion.setFecha(resultSet.getString("consecutivo"));
                facturacion.setFecha(resultSet.getString("observacion"));
                facturacion.setFecha(resultSet.getString("subTotal"));
                facturacion.setFecha(resultSet.getString("iva"));
                facturacion.setFecha(resultSet.getString("formaPago"));
                facturacion.setFecha(resultSet.getString("total"));
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
        String QuerySQL = "INSERT INTO " + Constantes.TABLAFACTURACION + " VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)";
        String QueryFacturacionDetalle = "INSERT INTO " + Constantes.TABLADETALLEFACTURACION + " VALUES (NULL,?,?,?,?,?,?)";
        String QuerySelectConceptos = "SELECT * FROM " + Constantes.TABLACONCEPTOS + "WHERE idConceptos = ?";
        String QueryUpdateConceptos = "UPDATE " + Constantes.TABLACONCEPTOS + " SET Codigo = ?,Descripción = ?,Etiqueta = ?,NaturalezaDinero = ?,NaturalezaInventario =? ,ManejaConsecutivo = ?,Prefijo = ?,UltimoConsecutivo = ?, ResolucionDIAN = ? WHERE idConceptos = ?";
        String QuerySelectFacturacion = "SELECT * FROM " + Constantes.TABLAFACTURACION + "WHERE idConceptos = ? ORDER BY Consecutivo DESC";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementDetalle = null;
        PreparedStatement preparedStatementSelectConceptos = null;
        PreparedStatement preparedStatementUpdateConceptos = null;
        PreparedStatement preparedStatementSelectFacturacion = null;
        Savepoint saveObj = null;
        Connection connection = Conexion.conectar();

        try {
            connection.setAutoCommit(false);
            saveObj = connection.setSavepoint();

            preparedStatementSelectConceptos.setInt(1, facturacion.getIdConceptos());
            ResultSet resultSetSelectConceptos = preparedStatementSelectConceptos.executeQuery(QuerySelectConceptos);
            Conceptos conceptos = null;
            if (resultSetSelectConceptos.next()) {
                conceptos = new Conceptos();
                conceptos.setId(resultSetSelectConceptos.getInt("IdConceptos"));
                conceptos.setUltimoConsecutivo(resultSetSelectConceptos.getInt("UltimoConsecutivo"));
                conceptos.setManejaConsecutivo(resultSetSelectConceptos.getBoolean("ManejaConsecutivo"));
                conceptos.setNaturalezaDinero(resultSetSelectConceptos.getInt("NaturalezaDinero"));
                conceptos.setNaturalezaInventario(resultSetSelectConceptos.getInt("NaturalezaInventario"));
            }

            preparedStatement = connection.prepareStatement(QuerySQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, facturacion.getIdConceptos());
            preparedStatement.setInt(2, facturacion.getIdTerceros());
            preparedStatement.setInt(3, facturacion.getIdUsuarios());
            //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
            //Date date;
            //date = sdf1.parse(var.getFecha());
            java.util.Date d = new java.util.Date();
            java.sql.Date date2 = new java.sql.Date(d.getTime());
            preparedStatement.setDate(4, date2);

            if (conceptos.isManejaConsecutivo()) {
                int Consecutivo = 0;
                preparedStatementSelectFacturacion.setInt(1, facturacion.getIdConceptos());
                preparedStatementSelectFacturacion = connection.prepareStatement(QuerySelectFacturacion);
                ResultSet resultSet = preparedStatement.executeQuery();
                Facturacion facturacionTMP = null;
                if (resultSet.next()) {
                    facturacionTMP = new Facturacion();
                    facturacionTMP.setId(resultSet.getInt("idFacturacion"));
                    facturacionTMP.setIdConceptos(resultSet.getInt("idConcepto"));
                    facturacionTMP.setIdTerceros(resultSet.getInt("idTercero"));
                    facturacionTMP.setIdUsuarios(resultSet.getInt("idUsuario"));
                    facturacionTMP.setFecha(resultSet.getString("fecha"));
                    facturacionTMP.setFecha(resultSet.getString("consecutivo"));
                    facturacionTMP.setFecha(resultSet.getString("observacion"));
                    facturacionTMP.setFecha(resultSet.getString("subTotal"));
                    facturacionTMP.setFecha(resultSet.getString("iva"));
                    facturacionTMP.setFecha(resultSet.getString("formaPago"));
                    facturacionTMP.setFecha(resultSet.getString("total"));
                }
                if (facturacionTMP == null) {
                    
                }else{
                    preparedStatement.setInt(5, facturacionTMP.getConsecutivo()+1);
                }
            } else {
                preparedStatement.setInt(5, facturacion.getConsecutivo());
            }

            preparedStatement.setString(6, facturacion.getObservacion());
            preparedStatement.setDouble(7, facturacion.getSubTotal());
            preparedStatement.setDouble(8, facturacion.getIVA());
            preparedStatement.setDouble(9, facturacion.getDescuento());
            preparedStatement.setString(10, facturacion.getFormaPago());
            preparedStatement.setDouble(11, facturacion.getTotal());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int llave = 0;
            if (rs != null && rs.next()) {
                llave = rs.getInt(1);
            }

            ArrayList<FacturacionDetalle> detalleFactura;
            detalleFactura = (ArrayList<FacturacionDetalle>) obj.get(1);
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
    public Object MostrarTodoEnCaja(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object MostrarResumenEnCaja(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
