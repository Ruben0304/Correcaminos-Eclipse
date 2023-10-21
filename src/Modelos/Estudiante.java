package Modelos;

import Variables.Facultad;
import Variables.TipoCurso;

public class Estudiante extends Usuario {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String especialidad;
	protected int grupo;

	public Estudiante(String ci, String nombreUsuario, String contraseña, String nombre, String apellidos,
			Facultad facultad, String especialidad, int curso, TipoCurso tipoCurso, int grupo) {
		super(ci, nombreUsuario, contraseña, nombre, apellidos, facultad);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.grupo = grupo;
		this.especialidad = especialidad;
	}

	public void solicitarBaja() {
	}

	public void solicitarLicencia() {
	}

}
