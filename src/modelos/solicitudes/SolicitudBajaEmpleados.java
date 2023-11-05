package modelos.solicitudes;

import modelos.usuarios.Docente;
import modelos.usuarios.Empleado;
import modelos.usuarios.NoDocente;
import utiles.Estado;
import java.util.Date;

public class SolicitudBajaEmpleados {
    protected Empleado empleado;
    protected Estado estado;
    protected String motivo;
    protected String fechaDeLaSolicitud;
    
    public SolicitudBajaEmpleados(Docente docente, String motivo) {
    	this.empleado = docente;
    	this.estado = Estado.PENDIENTE;
    	this.motivo = motivo;
    	Date fechaActual = new Date();
    	this.fechaDeLaSolicitud = fechaActual.toString();
    }
    
    public SolicitudBajaEmpleados(NoDocente noDocente, String motivo) {
    	this.empleado = noDocente;
    	this.estado = Estado.PENDIENTE;
    	this.motivo = motivo;
    	Date fechaActual = new Date();
    	this.fechaDeLaSolicitud = fechaActual.toString();
    }

	public Empleado getEmpleado() {
		return empleado;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getFechaDeLaSolicitud() {
		return fechaDeLaSolicitud;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
    
    
    
    
}
