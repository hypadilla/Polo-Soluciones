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
public class DetalleFacturacion {
    int id;
    int idFacturacion;
    int idProducto;
    double Cantidad;
    double VrProducto;
    double VrIVA;
    double VrDescuento;

    public DetalleFacturacion() {
    }

    public DetalleFacturacion(int id, int idFacturacion, int idProducto, double Cantidad, double VrProducto, double VrIVA, double VrDescuento) {
        this.id = id;
        this.idFacturacion = idFacturacion;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.VrProducto = VrProducto;
        this.VrIVA = VrIVA;
        this.VrDescuento = VrDescuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFacturacion() {
        return idFacturacion;
    }

    public void setIdFacturacion(int idFacturacion) {
        this.idFacturacion = idFacturacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getVrProducto() {
        return VrProducto;
    }

    public void setVrProducto(double VrProducto) {
        this.VrProducto = VrProducto;
    }

    public double getVrIVA() {
        return VrIVA;
    }

    public void setVrIVA(double VrIVA) {
        this.VrIVA = VrIVA;
    }

    public double getVrDescuento() {
        return VrDescuento;
    }

    public void setVrDescuento(double VrDescuento) {
        this.VrDescuento = VrDescuento;
    }
    
    
}
