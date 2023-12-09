package modelos.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import datos.ObtenerEstudiantesConLibrosDocentesPendientes;
import datos.ObtenerPersonasConLibrosBibliotecaPendientes;
import interfaces.AdministradorDeudas;
import interfaces.VerificadorEstudiante;
import modelos.usuarios.Estudiante;

public class AlmacenDeLibros implements VerificadorEstudiante,AdministradorDeudas {

	
	
	private HashMap<String, Set<String>> estudiantesConLibrosDocentes;
	
	public AlmacenDeLibros() {
		estudiantesConLibrosDocentes = new HashMap<String, Set<String>>();
		cargarInformacionEstudiantesConLibrosDocentes();
	}
	
	public void cargarInformacionEstudiantesConLibrosDocentes() {
		estudiantesConLibrosDocentes = ObtenerEstudiantesConLibrosDocentesPendientes.cargarDesdeArchivo();
	}
	
	@Override
	public boolean verificarRequisitos(Estudiante e) {
		return estudiantesConLibrosDocentes.containsKey(e.getCi());
	}
	
	public void recogerDeudas(String e, Set<String> librosDocentes) {
		estudiantesConLibrosDocentes.get(e).removeAll(librosDocentes);
	}
	
	@Override
    public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes) {
    	
    	ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        for (Estudiante e: estudiantesSolicitudesPendientes) {
        	if (estudiantesConLibrosDocentes.containsKey(e.getCi())) {
        		estudiantes.add(e);
        	}
        }
   	
        return estudiantes;
    
    }
	
	public Set<String> obtenerDeudas(String e) {
		return estudiantesConLibrosDocentes.get(e);
	}
}
