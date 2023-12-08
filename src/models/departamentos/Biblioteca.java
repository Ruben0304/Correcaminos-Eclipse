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
    public ArrayList<Estudiante> getEstudiantesPendientes() {
    	
    	ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
    	Set<Persona> estudiantesPendientes = personasConLibrosBiblioteca.keySet();
        
        for (Persona p: estudiantesPendientes) {
        	if (p instanceof Estudiante) estudiantes.add(((Estudiante)p));
        }
   	
        return estudiantes;
    }
    
    @Override
    public ArrayList<Empleado> getEmpleadosPendientes() {
    	
    	ArrayList<Empleado> nombresEmpleados = new ArrayList<>();
        
    	Set<Persona> empleadosPendientes = personasConLibrosBiblioteca.keySet();
        
        for (Persona p: empleadosPendientes) {
        	if(p instanceof Empleado) nombresEmpleados.add(((Empleado)p));
        }
   	
        return nombresEmpleados;
    }
    
    public Set<String> obtenerLibrosPendientes(Persona p) {
    	return personasConLibrosBiblioteca.get(p);
    }
}
