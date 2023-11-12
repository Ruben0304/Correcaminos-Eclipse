package models.gestion.estudiantes;

import java.util.ArrayList;

import data.ObtenerSolicitudes;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Estudiante;

public class GestorSolicitudesEstudiante {

    ArrayList<SolicitudLicencia> solicitudesLicenciaHistoricas;
    ArrayList<SolicitudBaja> solicitudesBajaHistoricas;


    ArrayList<SolicitudLicencia> solicitudesLicenciaPendientes;
    ArrayList<SolicitudBaja> solicitudesBajaPendientes;


   
    public GestorSolicitudesEstudiante(ArrayList<Estudiante> estudiantes) {
        this.solicitudesLicenciaHistoricas = new ArrayList<>();
        this.solicitudesBajaHistoricas = new ArrayList<>();
        this.solicitudesLicenciaPendientes = new ArrayList<>();
        this.solicitudesBajaPendientes = new ArrayList<>();
        registrarLicenciasEstudiantes(estudiantes);
    }



    private void registrarLicenciasEstudiantes(ArrayList<Estudiante> estudiantes) {
        ArrayList<SolicitudLicencia> solicitudesCargadas = ObtenerSolicitudes.cargarDesdeArchivo();
        ArrayList<SolicitudLicencia> solicitudesRegistradas = new ArrayList<>();
        for (SolicitudLicencia solicitud : solicitudesCargadas) {
            String estudianteId = solicitud.getEstudiante().getCi();
            Estudiante estudianteExistente = referenciarEstudiante(estudianteId,estudiantes);

            if (estudianteExistente != null) {
                SolicitudLicencia solicitudRegistrada = new SolicitudLicencia(
                        estudianteExistente, solicitud.getMotivo(), solicitud.getFechaSalida(),
                        solicitud.getFechaRegreso());
                solicitudesRegistradas.add(solicitudRegistrada);
            }
        }

        this.solicitudesLicenciaPendientes.addAll(solicitudesRegistradas);
    }

    private Estudiante referenciarEstudiante(String id, ArrayList<Estudiante> estudiantes) {
        boolean encontrado = false;
        Estudiante estudianteEncontrado = null;
        for (int i = 0; i < estudiantes.size() && !encontrado; i++) {
            encontrado = id.equals(estudiantes.get(i).getCi());
            if (encontrado) {
                estudianteEncontrado = estudiantes.get(i);
            }
        }
        return estudianteEncontrado;
    }
}
