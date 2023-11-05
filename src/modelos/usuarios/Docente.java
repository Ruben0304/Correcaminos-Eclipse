package modelos.usuarios;

import java.util.ArrayList;

import modelos.departamentos.Secretaria;
import utiles.Facultad;
import utiles.ResponsabilidadesTrabajador;

public class Docente extends Empleado{
    private String departamento;
    private String categoriaDocente;

    public Docente(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
    Facultad facultad, boolean licencia, boolean baja, String numerotrabajador, ArrayList<ResponsabilidadesTrabajador> responsabilidades,
    String departamento, String categoriaDocente) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, facultad, licencia, baja, numerotrabajador, responsabilidades);
        this.departamento = departamento;
        this.categoriaDocente = categoriaDocente;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCategoriaDocente() {
        return categoriaDocente;
    }
    
    public boolean tieneCuentaUsuarioCerrada() {
    	return !responsabilidades.contains(ResponsabilidadesTrabajador.CUENTA_USUARIO);
    }



    
}
