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
public class ControladorCategoria implements ICategorias{
    CategoriaDAO var = new CategoriaDAO();
    @Override
    public Object Insertar(Object object) {
        Categorias categoria = (Categorias) object;
        Object[] Rpta = new Object[2];
        Rpta[0]= "String";
        if (categoria.getCategoria().length()>50){
            Rpta[1]= "El nombre de la categoria es demasiado largo";
            return Rpta;
        }        
        
        if (categoria.getDescripcion().length()>100){
            Rpta[1]= "El nombre de la descripción es demasiado largo";
            return Rpta;
        }
        
        if (categoria.getCodigo().length()>20){
            Rpta[1]= "El código de la cotegoria es demasiado largo.";
            return Rpta;
        }
        
        ArrayList<String> Parametros = new ArrayList<>();
        Parametros.add("Codigo");
        Parametros.add(categoria.getCodigo());
        Parametros.add("String");
        if (Existe(Parametros)) {
            Rpta[1]= "Esta categoría ya existe.";
            return Rpta;
        }else{
            return var.Insertar(object);
        }
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
       return var.Existe(object);
    }
}
