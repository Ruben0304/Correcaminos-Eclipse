package modelos.entidades;

import utiles.Facultad;

public class NoDocente extends Empleado{
    private String seccion;

    public NoDocente(String nombreUsuario, String contrasena, String ci, String nombre, String apellidos,
            Facultad facultad, boolean licencia, boolean baja, String numerotrabajador, String seccion) {
        super(nombreUsuario, contrasena, ci, nombre, apellidos, facultad, licencia, baja, numerotrabajador);
        this.seccion = seccion;
    }

   
}


