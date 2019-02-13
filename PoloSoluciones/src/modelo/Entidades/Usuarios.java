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
public class Usuarios {
    int Id;
    String Usuario;
    String Clave;
    String CorreoElectronico;
    String Pregunta;
    String RespuestaSecreta;

    public Usuarios() {
    }

    public Usuarios( String Usuario, String Clave, String CorreoElectronico, String Pregunta, String RespuestaSecreta) {
        
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.CorreoElectronico = CorreoElectronico;
        this.Pregunta = Pregunta;
        this.RespuestaSecreta = RespuestaSecreta;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    public String getRespuestaSecreta() {
        return RespuestaSecreta;
    }

    public void setRespuestaSecreta(String RespuestaSecreta) {
        this.RespuestaSecreta = RespuestaSecreta;
    }
    
}
