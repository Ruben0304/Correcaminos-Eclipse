package models.solicitudes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import models.usuarios.Estudiante;
import util.Estado;

public abstract class SolicitudLicencia extends Solicitud {
    protected Date fechaSalida;
    protected Date fechaRegreso;

    public SolicitudLicencia(String motivo) {
        super(motivo);
        // this.fechaSalida = fechaSalida;
        // this.fechaRegreso = fechaRegreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public int getAnioExpedicion() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaSalida);
        return calendar.get(Calendar.YEAR);
    }

}
