 package modelos.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import controladores.ControladorFiltrado;
import datos.ObtenerEstudiantesConLibrosDocentesPendientes;
import datos.ObtenerUsuariosCujae;
import interfaces.Autenticable;
import interfaces.VerificadorEmpleado;
import interfaces.VerificadorEstudiante;
import modelos.solicitudes.Solicitud;
import modelos.usuarios.Credenciales;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;


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



