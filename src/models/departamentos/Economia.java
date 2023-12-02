package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import data.ObtenerEstudiantesConEstipendio;
import interfaces.VerificadorEstudiante;
import models.usuarios.Estudiante;
import util.TiposResponsabilidad;

public class Economia implements VerificadorEstudiante {
	
	private HashMap<Estudiante, TiposResponsabilidad> estudiantesConEstipendio;
	
	public void cargarInformacionEstudiantesConCarnet() {
		estudiantesConEstipendio = ObtenerEstudiantesConEstipendio.cargarDesdeArchivo();
	}
	
    public boolean tieneEstipendio(Estudiante e) {
        return estudiantesConEstipendio.containsKey(e);
    }

    @Override
    public boolean verificarRequisitos(Estudiante e) {
        return tieneEstipendio(e);
    }

    public void cancelarPagoEstipendio(Estudiante e) {
    	estudiantesConEstipendio.remove(e);
    }

   
    @Override
    public ArrayList<Estudiante> getEstudiantesPendientes() {
        
    	ArrayList<Estudiante> nombresEstudiantes = new ArrayList<>();
       
    	Set<Estudiante> estudiantesPendientes = estudiantesConEstipendio.keySet();
        
        for (Estudiante e: estudiantesPendientes) {
        	nombresEstudiantes.add(e);
        }
        
        return nombresEstudiantes;
    }


}
