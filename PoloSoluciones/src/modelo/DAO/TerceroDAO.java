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
import modelo.Entidades.Terceros;
import modelo.Entidades.Usuarios;
import modelo.Interfaces.ITerceros;
import src.Constantes;

/**
 *
 * @author hypadilla
 */
public class TerceroDAO implements ITerceros {
    
    public boolean IfExist(String documento) {
        boolean Rpta = false;
        PreparedStatement ps = null;
        Connection acceDB = null;
        String consultarSQL = "SELECT documento from terceros where (documento=?)";
        try {
            acceDB = Conexion.conectar();
            ps = acceDB.prepareStatement(consultarSQL);
            ps.setString(1, documento);
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
            System.out.println("Error: Clase TerceroDAO, método ifExist");
            e.printStackTrace();
            Rpta = false;
        }
        return Rpta;
    }

    @Override
    public Object Insertar(Object object) {
        Terceros var = (Terceros) object;
        Object[] Rpta = new Object[2];
        PreparedStatement ps = null;
        Connection acceDB = null;

        if (IfExist(var.getDocumento())) {
            Rpta[0] = "String";
            Rpta[1] = "El documento del tercero ya existe";
        } else {
                
                    String registrarSQL = "INSERT INTO terceros values (null,?,?,?,?,?,?)";

                try {
                    acceDB = Conexion.conectar();
                    ps = acceDB.prepareStatement(registrarSQL);
                    ps.setString(1, var.getTipoTercero());
                    ps.setString(2, var.getDocumento());
                    ps.setString(3, var.getNombre());
                    ps.setString(4, var.getDireccion());
                    ps.setString(5, var.getCorreo());
                    ps.setString(6, var.getTelefono());
                    ps.execute();
                    ps.close();
                    acceDB.close();
                    Rpta[0] = "Boolean";
                    Rpta[1] = true;
                } catch (SQLException e) {
                    System.out.println("Error: Clase TerceroDAO, método insertar");
                    e.printStackTrace();
                    Rpta[0] = "Boolean";
                    Rpta[1] = false;
                }
            }
            
        
                return Rpta ;
        /*
        Terceros var = (Terceros) object;
        Object[] Rpta = new Object[2];
        PreparedStatement ps = null;
        Connection acceDB = null;
        String registrarSQL = "INSERT INTO " + Constantes.TERCEROS + " values (?,?,?,?,?,?)";
        try {
            acceDB = Conexion.conectar();
            ps = acceDB.prepareStatement(registrarSQL);
            ps.setString(1, var.getTipoTercero());
            ps.setString(2, var.getDocumento());
            ps.setString(3, var.getNombre());
            ps.setString(4, var.getDireccion());
            ps.setString(5, var.getCorreo());
            ps.setString(6, var.getTelefono());
            ps.execute();
            ps.close();
            acceDB.close();
            Rpta[0] = "Boolean";
            Rpta[1] = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase TerceroDAO, método insertar");
            e.printStackTrace();
            Rpta[0] = "Boolean";
            Rpta[1] = false;
        }
        return Rpta;
        */
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
    public ArrayList<Object> MostrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
