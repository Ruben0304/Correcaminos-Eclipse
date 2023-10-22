package modelos.entidades;

import utiles.Facultad;

public abstract class Usuario {
	protected String ci;
	protected String nombreUsuario;
	protected String contrasena;
	protected String nombre;
	protected String apellidos;
	protected Facultad facultad;
	protected boolean licencia;
	protected boolean baja;

	public Usuario(String ci, String nombreUsuario, String contrasena, String nombre, String apellidos,
			Facultad facultad) {
		this.ci = ci;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.facultad = facultad;

	}

	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

    
    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }


	public String getCi() {
		return ci;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public String getContrasena() {
		return contrasena;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public Facultad getFacultad() {
		return facultad;
	}


	public boolean isLicencia() {
		return licencia;
	}


	public boolean isBaja() {
		return baja;
	}



	

	
	

	

	
}
