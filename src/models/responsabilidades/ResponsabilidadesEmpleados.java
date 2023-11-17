package models.responsabilidades;

import java.util.ArrayList;

import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.NoDocente;
import utiles.ResponsabilidadesTrabajador;

public class ResponsabilidadesEmpleados {
    private Empleado empleado;
    private ArrayList<ResponsabilidadesTrabajador> responsabilidades;
    
    public ResponsabilidadesEmpleados(Empleado empleado, ArrayList<ResponsabilidadesTrabajador> responsabilidades) {
    	this.responsabilidades = responsabilidades;
    	
    	if (empleado instanceof NoDocente) {
    		this.empleado = new NoDocente(
    				 empleado.getNombreUsuario(),
    				 empleado.getContrasena(),
    				 empleado.getCi(),
    				 empleado.getNombre(),
    				 empleado.getPrimer_apellido(),
    				 empleado.getSegundo_apellido(),
                     empleado.getNumerotrabajador(),
                     ((NoDocente)empleado).getSeccion());
    	}
    	else {
    		this.empleado = new Docente(
   				 empleado.getNombreUsuario(),
   				 empleado.getContrasena(),
   				 empleado.getCi(),
   				 empleado.getNombre(),
   				 empleado.getPrimer_apellido(),
   				 empleado.getSegundo_apellido(),
   				 empleado.getNumerotrabajador(),
   				 ((Docente)empleado).getFacultad(),
                 ((Docente)empleado).getDepartamento(),
                 ((Docente)empleado).getCategoriaDocente());
    	}
    	
    }

	public Empleado getEmpleado() {
		return empleado;
	}

	public ArrayList<ResponsabilidadesTrabajador> getResponsabilidades() {
		return responsabilidades;
	}
    
    
}
