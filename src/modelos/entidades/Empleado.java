package modelos.entidades;

import utiles.Facultad;

public abstract class Empleado extends Persona{
    protected String numerotrabajador;

    public Empleado(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido, String segundo_apellido,
    Facultad facultad, boolean licencia, boolean baja, String numerotrabajador) {
        super(nombreUsuario, contrasena, ci, nombre, primer_apellido,segundo_apellido, facultad, licencia, baja);
        this.numerotrabajador = numerotrabajador;
    }

    public  void solicitarLicencia(Secretaria secretaria,String motivo, String fechaInicio, String fechaFin){}

    public  void solicitarBaja(){}
}
