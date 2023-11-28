package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import models.interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import util.TiposResponsabilidad;

public class AlmacenDeLibros implements VerificadorEstudiante {

	private HashMap<Estudiante, TiposResponsabilidad> estudiantesConLibrosDocentes;
	
	public boolean tieneLibrosDocentes(Estudiante e) {
		return estudiantesConLibrosDocentes.containsKey(e);
	}
	@Override
	public boolean verificarRequisitos(Estudiante e) {
		return tieneLibrosDocentes(e);
	}
	
	public void recogerLibrosDocentes(Estudiante e) {
		estudiantesConLibrosDocentes.remove(e);
	}
	
	@Override
	public ArrayList<Estudiante> getEstudiantesPendientes() {
        
		ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
    	Set<Estudiante> estudiantesPendientes = estudiantesConLibrosDocentes.keySet();
        
        for (Estudiante e: estudiantesPendientes) {
        	estudiantes.add(e);
        }
   	
        return estudiantes;
    }

}
