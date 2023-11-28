package models.chats;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Mensaje {
    private String nombreUsuario;
    private String contenido;
    private Calendar fecha;

    public Mensaje(String nombreUsuario, String contenido) {
        this.nombreUsuario = nombreUsuario;
        this.contenido = contenido;
        this.fecha = new GregorianCalendar();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContenido() {
        return contenido;
    }

    public Calendar getFecha() {
        return fecha;
    }

}
