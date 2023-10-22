package controlador;

import java.util.ArrayList;

import modelos.auth.GestorUsuarios;
import modelos.entidades.*;
import vistas.auth.Login;

public class ControladorLogin {

    

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

    public static void cerrarSesion(GestorUsuarios gestorUsuarios) {

        Login login = new Login(gestorUsuarios);
        login.setVisible(true);
    }
}
