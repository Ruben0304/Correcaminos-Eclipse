package interfaces;

import java.util.ArrayList;

import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;

public interface VerificadorEstudiante {

	boolean verificarRequisitos(String e);

	ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes);
}
