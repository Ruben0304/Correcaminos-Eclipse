package models.gestion;

import models.departamentos.Biblioteca;
import models.departamentos.Economia;
import models.departamentos.RecursosHumanos;
import models.departamentos.Secretaria;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;
import views.usuarios.EstudianteTramites;
import java.util.ArrayList;

public class GestorDepartamentos {
    private Secretaria secretaria;
    private RecursosHumanos recursosHumanos;
    private Biblioteca biblioteca;
    private Economia economia;

    public GestorDepartamentos() {
        secretaria = new Secretaria();
        recursosHumanos = new RecursosHumanos();
        biblioteca = new Biblioteca();
        economia = new Economia();
    }

    public ArrayList<Boolean> verificarRequisitosEstudiantes(Estudiante e,
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        ArrayList<Boolean> requisitos = new ArrayList<>();
        // requisitos.addAll(secretaria.verificarRequisitosEstudiantes(e, responsabilidades));
        // requisitos.addAll(recursosHumanos.verificarRequisitosEstudiantes(e, responsabilidades));
        requisitos.addAll(biblioteca.verificarRequisitosEstudiantes(e, responsabilidades));
        requisitos.addAll(economia.verificarRequisitosEstudiantes(e, responsabilidades));
        return requisitos;
    }

    

    
}
