/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DAO.ProductoDAO;
import modelo.Entidades.Productos;
import modelo.Interfaces.IProductos;

/**
 *
 * @author hypadilla
 */
public class ControladorProductos implements IProductos {

    ProductoDAO var = new ProductoDAO();

    @Override
    public Object Insertar(Object object) {

        ArrayList<String> Filtro = new ArrayList();
        Object[] Rpta = new Object[2];
        Productos productos = (Productos) object;
        Filtro.add("Codigo");
        Filtro.add(productos.getCodigo());
        Filtro.add("String");

        if (Existe(Filtro)) {
            Rpta[0] = "String";
            Rpta[1] = "El Producto ya existe en la base de datos";
            return Rpta;
        }

        if (productos.getCodigo().length() > 50) {
            Rpta[0] = "String";
            Rpta[1] = "El codigo del producto es demasiado largo";
            return Rpta;
        }
        if (productos.getReferencia().length() > 50) {
            Rpta[0] = "String";
            Rpta[1] = "La referencia es demasiado larga";
            return Rpta;
        }
        if (productos.getDescripcion().length() > 200) {
            Rpta[0] = "String";
            Rpta[1] = "La Descripción es demasiado larga";
            return Rpta;
        }
        if (productos.getRutaImagen().length() > 1000) {
            Rpta[0] = "String";
            Rpta[1] = "La ruta de la imagen demasiado larga";
            return Rpta;
        }
        return var.Insertar(object);

        //Todo validar que el costo neto costo iva venta neta venta iva y % utilidad guarden logica entre si.
    }

    @Override
    public Object Mostrar(Object object) {
        return var.Mostrar(object);
    }

    @Override
    public Object Eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Editar(Object object) {
        ArrayList<String> Filtro = new ArrayList();
        Object[] Rpta = new Object[2];
        Productos productos = (Productos) object;
        Filtro.add("Codigo");
        Filtro.add(productos.getCodigo());
        Filtro.add("String");
        if (!Existe(Filtro)) {
            Rpta[0] = "String";
            Rpta[1] = "El Producto no existe en la base de datos";
            return Rpta;
        } else {
            if (productos.getCodigo().length() > 50) {
                Rpta[0] = "String";
                Rpta[1] = "El codigo del producto es demasiado largo";
                return Rpta;
            }
            if (productos.getReferencia().length() > 50) {
                Rpta[0] = "String";
                Rpta[1] = "La referencia es demasiado larga";
                return Rpta;
            }
            if (productos.getDescripcion().length() > 200) {
                Rpta[0] = "String";
                Rpta[1] = "La Descripción es demasiado larga";
                return Rpta;
            }
            if (productos.getRutaImagen().length() > 1000) {
                Rpta[0] = "String";
                Rpta[1] = "La ruta de la imagen demasiado larga";
                return Rpta;
            }
            return var.Editar(object);
        }
    }

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
        return var.MostrarTodos(object);
    }

    @Override
    public Boolean Existe(Object object) {
        return var.Existe(object);
    }

}
