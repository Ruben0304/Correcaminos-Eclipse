package modelos.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import datos.ObtenerEstudiantesConEstipendio;
import interfaces.VerificadorEstudiante;
import modelos.usuarios.Estudiante;
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
    	estudiantesConEstipendio.remove(e.getCi());
    }

   
    @Override
    public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes) {
    	
    	ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        for (Estudiante e: estudiantesSolicitudesPendientes) {
        	if (estudiantesConEstipendio.containsKey(e.getCi())) {
        		estudiantes.add(e);
        	}
        }
   	
        return estudiantes;
    
    }


}
