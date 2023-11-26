package models.solicitudes;

import models.usuarios.Estudiante;
import util.Motivos;

public class SolicitudBajaEstudiante extends SolicitudBaja {

	private Estudiante estudiante;
	
	public SolicitudBajaEstudiante(Motivos motivo, Estudiante estudiante) {
		super(motivo);
		this.estudiante = estudiante;

	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public Motivos getMotivo() {
		return this.motivo;
	}

}
