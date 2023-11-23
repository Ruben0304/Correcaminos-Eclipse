package models.solicitudes;

import java.util.Date;

import models.usuarios.Empleado;
import util.Estado;

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
