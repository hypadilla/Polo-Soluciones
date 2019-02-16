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
public class Productos {
    private int id;
    private String codigo;
    private String referencia;
    private String descripcion;
    private String rutaImagen;
    private float costoNeto;
    private float costoIva;
    private float ventaNeto;
    private float ventaIva;
    private float ventaUtilidad;
    private int idCategoria;
    private int idDepartamento;

    public Productos() {
    }

    public Productos(int id, String codigo, String referencia, String descripcion, String rutaImagen, float costoNeto, float costoIva, float ventaNeto, float ventaIva, float ventaUtilidad, int idCategoria, int idDepartamento) {
        this.id = id;
        this.codigo = codigo;
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.costoNeto = costoNeto;
        this.costoIva = costoIva;
        this.ventaNeto = ventaNeto;
        this.ventaIva = ventaIva;
        this.ventaUtilidad = ventaUtilidad;
        this.idCategoria = idCategoria;
        this.idDepartamento = idDepartamento;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public float getCostoNeto() {
        return costoNeto;
    }

    public void setCostoNeto(float costoNeto) {
        this.costoNeto = costoNeto;
    }

    public float getCostoIva() {
        return costoIva;
    }

    public void setCostoIva(float costoIva) {
        this.costoIva = costoIva;
    }

    public float getVentaNeto() {
        return ventaNeto;
    }

    public void setVentaNeto(float ventaNeto) {
        this.ventaNeto = ventaNeto;
    }

    public float getVentaIva() {
        return ventaIva;
    }

    public void setVentaIva(float ventaIva) {
        this.ventaIva = ventaIva;
    }

    public float getVentaUtilidad() {
        return ventaUtilidad;
    }

    public void setVentaUtilidad(float ventaUtilidad) {
        this.ventaUtilidad = ventaUtilidad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    
}