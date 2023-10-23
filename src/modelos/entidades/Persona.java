package modelos.entidades;

import java.util.ArrayList;

import utiles.Facultad;

public abstract class Persona extends Usuario {
    protected String ci;
    protected String nombre;
    protected String apellidos;
    protected Facultad facultad;
    protected boolean licencia;
    protected boolean baja;

    public Persona(String nombreUsuario, String contrasena, String ci, String nombre, String apellidos,
            Facultad facultad, boolean licencia, boolean baja) {
        super(nombreUsuario, contrasena);
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.facultad = facultad;
        this.licencia = licencia;
        this.baja = baja;
    }

    public abstract void solicitarLicencia(Usuario usuarioAutenticado, ArrayList<Usuario> usuarios,
            Secretaria secretaria, RecursosHumanos RecursosHumanos);

    public abstract void solicitarBaja();

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public boolean isLicencia() {
        return licencia;
    }

    public boolean isBaja() {
        return baja;
    }
}
