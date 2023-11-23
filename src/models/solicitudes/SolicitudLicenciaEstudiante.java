package models.solicitudes;

import java.sql.Date;

import models.usuarios.Estudiante;
import util.Motivos;

public class SolicitudLicenciaEstudiante extends SolicitudLicencia {

	private Estudiante estudiante;

	public SolicitudLicenciaEstudiante( Motivos motivo, Estudiante estudiante) {
		super(motivo);
		this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

}
