package models.interfaces;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;

public interface VerificadorEstudiante {
	boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes);
	
	public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<ResponsabilidadesEstudiantes> responsabilidades);
}
