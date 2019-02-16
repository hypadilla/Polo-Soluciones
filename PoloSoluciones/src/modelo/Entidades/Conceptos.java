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
public class Conceptos {
    private String codigo;
    private String descripcion;
    private String etiqueta;
    private int naturalezaDinero;
    private int naturalezaInventario;
    private boolean manejaConsecutivo;
    private String prefijo;
    private int ultimoConsecutivo;
    private String resolucionDIAN;

    public Conceptos() {
    }

    public Conceptos(String codigo, String descripcion, String etiqueta, int naturalezaDinero, int naturalezaInventario, boolean manejaConsecutivo, String prefijo, int ultimoConsecutivo, String resolucionDIAN) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.etiqueta = etiqueta;
        this.naturalezaDinero = naturalezaDinero;
        this.naturalezaInventario = naturalezaInventario;
        this.manejaConsecutivo = manejaConsecutivo;
        this.prefijo = prefijo;
        this.ultimoConsecutivo = ultimoConsecutivo;
        this.resolucionDIAN = resolucionDIAN;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getNaturalezaDinero() {
        return naturalezaDinero;
    }

    public void setNaturalezaDinero(int naturalezaDinero) {
        this.naturalezaDinero = naturalezaDinero;
    }

    public int getNaturalezaInventario() {
        return naturalezaInventario;
    }

    public void setNaturalezaInventario(int naturalezaInventario) {
        this.naturalezaInventario = naturalezaInventario;
    }

    public boolean isManejaConsecutivo() {
        return manejaConsecutivo;
    }

    public void setManejaConsecutivo(boolean manejaConsecutivo) {
        this.manejaConsecutivo = manejaConsecutivo;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public int getUltimoConsecutivo() {
        return ultimoConsecutivo;
    }

    public void setUltimoConsecutivo(int ultimoConsecutivo) {
        this.ultimoConsecutivo = ultimoConsecutivo;
    }

    public String getResolucionDIAN() {
        return resolucionDIAN;
    }

    public void setResolucionDIAN(String resolucionDIAN) {
        this.resolucionDIAN = resolucionDIAN;
    }
    
    
    
}
