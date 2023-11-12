package models.gestion;

import java.util.ArrayList;

import data.ObtenerSolicitudes;
import models.solicitudes.SolicitudBajaEstudiante;
import models.solicitudes.SolicitudLicenciaEstudiante;
import models.usuarios.Estudiante;

public class GestorSolicitudes {
    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaHistoricas;
    ArrayList<SolicitudBajaEstudiante> solicitudesBajaHistoricas;

    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaPendientes;
    ArrayList<SolicitudBajaEstudiante> solicitudesBajaPendientes;


   
    public GestorSolicitudes(ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaHistoricas,
            ArrayList<SolicitudBajaEstudiante> solicitudesBajaHistoricas,
            ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaPendientes,
            ArrayList<SolicitudBajaEstudiante> solicitudesBajaPendientes) {
        this.solicitudesLicenciaHistoricas = solicitudesLicenciaHistoricas;
        this.solicitudesBajaHistoricas = solicitudesBajaHistoricas;
        this.solicitudesLicenciaPendientes = solicitudesLicenciaPendientes;
        this.solicitudesBajaPendientes = solicitudesBajaPendientes;
    }



    public void registrarLicenciasEstudiantes() {
        ArrayList<SolicitudLicenciaEstudiante> solicitudesCargadas = ObtenerSolicitudes.cargarDesdeArchivo();
        ArrayList<SolicitudLicenciaEstudiante> solicitudesRegistradas = new ArrayList<>();
        for (SolicitudLicenciaEstudiante solicitud : solicitudesCargadas) {
            String estudianteId = solicitud.getEstudiante().getCi();
            Estudiante estudianteExistente = buscarEstudiante(estudianteId);

            if (estudianteExistente != null) {
                SolicitudLicenciaEstudiante solicitudRegistrada = new SolicitudLicenciaEstudiante(
                        estudianteExistente, solicitud.getMotivo(), solicitud.getFechaSalida(),
                        solicitud.getFechaRegreso());
                solicitudesRegistradas.add(solicitudRegistrada);
            }
        }

        this.solicitudesLicenciaPendientes.addAll(solicitudesRegistradas);
    }
}
