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
import modelo.Conexion;
import modelo.Entidades.Productos;
import modelo.Interfaces.IProductos;

/**
 *
 * @author hypadilla
 */
public class ProductoDAO implements IProductos{
    
    public boolean IfExist(String codigo) {
        boolean Rpta = false;
        PreparedStatement ps = null;
        Connection acceDB = null;
        String consultarSQL = "SELECT * from productos where (codigo=?)";
        try {
            acceDB = Conexion.conectar();
            ps = acceDB.prepareStatement(consultarSQL);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Rpta = true;
            } else {
                Rpta = false;
            }
            ps.close();
            acceDB.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ProductoDAO, método ifExist");
            e.printStackTrace();
            Rpta = false;
        }
        return Rpta;
    }
    @Override
    public Object Insertar(Object object) {
        Productos var = (Productos) object;
        Object[] Rpta = new Object[2];
        PreparedStatement ps = null;
        Connection acceDB = null;

        if (IfExist(var.getCodigo())) {
            Rpta[0] = "String";
            Rpta[1] = "El Codigo del producto ya existe";
        } else {
                
                    String registrarSQL = "INSERT INTO productos values (null,?,?,?,?,?,?,?,?,?)";

                try {
                    acceDB = Conexion.conectar();
                    ps = acceDB.prepareStatement(registrarSQL);
                    ps.setString(1, var.getCodigo());
                    ps.setString(2, var.getReferencia());
                    ps.setString(3, var.getDescripcion());
                    ps.setString(4, var.getRutaImagen());
                    ps.setDouble(5, var.getCostoNeto());
                    ps.setDouble(6, var.getCostoIva());
                    ps.setDouble(7, var.getVentaNeto());
                    ps.setDouble(8, var.getVentaIva());
                    ps.setDouble(9, var.getVentaUtilidad());
                    
                    ps.execute();
                    ps.close();
                    acceDB.close();
                    Rpta[0] = "Boolean";
                    Rpta[1] = true;
                } catch (SQLException e) {
                    System.out.println("Error: Clase ProductoDAO, método insertar");
                    e.printStackTrace();
                    Rpta[0] = "Boolean";
                    Rpta[1] = false;
                }
            }
            
        
                return Rpta ;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
