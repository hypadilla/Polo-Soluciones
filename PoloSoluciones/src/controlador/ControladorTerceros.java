/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DAO.TerceroDAO;
import modelo.Entidades.Terceros;
import modelo.Interfaces.ITerceros;

/**
 *
 * @author hypadilla
 */
public class ControladorTerceros implements ITerceros {

    TerceroDAO var = new TerceroDAO();

    @Override
    public Object Insertar(Object object) {
        ArrayList<String> Filtro = new ArrayList();
        Object[] Rpta = new Object[2];
        Terceros terceros = (Terceros) object;
        Filtro.add("Documento");
        Filtro.add(terceros.getDocumento());
        Filtro.add("String");
        if(Existe(Filtro)) {
            Rpta[0] = "String";
                Rpta[1] = "El Tercero ya existe en la base de datos";
                return Rpta;
        } else {
            
            if (terceros.getTipoTercero().length() > 30) {
                Rpta[0] = "String";
                Rpta[1] = "El nombre del tipo de tercero es demasiado largo";
                return Rpta;
            }
            if (terceros.getDocumento().length() > 20) {
                Rpta[0] = "String";
                Rpta[1] = "El documento es demasiado largo";
                return Rpta;
            }

            if (terceros.getNombre().length() > 100) {
                Rpta[0] = "String";
                Rpta[1] = "El nombre  es demasiado largo";
                return Rpta;
            }
            if (terceros.getDireccion().length() > 100) {
                Rpta[0] = "String";
                Rpta[1] = "La direccion es demasiado larga";
                return Rpta;
            }
            if (terceros.getCorreo().length() > 100) {
                Rpta[0] = "String";
                Rpta[1] = "El correo es demasiado largo";
                return Rpta;
            }

            if (terceros.getTelefono().length() > 15) {
                Rpta[0] = "String";
                Rpta[1] = "El telefono es demasiado largo";
                return Rpta;
            }
            return var.Insertar(object);
        }

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
        Terceros terceros = (Terceros) object;
        Filtro.add("Documento");
        Filtro.add(terceros.getDocumento());
        Filtro.add("String");
        if(!Existe(Filtro)) {
            Rpta[0] = "String";
                Rpta[1] = "El Tercero no existe en la base de datos";
                return Rpta;
        } else {
            
            if (terceros.getTipoTercero().length() > 30) {
                Rpta[0] = "String";
                Rpta[1] = "El nombre del tipo de tercero es demasiado largo";
                return Rpta;
            }
            if (terceros.getDocumento().length() > 20) {
                Rpta[0] = "String";
                Rpta[1] = "El documento es demasiado largo";
                return Rpta;
            }

            if (terceros.getNombre().length() > 100) {
                Rpta[0] = "String";
                Rpta[1] = "El nombre  es demasiado largo";
                return Rpta;
            }
            if (terceros.getDireccion().length() > 100) {
                Rpta[0] = "String";
                Rpta[1] = "La direccion es demasiado larga";
                return Rpta;
            }
            if (terceros.getCorreo().length() > 100) {
                Rpta[0] = "String";
                Rpta[1] = "El correo es demasiado largo";
                return Rpta;
            }

            if (terceros.getTelefono().length() > 15) {
                Rpta[0] = "String";
                Rpta[1] = "El telefono es demasiado largo";
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
