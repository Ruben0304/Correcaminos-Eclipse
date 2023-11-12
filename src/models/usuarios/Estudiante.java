package models.usuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.departamentos.Secretaria;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.solicitudes.SolicitudLicencia;
import utiles.Facultad;
import utiles.TipoCurso;
import utiles.TiposResponsabilidad;

public class Estudiante extends Persona {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String carrera;
	protected int grupo;
	protected ArrayList<TiposResponsabilidad> responsabilidades;
	

	public Estudiante(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido,
			String segundo_apellido,
			Facultad facultad, int curso, TipoCurso tipoCurso, String carrera,
			int grupo, ArrayList<TiposResponsabilidad> responsabilidades) {
		super(nombreUsuario, contrasena, ci, nombre, primer_apellido, segundo_apellido, facultad);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.carrera = carrera;
		this.grupo = grupo;
		this.responsabilidades = responsabilidades;
		

	}


	@Override
	public void solicitarLicencia(String motivo, String fechaInicio, String fechaFin) {

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

    public ArrayList<TiposResponsabilidad> getResponsabilidades() {
        return responsabilidades;
    }

   

	

}
