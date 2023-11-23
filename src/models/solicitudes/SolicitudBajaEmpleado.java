package models.solicitudes;

import java.util.Date;

import models.usuarios.Empleado;
import util.Estado;

public class SolicitudBajaEmpleado extends SolicitudBaja {
	
	private Empleado empleado;
	
	public SolicitudBajaEmpleado(Estado estado, String motivo, Date fecha, Empleado empleado) {
		super(estado, motivo, fecha);
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

}
