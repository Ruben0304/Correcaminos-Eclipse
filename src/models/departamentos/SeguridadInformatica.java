 package models.departamentos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import controllers.ControladorFiltrado;
import data.ObtenerEstudiantesConLibrosDocentesPendientes;
import data.ObtenerUsuariosCujae;
import interfaces.Autenticable;
import interfaces.VerificadorEmpleado;
import interfaces.VerificadorEstudiante;
import models.solicitudes.Solicitud;
import models.usuarios.Credenciales;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Persona;


public class SeguridadInformatica implements VerificadorEstudiante, VerificadorEmpleado {

    private HashMap<Credenciales,Persona> usuariosCujae;
    
    public SeguridadInformatica() {
    	usuariosCujae = new HashMap<Credenciales,Persona>();
    	cargarInformacionUsuariosCujae();
    }
    private void cargarInformacionUsuariosCujae() {
    	usuariosCujae = ObtenerUsuariosCujae.cargarDesdeArchivo();
	} 
    
    public boolean tieneCuentaUsuarioAbierta(Persona c) {
        return usuariosCujae.containsValue(c);
    }

    public HashMap<Credenciales, Persona> getUsuariosCujae() {
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

    public void cerrarCuenta(Credenciales c) {
        usuariosCujae.remove(c);
    }

    @Override
    public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes) {
    	
    	ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        for (Estudiante e: estudiantesSolicitudesPendientes) {
           
		for (Map.Entry<Credenciales, Persona> usuario : usuariosCujae.entrySet()) {
            Persona estudiante = usuario.getValue();
			if (estudiante.getCi().equals(e.getCi())) {
        		estudiantes.add(e);
        	}
		}
        	
        }
   	
        return estudiantes;
    
    }


    @Override
    public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<Empleado> empleadosSolicitudesPendientes) {
    	
    	ArrayList<Empleado> estudiantes = new ArrayList<>();
        
        for (Empleado e: empleadosSolicitudesPendientes) {
           
		for (Map.Entry<Credenciales, Persona> usuario : usuariosCujae.entrySet()) {
            Persona estudiante = usuario.getValue();
			if (estudiante.getCi().equals(e.getCi())) {
        		estudiantes.add(e);
        	}
		}
        	
        }
   	
        return estudiantes;
    }
}



