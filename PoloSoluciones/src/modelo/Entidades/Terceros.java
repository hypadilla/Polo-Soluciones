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
public class Terceros {
    int IdTerceros;
    String TipoTercero;
    String Documento;
    String Nombre;
    String Direccion;
    String Correo;
    String Telefono;

    public Terceros() {
    }

    public Terceros(int IdTerceros, String TipoTercero, String Documento, String Nombre, String Direccion, String Correo, String Telefono) {
        this.IdTerceros = IdTerceros;
        this.TipoTercero = TipoTercero;
        this.Documento = Documento;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public int getIdTerceros() {
        return IdTerceros;
    }

    public void setIdTerceros(int IdTerceros) {
        this.IdTerceros = IdTerceros;
    }

    public String getTipoTercero() {
        return TipoTercero;
    }

    public void setTipoTercero(String TipoTercero) {
        this.TipoTercero = TipoTercero;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
