package modelos.auth;

import java.util.ArrayList;

import modelos.entidades.Usuario;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;

    public GestorUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static Usuario buscarUsuarioPorId(String nombreUsuario, String contrasena, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }
}
