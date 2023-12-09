package modelos.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datos.ObtenerEstudiantesConEstipendio;
import datos.ObtenerPersonasConLibrosBibliotecaPendientes;
import interfaces.AdministradorDeudas;
import interfaces.VerificadorEmpleado;
import interfaces.VerificadorEstudiante;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;

public class Biblioteca implements VerificadorEstudiante, VerificadorEmpleado, AdministradorDeudas {

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

    public void recogerDeudas(String p,Set<String> s) {
    	personasConLibrosBiblioteca.get(p).removeAll(s);
    }

    @Override
    public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes) {

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        for (Estudiante e : estudiantesSolicitudesPendientes) {
            if (personasConLibrosBiblioteca.containsKey(e.getCi())) {
                estudiantes.add(e);
            }
        }

        return estudiantes;

    }

    @Override
    public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<Empleado> empleadosSolicitudesPendientes) {

        ArrayList<Empleado> nombresEmpleados = new ArrayList<>();

        for (Empleado e : empleadosSolicitudesPendientes) {
            if (personasConLibrosBiblioteca.containsKey(e.getCi())) {
                nombresEmpleados.add(e);
            }
        }

        return nombresEmpleados;
    }

    public Set<String> obtenerDeudas(String p) {
        return personasConLibrosBiblioteca.get(p);
    }
}
