package models.departamentos;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class Economia {

    public boolean tieneEstipendio(ResponsabilidadesEstudiantes responsabilidades) {
        return responsabilidades.getResponsabilidades().contains(TiposResponsabilidad.ESTIPENDIO);
    }

    public boolean tieneDeuda(ResponsabilidadesEstudiantes responsabilidades) {
         return responsabilidades.getResponsabilidades().contains(TiposResponsabilidad.DEUDA);
    }

    public boolean tieneRequisitosCumplidos(ResponsabilidadesEstudiantes responsabilidades) {
        return tieneDeuda(responsabilidades) && tieneEstipendio(responsabilidades);
    }

    // public static void quitarEstipendio(Estudiante e) {
    //     ArrayList<TiposResponsabilidad> resp = e.getResponsabilidades();
    //     boolean encontrado = false;
    //     for (int i = 0; i < resp.size() && !encontrado; i++) {
    //         if (resp.get(i).equals(TiposResponsabilidad.ESTIPENDIO)) {
    //             resp.remove(resp.get(i));
    //             encontrado = true;
    //         }
    //     }

    // }

    // public Estudiante obtenerEstudiante(Estudiante e) {

    //     if (e.getResponsabilidades().contains(TiposResponsabilidad.ESTIPENDIO)) {
    //         return e;
    //     }
    //     return null;
    // }

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
