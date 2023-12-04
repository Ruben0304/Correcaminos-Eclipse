package models.solicitudes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import util.Estado;
import util.Motivos;

public abstract class Solicitud {
    protected long id;
    protected Estado estado;
    protected Calendar fechaDePeticion;


    public Solicitud(long id) {
        this.estado = Estado.PENDIENTE;
        this.fechaDePeticion = new GregorianCalendar();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getAnioExpedicion() {
        return 2023;
    }

    public int getMesExpedicion() {
        return fechaDePeticion.get(Calendar.MONTH);
    }

    public long getId() {
        return id;
    }

    public Calendar getFechaDePeticion() {
        return fechaDePeticion;
    }

    

    

}
