package models.departamentos;

import java.util.ArrayList;

import models.interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class Economia implements VerificadorEstudiante {

    public boolean tieneEstipendio(ResponsabilidadesEstudiantes responsabilidades) {
        return responsabilidades.getResponsabilidades().contains(TiposResponsabilidad.ESTIPENDIO);
    }

    public boolean tieneDeuda(ResponsabilidadesEstudiantes responsabilidades) {
         return responsabilidades.getResponsabilidades().contains(TiposResponsabilidad.DEUDA);
    }

    @Override
    public boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidades) {
        return tieneDeuda(responsabilidades) && tieneEstipendio(responsabilidades);
    }

   
    @Override
    public ArrayList<Estudiante> getEstudiantesPendientes(
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (ResponsabilidadesEstudiantes r : responsabilidades) {
            if (verificarRequisitos(r)) {
                es.add(r.getEstudiante());
            }
        }
        return es;
    }


}
