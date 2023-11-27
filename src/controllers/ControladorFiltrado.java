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
        return Secretaria.gestorEstudiantes().getGestorSolicitudes()
                .filtradoDinamicoSolicitudBajaEstudiantes(map);
    }
}
