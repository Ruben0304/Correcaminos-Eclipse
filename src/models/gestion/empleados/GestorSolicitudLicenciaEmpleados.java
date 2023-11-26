package models.gestion.empleados;

import java.util.ArrayList;

import data.ObtenerSolicitudes;
import data.ObtenerSolicitudesLicenciaEmpleados;
import data.ObtenerSolicitudesLicenciaEmpleadosAceptadas;
import models.solicitudes.SolicitudLicenciaEmpleado;
import models.usuarios.Empleado;
import utiles.Facultad;

public class GestorSolicitudLicenciaEmpleados {
	
	private ArrayList<SolicitudLicenciaEmpleado> solicitudesLicenciaAceptadas;
	 private ArrayList<SolicitudLicenciaEmpleado> solicitudesLicenciaPendientes;
	 
	 public GestorSolicitudLicenciaEmpleados() {
			this.solicitudesLicenciaAceptadas = new ArrayList<SolicitudLicenciaEmpleado>();
			this.solicitudesLicenciaPendientes = new ArrayList<SolicitudLicenciaEmpleado>();
			registrarLicenciasEmpleadosPendientes();
			registrarLicenciasEmpleadosAceptadas();
	}
	 
	 private void registrarLicenciasEmpleadosPendientes() {
	        solicitudesLicenciaPendientes = ObtenerSolicitudesLicenciaEmpleados.cargarDesdeArchivo();
	 }
	 
	 private void registrarLicenciasEmpleadosAceptadas() {
		 solicitudesLicenciaAceptadas = ObtenerSolicitudesLicenciaEmpleadosAceptadas.cargarDesdeArchivo();
	 }
	 
	 
	public ArrayList<SolicitudLicenciaEmpleado> getSolicitudesLicenciaPendientes() {

	        return solicitudesLicenciaPendientes;
   }
	 
	 public ArrayList<Empleado> getEmpleadoLicenciaPendientes() {
	        ArrayList<Empleado> es = new ArrayList<Empleado>();
	        for (SolicitudLicenciaEmpleado s : this.solicitudesLicenciaPendientes) {
	            es.add(s.getEmpleado());
	        }
	        return es;
   } 
	 
	 public boolean verificarEmpleadoSolicitaLicencia(Empleado e) {

	        boolean encontrado = false;
	        ArrayList<Empleado> empleados = getEmpleadoLicenciaPendientes();
	        for (int i = 0; i < empleados.size() && !encontrado; i++) {
	            if (e.getCi().equals(empleados.get(i).getCi())) {
	                encontrado = true;
	            }
	        }

	        return encontrado;

   }
	 
	public void agregarSolicitudDeLicencia(Empleado e, String motivo) {
	        solicitudesLicenciaPendientes.add(new SolicitudLicenciaEmpleado(motivo, null, null,e));
   }
	
	public int totalSolicitudesLicenciaPendientes() {
       return solicitudesLicenciaPendientes.size();
   }
	
	// Reportes relacionados a las licencias de los estudiantes

   public ArrayList<SolicitudLicenciaEmpleado> filtrarLicenciasPendientesPorFacultad(Facultad f) {
       ArrayList<SolicitudLicenciaEmpleado> solicitudLicenciasF = new ArrayList<SolicitudLicenciaEmpleado>();

       for (SolicitudLicenciaEmpleado s : solicitudesLicenciaPendientes) {
           if (s.getEmpleado().getFacultad().equals(f)) {
               solicitudLicenciasF.add(s);
           }
       }

       return solicitudLicenciasF;
   }

   public ArrayList<SolicitudLicenciaEmpleado> filtrarLicenciasAceptadasPorFacultad(Facultad f) {
       ArrayList<SolicitudLicenciaEmpleado> solicitudLicenciasF = new ArrayList<SolicitudLicenciaEmpleado>();

       for (SolicitudLicenciaEmpleado s : solicitudesLicenciaAceptadas) {
           if (s.getEmpleado().getFacultad().equals(f)) {
               solicitudLicenciasF.add(s);
           }
       }

       return solicitudLicenciasF;
   }

   public ArrayList<SolicitudLicenciaEmpleado> filtrarLicenciasPorAnio(int anio) {
       ArrayList<SolicitudLicenciaEmpleado> solicitudes = new ArrayList<SolicitudLicenciaEmpleado>();

       for (SolicitudLicenciaEmpleado solicitud : solicitudesLicenciaAceptadas) {
           if (solicitud.getAnioExpedicion() == anio) {
               solicitudes.add(solicitud);
           }
       }

       return solicitudes;
   }

	 
	
}
