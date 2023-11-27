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
