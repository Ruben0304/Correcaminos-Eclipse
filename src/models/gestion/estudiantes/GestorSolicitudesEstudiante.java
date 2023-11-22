package models.gestion.estudiantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import data.ObtenerSolicitudes;
import data.ObtenerSolicitudesBajasEstudiantesAceptadas;
import models.interfaces.Actualizador;
import models.reports.BajasAceptadasPorAnio;
import models.reports.BajasAceptadasPorFacultad;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudBajaEstudiante;

import models.solicitudes.SolicitudLicenciaEstudiante;
import models.usuarios.Estudiante;
import util.Facultad;

public class GestorSolicitudesEstudiante implements Actualizador {

    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaAceptadas;
    ArrayList<SolicitudBajaEstudiante> solicitudesBajaAceptadas;

    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaPendientes;
    ArrayList<SolicitudBajaEstudiante> solicitudesBajaPendientes;

    public GestorSolicitudesEstudiante(ArrayList<Estudiante> estudiantes) {
        this.solicitudesLicenciaAceptadas = new ArrayList<>();
        this.solicitudesBajaAceptadas = new ArrayList<>();
        this.solicitudesLicenciaPendientes = new ArrayList<>();
        this.solicitudesBajaPendientes = new ArrayList<>();
        registrarLicenciasEstudiantes();
        registrarBajasEstudiantesAceptadas();
    }

    private void registrarLicenciasEstudiantes() {
        solicitudesLicenciaPendientes = ObtenerSolicitudes.cargarDesdeArchivo();

    }

    private void registrarBajasEstudiantesAceptadas() {
        solicitudesBajaAceptadas = ObtenerSolicitudesBajasEstudiantesAceptadas.cargarDesdeArchivoB();

    }

