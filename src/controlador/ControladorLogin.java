package controlador;

import java.util.ArrayList;


import modelos.entidades.*;
import vistas.auth.Login;

public class ControladorLogin {

    public static void mostrarLogin(ArrayList<Usuario> usuarios) {

        Login login = new Login(usuarios);
        login.setVisible(true);

    }

    public static boolean autenticar(String nombreUsuario, String contrasena, ArrayList<Usuario> usuarios) {
        boolean encontrado = false;
        boolean autenticado = false;

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && contrasena.equals(usuarios.get(i).getContrasena())) {
                ControladorPrincipal.mostrarInicio(usuarios.get(i), usuarios);
                autenticado = true;
            }

        }

        return autenticado;
    }

    public static void cerrarSesion(ArrayList<Usuario> usuarios) {

        mostrarLogin(usuarios);
    }
}
