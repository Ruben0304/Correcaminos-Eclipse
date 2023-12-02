package controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import models.gestion.estudiantes.Secretaria;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Estudiante;
import views.admin.PanelAdministracion;
import views.admin.PendientesEstudiantes;
import views.layouts.Pricipal;

public class ControladorFiltrado {

    public static ArrayList<Solicitud> obtenerSolicitudesBajaEstudiantesFiltradas(
            HashMap<String, String> map) {
        return filtradoDinamicoSolicitudEstudiantes(map);
    }

    public static ArrayList<Solicitud> filtradoDinamicoSolicitudEstudiantes(Map<String, String> filtros) {
        HashMap<Estudiante, Set<Solicitud>> solicitudesEstudianes = Secretaria.gestorEstudiantes()
                .getGestorSolicitudes().getSolicitudes();
        ArrayList<Solicitud> solicitudesFiltradas = new ArrayList<>();

        for (Map.Entry<Estudiante, Set<Solicitud>> solicitudes : solicitudesEstudianes.entrySet()) {
            Estudiante estudiante = solicitudes.getKey();
            Set<Solicitud> listaSolicitudes = solicitudes.getValue();
            for (Solicitud s : listaSolicitudes) {
                for (Map.Entry<String, String> filtro : filtros.entrySet()) {
                    boolean cumpleFiltros = true;
                    String atributo = filtro.getKey();
                    String valor = filtro.getValue();

                    switch (atributo) {
                        case "licencia":
                            SolicitudLicencia solicitudLicencia = ((SolicitudLicencia) s);
                            switch (atributo) {
                                case "anio":
                                    if (!(solicitudLicencia.getAnioExpedicion() == Integer.parseInt(valor))) {
                                        cumpleFiltros = false;
                                    }
                                    break;
                                case "estado":
                                    if (!solicitudLicencia.getEstado().toString().equals(valor)) {
                                        cumpleFiltros = false;
                                    }
                                    break;
                                case "motivo":
                                    if (!solicitudLicencia.getMotivo().toString().equals(valor)) {
                                        cumpleFiltros = false;
                                    }
                                    break;
                                case "buscar":
                                    if (!(buscarPorNombreOCi(estudiante, valor))) {
                                        cumpleFiltros = false;
                                    }
                                    break;
                            }

                            if (cumpleFiltros) {
                                solicitudesFiltradas.add(solicitudLicencia);
                            }
                            break;

                        case "baja":
                            SolicitudBaja solicitudBaja = ((SolicitudBaja) s);
                            switch (atributo) {
                                case "anio":
                                    if (!(solicitudBaja.getAnioExpedicion() == Integer.parseInt(valor))) {
                                        cumpleFiltros = false;
                                    }
                                    break;
                                case "estado":
                                    if (!solicitudBaja.getEstado().toString().equals(valor)) {
                                        cumpleFiltros = false;
                                    }
                                    break;
                                case "motivo":
                                    if (!solicitudBaja.getMotivo().toString().equals(valor)) {
                                        cumpleFiltros = false;
                                    }
                                    break;
                                case "buscar":
                                    if (!(buscarPorNombreOCi(estudiante, valor))) {
                                        cumpleFiltros = false;
                                    }
                                    break;
                            }

                            if (cumpleFiltros) {
                                solicitudesFiltradas.add(solicitudBaja);
                            }
                            break;
                    }
                }

            }
        }

        return solicitudesFiltradas;
    }

    public static boolean buscarPorNombreOCi(Estudiante e, String valor) {

        return !(e.getNombreCompleto().toLowerCase().contains(valor.toLowerCase())
                || e.getCi().toLowerCase().contains(valor.toLowerCase()));
    }
}