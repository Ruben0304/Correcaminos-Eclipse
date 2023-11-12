package models.gestion;

import java.util.ArrayList;

import models.solicitudes.SolicitudBajaEstudiante;
import models.solicitudes.SolicitudLicenciaEstudiante;

public class GestorSolicitudes {
    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaHistoricas;
    ArrayList<SolicitudBajaEstudiante> solicitudesBajaHistoricas;
    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaPendientes;
    ArrayList<SolicitudBajaEstudiante> solicitudesBajaPendientes;
}
