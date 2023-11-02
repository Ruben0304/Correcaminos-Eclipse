package modelos.departamentos;

import java.util.ArrayList;

import modelos.usuarios.Estudiante;
import utiles.TiposResponsabilidad;

public class Biblioteca {
    public static boolean tieneLibrosPrestados(Estudiante e) {
        return e.getResponsabilidades().contains(TiposResponsabilidad.LIBROS_BIBLIOTECA);
    }

    public static boolean tieneRequisitosCumplidos(Estudiante e) {
        return tieneLibrosPrestados(e);
    }

    public static void quitarLibrosPrestados(Estudiante e) {
     ArrayList<TiposResponsabilidad> resp = e.getResponsabilidades();
     boolean encontrado = false;
        for (int i = 0; i < resp.size() && !encontrado; i++) {
            if (resp.get(i).equals(TiposResponsabilidad.LIBROS_BIBLIOTECA)) {
                resp.remove(i);
                encontrado = true;
            }
        }
      
    }

    public static ArrayList<Estudiante> getEstudiantesPendientes(Secretaria s){
        ArrayList<Estudiante> es = new ArrayList<>();
        for (Estudiante e : s.getEstudianteLicenciaPendientes()) {
            if (e.tieneLibrosDeBiblioteca()) {
                es.add(e);
            }
        }
         return es;
    }

    
}
