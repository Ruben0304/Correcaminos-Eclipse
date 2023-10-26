package modelos.datos;

import java.util.ArrayList;

import modelos.entidades.Estudiante;
import modelos.entidades.SolicitudLicenciaEstudiante;

public class SolicitudFactory {
    public static ArrayList<SolicitudLicenciaEstudiante> inicializarLicenciasEstudiantesFictisios(ArrayList<Estudiante> estudiantes) { 
     int i = 0;
     ArrayList<SolicitudLicenciaEstudiante> solicitudes = new ArrayList<>();
     SolicitudLicenciaEstudiante nuevasolicitud = null;
        for (Estudiante estudiante : estudiantes) {
            i++;
            if (i%2 == 0) {
                nuevasolicitud = new SolicitudLicenciaEstudiante(estudiante,"fdfdfd","hoy","mes que viene");
                solicitudes.add(nuevasolicitud);
            }
        }
     
        return solicitudes;

    }
}
