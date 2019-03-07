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
public class Facturacion {
    private int id;
    private int idConceptos;
    private int idTerceros;
    private int idUsuarios;
    private String Fecha;
    private int Consecutivo;
    private String Observacion;
    private double SubTotal;
    private double IVA;
    private double Descuento;
    private String FormaPago;
    private double Total;
    private int Estado;

    public Facturacion() {
    }

    public Facturacion(int id, int idConceptos, int idTerceros, int idUsuarios, String Fecha, int Consecutivo, String Observacion, double SubTotal, double IVA, double Descuento, String FormaPago, double Total, int Estado) {
        this.id = id;
        this.idConceptos = idConceptos;
        this.idTerceros = idTerceros;
        this.idUsuarios = idUsuarios;
        this.Fecha = Fecha;
        this.Consecutivo = Consecutivo;
        this.Observacion = Observacion;
        this.SubTotal = SubTotal;
        this.IVA = IVA;
        this.Descuento = Descuento;
        this.FormaPago = FormaPago;
        this.Total = Total;
        this.Estado = Estado;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConceptos() {
        return idConceptos;
    }

    public void setIdConceptos(int idConceptos) {
        this.idConceptos = idConceptos;
    }

    public int getIdTerceros() {
        return idTerceros;
    }

    public void setIdTerceros(int idTerceros) {
        this.idTerceros = idTerceros;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getConsecutivo() {
        return Consecutivo;
    }

    public void setConsecutivo(int Consecutivo) {
        this.Consecutivo = Consecutivo;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public String getFormaPago() {
        return FormaPago;
    }

    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
}
