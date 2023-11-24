package models.usuarios;

import util.Facultad;

public class NoDocente extends Empleado{
    private String seccion;

    public NoDocente(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
                     String numerotrabajador, Facultad facultad, String seccion) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, numerotrabajador, facultad);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

   
}


