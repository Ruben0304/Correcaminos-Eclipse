package models.responsabilidades;

import java.util.ArrayList;

import models.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class ResponsabilidadesEstudiantes {
    private Estudiante  estudiante;
    private ArrayList<TiposResponsabilidad> responsabilidades;
   
    public ResponsabilidadesEstudiantes(ArrayList<TiposResponsabilidad> responsabilidades, Estudiante  estudiante) {
        this.responsabilidades = responsabilidades;
        this.estudiante = estudiante;
    }

    public ResponsabilidadesEstudiantes(Estudiante  estudiante) {
        this.responsabilidades = new ArrayList<>();
        this.estudiante = estudiante;
    }

   

    public void agregarResponsabilidad(TiposResponsabilidad responsabilidad) {
        this.responsabilidades.add(responsabilidad);
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public ArrayList<TiposResponsabilidad> getResponsabilidades() {
        return responsabilidades;
    }

   
}
