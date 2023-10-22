package modelos.entidades;

import utiles.Facultad;

public class Persona extends Usuario {
    protected String ci;
    protected String nombre;
	protected String apellidos;
	protected Facultad facultad;
	protected boolean licencia;
	protected boolean baja;
   
    public Persona(String nombreUsuario, String contrasena, String ci, String nombre, String apellidos,
            Facultad facultad, boolean licencia, boolean baja) {
        super(nombreUsuario, contrasena);
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.facultad = facultad;
        this.licencia = licencia;
        this.baja = baja;
    }

    
}
