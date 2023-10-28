package modelos.auth;

import modelos.entidades.Usuario;

public class UsuarioAutenticado {
    private static UsuarioAutenticado instancia;
    private Usuario usuario;

    private UsuarioAutenticado() {
        
    }

    public static UsuarioAutenticado obtenerInstancia() {
        if (instancia == null) {
            instancia = new UsuarioAutenticado();
        }
        return instancia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void iniciarSesion(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean existe() {
        return usuario != null;
    }

    public void cerrarSesion() {
        usuario = null;
    }
}
