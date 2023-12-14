package modelos.gestion.empleados;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import datos.ObtenerSolicitudesEmpleados;
import modelos.solicitudes.Solicitud;
import modelos.solicitudes.SolicitudBaja;
import modelos.solicitudes.SolicitudLicencia;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import util.Estado;
import util.MotivoBaja;
import util.MotivoLicencia;

public class GestorSolicitudesEmpleados {

    private HashMap<Empleado, Set<Solicitud>> solicitudesEmpleados;

    public GestorSolicitudesEmpleados() {
        solicitudesEmpleados = new HashMap<Empleado, Set<Solicitud>>();
        registrarLicenciasEmpleados();
    }

    private void registrarLicenciasEmpleados() {
        solicitudesEmpleados = ObtenerSolicitudesEmpleados.cargarDesdeArchivo();
    }

    public HashMap<Empleado, Set<Solicitud>> getSolicitudesPendientes() {
        return solicitudesEmpleados;
    }

   
    public boolean verificarEmpleadoSolicitaAlgo(Empleado e) {
        boolean solicita = false;

        for (Map.Entry<Empleado, Set<Solicitud>> solicitud : solicitudesEmpleados.entrySet()) {

            Empleado estudiante = solicitud.getKey();
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

    public boolean verificarEmpleadoSolicitaCancelacion(Empleado e) {
        boolean solicita = false;

        for (Map.Entry<Empleado, Set<Solicitud>> solicitud : solicitudesEmpleados.entrySet()) {

            Empleado estudiante = solicitud.getKey();
            Set<Solicitud> listaSolicitudes = solicitud.getValue();
            if (estudiante.getCi().equals(e.getCi())) {
                for (Solicitud s : listaSolicitudes) {
                    if (s.getEstado().equals(Estado.SOLICITACANCELACION)) {
                        solicita = true;
                    }
                }

            }

        }

        return solicita;

    }

    public boolean verificarEmpleadoSolicitaLicencia(Empleado e) {
        boolean solicita = false;
        if (solicitudesEmpleados.containsKey(e)) {
            for (Solicitud s : solicitudesEmpleados.get(e)) {
                if (s.getEstado().equals(Estado.PENDIENTE) && s instanceof SolicitudLicencia) {
                    solicita = true;
                }
            }

        }

        return solicita;

    }

    public void crearSolicitudBaja(MotivoBaja motivo, Empleado e) {

        if (solicitudesEmpleados.containsKey(e)) {
            solicitudesEmpleados.get(e).add(new SolicitudBaja(12, motivo));
        } else {
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudBaja(12, motivo));
            solicitudesEmpleados.put(e, solicituds);
        }

    }

    public void crearSolicitudLicencia(MotivoLicencia motivo, Empleado e, Calendar salida, Calendar regreso) {

        if (solicitudesEmpleados.containsKey(e)) {
            solicitudesEmpleados.get(e).add(new SolicitudLicencia(12, motivo, salida, regreso));
        } else {
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudLicencia(12, motivo, salida, regreso));
            solicitudesEmpleados.put(e, solicituds);
        }

    }

    public Set<Solicitud> getSolicitudesEmpleado(Empleado e) {
        return solicitudesEmpleados.get(e);
    }

    public ArrayList<Empleado> obtenerEstudiantesPendientes() {

        ArrayList<Empleado> empleados = new ArrayList<>();
        for (Map.Entry<Empleado, Set<Solicitud>> solicitud : solicitudesEmpleados.entrySet()) {

            Empleado estudiante = solicitud.getKey();
            Set<Solicitud> listaSolicitudes = solicitud.getValue();

            for (Solicitud s : listaSolicitudes) {
                if (s.getEstado().equals(Estado.PENDIENTE) || s.getEstado().equals(Estado.SOLICITACANCELACION)) {
                    empleados.add(estudiante);
                }
            }
        }

        return empleados;
    }

    public void aceptarSolicitud(String e) {

        List<Empleado> empleados = new ArrayList<>(solicitudesEmpleados.keySet());

        for (int i = 0; i < empleados.size(); i++) {
            Empleado est = empleados.get(i);

            if (est.getCi().equals(e)) {
                for (Solicitud s : solicitudesEmpleados.get(est)) {
                    if (s.getEstado().equals(Estado.PENDIENTE)) {
                        s.setEstado(Estado.ACEPTADO);
                    }
                }
            }
        }
    }

    public void cambiarEstadoSolicitud(String e, Estado estado) {

        List<Empleado> empleados = new ArrayList<>(solicitudesEmpleados.keySet());

        for (int i = 0; i < empleados.size(); i++) {
            Empleado est = empleados.get(i);

            if (est.getCi().equals(e)) {
                for (Solicitud s : solicitudesEmpleados.get(est)) {
                    if (s.getEstado().equals(Estado.PENDIENTE) || s.getEstado().equals(Estado.SOLICITACANCELACION)) {
                        s.setEstado(estado);
                    }
                }
            }
        }
    }

}
