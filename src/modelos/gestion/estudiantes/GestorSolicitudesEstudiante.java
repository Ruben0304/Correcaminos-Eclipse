package modelos.gestion.estudiantes;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import datos.ObtenerSolicitudesEstudiantes;
import modelos.solicitudes.Solicitud;
import modelos.solicitudes.SolicitudBaja;
import modelos.solicitudes.SolicitudLicencia;
import modelos.usuarios.Credenciales;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;
import util.Estado;
import util.MotivoBaja;
import util.MotivoLicencia;

public class GestorSolicitudesEstudiante {

    private HashMap<Estudiante, Set<Solicitud>> solicitudes;

    public GestorSolicitudesEstudiante() {

        registrarSolicitudes();
        for (Estudiante est : solicitudes.keySet()) {
			System.out.println(est.getNombre() + " " +est.getCi());
		}
    }

    private void registrarSolicitudes() {
        this.solicitudes = ObtenerSolicitudesEstudiantes.cargarDesdeArchivo();

    }

    public HashMap<Estudiante, Set<Solicitud>> getSolicitudes() {
        return solicitudes;
    }

    public boolean verificarEstudianteSolicitaAlgo(Estudiante e) {
        boolean solicita = false;
        for (Map.Entry<Estudiante, Set<Solicitud>> solicitud : solicitudes.entrySet()) {

            Estudiante estudiante = solicitud.getKey();
            Set<Solicitud> listaSolicitudes = solicitud.getValue();
            if (estudiante.getCi().equals(e.getCi())) {
                for (Solicitud s : listaSolicitudes) {
                    if (s.getEstado().equals(Estado.PENDIENTE)) {
                        solicita = true;
                    }
                }

            }

        }
        
        
        return solicita;
    }

       public boolean verificarEstudianteSolicitaCancelacion(Estudiante e) {
        boolean solicita = false;
        for (Map.Entry<Estudiante, Set<Solicitud>> solicitud : solicitudes.entrySet()) {

            Estudiante estudiante = solicitud.getKey();
            Set<Solicitud> listaSolicitudes = solicitud.getValue();
            if (estudiante.getCi().equals(e.getCi())) {
                for (Solicitud s : listaSolicitudes) {
                    if (s.getEstado().equals(Estado.SOLICITACANCELACION)) {
                        solicita = true;
                    }
                }

            }

        }
        System.out.println(solicita);
        return solicita;
    }

    public ArrayList<Estudiante> obtenerEstudiantesPendientes() {

        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

        for (Map.Entry<Estudiante, Set<Solicitud>> solicitud : solicitudes.entrySet()) {

            Estudiante estudiante = solicitud.getKey();
            Set<Solicitud> listaSolicitudes = solicitud.getValue();

            for (Solicitud s : listaSolicitudes) {
                if (s.getEstado().equals(Estado.PENDIENTE) || s.getEstado().equals(Estado.SOLICITACANCELACION)) {
                    estudiantes.add(estudiante);
                }
            }
        }

        return estudiantes;
    }

    public void crearSolicitudBaja(MotivoBaja motivo, Estudiante e) {

        if (solicitudes.containsKey(e)) {
            solicitudes.get(e).add(new SolicitudBaja(12, motivo));
        } else {
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudBaja(12, motivo));
            solicitudes.put(e, solicituds);
        }

    }

    public void crearSolicitudLiciencia(MotivoLicencia motivo, Estudiante e) {

        Calendar c = Calendar.getInstance();
        Calendar a = Calendar.getInstance();
        a.add(Calendar.YEAR, 1);

        if (solicitudes.containsKey(e)) {
            solicitudes.get(e).add(new SolicitudLicencia(12, motivo, c, a));
        } else {
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudLicencia(12, motivo, c, a));
            solicitudes.put(e, solicituds);
        }

    }

    public void aceptarSolicitud(String e) {

        List<Estudiante> estudiantes = new ArrayList<>(solicitudes.keySet());

        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante est = estudiantes.get(i);

            if (est.getCi().equals(e)) {
                for (Solicitud s : solicitudes.get(est)) {
                    if (s.getEstado().equals(Estado.PENDIENTE)) {
                        s.setEstado(Estado.ACEPTADO);
                    }
                }
            }
        }
    }

    public void cambiarEstadoSolicitud(String e, Estado estado) {

        List<Estudiante> estudiantes = new ArrayList<>(solicitudes.keySet());

        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante est = estudiantes.get(i);

            if (est.getCi().equals(e)) {
                for (Solicitud s : solicitudes.get(est)) {
                    if (s.getEstado().equals(Estado.PENDIENTE) || s.getEstado().equals(Estado.SOLICITACANCELACION)) {
                        s.setEstado(estado);
                    }
                }
            }
        }
    }

}
