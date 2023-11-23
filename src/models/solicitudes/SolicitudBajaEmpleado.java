package models.solicitudes;

import models.usuarios.Empleado;
import util.Motivos;

public class SolicitudBajaEmpleado extends SolicitudBaja {
	
	private Empleado empleado;
	
	public SolicitudBajaEmpleado(Motivos motivo, Empleado empleado) {
		super(motivo);
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

}
