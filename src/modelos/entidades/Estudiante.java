package modelos.entidades;

import utiles.Facultad;
import utiles.TipoCurso;

public class Estudiante extends Usuario {
	protected int curso;
	protected TipoCurso tipoCurso;
	protected String especialidad;
	protected int grupo;
	protected boolean tieneDeuda;
	protected boolean tieneEstipendio;
	protected boolean tieneCuentaCerrada;
	protected boolean tieneLibrosDeBiblioteca;
	protected boolean tieneLibrosDocentes;

	public Estudiante(String ci, String nombreUsuario, String contrasena, String nombre, String apellidos,
			Facultad facultad, String especialidad, int curso, TipoCurso tipoCurso, int grupo) {
		super(ci, nombreUsuario, contrasena, nombre, apellidos, facultad);
		this.curso = curso;
		this.tipoCurso = tipoCurso;
		this.grupo = grupo;
		this.especialidad = especialidad;
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



    

	
	

}
