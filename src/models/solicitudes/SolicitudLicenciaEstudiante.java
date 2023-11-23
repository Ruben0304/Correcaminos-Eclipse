package models.solicitudes;

import java.sql.Date;

import models.usuarios.Estudiante;
import util.Estado;

public class SolicitudLicenciaEstudiante extends SolicitudLicencia {

	private Estudiante estudiante;

	public SolicitudLicenciaEstudiante(Estudiante estudiante, String motivo) {
		super( motivo);
		this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}



}
