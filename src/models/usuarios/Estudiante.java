package models.usuarios;

import models.gestion.estudiantes.GestorEstudiantes;
import util.Facultad;
import util.TipoCurso;

public class Estudiante extends Persona {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String carrera;
	protected int grupo;
	protected Facultad facultad;

	public Estudiante(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido,
			String segundo_apellido,
			Facultad facultad, int curso, TipoCurso tipoCurso, String carrera,
			int grupo) {
		super(nombreUsuario, contrasena, ci, nombre, primer_apellido, segundo_apellido);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.carrera = carrera;
		this.grupo = grupo;
		this.grupo = grupo;

	}

	public void solicitarLicencia(String motivo){
		GestorEstudiantes.gestorEstudiantes().getGestorSolicitudes().agregarSolicitudDeLicencia(this,motivo);
	}

	public void solicitarBaja(String motivo){
		GestorEstudiantes.gestorEstudiantes().getGestorSolicitudes().agregarSolicitudDeBaja(this,motivo);
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



    public Facultad getFacultad() {
        return facultad;
    }

	

}
