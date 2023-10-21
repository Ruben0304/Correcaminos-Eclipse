package Modelos;

import Variables.Facultad;

public abstract class Usuario {
	protected String ci;
	protected String nombreUsuario;
	protected String contraseña;
	protected String nombre;
	protected String apellidos;
	protected Facultad facultad;

	public Usuario(String ci, String nombreUsuario, String contraseña, String nombre, String apellidos,
			Facultad facultad) {
		this.ci = ci;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.facultad = facultad;

	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public abstract void solicitarBaja();

	public abstract void solicitarLicencia();

}
