package modelos.usuarios;



public class NoDocente extends Empleado{
    private String seccion;

    public NoDocente( String ci, String nombre, String primer_apellido, String segundo_apellido,
                     String numerotrabajador, String seccion) {
        super(ci, nombre, primer_apellido,segundo_apellido, numerotrabajador);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

   
}


