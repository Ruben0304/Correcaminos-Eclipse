package modelos.usuarios;

import java.util.Objects;

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

	
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado that = (Empleado) o;
        return Objects.equals(ci, that.ci);
               
    }
	
    
    

    
}
