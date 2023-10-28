package modelos.auth;

import modelos.entidades.Usuario;

public class UsuarioAutenticado {
     private static UsuarioAutenticado instancia;
    private Usuario usuario;

    private UsuarioAutenticado() {
        // Constructor privado para evitar la creación de instancias externas
    }

    public static UsuarioAutenticado getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioAutenticado();
        }
        return instancia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean estaAutenticado() {
        return usuario != null;
    }
}
