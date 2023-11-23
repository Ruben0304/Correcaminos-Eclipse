package controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.solicitudes.SolicitudBajaEstudiante;
import views.Pricipal;
import views.admin.PanelAdministracion;
import views.admin.PendientesEstudiantes;

public class ControladorFiltrado {

    public static ArrayList<SolicitudBajaEstudiante> obtenerSolicitudesBajaEstudiantesFiltradas(
            HashMap<String, String> map) {
        return GestorEstudiantes.gestorEstudiantes().getGestorSolicitudes()
                .filtradoDinamicoSolicitudBajaEstudiantes(map);
    }
}
