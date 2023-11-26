package models.usuarios;

import util.Facultad;

public abstract class Empleado extends Persona{
    protected String numerotrabajador;
    protected Facultad facultad;


    
    public Empleado(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
                     String numerotrabajador,Facultad facultad) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido);
        this.numerotrabajador = numerotrabajador;
        this.facultad = facultad;
    }

	public String getNumerotrabajador() {
		return numerotrabajador;
	}

	public Facultad getFacultad() {
		return facultad;
	}
	
	

	
	
	
	
	
    
    

    
}
