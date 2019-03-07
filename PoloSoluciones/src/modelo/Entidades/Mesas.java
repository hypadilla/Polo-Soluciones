/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Entidades;

/**
 *
 * @author hypadilla
 */
public class Mesas {
    private int id;
    private String Mesa;
    private String Descripcion;

    public Mesas() {
    }

    public Mesas(int id, String Mesa, String Descripcion) {
        this.id = id;
        this.Mesa = Mesa;
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMesa() {
        return Mesa;
    }

    public void setMesa(String Mesa) {
        this.Mesa = Mesa;
    }
    
    
}
