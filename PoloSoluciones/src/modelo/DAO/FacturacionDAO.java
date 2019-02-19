/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Entidades.Facturacion;
import modelo.Interfaces.IFacturacion;
import src.Constantes;

/**
 *
 * @author cdap_
 */
public class FacturacionDAO implements IFacturacion {

    @Override
    public Object Insertar(Object object) {
        Facturacion var = (Facturacion) object;
        String QuerySQL = "INSERT INTO " + Constantes.TABLAFACTURACION + " VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";
        PreparedStatement preparedStatement = null;
        Savepoint saveObj = null;
        Connection connection = null;

        try {
            connection.setAutoCommit(false);
            saveObj = connection.setSavepoint();
            preparedStatement = connection.prepareStatement(QuerySQL);
            preparedStatement.setInt(1, var.getIdConceptos());
            preparedStatement.setInt(2, var.getIdTerceros());
            preparedStatement.setInt(3, var.getIdUsuarios());
            preparedStatement.setDate(4, var.getFecha());
            preparedStatement.setInt(5, var.getConsecutivo());
            preparedStatement.setString(6, var.getObservacion());
            preparedStatement.setDouble(7, var.getSubTotal());
            preparedStatement.setDouble(8, var.getIVA());
            preparedStatement.setDouble(9, var.getDescuento());
            preparedStatement.setString(10, var.getFormaPago());
            preparedStatement.setDouble(11, var.getTotal());
            preparedStatement.executeUpdate();           
            
            
            Rpta[1] = "true";
            connection.commit();
        } catch (Exception sqlException) {
            Rpta[1]="false";
            JOptionPane.showMessageDialog(null, "Error al registrar factura, intentando rollback...");
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

}
