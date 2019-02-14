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
public class Departamentos {
    private int id;
    private String codigo;
    private String departamento;
    private String descripcion;

    public Departamentos() {
    }

    public Departamentos(int id, String codigo, String departamento, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.departamento = departamento;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
