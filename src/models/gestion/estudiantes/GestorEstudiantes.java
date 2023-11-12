package models.gestion.estudiantes;

import java.util.ArrayList;

import data.ObtenerEstudiantes;

import models.interfaces.Actualizador;

import models.usuarios.Estudiante;

public class GestorEstudiantes implements Actualizador {
    private GestorSolicitudesEstudiante gestorSolicitudes;
    private GestorResponsabilidadesEstudiantes gestorResponsabilidadesEstudiantes;
    private ArrayList<Estudiante> estudiantes;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
        registrarEstudiantes();
        gestorSolicitudes = new GestorSolicitudesEstudiante(estudiantes);
        gestorResponsabilidadesEstudiantes = new GestorResponsabilidadesEstudiantes(estudiantes);

    }

    private void registrarEstudiantes() {
        this.estudiantes = ObtenerEstudiantes.cargarDesdeArchivo();
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

    
   

    @Override
    public void actualizarDatos() {

    }

    public GestorSolicitudesEstudiante getGestorSolicitudes() {
        return gestorSolicitudes;
    }

    public GestorResponsabilidadesEstudiantes getGestorResponsabilidadesEstudiantes() {
        return gestorResponsabilidadesEstudiantes;
    }
}
