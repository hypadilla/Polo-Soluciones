/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DAO.DepartamentoDAO;
import modelo.Entidades.Departamentos;
import modelo.Interfaces.IDepartamentos;

/**
 *
 * @author hypadilla
 */
public class ControladorDepartamentos implements IDepartamentos {

    DepartamentoDAO var = new DepartamentoDAO();

    @Override
    public Object Insertar(Object object) {
        ArrayList<String> Filtro = new ArrayList();
        Object[] Rpta = new Object[2];
        Departamentos departamentos = (Departamentos) object;
        Filtro.add("Codigo");
        Filtro.add(departamentos.getCodigo());
        Filtro.add("String");

        if (Existe(Filtro)) {
            Rpta[0] = "String";
            Rpta[1] = "El Departamento ya existe en la base de datos";
            return Rpta;
        }

        if (departamentos.getDepartamento().length() > 50) {
            Rpta[0] = "String";
            Rpta[1] = "El nombre del departamento es demasiado largo";
            return Rpta;
        }

        if (departamentos.getDescripcion().length() > 100) {
            Rpta[0] = "String";
            Rpta[1] = "La descripción es demasiado larga";
            return Rpta;
        }

        if (departamentos.getCodigo().length() > 20) {
            Rpta[0] = "String";
            Rpta[1] = "El código del departamento es demasiado largo.";
            return Rpta;
        }
        return var.Insertar(object);
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
        Departamentos departamentos = (Departamentos) object;
        Filtro.add("Codigo");
        Filtro.add(departamentos.getCodigo());
        Filtro.add("String");

        
        if (departamentos.getDepartamento().length() > 50) {
            Rpta[0] = "String";
            Rpta[1] = "El nombre del departamento es demasiado largo";
            return Rpta;
        }

        if (departamentos.getDescripcion().length() > 100) {
            Rpta[0] = "String";
            Rpta[1] = "La descripción es demasiado larga";
            return Rpta;
        }

        if (departamentos.getCodigo().length() > 20) {
            Rpta[0] = "String";
            Rpta[1] = "El código del departamento es demasiado largo.";
            return Rpta;
        }
        return var.Editar(object);
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
