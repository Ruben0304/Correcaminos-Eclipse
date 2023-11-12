package models.departamentos;


import java.util.ArrayList;

import data.ObtenerEstudinetes;
import data.ObtenerSolicitudes;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Estudiante;

public class Secretaria {
    
    

    public Secretaria() {
        registrarEstudiantes();
        registrarLicenciasEstudiantes();
    }

    

    

    public void agregarSolicitudDeLicencia(SolicitudLicencia solicitud) {
        solicitudesLicenciaPendientes.add(solicitud);
    }

    public boolean verificarEstudianteSolicitaLicencia(Estudiante e) {
        boolean encontrado = false;
        for (int i = 0; i < this.solicitudesLicenciaPendientes.size() && !encontrado; i++) {
            encontrado = e.getCi().equals(this.solicitudesLicenciaPendientes.get(i).getEstudiante().getCi());
        }
        return encontrado;
    }

   

    public ArrayList<SolicitudLicencia> getSolicitudesLicenciaPendientes() {

        return solicitudesLicenciaPendientes;
    }

    public ArrayList<Estudiante> getEstudianteLicenciaPendientes() {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (SolicitudLicencia s : this.solicitudesLicenciaPendientes) {
            es.add(s.getEstudiante());
        }
        return es;
    }

    
    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantes() {

        return responsabilidades;
    }

}
