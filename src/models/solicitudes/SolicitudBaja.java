package models.solicitudes;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import models.usuarios.Estudiante;
import utiles.Estado;

public abstract class SolicitudBaja {
    protected Estado estado;
    protected String motivo;
    protected Calendar fecha;

    

    public SolicitudBaja(String motivo) {
        this.estado = Estado.PENDIENTE;
        this.motivo = motivo;
        this.fecha = new GregorianCalendar();
    }

    public Estado getEstado() {
        return estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

   
}
