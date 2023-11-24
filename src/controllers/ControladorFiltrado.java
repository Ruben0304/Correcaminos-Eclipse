package controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import models.gestion.empleados.GestorEmpleados;
import models.gestion.empleados.GestorSolicitudesEmpleados;
import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBajaEmpleado;
import models.solicitudes.SolicitudBajaEstudiante;
import views.Pricipal;
import views.admin.PanelAdministracion;
import views.admin.PendientesEstudiantes;

public class ControladorFiltrado {

    public static SolicitudBajaEstudiante buscarBajaPorNombreOCi(SolicitudBajaEstudiante solicitud, String valor) {
        boolean result = true;

        if (!(solicitud.getEstudiante().getNombreCompleto().toLowerCase().contains(valor.toLowerCase())
                || solicitud.getEstudiante().getCi().toLowerCase().contains(valor.toLowerCase()))) {
            result = false;
        }

        return result ? solicitud : null;
    }

    public static ArrayList<SolicitudBajaEstudiante> obtenerSolicitudesBajaEstudiantesFiltradas(
            HashMap<String, String> map) {
        return GestorEstudiantes.gestorEstudiantes().getGestorSolicitudes()
                .filtradoDinamicoSolicitudBajaEstudiantes(map);
    }

    // public static ArrayList<Solicitud> filtradoDinamicoSolicitudBaja(Map<String, String> filtros,
    //         boolean isEstudiante) {
    //     GestorSolicitudesEstudiante gestorSolicitudesEstudiante = GestorEstudiantes.gestorEstudiantes()
    //             .getGestorSolicitudes();
    //     GestorSolicitudesEmpleados gestorSolicitudesEmpleados = GestorEmpleados.gestorEmpleados()
    //             .getGestorSolicitudesEmpleados();
    //     ArrayList<Solicitud> solicitudesBajaFiltradas = new ArrayList<>();


    //     if (isEstudiante) {

    //          for (Solicitud solictud : gestorSolicitudesEstudiante.getSolicitudesBaja()) {
    //         boolean cumpleFiltros = true;
    //         for (Map.Entry<String, String> filtro : filtros.entrySet()) {
    //             String atributo = filtro.getKey();
    //             String valor = filtro.getValue();

    //             switch (atributo) {
    //                 case "facultad":
    //                     if (!solictud.getEstudiante().getFacultad().toString().equals(valor)) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //                 case "anio":
    //                     if (!(solictud.getAnioExpedicion() == Integer.parseInt(valor))) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //                 case "estado":
    //                     if (!solictud.getEstado().toString().equals(valor)) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //                 case "motivo":
    //                     if (!solictud.getMotivo().toString().equals(valor)) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //                 case "buscar":
    //                     if ((buscarBajaPorNombreOCi(solictud, valor)) == null) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //             }
    //         }

    //         if (cumpleFiltros) {
    //             solicitudesBajaFiltradas.add(solictud);
    //         }
    //     }
    //     }

    //     for (Solicitud solictud : isEstudiante ? gestorSolicitudesEstudiante.getSolicitudesBaja()
    //             : gestorSolicitudesEmpleados.getSolicitudesBaja()) {
    //         boolean cumpleFiltros = true;
    //         for (Map.Entry<String, String> filtro : filtros.entrySet()) {
    //             String atributo = filtro.getKey();
    //             String valor = filtro.getValue();

    //             switch (atributo) {
    //                 case "facultad":
    //                 if(solictud instanceof SolicitudBajaEstudiante){
    //                     if (!((SolicitudBajaEstudiante)solictud).getEstudiante().getFacultad().toString().equals(valor)) {
    //                         cumpleFiltros = false;
    //                     }
    //                     else {
    //                         if(((SolicitudBajaEmpleado)solicitud).getEmpleado().get)
    //                     }
    //                 }
                        
    //                     break;
    //                 case "anio":
    //                     if (!(solictud.getAnioExpedicion() == Integer.parseInt(valor))) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //                 case "estado":
    //                     if (!solictud.getEstado().toString().equals(valor)) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //                 case "motivo":
    //                     if (!solictud.getMotivo().toString().equals(valor)) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //                 case "buscar":
    //                     if ((buscarBajaPorNombreOCi(solictud, valor)) == null) {
    //                         cumpleFiltros = false;
    //                     }
    //                     break;
    //             }
    //         }

    //         if (cumpleFiltros) {
    //             solicitudesBajaFiltradas.add(solictud);
    //         }
    //     }

    //     return solicitudesBajaFiltradas;
    // }

    
}
