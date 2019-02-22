/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DAO.FacturacionDAO;
import modelo.Entidades.Facturacion;
import modelo.Interfaces.IFacturacion;

/**
 *
 * @author cdap_
 */
public class ControladorFacturacion implements IFacturacion {

    FacturacionDAO var = new FacturacionDAO();

    @Override
    public Object Insertar(Object object) {
        return var.Insertar(object);
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
//    return var.Existe(object);
    }

    @Override
    public Object RegistrarFactura(Object object, Object object2) {
       return var.RegistrarFactura(object, object2);
    }
}
