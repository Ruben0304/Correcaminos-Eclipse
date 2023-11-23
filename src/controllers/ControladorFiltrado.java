package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.solicitudes.SolicitudBajaEstudiante;
import views.admin.PanelAdministracion;
import views.admin.PendientesEstudiantes;

public class ControladorFiltrado {

    public static void Filtrar(HashMap<String, String> map) {

      ArrayList<SolicitudBajaEstudiante> solicitudBajaEstudiantes =  GestorEstudiantes.gestorEstudiantes().getGestorSolicitudes().filtradoDinamicoSolicitudBajaEstudiantes(map);
        PanelAdministracion.getPanelAdministracion().getTable().setModel(new PendientesEstudiantes(solicitudBajaEstudiantes,8));

    }
}
