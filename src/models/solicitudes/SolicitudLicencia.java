package models.solicitudes;

import java.sql.Date;
import java.util.Calendar;

import models.usuarios.Estudiante;

public class SolicitudLicencia extends SolicitudBaja{
    private Date fechaSalida;
    private Date fechaRegreso;
    
    public SolicitudLicencia(Estudiante estudiante, String motivo,
            Date fechaSalida, Date fechaRegreso) {
        super(estudiante, motivo);
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
