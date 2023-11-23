package models.solicitudes;

import java.sql.Date;

import models.usuarios.Empleado;
import util.Estado;

public class SolicitudLicenciaEmpleado extends SolicitudLicencia {
	
	private Empleado empleado;

	public SolicitudLicenciaEmpleado(String motivo, Date fechaSalida, Date fechaRegreso, Empleado empleado) {
		super( motivo);
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}
	
	
}
