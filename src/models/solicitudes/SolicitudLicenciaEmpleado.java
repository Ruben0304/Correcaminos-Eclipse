package models.solicitudes;



import models.usuarios.Empleado;
import util.Motivos;

public class SolicitudLicenciaEmpleado extends SolicitudLicencia {
	
	private Empleado empleado;

	public SolicitudLicenciaEmpleado(Motivos motivo, Empleado empleado) {
		super(motivo);
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}
	
	
}
