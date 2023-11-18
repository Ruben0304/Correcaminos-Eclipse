package models.usuarios;



public class NoDocente extends Empleado{
    private String seccion;

    public NoDocente(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
                     String numerotrabajador, String seccion) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, numerotrabajador);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

   
}


