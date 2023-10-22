package modelos.entidades;

import utiles.Facultad;
import utiles.TipoCurso;

public class Estudiante extends Persona {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String especialidad;
	protected int grupo;
	protected boolean tieneDeuda;
	protected boolean tieneEstipendio;
	protected boolean tieneCuentaCerrada;
	protected boolean tieneLibrosDeBiblioteca;
	protected boolean tieneLibrosDocentes;

	

   

    public Estudiante(String nombreUsuario, String contrasena, String ci, String nombre, String apellidos,
			Facultad facultad, boolean licencia, boolean baja, int curso, TipoCurso tipoCurso, String especialidad,
			int grupo, boolean tieneDeuda, boolean tieneEstipendio, boolean tieneCuentaCerrada,
			boolean tieneLibrosDeBiblioteca, boolean tieneLibrosDocentes) {
		super(nombreUsuario, contrasena, ci, nombre, apellidos, facultad, licencia, baja);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.especialidad = especialidad;
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

    public void solicitarLicencia() {
		
		
	}
	public void solicitarBaja() {
		
		
	}

    

	
	

}
