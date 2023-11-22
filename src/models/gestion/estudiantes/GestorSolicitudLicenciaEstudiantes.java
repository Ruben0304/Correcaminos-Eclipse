package models.gestion.estudiantes;

import java.util.ArrayList;

import data.ObtenerSolicitudes;
import models.solicitudes.SolicitudLicenciaEstudiante;
import models.usuarios.Estudiante;
import utiles.Facultad;

public class GestorSolicitudLicenciaEstudiantes {
	
	 private ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaAceptadas;
	 private ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaPendientes;
	 
	 public GestorSolicitudLicenciaEstudiantes() {
			this.solicitudesLicenciaAceptadas = new ArrayList<SolicitudLicenciaEstudiante>();
			this.solicitudesLicenciaPendientes = new ArrayList<SolicitudLicenciaEstudiante>();
			registrarLicenciasEstudiantes();
	}
	 
	 private void registrarLicenciasEstudiantes() {
	        solicitudesLicenciaPendientes = ObtenerSolicitudes.cargarDesdeArchivo();

    }
	 
	public ArrayList<SolicitudLicenciaEstudiante> getSolicitudesLicenciaPendientes() {

	        return solicitudesLicenciaPendientes;
    }
	 
	 public ArrayList<Estudiante> getEstudianteLicenciaPendientes() {
	        ArrayList<Estudiante> es = new ArrayList<>();
	        for (SolicitudLicenciaEstudiante s : this.solicitudesLicenciaPendientes) {
	            es.add(s.getEstudiante());
	        }
	        return es;
    } 
	 
	 public boolean verificarEstudianteSolicitaLicencia(Estudiante e) {

	        boolean encontrado = false;
	        ArrayList<Estudiante> estudiantes = getEstudianteLicenciaPendientes();
	        for (int i = 0; i < estudiantes.size() && !encontrado; i++) {
	            if (e.getCi().equals(estudiantes.get(i).getCi())) {
	                encontrado = true;
	            }
	        }

	        return encontrado;

    }
	 
	public void agregarSolicitudDeLicencia(Estudiante e, String motivo) {
	        solicitudesLicenciaPendientes.add(new SolicitudLicenciaEstudiante(e, motivo, null, null));
    }
	
	public int totalSolicitudesLicenciaPendientes() {
        return solicitudesLicenciaPendientes.size();
    }
	
	// Reportes relacionados a las licencias de los estudiantes

    public ArrayList<SolicitudLicenciaEstudiante> filtrarLicenciasPendientesPorFacultad(Facultad f) {
        ArrayList<SolicitudLicenciaEstudiante> solicitudLicenciasF = new ArrayList<>();

        for (SolicitudLicenciaEstudiante s : solicitudesLicenciaPendientes) {
            if (s.getEstudiante().getFacultad().equals(f)) {
                solicitudLicenciasF.add(s);
            }
        }

        return solicitudLicenciasF;
    }

    public ArrayList<SolicitudLicenciaEstudiante> filtrarLicenciasAceptadasPorFacultad(Facultad f) {
        ArrayList<SolicitudLicenciaEstudiante> solicitudLicenciasF = new ArrayList<>();

        for (SolicitudLicenciaEstudiante s : solicitudesLicenciaAceptadas) {
            if (s.getEstudiante().getFacultad().equals(f)) {
                solicitudLicenciasF.add(s);
            }
        }

        return solicitudLicenciasF;
    }

    public ArrayList<SolicitudLicenciaEstudiante> filtrarLicenciasPorAnio(int anio) {
        ArrayList<SolicitudLicenciaEstudiante> solicitudes = new ArrayList<>();

        for (SolicitudLicenciaEstudiante solicitud : solicitudesLicenciaAceptadas) {
            if (solicitud.getAnioExpedicion() == anio) {
                solicitudes.add(solicitud);
            }
        }

        return solicitudes;
    }

	 
	
}
