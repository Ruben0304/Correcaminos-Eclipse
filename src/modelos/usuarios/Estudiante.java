package modelos.usuarios;

import modelos.gestion.estudiantes.Secretaria;
import util.Facultad;
import util.Motivos;
import util.TipoCurso;

public class Estudiante extends Persona {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String carrera;
	protected int grupo;
	protected Facultad facultad;

	public Estudiante(String ci, String nombre, String primer_apellido,
			String segundo_apellido,
			Facultad facultad, int curso, TipoCurso tipoCurso, String carrera,
			int grupo) {
		super(ci, nombre, primer_apellido, segundo_apellido);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.carrera = carrera;
		this.grupo = grupo;
		this.grupo = grupo;

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
