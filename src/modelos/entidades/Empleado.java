package modelos.entidades;

import utiles.Facultad;

public class Empleado extends Persona{
    protected String cargo;

    public Empleado(String nombreUsuario, String contrasena, String ci, String nombre, String apellidos,
            Facultad facultad, boolean licencia, boolean baja, String cargo) {
        super(nombreUsuario, contrasena, ci, nombre, apellidos, facultad, licencia, baja);
        this.cargo = cargo;
    }

    
}
