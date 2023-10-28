package controlador;

import java.util.ArrayList;

import modelos.entidades.*;
import vistas.auth.Login;

public class ControladorLogin {

    public static void mostrarLogin() {

        Login login = new Login();
        login.setVisible(true);

    }

    public static boolean autenticar(String nombreUsuario, String contrasena) {
        boolean encontrado = false;
        boolean autenticado = false;
        ArrayList<Usuario> usuarios = GestorPrincipal.getGestorPrincipal().getUsuarios();

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && contrasena.equals(usuarios.get(i).getContrasena())) {
                autenticado = true;
                GestorPrincipal.getGestorPrincipal().setUsuarioAutenticado(usuarios.get(i));
                
            }

        }

        return autenticado;
    }

    

    public static void cerrarSesion() {
        GestorPrincipal.getGestorPrincipal().setUsuarioAutenticado(null);
        mostrarLogin();
    }
}
