package modelos.usuarios;

import java.util.ArrayList;

import modelos.departamentos.Secretaria;
import modelos.solicitudes.SolicitudLicenciaEstudiante;
import utiles.Facultad;
import utiles.TipoCurso;
import utiles.TiposResponsabilidad;

public class Estudiante extends Persona {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String carrera;
	protected int grupo;
	protected ArrayList<TiposResponsabilidad> responsabilidades;

	public Estudiante(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
	Facultad facultad, int curso, TipoCurso tipoCurso, String carrera,
			int grupo,ArrayList<TiposResponsabilidad> responsabilidades) {
		super(nombreUsuario, contrasena, ci, nombre,primer_apellido, segundo_apellido, facultad);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.carrera = carrera;
		this.grupo = grupo;
		this.responsabilidades = responsabilidades;
	}

	public Estudiante(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
	Facultad facultad, int curso, TipoCurso tipoCurso, String carrera,
			int grupo) {
		super(nombreUsuario, contrasena, ci, nombre,primer_apellido, segundo_apellido, facultad);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.carrera = carrera;
		this.grupo = grupo;
		this.responsabilidades = new ArrayList<>();
	}

	public ArrayList<TiposResponsabilidad> getResponsabilidades() {
		return responsabilidades;
	}


	public boolean entregoCarnet() {
		return !responsabilidades.contains(TiposResponsabilidad.CARNET_CUJAE);
	}
	public boolean tieneDeuda() {
		return responsabilidades.contains(TiposResponsabilidad.DEUDA);
	}

	public boolean tieneEstipendio() {
		return responsabilidades.contains(TiposResponsabilidad.ESTIPENDIO);
	}

	public boolean tieneCuentaCerrada() {
		return !responsabilidades.contains(TiposResponsabilidad.CUENTA_USUARIO);
	}

	public boolean tieneLibrosDeBiblioteca() {
		return responsabilidades.contains(TiposResponsabilidad.LIBROS_BIBLIOTECA);
	}

	public boolean tieneLibrosDocentes() {
		return responsabilidades.contains(TiposResponsabilidad.LIBROS_DOCENTES);
	}

	// public void setDeuda(boolean tieneDeuda) {
	// 	this.tieneDeuda = tieneDeuda;
	// }

	// public void setEstipendio(boolean tieneEstipendio) {
	// 	this.tieneEstipendio = tieneEstipendio;
	// }

	// public void setCuentaCerrada(boolean tieneCuentaCerrada) {
	// 	this.tieneCuentaCerrada = tieneCuentaCerrada;
	// }

	// public void setLibrosDeBiblioteca(boolean tieneLibrosDeBiblioteca) {
	// 	this.tieneLibrosDeBiblioteca = tieneLibrosDeBiblioteca;
	// }

	// public void setLibrosDocentes(boolean tieneLibrosDocentes) {
	// 	this.tieneLibrosDocentes = tieneLibrosDocentes;
	// }

	@Override
	public void solicitarLicencia(Secretaria secretaria, String motivo, String fechaInicio, String fechaFin) {
		SolicitudLicenciaEstudiante solicitud = new SolicitudLicenciaEstudiante(Estudiante.this, motivo, fechaInicio, fechaFin);
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
