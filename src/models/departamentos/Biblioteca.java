package models.departamentos;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class Biblioteca {

    public static boolean tieneLibrosPrestados(Estudiante e,
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        boolean encontrado = false;

        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e)
                    && responsabilidades.get(i).getResponsabilidades().contains(TiposResponsabilidad.LIBROS_BIBLIOTECA);

        }
        return encontrado;
    }

    public static boolean tieneRequisitosCumplidos(Estudiante e,
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        return tieneLibrosPrestados(e, responsabilidades);
    }

    public static void quitarLibrosPrestados(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.LIBROS_BIBLIOTECA);
            }

        }
    }

    public static ArrayList<Estudiante> getEstudiantesPendientes(
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (ResponsabilidadesEstudiantes r : responsabilidades) {
            if (tieneRequisitosCumplidos(r.getEstudiante(), responsabilidades)) {
                es.add(r.getEstudiante());
            }
        }
        return es;
    }

   

}
