package models.responsabilidades;

import java.util.ArrayList;

import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.NoDocente;
import util.ResponsabilidadesTrabajador;

public class ResponsabilidadesEmpleados {
    private Empleado empleado;
    private ArrayList<ResponsabilidadesTrabajador> responsabilidades;
    
    public ResponsabilidadesEmpleados(Empleado empleado, ArrayList<ResponsabilidadesTrabajador> responsabilidades) {
    	this.responsabilidades = responsabilidades;
    	this.empleado = empleado;
    }

	public Empleado getEmpleado() {
		return empleado;
	}

	public ArrayList<ResponsabilidadesTrabajador> getResponsabilidades() {
		return responsabilidades;
	}
    
    
}
