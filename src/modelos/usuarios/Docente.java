package modelos.usuarios;

import util.CategoriaDocente;
import util.Facultad;

public class Docente extends Empleado{
    private String departamento;
    private CategoriaDocente categoriaDocente;
    private Facultad facultad;

    public Docente( String ci, String nombre, String primer_apellido, String segundo_apellido,
                    String numerotrabajador, Facultad facultad,  String departamento,CategoriaDocente categoriaDocente) {
        super(ci, nombre, primer_apellido,segundo_apellido, numerotrabajador);
        this.departamento = departamento;
        this.categoriaDocente = categoriaDocente;
        this.facultad = facultad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public CategoriaDocente getCategoriaDocente() {
        return categoriaDocente;
    }

	public Facultad getFacultad() {
		return facultad;
	}

    
}
