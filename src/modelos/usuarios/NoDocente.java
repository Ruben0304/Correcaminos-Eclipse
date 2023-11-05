package modelos.usuarios;

import java.util.ArrayList;

import utiles.Facultad;
import utiles.ResponsabilidadesTrabajador;

public class NoDocente extends Empleado{
    private String seccion;

    public NoDocente(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
    Facultad facultad, boolean licencia, boolean baja, String numerotrabajador,ArrayList<ResponsabilidadesTrabajador> responsabilidades, String seccion) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, facultad, licencia, baja, numerotrabajador, responsabilidades);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

   
}


