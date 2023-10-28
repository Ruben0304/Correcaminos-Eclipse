package modelos.entidades;



public abstract class Usuario {

	protected String nombreUsuario;
	protected String contrasena;
	


	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
