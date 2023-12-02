package controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import models.gestion.estudiantes.Secretaria;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.solicitudes.SolicitudBajaEstudiante;
import views.admin.PanelAdministracion;
import views.admin.PendientesEstudiantes;
import views.layouts.Pricipal;

public class ControladorFiltrado {

    public static ArrayList<SolicitudBajaEstudiante> obtenerSolicitudesBajaEstudiantesFiltradas(
            HashMap<String, String> map) {
        return Secretaria.gestorEstudiantes().getGestorSolicitudes().filtradoDinamicoSolicitudBajaEstudiantes(map);
    }
}
public ArrayList<Solicitud> filtradoDinamicoSolicitudEstudiantes(Map<String, String> filtros) {
    HashMap<Estudiante, Set<Solicitud>> solicitudesEstudianes = Secretaria.getGestorSolicitudes().getSolicitudes();
    ArrayList<Solicitud> solicitudes = new ArrayList<>();

    for (Map.Entry<Estudiante, Set<Solicitud>> solicitudesEstudianes : solicitudesEstudianes.entrySet()) {
        Estudiante estudiante = solicitudesEstudianes.getKey();
        Set<Solicitud> solicitudes = solicitudesEstudianes.getValue();
        for (Map.Entry<String, String> filtro : filtros.entrySet()) {
            String atributo = filtro.getKey();
            String valor = filtro.getValue();

            switch (atributo) {
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
                case "motivo":
                    if (!solictud.getMotivo().toString().equals(valor)) {
                        cumpleFiltros = false;
                    }
                    break;
                case "buscar":
                    if ((buscarBajaPorNombreOCi(solictud, valor)) == null) {
                        cumpleFiltros = false;
                    }
                    break;
            }
        }

        if (cumpleFiltros) {
            solicitudesBajaFiltradas.add(solictud);
        }
    }

    return solicitudes;
}

public SolicitudBajaEstudiante buscarBajaPorNombreOCi(SolicitudBajaEstudiante solicitud, String valor) {
    boolean result = true;

    if (!(solicitud.getEstudiante().getNombreCompleto().toLowerCase().contains(valor.toLowerCase())
            || solicitud.getEstudiante().getCi().toLowerCase().contains(valor.toLowerCase()))) {
        result = false;
    }

    return result ? solicitud : null;
}
