package models.solicitudes;

import java.util.Calendar;

import models.usuarios.Empleado;

public class SolicitudLicenciaEmpleado extends SolicitudLicencia {
	
	private Empleado empleado;

	public SolicitudLicenciaEmpleado(String motivo, Calendar fechaSalida, Calendar fechaRegreso, Empleado empleado) {
		super(motivo, fechaSalida, fechaRegreso);
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}
	
	
}
