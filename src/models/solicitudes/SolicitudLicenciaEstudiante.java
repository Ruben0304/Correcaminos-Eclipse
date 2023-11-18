package models.solicitudes;

import java.util.Calendar;

import models.usuarios.Estudiante;

public class SolicitudLicenciaEstudiante extends SolicitudLicencia {

	private Estudiante estudiante;

	public SolicitudLicenciaEstudiante(String motivo, Calendar fechaSalida,  Calendar fechaRegreso, Estudiante estudiante) {
		super(motivo, fechaSalida, fechaRegreso);
		this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

}