    public ArrayList<SolicitudLicenciaEstudiante> getSolicitudesLicenciaPendientes() {

        return solicitudesLicenciaPendientes;
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

    public boolean verificarEstudianteSolicitaBaja(Estudiante e) {

        boolean encontrado = false;
        ArrayList<Estudiante> estudiantes = getEstudianteBajaPendientes();
        for (int i = 0; i < estudiantes.size() && !encontrado; i++) {
            if (e.getCi().equals(estudiantes.get(i).getCi())) {
                encontrado = true;
            }
        }

        return encontrado;

    }

    public ArrayList<Estudiante> getEstudianteLicenciaPendientes() {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (SolicitudLicenciaEstudiante s : this.solicitudesLicenciaPendientes) {
            es.add(s.getEstudiante());
        }
        return es;
    }

    public ArrayList<Estudiante> getEstudianteBajaPendientes() {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (SolicitudBajaEstudiante s : this.solicitudesBajaPendientes) {
            es.add(s.getEstudiante());
        }
        return es;
    }

    public void agregarSolicitudDeLicencia(Estudiante e, String motivo) {
        solicitudesLicenciaPendientes.add(new SolicitudLicenciaEstudiante(e, motivo, null, null));
    }

    public void agregarSolicitudDeBaja(Estudiante e, String motivo) {
        solicitudesBajaPendientes.add(new SolicitudBajaEstudiante(motivo, e));
    }

    @Override
    public void actualizarDatos() {

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

    // Filtraciones bajas

    public ArrayList<BajasAceptadasPorAnio> cantidadDeBajasPorAnio(int anioMinimo) {
        ArrayList<BajasAceptadasPorAnio> solicitudes = new ArrayList<>();

        for (SolicitudBajaEstudiante s : solicitudesBajaAceptadas) {
            boolean encontrado = false;
            if (s.getAnioExpedicion() >= anioMinimo) {
                for (int i = 0; i < solicitudes.size() && !encontrado; i++) {
                    if (solicitudes.get(i).getAnio() == s.getAnioExpedicion()) {
                        solicitudes.get(i).setCantidad(solicitudes.get(i).getCantidad() + 1);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    solicitudes.add(new BajasAceptadasPorAnio(s.getAnioExpedicion(), 1));
                }

            }
        }

        return solicitudes;
    }

    public int cantidadDeBajasDeUnAnio(int anio) {

        int total = 0;
        for (SolicitudBajaEstudiante s : solicitudesBajaAceptadas) {
            if (s.getAnioExpedicion() == anio) {
                total++;
            }
        }

        return total;
    }

    public ArrayList<SolicitudBajaEstudiante> filtrarBajasPendientesPorFacultad(Facultad f) {
        ArrayList<SolicitudBajaEstudiante> solicitudBajasF = new ArrayList<>();

        for (SolicitudBajaEstudiante s : solicitudesBajaPendientes) {
            if (s.getEstudiante().getFacultad().equals(f)) {
                solicitudBajasF.add(s);
            }
        }

        return solicitudBajasF;
    }

    public ArrayList<SolicitudBajaEstudiante> filtrarBajasAceptadasPorFacultad(Facultad f) {
        ArrayList<SolicitudBajaEstudiante> solicitudBajasF = new ArrayList<>();

        for (SolicitudBajaEstudiante s : solicitudesBajaAceptadas) {
            if (s.getEstudiante().getFacultad().equals(f)) {
                solicitudBajasF.add(s);
            }
        }

        return solicitudBajasF;
    }

    public ArrayList<SolicitudBajaEstudiante> filtraBajasPorAnio(int anio) {
        ArrayList<SolicitudBajaEstudiante> solicitudes = new ArrayList<>();

        for (SolicitudBajaEstudiante solicitud : solicitudesBajaAceptadas) {
            if (solicitud.getAnioExpedicion() == anio) {
                solicitudes.add(solicitud);
            }
        }

        return solicitudes;
    }

    public ArrayList<BajasAceptadasPorFacultad> obtenerCantidadBajasAceptadasPorFacultad() {

        ArrayList<BajasAceptadasPorFacultad> bajas = new ArrayList<>();

        for (SolicitudBajaEstudiante s : solicitudesBajaAceptadas) {
            boolean encontrado = false;
            for (int i = 0; i < bajas.size() && !encontrado; i++) {
                if (bajas.get(i).getFacultad().equals(s.getEstudiante().getFacultad())) {
                    bajas.get(i).setCantidad(bajas.get(i).getCantidad() + 1);
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
                return Integer.compare(b1.getCantidad(), b2.getCantidad());
            }
        });

        return bajasOrdenadas;
    }

    // public ArrayList<SolicitudBajaEstudiante> filtrarPorFecha(String anio) {
    // ArrayList<SolicitudBajaEstudiante> solBajasFiltradas = new ArrayList<>();

    // }

    // public ArrayList<Facultad> facultadesConMasBajasAceptadas() {
    // ArrayList<Facultad> ordenada = new ArrayList<>();
    // int max = 0;

    // }

    // Filtros administración

    public ArrayList<SolicitudBajaEstudiante> filtradoDinamicoSolicitudBajaEstudiantes(Map<String, String> filtros) {
        ArrayList<SolicitudBajaEstudiante> solicitudesBajaFiltradas = new ArrayList<>();

        for (SolicitudBajaEstudiante solictud : solicitudesBajaAceptadas) {
            boolean cumpleFiltros = true;
            for (Map.Entry<String, String> filtro : filtros.entrySet()) {
                String atributo = filtro.getKey();
                String valor = filtro.getValue();

                switch (atributo) {
                    case "facultad":
                        if (!solictud.getEstudiante().getFacultad().toString().equals(valor)) {
                            cumpleFiltros = false;
                        }
                        break;
                    case "anio":
                        if (!(solictud.getAnioExpedicion() == Integer.parseInt(valor))) {
                            cumpleFiltros = false;
                        }
                        break;
                    case "estado":
                        if (!solictud.getEstado().toString().equals(valor)) {
                            cumpleFiltros = false;
                        }
                        break;

                    case "buscar":
                        if ((buscarBajaPorNombreOCi(solictud, valor)).equals(null)) {
                            cumpleFiltros = false;
                        }
                        break;
                }
            }

            if (cumpleFiltros) {
                solicitudesBajaFiltradas.add(solictud);
            }
        }

        return solicitudesBajaFiltradas;
    }

    public SolicitudBajaEstudiante buscarBajaPorNombreOCi(SolicitudBajaEstudiante solicitud, String valor) {
        boolean result = true;
        if (!solicitud.getEstudiante().getNombreCompleto().contains(valor)) {
            result = false;
        }
        if (!solicitud.getEstudiante().getCi().contains(valor)) {
            result = false;
        }

        return result ? solicitud : null;
    }

    public ArrayList<SolicitudLicenciaEstudiante> filtradoDinamicoSolicitudLicenciaEstudiantes(
            Map<String, String> filtros) {
        ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaFiltradas = new ArrayList<>();

        for (SolicitudLicenciaEstudiante solictud : solicitudesLicenciaAceptadas) {
            boolean cumpleFiltros = true;
            for (Map.Entry<String, String> filtro : filtros.entrySet()) {
                String atributo = filtro.getKey();
                String valor = filtro.getValue();

                switch (atributo) {
                    case "facultad":
                        if (!solictud.getEstudiante().getFacultad().toString().equals(valor)) {
                            cumpleFiltros = false;
                        }
                        break;
                    case "anio":
                        if (!(solictud.getAnioExpedicion() == Integer.parseInt(valor))) {
                            cumpleFiltros = false;
                        }
                        break;
                    case "estado":
                        if (!solictud.getEstado().toString().equals(valor)) {
                            cumpleFiltros = false;
                        }
                        break;

                    case "buscar":
                        if ((buscarLicenciaPorNombreOCi(solictud, valor)).equals(null)) {
                            cumpleFiltros = false;
                        }
                        break;
                }
            }

            if (cumpleFiltros) {
                solicitudesLicenciaFiltradas.add(solictud);
            }
        }

        return solicitudesLicenciaFiltradas;
    }

    public SolicitudLicenciaEstudiante buscarLicenciaPorNombreOCi(SolicitudLicenciaEstudiante solicitud, String valor) {
        boolean result = true;
        if (!solicitud.getEstudiante().getNombreCompleto().contains(valor)) {
            result = false;
        }
        if (!solicitud.getEstudiante().getCi().contains(valor)) {
            result = false;
        }

        return result ? solicitud : null;
    }
}
