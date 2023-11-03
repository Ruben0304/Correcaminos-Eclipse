package modelos.fabricas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelos.solicitudes.SolicitudLicenciaEstudiante;
import modelos.usuarios.Estudiante;

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
