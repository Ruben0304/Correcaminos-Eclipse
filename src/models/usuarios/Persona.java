package models.usuarios;

public abstract class Persona extends Usuario {
    protected String ci;
    protected String nombre;
    protected String primer_apellido;
    protected String segundo_apellido;

    public Persona(String nombreUsuario, String contrasena, String ci, String nombre, String primer_apellido,
            String segundo_apellido) {
        super(nombreUsuario, contrasena);
        this.ci = ci;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;

    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return primer_apellido + " " + segundo_apellido;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public String getNombreCompleto() {
        return getNombre() + " " + getApellidos();
    }

    public char getSexo() {

        return this.ci.charAt(9) % 2 == 0 ? 'M' : 'F';

    }

}
