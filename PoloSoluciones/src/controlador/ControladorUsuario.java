/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DAO.UsuarioDAO;
import modelo.Entidades.Usuarios;
import modelo.Interfaces.IUsuario;

/**
 *
 * @author cdap_
 */
public class ControladorUsuario implements IUsuario {
    UsuarioDAO var = new UsuarioDAO();
    /***
     * Retorna String si hay un error en controlador, ó boolean si hay error en la base de datos
     * @param object
     * @return 
     */
    @Override
    public Object Insertar(Object object) {
        Usuarios usuario = (Usuarios) object;
        Object[] Rpta = new Object[2];
        if (usuario.getUsuario().length()>10){
            Rpta[0]= "String";
            Rpta[1]= "El nombre de usuario es demasiado largo";
            return Rpta;
        }        
        
        if (usuario.getUsuario().length()<5){
            Rpta[0]= "String";
            Rpta[1]= "El nombre de usuario es demasiado corto";
            return Rpta;
        }
        
        if (usuario.getClave().length()>12){
            Rpta[0]= "String";
            Rpta[1]= "La contraseña es demasiado larga";
            return Rpta;
        }
        
        if (usuario.getClave().length()<8){
            Rpta[0]= "String";
            Rpta[1]= "La contraseña es demasiado corta";
            return Rpta;
        }      
        
        if (usuario.getCorreoElectronico().length()>100){
            Rpta[0]= "String";
            Rpta[1]= "El correo es demasiado Largo";
            return Rpta;
        }  
        
        if (usuario.getCorreoElectronico().length()>100){
            Rpta[0]= "String";
            Rpta[1]= "El correo es demasiado Largo";
            return Rpta;
        }   
        
        if (usuario.getPregunta().length()>50){
            Rpta[0]= "String";
            Rpta[1]= "La pregunta es demasiado larga";
            return Rpta;
        }      
        
        if (usuario.getRespuestaSecreta().length()>20){
            Rpta[0]= "String";
            Rpta[1]= "La respuesta es demasiado larga.";
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
