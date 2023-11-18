package models.gestion.empleados;

import java.util.ArrayList;

import data.ObtenerSolicitudesEmpleados;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.solicitudes.SolicitudBaja;

public class GestorSolicitudesEmpleados {
    
	private ArrayList<SolicitudBaja> solicitudesPendientes;
	
	public GestorSolicitudesEmpleados() {
		solicitudesPendientes = new  ArrayList<SolicitudBaja>();
		registrarLicenciasEmpleados();
	}
    
    
    
    private void registrarLicenciasEmpleados() {
    	solicitudesPendientes = ObtenerSolicitudesEmpleados.cargarDesdeArchivo();
    }



	public ArrayList<SolicitudBaja> getSolicitudesPendientes() {
		return solicitudesPendientes;
	}
    
    
}
