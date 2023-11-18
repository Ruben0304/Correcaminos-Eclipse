package models.solicitudes;


import java.util.Calendar;
import java.util.Date;


import util.Estado;

public abstract class SolicitudBaja {
    protected Estado estado;
    protected String motivo;
    protected Date fecha;

    

    public SolicitudBaja(String motivo) {
        this.estado = Estado.PENDIENTE;
        this.motivo = motivo;
        this.fecha = new Date();
    }

    public Estado getEstado() {
        return estado;
    }

    public String getMotivo() {
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
