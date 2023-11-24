package models.usuarios;

import util.CategoriaDocente;
import util.Facultad;

public class Docente extends Empleado{
    private String departamento;
    private CategoriaDocente categoriaDocente;

    public Docente(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
                    String numerotrabajador, Facultad facultad,  String departamento,CategoriaDocente categoriaDocente) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, numerotrabajador,facultad);
        this.departamento = departamento;
        this.categoriaDocente = categoriaDocente;
    }

    public String getDepartamento() {
        return departamento;
    }

    public CategoriaDocente getCategoriaDocente() {
        return categoriaDocente;
    }    
}
