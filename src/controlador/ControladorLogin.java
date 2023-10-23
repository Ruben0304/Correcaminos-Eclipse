package controlador;

import java.util.ArrayList;

import modelos.entidades.*;
import vistas.auth.Login;

public class ControladorLogin {

    public static void mostrarLogin(ArrayList<Usuario> usuarios, Secretaria secretaria,
            RecursosHumanos recursosHumanos) {

        Login login = new Login(usuarios, secretaria, recursosHumanos);
        login.setVisible(true);

    }

    public static Usuario autenticar(String nombreUsuario, String contrasena, ArrayList<Usuario> usuarios) {
        boolean encontrado = false;

        Usuario usuarioAutenticado = null;

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && contrasena.equals(usuarios.get(i).getContrasena())) {

                usuarioAutenticado = usuarios.get(i);
            }

        }

        return usuarioAutenticado;
    }

    public static void cerrarSesion(ArrayList<Usuario> usuarios, Secretaria secretaria, RecursosHumanos recursosHumanos) {

        mostrarLogin(usuarios,secretaria,recursosHumanos);
    }
}
