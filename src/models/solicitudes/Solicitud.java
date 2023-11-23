package models.solicitudes;

import java.util.Calendar;
import java.util.Date;

import util.Estado;
import util.Motivos;

public abstract class Solicitud {
    protected Estado estado;
    protected Motivos motivo;
    protected Date fecha;

    public Solicitud(Motivos motivo) {
        this.estado = Estado.PENDIENTE;
        this.motivo = motivo;
        Calendar fechaActual = Calendar.getInstance();
        fecha = fechaActual.getTime();
    }

    public Estado getEstado() {
        return estado;
    }

    public Motivos getMotivo() {
        return motivo;
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
