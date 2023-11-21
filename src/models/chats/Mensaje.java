package models.chats;

import java.sql.Date;

public class Mensaje {
    private String nombreUsuario;
    private String contenido;
    private Date fecha;

    public Mensaje(String nombreUsuario, String contenido, Date fecha) {
        this.nombreUsuario = nombreUsuario;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContenido() {
        return contenido;
    }

    public Date getFecha() {
        return fecha;
    }

}
