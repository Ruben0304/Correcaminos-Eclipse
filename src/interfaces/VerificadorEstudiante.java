package interfaces;

import java.util.ArrayList;


import modelos.usuarios.Estudiante;

public interface VerificadorEstudiante {

	boolean verificarRequisitos(Estudiante e);

	ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes);
}
