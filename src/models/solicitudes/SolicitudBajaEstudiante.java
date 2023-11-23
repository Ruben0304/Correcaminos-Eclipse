package models.solicitudes;

import java.util.Date;

import models.usuarios.Estudiante;
import util.Estado;

public class SolicitudBajaEstudiante extends SolicitudBaja {
	
	private Estudiante estudiante;
	
	public SolicitudBajaEstudiante(Estado estado, String motivo, Date fecha, Estudiante estudiante) {
		super(estado, motivo, fecha);
		this.estudiante = estudiante;
		
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

}
