/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Entidades;

import java.util.Date;

/**
 *
 * @author hypadilla
 */
public class TMPDetalleCuadreCaja {
    private int idFactura;
    private int idConceptos;
    private int idTerceros;
    private Date Fecha;
    private String FormaPago;
    private String Descripcion;
    private int NaturalezaDinero;
    private String Nombre;
    private double Totales;

    public TMPDetalleCuadreCaja() {
    }

    public TMPDetalleCuadreCaja(int idFactura, int idConceptos, int idTerceros, Date Fecha, String FormaPago, String Descripcion, int NaturalezaDinero, String Nombre, double Totales) {
        this.idFactura = idFactura;
        this.idConceptos = idConceptos;
        this.idTerceros = idTerceros;
        this.Fecha = Fecha;
        this.FormaPago = FormaPago;
        this.Descripcion = Descripcion;
        this.NaturalezaDinero = NaturalezaDinero;
        this.Nombre = Nombre;
        this.Totales = Totales;
    }

    public double getTotales() {
        return Totales;
    }

    public void setTotales(double Totales) {
        this.Totales = Totales;
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

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
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
}
