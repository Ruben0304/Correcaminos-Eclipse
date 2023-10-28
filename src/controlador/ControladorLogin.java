package controlador;

import java.util.ArrayList;

import modelos.entidades.*;
import vistas.auth.Login;

public class ControladorLogin {

    public static void mostrarLogin() {

        Login login = new Login();
        login.setVisible(true);

    }

    public static Usuario autenticar(String nombreUsuario, String contrasena) {
        boolean encontrado = false;
        ArrayList<Usuario> usuarios = GestorPrincipal.getGestorPrincipal().getUsuarios();
        Usuario usuarioAutenticado = null;

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && contrasena.equals(usuarios.get(i).getContrasena())) {

                usuarioAutenticado = usuarios.get(i);
            }

        }

        return usuarioAutenticado;
    }

    public static void cerrarSesion(ArrayList<Usuario> usuarios, Secretaria secretaria,
            RecursosHumanos recursosHumanos) {

        mostrarLogin();
    }
}
