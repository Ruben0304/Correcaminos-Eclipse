package models.solicitudes;

import java.util.Calendar;
import java.util.Date;

import util.Estado;
import util.Motivos;

public abstract class SolicitudBaja extends Solicitud {

    public SolicitudBaja(Motivos motivo) {
        super(motivo);

    }

    public Estado getEstado() {
        return estado;
    }

    public Motivos getMotivo() {
        return motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getAnioExpedicion() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar.get(Calendar.YEAR);
    }

}
