package models.solicitudes;

import models.usuarios.Empleado;

public class SolicitudBajaEmpleado extends SolicitudBaja {
	
	private Empleado empleado;
	
	public SolicitudBajaEmpleado(String motivo, Empleado empleado) {
		super(motivo);
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

}
