package models.departamentos;

import java.util.ArrayList;

import models.gestion.GestorPrincipal;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.solicitudes.SolicitudLicenciaEstudiante;
import models.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class Biblioteca {
    public static boolean tieneLibrosPrestados(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        boolean encontrado = false;


        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {
            if (encontrado) {

            }
        }
        return e.getResponsabilidades().contains(TiposResponsabilidad.LIBROS_BIBLIOTECA);
    }

    public static boolean tieneRequisitosCumplidos(Estudiante e) {
        return tieneLibrosPrestados(e);
    }

    public static void quitarLibrosPrestados(Estudiante e) {
        ArrayList<TiposResponsabilidad> resp = e.getResponsabilidades();
        resp.remove(TiposResponsabilidad.LIBROS_BIBLIOTECA);

    }

    public static ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<SolicitudLicenciaEstudiante> solicitudes) {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (SolicitudLicenciaEstudiante s : solicitudes) {
            if (tieneLibrosPrestados(s.getEstudiante())) {
                es.add(s.getEstudiante());
            }
        }
        return es;
    }

}
