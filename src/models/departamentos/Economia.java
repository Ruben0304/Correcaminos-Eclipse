package models.departamentos;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class Economia {

    public static boolean tieneEstipendio(Estudiante e,
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        boolean encontrado = false;

        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e)
                    && responsabilidades.get(i).getResponsabilidades().contains(TiposResponsabilidad.ESTIPENDIO);

        }
        return encontrado;
    }

    public static boolean tieneDeuda(Estudiante e,
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        boolean encontrado = false;

        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e)
                    && responsabilidades.get(i).getResponsabilidades().contains(TiposResponsabilidad.DEUDA);

        }
        return encontrado;
    }

    public static boolean tieneRequisitosCumplidos(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantes) {
        return tieneDeuda(e,responsabilidadesEstudiantes) && tieneEstipendio(e,responsabilidadesEstudiantes);
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

    public ArrayList<Boolean> verificarRequisitosEstudiantes(Estudiante e,
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {

        ArrayList<Boolean> requisitos = new ArrayList<>();
        boolean tieneEstipendio = tieneEstipendio(e, responsabilidades);
        boolean tieneDeuda = tieneDeuda(e, responsabilidades);
        requisitos.add(tieneEstipendio);
        requisitos.add(tieneDeuda);

        return requisitos;
    }
}
