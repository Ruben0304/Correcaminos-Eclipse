package models.gestion.estudiantes;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;

public class GestorResponsabilidadesEstudiantes {
    private ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantesPendientes;
    

    private ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantesCujae;
   

    
    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantesPendientes() {
        return responsabilidadesEstudiantesPendientes;
    }
   
    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantesCujae() {
        return responsabilidadesEstudiantesCujae;
    }
   


    
}
