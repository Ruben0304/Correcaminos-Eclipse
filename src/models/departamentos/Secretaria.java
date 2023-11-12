package models.departamentos;


import java.util.ArrayList;

import data.ObtenerEstudinetes;
import data.ObtenerSolicitudes;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.solicitudes.SolicitudBajaEstudiante;
import models.solicitudes.SolicitudLicenciaEstudiante;
import models.usuarios.Estudiante;

public class Secretaria {
    ArrayList<Estudiante> estudiantes;
    

    public Secretaria() {
        estudiantes = new ArrayList<>();
        registrarEstudiantes();
        registrarLicenciasEstudiantes();
    }

    public void registrarEstudiantes() {
       this.estudiantes = ObtenerEstudinetes.cargarDesdeArchivo();
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

    public void agregarSolicitudDeLicencia(SolicitudLicenciaEstudiante solicitud) {
        solicitudesLicenciaPendientes.add(solicitud);
    }

    public boolean verificarEstudianteSolicitaLicencia(Estudiante e) {
        boolean encontrado = false;
        for (int i = 0; i < this.solicitudesLicenciaPendientes.size() && !encontrado; i++) {
            encontrado = e.getCi().equals(this.solicitudesLicenciaPendientes.get(i).getEstudiante().getCi());
        }
        return encontrado;
    }

    public Estudiante buscarEstudiante(String id) {
        boolean encontrado = false;
        Estudiante estudianteEncontrado = null;
        for (int i = 0; i < this.estudiantes.size() && !encontrado; i++) {
            encontrado = id.equals(this.estudiantes.get(i).getCi());
            if (encontrado) {
                estudianteEncontrado = this.estudiantes.get(i);
            }
        }
        return estudianteEncontrado;
    }

    public ArrayList<SolicitudLicenciaEstudiante> getSolicitudesLicenciaPendientes() {

        return solicitudesLicenciaPendientes;
    }

    public ArrayList<Estudiante> getEstudianteLicenciaPendientes() {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (SolicitudLicenciaEstudiante s : this.solicitudesLicenciaPendientes) {
            es.add(s.getEstudiante());
        }
        return es;
    }

    public ArrayList<Estudiante> getEstudiantes() {

        return estudiantes;
    }

    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantes() {

        return responsabilidades;
    }

}
