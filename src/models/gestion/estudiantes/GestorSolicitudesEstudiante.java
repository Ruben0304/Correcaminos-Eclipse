package models.gestion.estudiantes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import data.ObtenerSolicitudes;
import models.interfaces.Actualizador;

import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Estudiante;
import util.Facultad;

public class GestorSolicitudesEstudiante implements Actualizador {

    ArrayList<SolicitudLicencia> solicitudesLicenciaAceptadas;
    ArrayList<SolicitudBaja> solicitudesBajaAceptadas;

    ArrayList<SolicitudLicencia> solicitudesLicenciaPendientes;
    ArrayList<SolicitudBaja> solicitudesBajaPendientes;

    public GestorSolicitudesEstudiante(ArrayList<Estudiante> estudiantes) {
        this.solicitudesLicenciaAceptadas = new ArrayList<>();
        this.solicitudesBajaAceptadas = new ArrayList<>();
        this.solicitudesLicenciaPendientes = new ArrayList<>();
        this.solicitudesBajaPendientes = new ArrayList<>();
        registrarLicenciasEstudiantes(estudiantes);
    }

    private void registrarLicenciasEstudiantes(ArrayList<Estudiante> estudiantes) {
        ArrayList<SolicitudLicencia> solicitudesCargadas = ObtenerSolicitudes.cargarDesdeArchivo();
        ArrayList<SolicitudLicencia> solicitudesRegistradas = new ArrayList<>();
        for (SolicitudLicencia solicitud : solicitudesCargadas) {
            String estudianteId = solicitud.getEstudiante().getCi();
            Estudiante estudianteExistente = referenciarEstudiante(estudianteId, estudiantes);

            if (estudianteExistente != null) {
                SolicitudLicencia solicitudRegistrada = new SolicitudLicencia(
                        estudianteExistente, solicitud.getMotivo(), solicitud.getFechaSalida(),
                        solicitud.getFechaRegreso());
                solicitudesRegistradas.add(solicitudRegistrada);
            }
        }

        this.solicitudesLicenciaPendientes.addAll(solicitudesRegistradas);
    }

    private Estudiante referenciarEstudiante(String id, ArrayList<Estudiante> estudiantes) {
        boolean encontrado = false;
        Estudiante estudianteEncontrado = null;
        for (int i = 0; i < estudiantes.size() && !encontrado; i++) {
            encontrado = id.equals(estudiantes.get(i).getCi());
            if (encontrado) {
                estudianteEncontrado = estudiantes.get(i);
            }
        }
        return estudianteEncontrado;
    }

    public ArrayList<SolicitudLicencia> getSolicitudesLicenciaPendientes() {

        return solicitudesLicenciaPendientes;
    }

    public boolean verificarEstudianteSolicitaLicencia(Estudiante e) {

        return getEstudianteLicenciaPendientes().contains(e);

    }

    public ArrayList<Estudiante> getEstudianteLicenciaPendientes() {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (SolicitudLicencia s : this.solicitudesLicenciaPendientes) {
            es.add(s.getEstudiante());
        }
        return es;
    }

    public void agregarSolicitudDeLicencia(SolicitudLicencia solicitud) {
        solicitudesLicenciaPendientes.add(solicitud);
    }

    @Override
    public void actualizarDatos() {

    }

