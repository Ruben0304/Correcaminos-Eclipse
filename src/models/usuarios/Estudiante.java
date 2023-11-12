package models.usuarios;

import java.util.ArrayList;

import models.departamentos.Secretaria;
import models.solicitudes.SolicitudLicenciaEstudiante;
import utiles.Facultad;
import utiles.TipoCurso;
import utiles.TiposResponsabilidad;

public class Estudiante extends Persona {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String carrera;
	protected int grupo;

	public Estudiante(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido,
			String segundo_apellido,
			Facultad facultad, int curso, TipoCurso tipoCurso, String carrera,
			int grupo) {
		super(nombreUsuario, contrasena, ci, nombre, primer_apellido, segundo_apellido, facultad);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.carrera = carrera;
		this.grupo = grupo;

	}

	@Override
	public void solicitarLicencia(Secretaria secretaria, String motivo, String fechaInicio, String fechaFin) {
		SolicitudLicenciaEstudiante solicitud = new SolicitudLicenciaEstudiante(Estudiante.this, motivo, fechaInicio,
				fechaFin);
		secretaria.agregarSolicitudDeLicencia(solicitud);

	}

	@Override
	public void solicitarBaja() {

	}

	public int getCurso() {
		return curso;
	}

	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}

	public String getCarrera() {
		return carrera;
	}

	public int getGrupo() {
		return grupo;
	}

}
