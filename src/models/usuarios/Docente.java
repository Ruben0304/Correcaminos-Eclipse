package models.usuarios;

import utiles.CategoriaDocente;
import utiles.Facultad;

public class Docente extends Empleado{
    private String departamento;
    private CategoriaDocente categoriaDocente;
    private Facultad facultad;

    public Docente(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
                    String numerotrabajador, Facultad facultad,  String departamento,CategoriaDocente categoriaDocente) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, numerotrabajador);
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
