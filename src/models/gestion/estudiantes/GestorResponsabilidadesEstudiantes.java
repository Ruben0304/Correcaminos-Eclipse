package models.gestion.estudiantes;

import java.util.HashMap;
import java.util.Set;

import models.interfaces.Actualizador;
import models.usuarios.Becado;
import models.usuarios.Estudiante;
import util.TipoPerteneciasBeca;
import util.TiposResponsabilidad;

public class GestorResponsabilidadesEstudiantes implements Actualizador {

    private HashMap<Estudiante, Set<TiposResponsabilidad>> responsabilidades;
    private HashMap<Becado, Set<TipoPerteneciasBeca>> perteneciasBecado;
    private HashMap<Estudiante, Set<String>> librosNoDocentes;
    private HashMap<Estudiante, Set<String>> librosDocentes;

    // private void registrarResponsabilidades(ArrayList<Estudiante> estudiantes) {
    // ArrayList<ResponsabilidadesEstudiantes> responsabilidades =
    // ObtenerResponsabilidadesEstudiantes
    // .cargarDesdeArchivo();
    // ArrayList<ResponsabilidadesEstudiantes> responsabilidadesRegistradas = new
    // ArrayList<>();

    // for (ResponsabilidadesEstudiantes resp : responsabilidades) {
    // String estudianteId = resp.getEstudiante().getCi();
    // Estudiante estudianteExistente = referenciarEstudiante(estudianteId,
    // estudiantes);

    // if (estudianteExistente != null) {
    // ResponsabilidadesEstudiantes respRegistrada = new
    // ResponsabilidadesEstudiantes(
    // resp.getResponsabilidades(), estudianteExistente);
    // responsabilidadesRegistradas.add(respRegistrada);
    // }
    // }
    // this.responsabilidadesEstudiantesPendientes.addAll(responsabilidadesRegistradas);
    // }

    // private Estudiante referenciarEstudiante(String id, ArrayList<Estudiante>
    // estudiantes) {
    // boolean encontrado = false;
    // Estudiante estudianteEncontrado = null;
    // for (int i = 0; i < estudiantes.size() && !encontrado; i++) {
    // encontrado = id.equals(estudiantes.get(i).getCi());
    // if (encontrado) {
    // estudianteEncontrado = estudiantes.get(i);
    // }
    // }
    // return estudianteEncontrado;
    // }

    public GestorResponsabilidadesEstudiantes() {
        responsabilidades = new HashMap<>();
        perteneciasBecado = new HashMap<>();
        librosNoDocentes = new HashMap<>();
        librosDocentes = new HashMap<>();
    }

    public Set<TipoPerteneciasBeca> getListadoDeUnEstudiante(Estudiante e) {

        return perteneciasBecado.get(e);

    }

    public Set<TiposResponsabilidad> getPerteneciasDeUnBecado(Becado e) {

        return responsabilidades.get(e);

    }

    public Set<String> librosDocentesQueDebe(Estudiante e) {

        return librosDocentes.get(e);

    }

    public Set<String> librosNoDocentesQueDebe(Estudiante e) {

        return librosNoDocentes.get(e);

    }

    public int totalLibrosNoDocentesQueDebe(Estudiante e) {

        return librosNoDocentesQueDebe(e).size();

    }

    public int totalLibrosDocentesQueDebe(Estudiante e) {

        return librosDocentesQueDebe(e).size();

    }

    @Override
    public void actualizarDatos() {

    }

}
