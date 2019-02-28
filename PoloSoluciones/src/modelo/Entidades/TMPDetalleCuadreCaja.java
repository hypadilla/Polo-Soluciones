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
public class TMPDetalleCuadreCaja {
    private int idFactura;
    private int idConceptos;
    private int idTerceros;
    private String Fecha;
    private String FormaPago;
    private String Descripcion;
    private int NaturalezaDinero;
    private String Nombre;
    private double Totales;
    private int Consecutivo;

    public TMPDetalleCuadreCaja() {
    }

    public TMPDetalleCuadreCaja(int idFactura, int idConceptos, int idTerceros, String Fecha, String FormaPago, String Descripcion, int NaturalezaDinero, String Nombre, double Totales, int Consecutivo) {
        this.idFactura = idFactura;
        this.idConceptos = idConceptos;
        this.idTerceros = idTerceros;
        this.Fecha = Fecha;
        this.FormaPago = FormaPago;
        this.Descripcion = Descripcion;
        this.NaturalezaDinero = NaturalezaDinero;
        this.Nombre = Nombre;
        this.Totales = Totales;
        this.Consecutivo = Consecutivo;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
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

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getFormaPago() {
        return FormaPago;
    }

    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getNaturalezaDinero() {
        return NaturalezaDinero;
    }

    public void setNaturalezaDinero(int NaturalezaDinero) {
        this.NaturalezaDinero = NaturalezaDinero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getTotales() {
        return Totales;
    }

    public void setTotales(double Totales) {
        this.Totales = Totales;
    }

    public int getConsecutivo() {
        return Consecutivo;
    }

    public void setConsecutivo(int Consecutivo) {
        this.Consecutivo = Consecutivo;
    }
    
    
}
