package models.solicitudes;


import java.util.Calendar;
import java.util.Date;


import util.Estado;

public abstract class SolicitudBaja extends Solicitud{
    protected Date fecha;


    public SolicitudBaja(String motivo) {
        super(motivo);
        
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
