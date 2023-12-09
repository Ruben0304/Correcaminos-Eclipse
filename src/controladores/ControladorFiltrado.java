package controladores;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import modelos.gestion.estudiantes.GestorSolicitudesEstudiante;
import modelos.gestion.estudiantes.Secretaria;
import modelos.solicitudes.Solicitud;
import modelos.solicitudes.SolicitudBaja;
import modelos.solicitudes.SolicitudLicencia;
import modelos.usuarios.Estudiante;
import vistas.admin.PanelAdministracion;
import vistas.admin.PendientesEstudiantes;
import vistas.template.Pricipal;

public class ControladorFiltrado {

   

    public static HashMap<Estudiante, Set<Solicitud>> filtradoDinamicoSolicitudEstudiantes(Map<String, String> filtros) {
        HashMap<Estudiante, Set<Solicitud>> solicitudesEstudianes = Secretaria.gestorEstudiantes()
                .getGestorSolicitudes().getSolicitudes();
        HashMap<Estudiante, Set<Solicitud>> solicitudesFiltradas = new HashMap<>();

        for (Map.Entry<Estudiante, Set<Solicitud>> solicitudes : solicitudesEstudianes.entrySet()) {
            Estudiante estudiante = solicitudes.getKey();
            Set<Solicitud> listaSolicitudes = solicitudes.getValue();
            for (Solicitud s : listaSolicitudes) {
                boolean cumpleFiltros = true;
                for (Map.Entry<String, String> filtro : filtros.entrySet()) {

                    String atributo = filtro.getKey();
                    String valor = filtro.getValue();

                    switch (atributo) {
                        case "anio":
                            if (!(s.getAnioExpedicion() == Integer.parseInt(valor))) {
                                cumpleFiltros = false;
                            }
                            break;
                        case "estado":
                            if (!s.getEstado().toString().equals(valor)) {
                                cumpleFiltros = false;
                            }
                            break;
                        case "motivo":
                            if (s instanceof SolicitudLicencia) {
                                if (!((SolicitudLicencia) s).getMotivo().toString().equals(valor)) {
                                    cumpleFiltros = false;
                                }
                            } else {
                                if (!((SolicitudBaja) s).getMotivo().toString().equals(valor)) {
                                    cumpleFiltros = false;
                                }
                            }
                            break;
                        case "buscar":
                            if (!(buscarPorNombreOCi(estudiante, valor))) {
                                cumpleFiltros = false;
                            }
                            break;
                        case "tipoSolicitud":
                            if ("licencia".equals(valor)) {
                                if (s instanceof SolicitudBaja) {
                                    cumpleFiltros = false;
                                }
                            }
                           else if ("baja".equals(valor)) {
                                 if (s instanceof SolicitudLicencia) {
                                    cumpleFiltros = false;
                                }
                            }
                            break;
                    }

                }
                if (cumpleFiltros) {
                    solicitudesFiltradas.put(estudiante, listaSolicitudes);
                }
            }
        }

        return solicitudesFiltradas;
    }

    public static boolean buscarPorNombreOCi(Estudiante e, String valor) {

        return (e.getNombreCompleto().toLowerCase().contains(valor.toLowerCase())
                || e.getCi().toLowerCase().contains(valor.toLowerCase()));
    }
}