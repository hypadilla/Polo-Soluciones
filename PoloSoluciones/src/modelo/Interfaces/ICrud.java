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
        public boolean Insertar(Object object);
        
        /***
         * 
         * @param object
         * @return 
         */
	public ArrayList<Object> Mostrar(Object object);	
	public void Eliminar(Object object);
        public boolean Editar(Object object);
        public ArrayList<Object> MostrarTodos();
}
