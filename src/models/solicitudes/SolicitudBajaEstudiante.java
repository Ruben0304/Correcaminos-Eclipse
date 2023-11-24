package models.solicitudes;

import models.usuarios.Estudiante;

public class SolicitudBajaEstudiante extends Solicitud {
	
	private Estudiante estudiante;
	
	public SolicitudBajaEstudiante(String motivo, Estudiante estudiante) {
		super(motivo);
		this.estudiante = estudiante;
		
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

}
