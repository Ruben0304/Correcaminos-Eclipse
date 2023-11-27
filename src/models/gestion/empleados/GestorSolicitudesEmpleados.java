package models.gestion.empleados;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import data.ObtenerSolicitudesEmpleados;
import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Empleado;

public class GestorSolicitudesEmpleados {
    
	private HashMap<Empleado, Set<Solicitud>> solicitudesEmpleados;
	
	public GestorSolicitudesEmpleados() {
		solicitudesEmpleados = new  HashMap<Empleado, Set<Solicitud>>();
		registrarLicenciasEmpleados();
	}
    
    private void registrarLicenciasEmpleados() {
    	solicitudesEmpleados = ObtenerSolicitudesEmpleados.cargarDesdeArchivo();
    }

	public HashMap<Empleado, Set<Solicitud>> getSolicitudesPendientes() {
		return solicitudesEmpleados;
	}
	
	public boolean agregarSolicitud(Empleado e, Solicitud s) {
		
		boolean registroExitoso = false;
		
		if (solicitudesEmpleados.containsKey(e)) {
			registroExitoso = solicitudesEmpleados.get(e).add(s);
		}
		else {
			Set<Solicitud> nuevoSet = new HashSet<>();
			registroExitoso = nuevoSet.add(s);
			solicitudesEmpleados.put(e, nuevoSet);
		}
		
		return registroExitoso;
	}
    
    public Set<Solicitud> getSolicitudesEmpleado(Empleado e) {
    	return solicitudesEmpleados.get(e);
    }
    
}
