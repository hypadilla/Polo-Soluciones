/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author cdap_
 */
public interface ICrud {
    
        /***    
         * Metodo genérico para insertar valores a una tabla.
         * el parametro object debe ser un objeto del tipo de datos que se va a insertar.
         * @param object
         * @return 
         */    
        public Object Insertar(Object object);
        
        /***
         * 
         * @param object
         * @return 
         */
	public ArrayList<Object> MostrarTodos(Object object);	
	public Object Eliminar(Object object);
        public Object Editar(Object object);
        public Object Mostrar(Object object);
        public Boolean Existe(Object object);
}
