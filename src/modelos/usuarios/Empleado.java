package modelos.usuarios;

import java.util.ArrayList;

import modelos.departamentos.Secretaria;
import utiles.Facultad;
import utiles.ResponsabilidadesTrabajador;
import utiles.TiposResponsabilidad;

public abstract class Empleado extends Persona{
    protected String numerotrabajador;
    protected ArrayList<ResponsabilidadesTrabajador> responsabilidades;

    public Empleado(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
    Facultad facultad, boolean licencia, boolean baja, String numerotrabajador, ArrayList<ResponsabilidadesTrabajador> responsabilidades) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, facultad);
        this.numerotrabajador = numerotrabajador;
        this.responsabilidades = responsabilidades;
    }

	public String getNumerotrabajador() {
		return numerotrabajador;
	}

	public ArrayList<ResponsabilidadesTrabajador> getResponsabilidades() {
		return responsabilidades;
	}
	
	public boolean tieneCarnetCujae() {
		return responsabilidades.contains(ResponsabilidadesTrabajador.CARNET_CUJAE);
	}
	
	public boolean tieneDeuda() {
		return responsabilidades.contains(ResponsabilidadesTrabajador.DEUDA);
	}
	
	public boolean tieneLibrosDeBiblioteca() {
		return responsabilidades.contains(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA);
	}
	
	public boolean tieneCarnetBiblioteca() {
		return responsabilidades.contains(ResponsabilidadesTrabajador.CARNET_BIBLIOTECA);
	}
	
	public boolean tieneSalarioIndebido() {
		return responsabilidades.contains(ResponsabilidadesTrabajador.SALARIO_INDEBIDO);
	}
	
	
    
    

    
}
