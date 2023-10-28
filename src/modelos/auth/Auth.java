package modelos.auth;

import modelos.entidades.Usuario;

public class Auth {
    private static Auth instancia;
    private Usuario usuario;

    private Auth() {

    }

    public static Usuario usuarioAutenticado() {
        if (instancia == null) {
            instancia = new Auth();
        }
        return instancia.getUsuario();
    }

    public static Auth obtenerInstancia() {
        if (instancia == null) {
            instancia = new Auth();
        }
        return instancia;
    }

    public static void iniciarSesion(Usuario usuario) {
        if (instancia == null) {
            instancia = new Auth();
        }
        instancia.login(usuario);
    }

    public static boolean hayUsuarioAutenticado() {
        if (instancia == null) {
            instancia = new Auth();
        }
       return instancia.existe();
    }

    public static void cerrarSesion() {
        if (instancia == null) {
            instancia = new Auth();
        }
        instancia.logout();
    }

    private Usuario getUsuario() {
        return usuario;
    }

    private void login(Usuario usuario) {
        this.usuario = usuario;
    }

    private boolean existe() {
        return usuario != null;
    }

    private void logout() {
        usuario = null;
    }
}
