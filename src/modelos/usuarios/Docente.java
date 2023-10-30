package modelos.usuarios;

import utiles.Facultad;

public class Docente extends Empleado{
    private String departamento;
    private String categoriaDocente;

    public Docente(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
    Facultad facultad, boolean licencia, boolean baja, String numerotrabajador, String departamento,
            String categoriaDocente) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, facultad, licencia, baja, numerotrabajador);
        this.departamento = departamento;
        this.categoriaDocente = categoriaDocente;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCategoriaDocente() {
        return categoriaDocente;
    }

    
}
