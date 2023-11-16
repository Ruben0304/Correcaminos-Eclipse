package models.gestion.estudiantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import data.ObtenerSolicitudes;
import models.interfaces.Actualizador;
import models.reports.BajasAceptadasPorFacultad;
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

    public ArrayList<BajasAceptadasPorFacultad> ordenarBajasPorCantidad(boolean ascendente) {
        ArrayList<BajasAceptadasPorFacultad> bajas = obtenerCantidadBajasAceptadasPorFacultad();
        if (ascendente) {
            Collections.sort(bajas, (b1, b2) -> Integer.compare(b1.getCantidadBajas(), b2.getCantidadBajas()));
        } else {
            Collections.sort(bajas, (b1, b2) -> Integer.compare(b2.getCantidadBajas(), b1.getCantidadBajas()));
        }
        return bajas;
    }

    // public ArrayList<Facultad> facultadesConMasBajasAceptadas() {
    // ArrayList<Facultad> ordenada = new ArrayList<>();
    // int max = 0;

    // }
}
