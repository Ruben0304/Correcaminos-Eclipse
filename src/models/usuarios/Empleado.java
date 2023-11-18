package models.usuarios;


public abstract class Empleado extends Persona{
    protected String numerotrabajador;

    public Empleado(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
                     String numerotrabajador) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido);
        this.numerotrabajador = numerotrabajador;
    }

	public String getNumerotrabajador() {
		return numerotrabajador;
	}

	
	
	
	
	
    
    

    
}
