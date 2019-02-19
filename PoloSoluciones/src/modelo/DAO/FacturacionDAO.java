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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;
import modelo.Conexion;
import modelo.Entidades.Facturacion;
import modelo.Entidades.FacturacionDetalle;
import modelo.Entidades.Productos;
import modelo.Entidades.Terceros;
import modelo.Interfaces.IFacturacion;
import src.Constantes;

/**
 *
 * @author cdap_
 */
public class FacturacionDAO implements IFacturacion {

    public Object RegistrarFactura(Object object, Object object2) {
        Facturacion var = (Facturacion) object;
        String QuerySQL = "INSERT INTO " + Constantes.TABLAFACTURACION + " VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)";
        //String QueryFacturacionDetalle = "INSERT INTO " + Constantes.TABLADETALLEFACTURACION + " VALUES (NULL,?,?,?,?,?,?)";
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
                JOptionPane.showMessageDialog(null, "La llave es:" + llave);
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo obtener la llave");
            }
            /*
            ArrayList<FacturacionDetalle> detalleFactura = new ArrayList();
            detalleFactura = (ArrayList<FacturacionDetalle>) object2;
            for (Object item : detalleFactura) {
                
                FacturacionDetalle var2 = (FacturacionDetalle) item;
                preparedStatementDetalle = connection.prepareStatement(QueryFacturacionDetalle);
                preparedStatementDetalle.setInt(1, llave);
                preparedStatementDetalle.setInt(2, var2.getIdProducto());
                preparedStatementDetalle.setDouble(3, var2.getCantidad());
                preparedStatementDetalle.setDouble(4, var2.getVrProducto());
                preparedStatementDetalle.setDouble(5, var2.getVrIVA());
                preparedStatementDetalle.setDouble(6, var2.getVrDescuento());
                preparedStatementDetalle.executeUpdate();

            }
            */
            Rpta[1] = true;
            connection.commit();
        } catch (Exception sqlException) {
            Rpta[1] = false;
            JOptionPane.showMessageDialog(null, "Error al registrar factura, intentando rollback...");
            sqlException.printStackTrace();
            try {
                connection.rollback(saveObj);
                JOptionPane.showMessageDialog(null, "rollback exitoso");
            } catch (SQLException sqlEx) {
                JOptionPane.showMessageDialog(null, "rollback fallido");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean Existe(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Insertar(Object object) {
        
        return RegistrarFactura(object, object);
        
    }

}
