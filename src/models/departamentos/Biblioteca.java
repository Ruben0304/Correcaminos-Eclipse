package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.ObtenerEstudiantesConEstipendio;
import data.ObtenerPersonasConLibrosBibliotecaPendientes;
import interfaces.VerificadorEmpleado;
import interfaces.VerificadorEstudiante;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;

public class Biblioteca implements VerificadorEstudiante, VerificadorEmpleado {
	
	private HashMap<String, Set<String>> personasConLibrosBiblioteca;
	
	public Biblioteca() {
		personasConLibrosBiblioteca = new HashMap<String, Set<String>>();
		cargarInformacionPersonasConLibrosBiblioteca();
		
	}
	public void cargarInformacionPersonasConLibrosBiblioteca() {
		personasConLibrosBiblioteca = ObtenerPersonasConLibrosBibliotecaPendientes.cargarDesdeArchivo();
	}
	
	
    @Override
    public boolean verificarRequisitos(Estudiante e) {
        return personasConLibrosBiblioteca.containsKey(e.getCi());
    }

    @Override
	public boolean verificarRequisitos(Empleado e) {
		return personasConLibrosBiblioteca.containsKey(e.getCi());
	}

    public void recogerLibrosPrestados(Persona p) {
    	personasConLibrosBiblioteca.remove(p);
    }

    @Override
    public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes) {
    	
    	ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        for (Estudiante e: estudiantesSolicitudesPendientes) {
        	if (personasConLibrosBiblioteca.containsKey(e.getCi())) {
        		estudiantes.add(e);
        	}
        }
   	
        return estudiantes;
    
    }
    
    @Override
    public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<Empleado> empleadosSolicitudesPendientes) {
    	
    	ArrayList<Empleado> nombresEmpleados = new ArrayList<>();
        
        for (Empleado e: empleadosSolicitudesPendientes) {
        	if (personasConLibrosBiblioteca.containsKey(e.getCi())) {
        		nombresEmpleados.add(e);
        	}
        }
   	
        return nombresEmpleados;
    }
    
    public Set<String> obtenerLibrosPendientes(Persona p) {
    	return personasConLibrosBiblioteca.get(p);
    }
}
