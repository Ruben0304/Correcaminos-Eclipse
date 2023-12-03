package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interfaces.VerificadorEstudiante;
import models.usuarios.Becado;
import models.usuarios.Estudiante;

public class DireccionDeBecas implements VerificadorEstudiante {
	
	private HashMap<Becado, Set<String>> pertenenciasBecados;
	
	
	@Override
	public boolean verificarRequisitos(Estudiante e) {
		return pertenenciasBecados.containsKey(((Becado)e));
	}
	
	public void recogerPertenenciasDeEstudiante(Estudiante e, Set<String> pertenencias) {
		pertenenciasBecados.get(e).removeAll(pertenencias);
	}
	
	@Override
	public ArrayList<Estudiante> getEstudiantesPendientes() {
		
		ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
    	Set<Becado> estudiantesPendientes = pertenenciasBecados.keySet();
        
        for (Becado b: estudiantesPendientes) {
        	estudiantes.add(b);
        }
   	
        return estudiantes;
    }
	
	public Set<String> obtenerPertenenciasBecado(Estudiante e) {
		return pertenenciasBecados.get(((Becado)e));
	}
}
