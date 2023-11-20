package models.gestion.estudiantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import data.ObtenerEstudiantes;
import models.gestion.GestorPrincipal;
import models.interfaces.Actualizador;

import models.usuarios.Estudiante;
import util.Facultad;

public class GestorEstudiantes {
    private static GestorEstudiantes gestorEstudiantes;
    private GestorSolicitudesEstudiante gestorSolicitudes;
    private GestorResponsabilidadesEstudiantes gestorResponsabilidadesEstudiantes;
    private ArrayList<Estudiante> estudiantes;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
        registrarEstudiantes();
        gestorSolicitudes = new GestorSolicitudesEstudiante(estudiantes);
        gestorResponsabilidadesEstudiantes = new GestorResponsabilidadesEstudiantes(estudiantes);

    }

    public static GestorEstudiantes gestorEstudiantes() {
        if (gestorEstudiantes == null) {
            gestorEstudiantes = new GestorEstudiantes();
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

    public GestorResponsabilidadesEstudiantes getGestorResponsabilidadesEstudiantes() {
        return gestorResponsabilidadesEstudiantes;
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

    public ArrayList<Estudiante> filtrar(Map<String, String> filtros) {
    ArrayList<Estudiante> estudiantesFiltrados = new ArrayList<>();

    for (Estudiante estudiante : estudiantes) {
        boolean cumpleFiltros = true;
        for (Map.Entry<String, String> filtro : filtros.entrySet()) {
            String atributo = filtro.getKey();
            String valor = filtro.getValue();

            switch (atributo) {
                case "nombre":
                    if (!estudiante.getNombre().equals(valor)) {
                        cumpleFiltros = false;
                    }
                    break;
                case "facultad":
                    if (!estudiante.getFacultad().equals(valor)) {
                        cumpleFiltros = false;
                    }
                    break;
                // Agrega más casos para cada atributo que quieras filtrar
            }
        }

        if (cumpleFiltros) {
            estudiantesFiltrados.add(estudiante);
        }
    }

    return estudiantesFiltrados;
}

}
