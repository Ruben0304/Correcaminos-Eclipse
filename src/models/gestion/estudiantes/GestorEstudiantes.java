package models.gestion.estudiantes;

import java.util.ArrayList;

import data.ObtenerEstudinetes;
import models.usuarios.Estudiante;

public class GestorEstudiantes {
    private GestorSolicitudesEstudiante gestorSolicitudes;
    private GestorResponsabilidadesEstudiantes gestorResponsabilidadesEstudiantes;
    private ArrayList<Estudiante> estudiantes;

    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
        registrarEstudiantes();
        this.gestorSolicitudes=new GestorSolicitudesEstudiante(estudiantes);
    }
    

    private void registrarEstudiantes() {
        this.estudiantes = ObtenerEstudinetes.cargarDesdeArchivo();
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

}
