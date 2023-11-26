package models.solicitudes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import models.usuarios.Estudiante;
import util.MotivoLicencia;
import util.Motivos;

public class SolicitudLicencia extends Solicitud {

    private MotivoLicencia motivo;
    private Calendar fechaSalida;
    private Calendar fechaRegreso;

    public SolicitudLicencia(long id, MotivoLicencia motivo, Calendar fechaSalida, Calendar fechaRegreso) {
        super(id);
        this.motivo = motivo;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;

    }

    public MotivoLicencia getMotivo() {
        return motivo;
    }

    public Calendar getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Calendar fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}
