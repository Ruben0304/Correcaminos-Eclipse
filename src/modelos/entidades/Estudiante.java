package modelos.entidades;

import utiles.Facultad;
import utiles.TipoCurso;

public class Estudiante extends Persona {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String carrera;
	protected int grupo;
	protected boolean tieneDeuda;
	protected boolean tieneEstipendio;
	protected boolean tieneCuentaCerrada;
	protected boolean tieneLibrosDeBiblioteca;
	protected boolean tieneLibrosDocentes;

	

   

    public Estudiante(String nombreUsuario, String contrasena, String ci, String nombre, String apellidos,
			Facultad facultad, boolean licencia, boolean baja, int curso, TipoCurso tipoCurso, String carrera,
			int grupo, boolean tieneDeuda, boolean tieneEstipendio, boolean tieneCuentaCerrada,
			boolean tieneLibrosDeBiblioteca, boolean tieneLibrosDocentes) {
		super(nombreUsuario, contrasena, ci, nombre, apellidos, facultad, licencia, baja);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.carrera = carrera;
		this.grupo = grupo;
		this.tieneDeuda = tieneDeuda;
		this.tieneEstipendio = tieneEstipendio;
		this.tieneCuentaCerrada = tieneCuentaCerrada;
		this.tieneLibrosDeBiblioteca = tieneLibrosDeBiblioteca;
		this.tieneLibrosDocentes = tieneLibrosDocentes;
	}

	public boolean tieneDeuda() {
        return tieneDeuda;
    }

    public boolean tieneEstipendio() {
        return tieneEstipendio;
    }

    public boolean tieneCuentaCerrada() {
        return tieneCuentaCerrada;
    }

    public boolean tieneLibrosDeBiblioteca() {
        return tieneLibrosDeBiblioteca;
    }

    public boolean tieneLibrosDocentes() {
        return tieneLibrosDocentes;
    }



	public void setDeuda(boolean tieneDeuda) {
		this.tieneDeuda = tieneDeuda;
	}



	public void setEstipendio(boolean tieneEstipendio) {
		this.tieneEstipendio = tieneEstipendio;
	}



	public void setCuentaCerrada(boolean tieneCuentaCerrada) {
		this.tieneCuentaCerrada = tieneCuentaCerrada;
	}



	public void setLibrosDeBiblioteca(boolean tieneLibrosDeBiblioteca) {
		this.tieneLibrosDeBiblioteca = tieneLibrosDeBiblioteca;
	}



	public void setLibrosDocentes(boolean tieneLibrosDocentes) {
		this.tieneLibrosDocentes = tieneLibrosDocentes;
	}

    public void solicitarLicencia(Secretaria secretaria,String motivo, String fechaInicio, String fechaFin) {
		SolicitudLicenciaEstudiante solicitud = new SolicitudLicenciaEstudiante(this, motivo, fechaInicio, fechaFin);
		secretaria.agregarSolicitudDeLicencia(solicitud);
	}
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

	public boolean isTieneDeuda() {
		return tieneDeuda;
	}

	public boolean isTieneEstipendio() {
		return tieneEstipendio;
	}

	public boolean isTieneCuentaCerrada() {
		return tieneCuentaCerrada;
	}

	public boolean isTieneLibrosDeBiblioteca() {
		return tieneLibrosDeBiblioteca;
	}

	public boolean isTieneLibrosDocentes() {
		return tieneLibrosDocentes;
	}

    

	
	

}
