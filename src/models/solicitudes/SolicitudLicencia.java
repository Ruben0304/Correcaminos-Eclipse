package models.solicitudes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import models.usuarios.Estudiante;
import util.Motivos;

public abstract class SolicitudLicencia extends Solicitud {

    protected Date fechaRegreso;

    public SolicitudLicencia(Motivos motivo) {
        super(motivo);
        fechaRegreso = null;

    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

}
