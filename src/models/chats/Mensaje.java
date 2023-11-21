package models.chats;

import java.util.Date;
import java.util.Calendar;

public class Mensaje {
    private String nombreUsuario;
    private String contenido;
    private Date fecha;

    public Mensaje(String nombreUsuario, String contenido) {
        this.nombreUsuario = nombreUsuario;
        this.contenido = contenido;
        Calendar calendario = Calendar.getInstance(); 
        this.fecha = calendario.getTime();
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
