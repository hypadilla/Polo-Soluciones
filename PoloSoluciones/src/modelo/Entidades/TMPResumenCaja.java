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
public class TMPResumenCaja {
    private String Conceptos;
    private double Totales;

    public TMPResumenCaja() {
    }

    public TMPResumenCaja(String Conceptos, double Totales) {
        this.Conceptos = Conceptos;
        this.Totales = Totales;
    }

    public double getTotales() {
        return Totales;
    }

    public void setTotales(double Totales) {
        this.Totales = Totales;
    }

    public String getConceptos() {
        return Conceptos;
    }

    public void setConceptos(String Conceptos) {
        this.Conceptos = Conceptos;
    }
}