    public ArrayList<BajasAceptadasPorFacultad> obtenerCantidadBajasAceptadasPorFacultad() {

        ArrayList<BajasAceptadasPorFacultad> bajas = new ArrayList<>();

        for (SolicitudBaja s : solicitudesBajaAceptadas) {
            boolean encontrado = false;
            for (int i = 0; i < bajas.size() && !encontrado; i++) {
                if (bajas.get(i).getFacultad().equals(s.getEstudiante().getFacultad())) {
                    bajas.get(i).setCantidadBajas(bajas.get(i).getCantidadBajas() + 1);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                bajas.add(new BajasAceptadasPorFacultad(s.getEstudiante().getFacultad(), 1));
            }
        }
        return bajas;
    }

    public ArrayList<BajasAceptadasPorFacultad> ordenarFacultadesPorCantidadBajasAceptadas() {
        ArrayList<BajasAceptadasPorFacultad> bajasOrdenadas = obtenerCantidadBajasAceptadasPorFacultad();

        Collections.sort(bajasOrdenadas, new Comparator<BajasAceptadasPorFacultad>() {
            @Override
            public int compare(BajasAceptadasPorFacultad b1, BajasAceptadasPorFacultad b2) {
                return Integer.compare(b1.getCantidadBajas(), b2.getCantidadBajas());
            }
        });

        return bajasOrdenadas;
    }

    

    public int totalSolicitudesBajaPendientes() {
        return solicitudesBajaPendientes.size();
    }

    public int totalSolicitudesLicenciaPendientes() {
        return solicitudesLicenciaPendientes.size();
    }

    public int toalSolicitudesBajaYLicencia() {
        return totalSolicitudesBajaPendientes() + totalSolicitudesLicenciaPendientes();
    }

    // Filtraciones licencias

    public ArrayList<SolicitudLicencia> filtrarLicenciasPendientesPorFacultad(Facultad f) {
        ArrayList<SolicitudLicencia> solicitudLicenciasF = new ArrayList<>();

        for (SolicitudLicencia s : solicitudesLicenciaPendientes) {
            if (s.getEstudiante().getFacultad().equals(f)) {
                solicitudLicenciasF.add(s);
            }
        }

        return solicitudLicenciasF;
    }

    public ArrayList<SolicitudLicencia> filtrarLicenciasAceptadasPorFacultad(Facultad f) {
        ArrayList<SolicitudLicencia> solicitudLicenciasF = new ArrayList<>();

        for (SolicitudLicencia s : solicitudesLicenciaAceptadas) {
            if (s.getEstudiante().getFacultad().equals(f)) {
                solicitudLicenciasF.add(s);
            }
        }

        return solicitudLicenciasF;
    }

    public ArrayList<SolicitudLicencia> filtrarLicenciasPorAnio(int anio) {
        ArrayList<SolicitudLicencia> solicitudes = new ArrayList<>();

        for (SolicitudLicencia solicitud : solicitudesLicenciaAceptadas) {
            if (solicitud.getAnioExpedicion() == anio) {
                solicitudes.add(solicitud);
            }
        }

        return solicitudes;
    }

    public HashMap<Integer, Integer> cantidadDeLicenciaPorAnio(int anioMinimo) {
        HashMap<Integer, Integer> solicitudes = new HashMap<>();
    
        for (SolicitudLicencia s : solicitudesLicenciaAceptadas) {
            if (s.getAnioExpedicion() > anioMinimo) {
                Integer cantidad = solicitudes.get(s.getAnioExpedicion());
                if (cantidad == null) {
                    cantidad = 0;
                }
                solicitudes.put(s.getAnioExpedicion(), cantidad + 1);
            }
        }
    
        return solicitudes;
    }
    

    // Filtraciones bajas

    public ArrayList<SolicitudBaja> filtrarBajasPendientesPorFacultad(Facultad f) {
        ArrayList<SolicitudBaja> solicitudBajasF = new ArrayList<>();

        for (SolicitudBaja s : solicitudesBajaPendientes) {
            if (s.getEstudiante().getFacultad().equals(f)) {
                solicitudBajasF.add(s);
            }
        }

        return solicitudBajasF;
    }

    public ArrayList<SolicitudBaja> filtrarBajasAceptadasPorFacultad(Facultad f) {
        ArrayList<SolicitudBaja> solicitudBajasF = new ArrayList<>();

        for (SolicitudBaja s : solicitudesBajaAceptadas) {
            if (s.getEstudiante().getFacultad().equals(f)) {
                solicitudBajasF.add(s);
            }
        }

        return solicitudBajasF;
    }

    // public ArrayList<SolicitudBaja> filtrarPorFecha(String anio) {
    // ArrayList<SolicitudBaja> solBajasFiltradas = new ArrayList<>();

    // }

    // public ArrayList<Facultad> facultadesConMasBajasAceptadas() {
    // ArrayList<Facultad> ordenada = new ArrayList<>();
    // int max = 0;

    // }
}
