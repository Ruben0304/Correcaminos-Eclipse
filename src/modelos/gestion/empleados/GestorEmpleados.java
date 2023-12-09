package modelos.gestion.empleados;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import datos.ObtenerEmpleados;
import modelos.solicitudes.Solicitud;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import util.Estado;

public class GestorEmpleados {
    private static GestorEmpleados gestorEmpleados;
    private GestorSolicitudesEmpleados gestorSolicitudesEmpleados;
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
    }
    
    private void registrarEmpleados() {
    	empleados = ObtenerEmpleados.cargarDesdeArchivo();
    }

	public GestorSolicitudesEmpleados getGestorSolicitudesEmpleados() {
		return gestorSolicitudesEmpleados;
	}
	
}
