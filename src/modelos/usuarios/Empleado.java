package modelos.usuarios;


public abstract class Empleado extends Persona{
    protected String numerotrabajador;


    
    public Empleado(String ci, String nombre, String primer_apellido, String segundo_apellido,
                     String numerotrabajador) {
        super(ci, nombre, primer_apellido,segundo_apellido);
        this.numerotrabajador = numerotrabajador;
    }

	public String getNumerotrabajador() {
		return numerotrabajador;
	}

	
	
	
	
	
    
    

    
}
