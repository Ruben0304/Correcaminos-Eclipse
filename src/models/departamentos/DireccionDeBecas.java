package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interfaces.VerificadorEstudiante;
import models.usuarios.Becado;
import models.usuarios.Estudiante;


public class DireccionDeBecas implements VerificadorEstudiante {
	
	private HashMap<Becado,Set<String>> estudiantesBecados;
	
	@Override
	public boolean verificarRequisitos(Estudiante e) {
		return estudiantesBecados.containsKey(((Becado)e));
	}
	
	public void recogerPertenenciasDeEstudiante(Estudiante e, Set<String> pertenencias) {
		estudiantesBecados.get(e).removeAll(pertenencias);
	}
	
	@Override
    public ArrayList<Estudiante> getEstudiantesPendientes() {
        
    	ArrayList<Estudiante> nombresEstudiantes = new ArrayList<>();
       
    	Set<Becado> estudiantesPendientes = estudiantesBecados.keySet();
        
        for (Estudiante e: estudiantesPendientes) {
        	nombresEstudiantes.add(e);
        }
        
        return nombresEstudiantes;
    }

}
