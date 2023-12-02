package models.chats;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Mensaje {
    private String emisor;
    private String contenido;
    private Calendar fecha;

    public Mensaje(String nombreUsuario, String contenido) {
        this.emisor = nombreUsuario;
        this.contenido = contenido;
        this.fecha = new GregorianCalendar();
    }

    public String getEmisor() {
        return emisor;
    }

    public String getContenido() {
        return contenido;
    }

    public Calendar getFecha() {
        return fecha;
    }

}
