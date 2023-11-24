package models.gestion.empleados;

import java.util.ArrayList;

import data.ObtenerSolicitudesEmpleados;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.solicitudes.SolicitudBajaEmpleado;
import models.solicitudes.SolicitudLicenciaEmpleado;

public class GestorSolicitudesEmpleados {
    
	private ArrayList<SolicitudBajaEmpleado> solicitudesBaja;
	private ArrayList<SolicitudLicenciaEmpleado> solicitudesLicencia;

	
	public GestorSolicitudesEmpleados() {
		solicitudesBaja = new  ArrayList<SolicitudBajaEmpleado>();
		registrarBajasEmpleados();
		solicitudesLicencia = new ArrayList<SolicitudLicenciaEmpleado>();
		registrarLicenciasEmpleados();
	}
    
    private void registrarBajasEmpleados() {
    	solicitudesBaja = ObtenerSolicitudesEmpleados.cargarDesdeArchivo();
    }

	public ArrayList<SolicitudBajaEmpleado> getSolicitudesBaja() {
		return solicitudesBaja;
	}
    
	 private void registrarLicenciasEmpleados() {
    	solicitudesLicencia = ObtenerSolicitudesEmpleados.cargarSolicitcitudesLicenciaEmpleados();
    }

	public ArrayList<SolicitudLicenciaEmpleado> getSolicitudesLicencia() {
		return solicitudesLicencia;
	}
    
}
