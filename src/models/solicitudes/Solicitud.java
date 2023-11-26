package models.solicitudes;


import java.util.Calendar;
import java.util.GregorianCalendar;

import util.Estado;

public abstract class Solicitud {
    protected Estado estado;
    protected String motivo;
    protected Calendar fecha;

    

    public Solicitud(String motivo) {
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


      public int getAnioExpedicion() {
        return fecha.get(Calendar.YEAR);
        
    }

   
}
