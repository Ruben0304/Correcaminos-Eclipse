package models.solicitudes;

import models.usuarios.Empleado;

public class SolicitudLicenciaEmpleado extends SolicitudLicencia {
	
	private Empleado empleado;

	public SolicitudLicenciaEmpleado(String motivo, String fechaSalida, String fechaRegreso, Empleado empleado) {
		super(motivo, fechaSalida, fechaRegreso);
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}
	
	
}
