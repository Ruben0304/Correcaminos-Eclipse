package models.solicitudes;

import java.util.Date;

import models.usuarios.Estudiante;
import util.Estado;

public class SolicitudBajaEstudiante extends SolicitudBaja {
	
	private Estudiante estudiante;
	
	public SolicitudBajaEstudiante(String motivo, Estudiante estudiante) {
		super(motivo);
		this.estudiante = estudiante;
		
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

}
