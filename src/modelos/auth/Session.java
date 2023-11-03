package modelos.auth;

public class Session {
    private String nombreUsuario;
    private String contrasena;

    public Session(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
