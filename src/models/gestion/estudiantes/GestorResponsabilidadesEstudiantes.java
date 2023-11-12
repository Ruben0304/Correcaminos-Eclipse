package models.gestion.estudiantes;

import java.util.ArrayList;

import models.interfaces.actualizador;
import models.responsabilidades.ResponsabilidadesEstudiantes;

public class GestorResponsabilidadesEstudiantes implements actualizador{
    private ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantesPendientes;
    private ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantesCujae;
   

    
    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantesPendientes() {
        return responsabilidadesEstudiantesPendientes;
    }
   
    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantesCujae() {
        return responsabilidadesEstudiantesCujae;
    }
   
    @Override
    public void actualizarDatos() {

    }

    
}
