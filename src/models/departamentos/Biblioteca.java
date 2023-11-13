package models.departamentos;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class Biblioteca {

    public boolean tieneLibrosPrestados(ResponsabilidadesEstudiantes r){
        return r.getResponsabilidades().contains(TiposResponsabilidad.LIBROS_BIBLIOTECA);
        
    }

    public boolean tieneRequisitosCumplidos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes) {
        return tieneLibrosPrestados(responsabilidadesEstudiantes);
    }

    public void quitarLibrosPrestados(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.LIBROS_BIBLIOTECA);
            }

        }
    }

    public ArrayList<Estudiante> getEstudiantesPendientes(
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (ResponsabilidadesEstudiantes r : responsabilidades) {
            if (tieneRequisitosCumplidos(r)) {
                es.add(r.getEstudiante());
            }
        }
        return es;
    }

   

}
