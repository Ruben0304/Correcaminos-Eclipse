package modelos.entidades;

import utiles.Facultad;

public abstract class Usuario {

	protected String nombreUsuario;
	protected String contrasena;
	


	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

    
	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public String getContrasena() {
		return contrasena;
	}


	

	

	
	

	

	
}
