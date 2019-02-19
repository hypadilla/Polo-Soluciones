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
        ArrayList<String> Filtro = new ArrayList();
        Object[] Rpta = new Object[2];
        Facturacion facturacion = (Facturacion) object;
        Filtro.add("Consecutivo");
        Filtro.add("" + facturacion.getConsecutivo());
        Filtro.add("int");
        /*
        if (Existe(Filtro)) {
            Rpta[0] = "String";
            Rpta[1] = "El Producto ya existe en la base de datos";
            return Rpta;
        }
        /*
        /*
        if (facturacion.getCodigo().length() > 50) {
            Rpta[0] = "String";
            Rpta[1] = "El codigo del producto es demasiado largo";
            return Rpta;
        }
        if (facturacion.getReferencia().length() > 50) {
            Rpta[0] = "String";
            Rpta[1] = "La referencia es demasiado larga";
            return Rpta;
        }
        if (facturacion.getDescripcion().length() > 200) {
            Rpta[0] = "String";
            Rpta[1] = "La Descripción es demasiado larga";
            return Rpta;
        }
        if (facturacion.getRutaImagen().length() > 1000) {
            Rpta[0] = "String";
            Rpta[1] = "La ruta de la imagen demasiado larga";
            return Rpta;
        }
         */
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
}
