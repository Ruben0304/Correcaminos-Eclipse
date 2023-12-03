package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interfaces.VerificadorEmpleado;
import interfaces.VerificadorEstudiante;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;

public class Biblioteca implements VerificadorEstudiante, VerificadorEmpleado {
	
	private HashMap<Persona, Set<String>> personasConLibrosDocentes;
	
	public boolean tieneLibrosPrestados(Persona p){
        return personasConLibrosDocentes.containsKey(p);        
    }
	
    @Override
    public boolean verificarRequisitos(Estudiante e) {
        return tieneLibrosPrestados(e);
    }

    @Override
	public boolean verificarRequisitos(Empleado e) {
		return tieneLibrosPrestados(e);
	}

    public void recogerLibrosPrestados(Persona p) {
    	personasConLibrosDocentes.remove(p);
    }

    @Override
    public ArrayList<Estudiante> getEstudiantesPendientes() {
    	
    	ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
    	Set<Persona> estudiantesPendientes = personasConLibrosDocentes.keySet();
        
        for (Persona p: estudiantesPendientes) {
        	if (p instanceof Estudiante) estudiantes.add(((Estudiante)p));
        }
   	
        return estudiantes;
    }
    
    @Override
    public ArrayList<Empleado> getEmpleadosPendientes() {
    	
    	ArrayList<Empleado> nombresEmpleados = new ArrayList<>();
        
    	Set<Persona> empleadosPendientes = personasConLibrosDocentes.keySet();
        
        for (Persona p: empleadosPendientes) {
        	if(p instanceof Empleado) nombresEmpleados.add(((Empleado)p));
        }
   	
        return nombresEmpleados;
    }
    
    public Set<String> obtenerLibrosPendientes(Persona p) {
    	return personasConLibrosDocentes.get(p);
    }
}
