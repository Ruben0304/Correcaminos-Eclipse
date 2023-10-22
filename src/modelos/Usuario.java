package modelos;

import variables.Facultad;

public abstract class Usuario {
	protected String ci;
	protected String nombreUsuario;
	protected String contrase�a;
	protected String nombre;
	protected String apellidos;
	protected Facultad facultad;
	protected boolean licencia;
	protected boolean baja;

	public Usuario(String ci, String nombreUsuario, String contrase�a, String nombre, String apellidos,
			Facultad facultad) {
		this.ci = ci;
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.facultad = facultad;

	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

    
    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }



	

	
	

	

	
}
