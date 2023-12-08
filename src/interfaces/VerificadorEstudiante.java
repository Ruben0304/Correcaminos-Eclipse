package interfaces;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;

public interface VerificadorEstudiante {

	boolean verificarRequisitos(Estudiante e);

	ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes);
}
