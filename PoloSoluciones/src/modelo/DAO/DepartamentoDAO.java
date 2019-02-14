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
import modelo.Entidades.Departamentos;
import modelo.Interfaces.IDepartamentos;

/**
 *
 * @author hypadilla
 */
public class DepartamentoDAO implements IDepartamentos{
    public boolean IfExist(String codigo) {
        boolean Rpta = false;
        PreparedStatement ps = null;
        Connection acceDB = null;
        String consultarSQL = "SELECT codigo from departamentos where (codigo=?)";
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
            System.out.println("Error: Clase DepartamentoDAO, método ifExist");
            e.printStackTrace();
            Rpta = false;
        }
        return Rpta;
    }
    
    public boolean IfExistDepartamento(String departamento) {
        boolean Rpta = false;
        PreparedStatement ps = null;
        Connection acceDB = null;
        String consultarSQL = "SELECT departamento from departamentos where (departamento=?)";
        try {
            acceDB = Conexion.conectar();
            ps = acceDB.prepareStatement(consultarSQL);
            ps.setString(1, departamento);
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
            System.out.println("Error: Clase DepartamentoDAO, método ifExistDepartamento");
            e.printStackTrace();
            Rpta = false;
        }
        return Rpta;
    }
    @Override
    public Object Insertar(Object object) {
Departamentos   var = (Departamentos) object;
        Object[] Rpta = new Object[2];
        PreparedStatement ps = null;
        Connection acceDB = null;

        if (IfExist(var.getCodigo())) {
            Rpta[0] = "String";
            Rpta[1] = "El codigo de departamento ya existe";
        } else {
                if (IfExistDepartamento(var.getDepartamento())){
                    Rpta[0] = "String";
                    Rpta[1] = "El Nombre de departamento ya existe";
                }else{
                    String registrarSQL = "INSERT INTO departamentos values (null,?,?,?)";

                try {
                    acceDB = Conexion.conectar();
                    ps = acceDB.prepareStatement(registrarSQL);
                    ps.setString(1, var.getCodigo());
                    ps.setString(2, var.getDepartamento());
                    ps.setString(3, var.getDescripcion());
                    ps.execute();
                    ps.close();
                    acceDB.close();
                    Rpta[0] = "Boolean";
                    Rpta[1] = true;
                } catch (SQLException e) {
                    System.out.println("Error: Clase DepartamentoDAO, método insertar");
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
