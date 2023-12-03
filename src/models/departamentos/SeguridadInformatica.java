 package models.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import interfaces.Autenticable;
import models.interfaces.VerificadorEmpleado;
import models.interfaces.VerificadorEstudiante;
import models.usuarios.Credenciales;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import models.usuarios.Usuario;

public class SeguridadInformatica implements VerificadorEstudiante, VerificadorEmpleado {

	private HashMap<Credenciales,Autenticable> usuariosCujae;
	

	public boolean tieneCuentaUsuarioAbierta(Persona p) {
		return usuariosCujae.containsKey(p);
	}

	public HashMap<Credenciales, Autenticable> getUsuariosCujae() {
		return usuariosCujae;
	}
	
	@Override
	public boolean verificarRequisitos(Estudiante e) {
		return tieneCuentaUsuarioAbierta(e);
	}

	@Override
	public boolean verificarRequisitos(Empleado e) {
		return tieneCuentaUsuarioAbierta(e);
	}
	
	public void cerrarCuenta(Persona p) {
		usuariosCujae.remove(p);
	}
	
	 @Override
	    public ArrayList<Estudiante> getEstudiantesPendientes() {
	    	
	    	ArrayList<Estudiante> estudiantes = new ArrayList<>();
	        
	    	Set<Persona> estudiantesPendientes = usuariosCujae.keySet();
	        
	        for (Persona p: estudiantesPendientes) {
	        	if (p instanceof Estudiante) estudiantes.add(((Estudiante)p));
	        }
	   	
	        return estudiantes;
	    }
	    
	    @Override
	    public ArrayList<Empleado> getEmpleadosPendientes() {
	    	
	    	ArrayList<Empleado> nombresEmpleados = new ArrayList<>();
	        
	    	Set<Persona> empleadosPendientes = usuariosCujae.keySet();
	        
	        for (Persona p: empleadosPendientes) {
	        	if(p instanceof Empleado) nombresEmpleados.add(((Empleado)p));
	        }
	   	
	        return nombresEmpleados;
	    
	}

}
