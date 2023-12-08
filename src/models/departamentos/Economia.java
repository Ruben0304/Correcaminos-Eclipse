package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import data.ObtenerEstudiantesConEstipendio;
import interfaces.VerificadorEstudiante;
import models.usuarios.Estudiante;
import util.TiposResponsabilidad;

public class Economia implements VerificadorEstudiante {
	
	private HashMap<String, TiposResponsabilidad> estudiantesConEstipendio;
	
	public Economia() {
		estudiantesConEstipendio = new HashMap<String, TiposResponsabilidad>();
		cargarInformacionEstudiantesConEstipendio();
	}
	public void cargarInformacionEstudiantesConEstipendio() {
		estudiantesConEstipendio = ObtenerEstudiantesConEstipendio.cargarDesdeArchivo();
	}
	

    @Override
    public boolean verificarRequisitos(Estudiante e) {
        return estudiantesConEstipendio.containsKey(e.getCi());
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
