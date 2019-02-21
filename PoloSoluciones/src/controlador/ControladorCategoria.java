/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DAO.CategoriaDAO;
import modelo.Entidades.Categorias;
import modelo.Interfaces.ICategorias;

/**
 *
 * @author hypadilla
 */
public class ControladorCategoria implements ICategorias {

    CategoriaDAO var = new CategoriaDAO();

    @Override
    public Object Insertar(Object object) {
        ArrayList<String> Filtro = new ArrayList();
        Object[] Rpta = new Object[2];
        Categorias categoria = (Categorias) object;
        Filtro.add("Categoria");
        Filtro.add(categoria.getCodigo());
        Filtro.add("String");
        Rpta[0] = "String";

        if (Existe(Filtro)) {
            Rpta[0] = "String";
            Rpta[1] = "La Categoría ya existe en la base de datos";
            return Rpta;
        }
        if (categoria.getCategoria().length() > 50) {
            Rpta[1] = "El nombre de la categoria es demasiado largo";
            return Rpta;
        }

        if (categoria.getDescripcion().length() > 100) {
            Rpta[1] = "El nombre de la descripción es demasiado largo";
            return Rpta;
        }

        if (categoria.getCodigo().length() > 20) {
            Rpta[1] = "El código de la cotegoria es demasiado largo.";
            return Rpta;
        }
        return var.Insertar(object);
    }

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
        return var.MostrarTodos(object);
    }

    @Override
    public Object Eliminar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Editar(Object object) {
ArrayList<String> Filtro = new ArrayList();
        Object[] Rpta = new Object[2];
        Categorias categorias = (Categorias) object;
        Filtro.add("Codigo");
        Filtro.add(categorias.getCodigo());
        Filtro.add("String");

        
        if (categorias.getCategoria().length() > 50) {
            Rpta[0] = "String";
            Rpta[1] = "El nombre de la categoria es demasiado largo";
            return Rpta;
        }

        if (categorias.getDescripcion().length() > 100) {
            Rpta[0] = "String";
            Rpta[1] = "La descripción es demasiado larga";
            return Rpta;
        }

        if (categorias.getCodigo().length() > 20) {
            Rpta[0] = "String";
            Rpta[1] = "El código de la categoria es demasiado largo.";
            return Rpta;
        }
        return var.Editar(object);
    }

    @Override
    public Object Mostrar(Object object) {
        return var.Mostrar(object);
    }

    @Override
    public Boolean Existe(Object object) {
        return var.Existe(object);
    }
}
