 package models.departamentos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import data.ObtenerEstudiantesConLibrosDocentesPendientes;
import data.ObtenerUsuariosCujae;
import interfaces.Autenticable;
import interfaces.VerificadorEmpleado;
import interfaces.VerificadorEstudiante;
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
    public ArrayList<Estudiante> getEstudiantesPendientes() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Collection<Persona> personas = usuariosCujae.values();
        for (Persona p: personas) {
            if (p instanceof Estudiante) estudiantes.add((Estudiante)p);
        }
        return estudiantes;
    }

    @Override
    public ArrayList<Empleado> getEmpleadosPendientes() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Collection<Persona> personas = usuariosCujae.values();
        for (Persona p: personas) {
            if(p instanceof Empleado) empleados.add((Empleado)p);
        }
        return empleados;
    }
}



