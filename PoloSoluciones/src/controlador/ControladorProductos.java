/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.DAO.CategoriaDAO;
import modelo.DAO.ProductoDAO;
import modelo.Entidades.Productos;
import modelo.Interfaces.IProductos;
import src.Constantes;

/**
 *
 * @author hypadilla
 */
public class ControladorProductos implements IProductos{
    ProductoDAO var = new ProductoDAO();
    
    @Override
    public Object Insertar(Object object) {
        Productos var = (Productos) object;
        String QuerySQL = "INSERT INTO " + Constantes.TABLAPRODUCTOS + " VALUES (null,?,?,?,?,?,?,?,?,?)";
        Object[] Rpta = new Object[2];
        Rpta[0] = "Boolean";
        if (var.getCodigo().length()>50){
            Rpta[0]= "String";
            Rpta[1]= "El codigo del producto es demasiado largo";
            return Rpta;
        }
        if (var.getReferencia().length()>50){
            Rpta[0]= "String";
            Rpta[1]= "La referencia es demasiado larga";
            return Rpta;
        }
        if (var.getDescripcion().length()>200){
            Rpta[0]= "String";
            Rpta[1]= "La Descripción es demasiado larga";
            return Rpta;
        }
        if (var.getRutaImagen().length()>1000){
            Rpta[0]= "String";
            Rpta[1]= "La ruta de la imagen demasiado larga";
            return Rpta;
        }
        return var.Insertar(object);
        
        //Todo validar que el costo neto costo iva venta neta venta iva y % utilidad guarden logica entre si.
       
        
            
        }

        try (Connection connection = Conexion.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(QuerySQL)) {
            preparedStatement.setString(1, var.getCodigo());
            preparedStatement.setString(2, var.getReferencia());
            preparedStatement.setString(3, var.getDescripcion());
            preparedStatement.setString(4, var.getRutaImagen());
            preparedStatement.setDouble(5, var.getCostoNeto());
            preparedStatement.setDouble(6, var.getCostoIva());
            preparedStatement.setDouble(7, var.getVentaNeto());
            preparedStatement.setDouble(8, var.getVentaIva());
            preparedStatement.setDouble(9, var.getVentaUtilidad());
            preparedStatement.execute();

            Rpta[1] = true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Rpta;
        
        
        /*
        ProductoDAO var = new ProductoDAO();
        Object[] Rpta = new Object[2];
        Productos productos = (Productos) object;
        
        

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
        return var.Existe(object);
    }

    
}
