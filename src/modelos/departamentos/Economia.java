package modelos.departamentos;

import java.util.ArrayList;

import modelos.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class Economia {

    public static boolean tieneEstipendio(Estudiante e) {
        return e.getResponsabilidades().contains(TiposResponsabilidad.ESTIPENDIO);
    }

    public static boolean tieneDeuda(Estudiante e) {
        return e.getResponsabilidades().contains(TiposResponsabilidad.DEUDA);
    }

    public static boolean tieneRequisitosCumplidos(Estudiante e) {
        return tieneDeuda(e) && tieneEstipendio(e);
    }

    public static void quitarEstipendio(Estudiante e) {
     ArrayList<TiposResponsabilidad> resp = e.getResponsabilidades();
     boolean encontrado = false;
        for (int i = 0; i < resp.size() && !encontrado; i++) {
            if (resp.get(i).equals(TiposResponsabilidad.ESTIPENDIO)) {
                resp.remove(resp.get(i));
                encontrado = true;
            }
        }
      
    }

    // public Estudiante obtenerEstudiante(Estudiante e) {

    // if (e.getResponsabilidades().contains(TiposResponsabilidad.ESTIPENDIO)) {
    // return e;
    // }
    // return null;
    // }
}
