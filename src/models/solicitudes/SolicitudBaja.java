package models.solicitudes;


import java.util.Calendar;
import java.util.Date;


import util.Estado;

public abstract class SolicitudBaja extends Solicitud{
    protected Date fecha;


    public SolicitudBaja(Estado estado, String motivo, Date fecha) {
        super(motivo);
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

      public int getAnioExpedicion() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar.get(Calendar.YEAR);
    }

   
}
