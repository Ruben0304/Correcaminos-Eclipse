package models.solicitudes;

import java.sql.Date;

import models.usuarios.Empleado;

public class SolicitudLicenciaEmpleado extends SolicitudLicencia {
	
	private Empleado empleado;

	public SolicitudLicenciaEmpleado(String motivo, Date fechaSalida, Date fechaRegreso, Empleado empleado) {
		super(motivo, fechaSalida, fechaRegreso);
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}
	
	
}
