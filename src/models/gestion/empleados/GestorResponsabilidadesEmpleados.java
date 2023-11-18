package models.gestion.empleados;

import java.util.ArrayList;

import data.ObtenerResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEmpleados;

public class GestorResponsabilidadesEmpleados {
	
	private ArrayList<ResponsabilidadesEmpleados> responsabilidadesEmpleadosPendientes;
    private ArrayList<ResponsabilidadesEmpleados> responsabilidadesEmpleadosCujae;
    
    public GestorResponsabilidadesEmpleados() {
    	responsabilidadesEmpleadosPendientes = new ArrayList<ResponsabilidadesEmpleados>();
    	responsabilidadesEmpleadosCujae = new ArrayList<ResponsabilidadesEmpleados>();
    	registrarResponsabilidadesEmpleados();
    }
    
    private void registrarResponsabilidadesEmpleados() {
    	responsabilidadesEmpleadosPendientes = ObtenerResponsabilidadesEmpleados.cargarDesdeArchivo();
    }

	public ArrayList<ResponsabilidadesEmpleados> getResponsabilidadesEmpleadosPendientes() {
		return responsabilidadesEmpleadosPendientes;
	}

	public ArrayList<ResponsabilidadesEmpleados> getResponsabilidadesEmpleadosCujae() {
		return responsabilidadesEmpleadosCujae;
	}
}
