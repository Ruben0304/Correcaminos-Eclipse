package models.solicitudes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import models.usuarios.Estudiante;

public abstract class SolicitudLicencia extends SolicitudBaja{
    protected Calendar fechaSalida;
    protected Calendar fechaRegreso;
    
   
    public SolicitudLicencia(String motivo,Calendar fechaSalida, Calendar fechaRegreso) {
        super(motivo);
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        
        
    }

    public Calendar getFechaSalida() {
        return fechaSalida;
    }

    public Calendar getFechaRegreso() {
        return fechaRegreso;
    }

	public void setFechaSalida(Calendar fechaSalida) {
		if(fechaSalida != null)
			this.fechaSalida = fechaSalida;
		else
			throw new IllegalArgumentException("La fecha no es valida");
	}

	public void setFechaRegreso(Calendar fechaRegreso) {
		if(fechaRegreso != null)
			this.fechaRegreso = fechaRegreso;
		else
			throw new IllegalArgumentException("La fecha no es valida");
	}

    
    
    
}
