package models.solicitudes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import models.usuarios.Estudiante;

public abstract class SolicitudLicencia extends SolicitudBaja{
    protected Date fechaSalida;
    protected Date fechaRegreso;
    
   
    public SolicitudLicencia(String motivo,Date fechaSalida, Date fechaRegreso) {
        super(motivo);
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        
        
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
