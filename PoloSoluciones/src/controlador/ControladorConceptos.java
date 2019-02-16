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
        Conceptos conceptos = (Conceptos) object;
        Object[] Rpta = new Object[2];
        Rpta[0]= "String";
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
        
        
        ArrayList<String> Parametros = new ArrayList<>();
        Parametros.add("Conceptos");
        Parametros.add(conceptos.getCodigo());
        Parametros.add("String");
        if (Existe(Parametros)) {
            Rpta[1]= "Este concepto ya existe.";
            return Rpta;
        }else{
            return var.Insertar(object);
        }
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
    public ArrayList<Object> MostrarTodos(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean Existe(Object object) {
        return var.Existe(object);
    }
    
}
