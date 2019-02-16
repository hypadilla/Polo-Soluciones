/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DAO.ProductoDAO;
import modelo.DAO.TerceroDAO;
import modelo.Entidades.Productos;
import modelo.Interfaces.IProductos;

/**
 *
 * @author hypadilla
 */
public class ControladorProductos implements IProductos{
    ProductoDAO var = new ProductoDAO();
    
    @Override
    public Object Insertar(Object object) {
        ProductoDAO var = new ProductoDAO();
        Object[] Rpta = new Object[2];
        Productos productos = (Productos) object;
        if (productos.getCodigo().length()>50){
            Rpta[0]= "String";
            Rpta[1]= "El codigo del producto es demasiado largo";
            return Rpta;
        }
        if (productos.getReferencia().length()>50){
            Rpta[0]= "String";
            Rpta[1]= "La referencia del producto es demasiado larga";
            return Rpta;
        }
        if (productos.getDescripcion().length()>200){
            Rpta[0]= "String";
            Rpta[1]= "La descripcion es demasiado larga";
            return Rpta;
        }
        if (productos.getRutaImagen().length()>1000){
            Rpta[0]= "String";
            Rpta[1]= "La ruta de la imagen es demasiado larga";
            return Rpta;
        }       
        return var.Insertar(object);
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
