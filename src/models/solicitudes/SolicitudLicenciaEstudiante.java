package models.solicitudes;

import java.sql.Date;

import models.usuarios.Estudiante;
import util.Estado;

public class SolicitudLicenciaEstudiante extends SolicitudLicencia {

	private Estudiante estudiante;

	public SolicitudLicenciaEstudiante(Estudiante estudiante,Estado estado, String motivo, Date fechaSalida, Date fechaRegreso) {
		super(estado, motivo, fechaSalida, fechaRegreso);
		this.estudiante = estudiante;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}



}
