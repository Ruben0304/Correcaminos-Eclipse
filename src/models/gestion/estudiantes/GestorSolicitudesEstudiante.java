package models.gestion.estudiantes;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import data.ObtenerSolicitudesEstudiantes;
import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Estudiante;
import util.Estado;
import util.MotivoBaja;
import util.MotivoLicencia;

public class GestorSolicitudesEstudiante {

    private HashMap<Estudiante, Set<Solicitud>> solicitudes;

    public GestorSolicitudesEstudiante(ArrayList<Estudiante> estudiantes) {

        registrarSolicitudes();
    }

    private void registrarSolicitudes() {
        this.solicitudes = ObtenerSolicitudesEstudiantes.cargarDesdeArchivo();

    }

    public HashMap<Estudiante, Set<Solicitud>> getSolicitudes() {
        return solicitudes;
    }

    public boolean verificarEstudianteSolicitaAlgo(Estudiante e) {
        boolean solicita = false;
        if (solicitudes.containsKey(e)) {
            for (Solicitud s : solicitudes.get(e)) {
                if (s.getEstado().equals(Estado.PENDIENTE)) {
                    solicita = true;
                }
            }

        }

        return solicita;

    }

    public void crearSolicitudBaja(MotivoBaja motivo, Estudiante e) {

        
        if (solicitudes.containsKey(e)) {
           solicitudes.get(e).add(new SolicitudBaja(12,motivo));
        }
        else{
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudBaja(12,motivo));
            solicitudes.put(e, solicituds);
        }

    }

    public void crearSolicitudLiciencia(MotivoLicencia motivo, Estudiante e) {

       
        Calendar c = Calendar.getInstance();
        Calendar a = Calendar.getInstance();
        a.add(Calendar.YEAR, 1);

        if (solicitudes.containsKey(e)) {
           solicitudes.get(e).add(new SolicitudLicencia(12,motivo,c,a));
        }
         else{
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudLicencia(12,motivo,c,a));
            solicitudes.put(e, solicituds);
        }

    }

}
