package models.solicitudes;

import java.sql.Date;

import models.usuarios.Estudiante;

public class SolicitudLicenciaEstudiante extends SolicitudLicencia {

	private Estudiante estudiante;

	public SolicitudLicenciaEstudiante(Estudiante estudiante, String motivo, Date fechaSalida, Date fechaRegreso) {
		super(motivo, fechaSalida, fechaRegreso);
		this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}



}
