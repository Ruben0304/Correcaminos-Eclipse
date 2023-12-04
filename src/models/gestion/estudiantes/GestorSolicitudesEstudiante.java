package models.gestion.estudiantes;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Set;

import data.ObtenerSolicitudesEstudiantes;
import models.solicitudes.Solicitud;

import models.usuarios.Estudiante;
import util.Estado;


public class GestorSolicitudesEstudiante{

    private HashMap<Estudiante, Set<Solicitud>> solicitudes;

    public GestorSolicitudesEstudiante(ArrayList<Estudiante> estudiantes) {

        registrarSolicitudes();
    }

    private void registrarSolicitudes() {
        this.solicitudes = ObtenerSolicitudesEstudiantes.cargarDesdeArchivo();

    }

    
public HashMap<Estudiante, Set<Solicitud>> getSolicitudes() {
    return solicitudes;
}
    public boolean verificarEstudianteSolicitaAlgo(Estudiante e) {
        boolean solicita = false;
        if (solicitudes.containsKey(e)) {
            for (Solicitud s : solicitudes.get(e)) {
                if ( s.getEstado().equals(Estado.PENDIENTE)) {
                    solicita = true;
                }
            }

        }

        return solicita;

    }


    
}
