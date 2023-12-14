package modelos.gestion.estudiantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import datos.ObtenerEstudiantes;
import modelos.gestion.Correcaminos;
import modelos.usuarios.Estudiante;
import util.Facultad;

public class Secretaria {
    private static Secretaria gestorEstudiantes;
    private GestorSolicitudesEstudiante gestorSolicitudes;
    private ArrayList<Estudiante> estudiantes;

    public Secretaria() {
        estudiantes = new ArrayList<>();
        registrarEstudiantes();
        gestorSolicitudes = new GestorSolicitudesEstudiante();
    }

    public static Secretaria gestorEstudiantes() {
        if (gestorEstudiantes == null) {
            gestorEstudiantes = new Secretaria();
        }
        return gestorEstudiantes;
    }

    private void registrarEstudiantes() {
        this.estudiantes = ObtenerEstudiantes.cargarDesdeArchivo();
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
            
        }
    }

    public Estudiante buscarEstudiantePorCi(String id) {
        boolean encontrado = false;
        Estudiante estudianteEncontrado = null;
        for (int i = 0; i < this.estudiantes.size() && !encontrado; i++) {
            encontrado = id.equals(this.estudiantes.get(i).getCi());
            System.out.println(encontrado);
            if (encontrado) {
                estudianteEncontrado = this.estudiantes.get(i);
            }
        }
        return estudianteEncontrado;
    }

    public ArrayList<Estudiante> getEstudiantes() {

        return estudiantes;
    }

    public GestorSolicitudesEstudiante getGestorSolicitudes() {
        return gestorSolicitudes;
    }

    public ArrayList<Estudiante> filtrar(String valor) {
        ArrayList<Estudiante> estudiantesFiltrados = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getNombre().contains(valor) || estudiante.getFacultad().equals(valor)) {
                estudiantesFiltrados.add(estudiante);
            }

        }

        return estudiantesFiltrados;
    }

}
