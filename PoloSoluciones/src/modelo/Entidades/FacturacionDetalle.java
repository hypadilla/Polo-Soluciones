/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Entidades;

/**
 *
 * @author cdap_
 */
public class FacturacionDetalle {
    private int id;
    private int idFactura;
    private int idProducto;
    private double cantidad;
    private double vrProducto;
    private double vrIVA;
    private double vrDescuento;

    public FacturacionDetalle() {
    }

    public FacturacionDetalle(int id, int idFactura, int idProducto, double cantidad, double vrProducto, double vrIVA, double vrDescuento) {
        this.id = id;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.vrProducto = vrProducto;
        this.vrIVA = vrIVA;
        this.vrDescuento = vrDescuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getVrProducto() {
        return vrProducto;
    }

    public void setVrProducto(double vrProducto) {
        this.vrProducto = vrProducto;
    }

    public double getVrIVA() {
        return vrIVA;
    }

    public void setVrIVA(double vrIVA) {
        this.vrIVA = vrIVA;
    }

    public double getVrDescuento() {
        return vrDescuento;
    }

    public void setVrDescuento(double vrDescuento) {
        this.vrDescuento = vrDescuento;
    }
    
    
}
