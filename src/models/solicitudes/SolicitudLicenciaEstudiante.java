package models.solicitudes;

import java.util.Calendar;

import models.usuarios.Estudiante;

public class SolicitudLicenciaEstudiante extends SolicitudLicencia {

	private Estudiante estudiante;

	public SolicitudLicenciaEstudiante(Estudiante estudiante, String motivo, Calendar fechaSalida, Calendar fechaRegreso) {
		super(motivo, fechaSalida, fechaRegreso);
		this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}



}
