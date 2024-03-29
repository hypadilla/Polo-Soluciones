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
    private double cantidad;
    private double costoNeto;
    private double porcCostoIva;
    private double costoIva;
    private double ventaNeto;
    private double porcVentaIva;
    private double ventaIva;
    private double ventaUtilidad;
    private int idCategoria;
    private int idDepartamento;
    
    public Productos() {
    }

    public Productos(int id, String codigo, String referencia, String descripcion, String rutaImagen, double cantidad, double costoNeto, double porcCostoIva, double costoIva, double ventaNeto, double porcVentaIva, double ventaIva, double ventaUtilidad, int idCategoria, int idDepartamento) {
        this.id = id;
        this.codigo = codigo;
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.cantidad = cantidad;
        this.costoNeto = costoNeto;
        this.porcCostoIva = porcCostoIva;
        this.costoIva = costoIva;
        this.ventaNeto = ventaNeto;
        this.porcVentaIva = porcVentaIva;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoNeto() {
        return costoNeto;
    }

    public void setCostoNeto(double costoNeto) {
        this.costoNeto = costoNeto;
    }

    public double getPorcCostoIva() {
        return porcCostoIva;
    }

    public void setPorcCostoIva(double porcCostoIva) {
        this.porcCostoIva = porcCostoIva;
    }

    public double getCostoIva() {
        return costoIva;
    }

    public void setCostoIva(double costoIva) {
        this.costoIva = costoIva;
    }

    public double getVentaNeto() {
        return ventaNeto;
    }

    public void setVentaNeto(double ventaNeto) {
        this.ventaNeto = ventaNeto;
    }

    public double getPorcVentaIva() {
        return porcVentaIva;
    }

    public void setPorcVentaIva(double porcVentaIva) {
        this.porcVentaIva = porcVentaIva;
    }

    public double getVentaIva() {
        return ventaIva;
    }

    public void setVentaIva(double ventaIva) {
        this.ventaIva = ventaIva;
    }

    public double getVentaUtilidad() {
        return ventaUtilidad;
    }

    public void setVentaUtilidad(double ventaUtilidad) {
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
