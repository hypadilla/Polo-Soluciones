/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.DAO.ConceptosDAO;
import modelo.Entidades.Conceptos;
import modelo.Interfaces.IConceptos;

/**
 *
 * @author hypadilla
 */
public class ControladorConceptos implements IConceptos{
    ConceptosDAO var = new ConceptosDAO();
    @Override
    public Object Insertar(Object object) {
        ArrayList<String> Filtro = new ArrayList();  
        Conceptos conceptos = (Conceptos) object;
        Filtro.add("Codigo");
        Filtro.add(conceptos.getCodigo());
        Filtro.add("String"); 
        Object[] Rpta = new Object[2];
        Rpta[0]= "String";
        
        if (Existe(Filtro)) {            
            Rpta[1] = "El Departamento ya existe en la base de datos";
            return Rpta;
        }
        
        if (conceptos.getCodigo().length()>20){
            Rpta[1]= "El código del concepto es demasiado largo";
            return Rpta;
        }        
        
        if (conceptos.getDescripcion().length()>50){
            Rpta[1]= "La descripción es demasiado larga";
            return Rpta;
        }
        
        if (conceptos.getEtiqueta().length()>50){
            Rpta[1]= "El nombre de la etiqueta es demasiado larga.";
            return Rpta;
        }
        if (String.valueOf( conceptos.getNaturalezaDinero()).length()>11){
            Rpta[1]= "El id de la naturaleza del dinero es demasiado alto";
            return Rpta;
        }
        if (String.valueOf( conceptos.getNaturalezaInventario()).length()>11){
            Rpta[1]= "El id de la naturaleza del inventario es demasiado alto";
            return Rpta;
        }
        if (conceptos.getPrefijo().length()>5){
            Rpta[1]= "El prefijo es demasiado largo.";
            return Rpta;
        }
        if (String.valueOf( conceptos.getUltimoConsecutivo()).length()>11){
            Rpta[1]= "El ultimo consecutivo es demasiado largo";
            return Rpta;
        }
        if (conceptos.getResolucionDIAN().length()>200){
            Rpta[1]= "La resolución de la DIAN es demasiado larga.";
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
        Conceptos conceptos = (Conceptos) object;
        Filtro.add("Codigo");
        Filtro.add(conceptos.getCodigo());
        Filtro.add("String");

        
        if (conceptos.getCodigo().length()>20){
            Rpta[1]= "El código del concepto es demasiado largo";
            return Rpta;
        }        
        
        if (conceptos.getDescripcion().length()>50){
            Rpta[1]= "La descripción es demasiado larga";
            return Rpta;
        }
        
        if (conceptos.getEtiqueta().length()>50){
            Rpta[1]= "El nombre de la etiqueta es demasiado larga.";
            return Rpta;
        }
        if (String.valueOf( conceptos.getNaturalezaDinero()).length()>11){
            Rpta[1]= "El id de la naturaleza del dinero es demasiado alto";
            return Rpta;
        }
        if (String.valueOf( conceptos.getNaturalezaInventario()).length()>11){
            Rpta[1]= "El id de la naturaleza del inventario es demasiado alto";
            return Rpta;
        }
        if (conceptos.getPrefijo().length()>5){
            Rpta[1]= "El prefijo es demasiado largo.";
            return Rpta;
        }
        if (String.valueOf( conceptos.getUltimoConsecutivo()).length()>11){
            Rpta[1]= "El ultimo consecutivo es demasiado largo";
            return Rpta;
        }
        if (conceptos.getResolucionDIAN().length()>200){
            Rpta[1]= "La resolución de la DIAN es demasiado larga.";
            return Rpta;
        }
        return var.Editar(object);    }

    

    @Override
    public ArrayList<Object> MostrarTodos(Object object) {
        return var.MostrarTodos(object);
    }

    @Override
    public Boolean Existe(Object object) {
        return var.Existe(object);
    }
    
}
