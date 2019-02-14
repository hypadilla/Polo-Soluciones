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
import modelo.Entidades.Categorias;

import modelo.Interfaces.ICategorias;

/**
 *
 * @author hypadilla
 */
public class CategoriaDAO implements ICategorias {

    public boolean IfExist(String codigo) {
        boolean Rpta = false;
        PreparedStatement ps = null;
        Connection acceDB = null;
        String consultarSQL = "SELECT codigo from categorias where (codigo=?)";
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
            System.out.println("Error: Clase CategoriaDAO, método ifExist");
            e.printStackTrace();
            Rpta = false;
        }
        return Rpta;
    }
    
    public boolean IfExistCategoria(String categoria) {
        boolean Rpta = false;
        PreparedStatement ps = null;
        Connection acceDB = null;
        String consultarSQL = "SELECT categoria from categorias where (categoria=?)";
        try {
            acceDB = Conexion.conectar();
            ps = acceDB.prepareStatement(consultarSQL);
            ps.setString(1, categoria);
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
            System.out.println("Error: Clase CategoriaDAO, método ifExistCategoria");
            e.printStackTrace();
            Rpta = false;
        }
        return Rpta;
    }

    @Override
    public Object Insertar(Object object) {
        Categorias var = (Categorias) object;
        Object[] Rpta = new Object[2];
        PreparedStatement ps = null;
        Connection acceDB = null;

        if (IfExist(var.getCodigo())) {
            Rpta[0] = "String";
            Rpta[1] = "El codigo de categoria ya existe";
        } else {
                if (IfExistCategoria(var.getCategoria())){
                    Rpta[0] = "String";
                    Rpta[1] = "El Nombre de categoria ya existe";
                }else{
                    String registrarSQL = "INSERT INTO categorias values (null,?,?,?)";

                try {
                    acceDB = Conexion.conectar();
                    ps = acceDB.prepareStatement(registrarSQL);
                    ps.setString(1, var.getCodigo());
                    ps.setString(2, var.getCategoria());
                    ps.setString(3, var.getDescripcion());
                    ps.execute();
                    ps.close();
                    acceDB.close();
                    Rpta[0] = "Boolean";
                    Rpta[1] = true;
                } catch (SQLException e) {
                    System.out.println("Error: Clase CategoriaDAO, método insertar");
                    e.printStackTrace();
                    Rpta[0] = "Boolean";
                    Rpta[1] = false;
                }
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
    public ArrayList<Object> MostrarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
    
        

