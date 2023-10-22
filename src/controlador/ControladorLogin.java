package controlador;

import java.util.ArrayList;

import modelos.entidades.*;

public class ControladorLogin {

    public static void autenticar(String nombreUsuario, String contrasena, ArrayList<Usuario> usuarios) {
        boolean encontrado = false;
        

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && contrasena.equals(usuarios.get(i).getContrasena())) {
               ControladorPrincipal.mostrarInicio(usuarios.get(i));
            }
            
        }

    
    }
}
