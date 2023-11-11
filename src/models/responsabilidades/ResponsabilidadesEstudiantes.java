package models.responsabilidades;

import java.util.ArrayList;

import models.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class ResponsabilidadesEstudiantes {
    private TiposResponsabilidad responsabilidad;
    private ArrayList<Estudiante> estudiantes;
   
    public ResponsabilidadesEstudiantes(TiposResponsabilidad responsabilidad, ArrayList<Estudiante> estudiantes) {
        this.responsabilidad = responsabilidad;
        this.estudiantes = estudiantes;
    }

    public TiposResponsabilidad getResponsabilidad() {
        return responsabilidad;
    }

    

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

   
}
