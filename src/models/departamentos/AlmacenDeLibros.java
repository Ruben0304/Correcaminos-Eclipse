package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import data.ObtenerEstudiantesConLibrosDocentesPendientes;
import data.ObtenerPersonasConLibrosBibliotecaPendientes;
import interfaces.VerificadorEstudiante;
import models.usuarios.Estudiante;

public class AlmacenDeLibros implements VerificadorEstudiante {

	
	private AlmacenDeLibros almacen;
	private HashMap<String, Set<String>> estudiantesConLibrosDocentes;
	
	public AlmacenDeLibros() {
		estudiantesConLibrosDocentes = new HashMap<String, Set<String>>();
		cargarInformacionEstudiantesConLibrosDocentes();
	}
	
	public void cargarInformacionEstudiantesConLibrosDocentes() {
		estudiantesConLibrosDocentes = ObtenerEstudiantesConLibrosDocentesPendientes.cargarDesdeArchivo();
	}
	public boolean tieneLibrosDocentes(Estudiante e) {
		return estudiantesConLibrosDocentes.containsKey(e);
	}
	@Override
	public boolean verificarRequisitos(Estudiante e) {
		return tieneLibrosDocentes(e);
	}
	
	public void recogerLibrosDocentes(Estudiante e, Set<String> librosDocentes) {
		estudiantesConLibrosDocentes.get(e).removeAll(librosDocentes);
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
	
	public Set<String> obtenerEstudianteLibrosDocentesPendientes(Estudiante e) {
		return estudiantesConLibrosDocentes.get(e);
	}
}
