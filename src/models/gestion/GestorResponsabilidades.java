package models.gestion;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;

public class GestorResponsabilidades {
    private ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantesPendientes;
    private ArrayList<ResponsabilidadesEmpleados> responsabilidadesEmpleadosPendientes;

    private ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantesCujae;
    private ArrayList<ResponsabilidadesEmpleados> responsabilidadesEmpleadosCujae;

    
    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantesPendientes() {
        return responsabilidadesEstudiantesPendientes;
    }
    public ArrayList<ResponsabilidadesEmpleados> getResponsabilidadesEmpleadosPendientes() {
        return responsabilidadesEmpleadosPendientes;
    }
    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantesCujae() {
        return responsabilidadesEstudiantesCujae;
    }
    public ArrayList<ResponsabilidadesEmpleados> getResponsabilidadesEmpleadosCujae() {
        return responsabilidadesEmpleadosCujae;
    }


    
}
