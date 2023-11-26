package models.gestion.empleados;

import java.util.ArrayList;

import data.ObtenerEmpleados;
import models.usuarios.Empleado;

public class GestorEmpleados {
    private static GestorEmpleados gestorEmpleados;
    private GestorSolicitudesEmpleados gestorSolicitudesEmpleados;
    private GestorResponsabilidadesEmpleados gestorResponsabilidadesEmpleados;
    private ArrayList<Empleado> empleados;

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

     public static GestorEmpleados gestorEmpleados() {
        if (gestorEmpleados == null) {
            gestorEmpleados = new GestorEmpleados();
        }
        return gestorEmpleados;
    }
     
    private GestorEmpleados() {
    	empleados = new ArrayList<Empleado>();
    	registrarEmpleados();
    	gestorSolicitudesEmpleados = new GestorSolicitudesEmpleados();
    	gestorResponsabilidadesEmpleados = new GestorResponsabilidadesEmpleados();
    }
    
    private void registrarEmpleados() {
    	empleados = ObtenerEmpleados.cargarDesdeArchivo();
    }

	public GestorSolicitudesEmpleados getGestorSolicitudesEmpleados() {
		return gestorSolicitudesEmpleados;
	}

	public GestorResponsabilidadesEmpleados getGestorResponsabilidadesEmpleados() {
		return gestorResponsabilidadesEmpleados;
	}
}