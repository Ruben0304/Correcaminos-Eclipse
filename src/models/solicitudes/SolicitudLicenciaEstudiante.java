package models.solicitudes;

import models.usuarios.Estudiante;

public class SolicitudLicenciaEstudiante extends SolicitudLicencia {

	private Estudiante estudiante;

	public SolicitudLicenciaEstudiante(String motivo, String fechaSalida, String fechaRegreso, Estudiante estudiante) {
		super(motivo, fechaSalida, fechaRegreso);
		this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

}
