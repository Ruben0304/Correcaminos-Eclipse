package controlador;

import java.util.ArrayList;

import modelos.entidades.*;

public class ControladorLogin {

    public static boolean autenticar(String nombreUsuario, String contraseña, ArrayList<Usuario> usuarios) {
        boolean encontrado = false;
        boolean autenticado = false;
        
        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && contraseña.equals(usuarios.get(i).getContrasena())) {
             autenticado = true;
            }
            
        }

        return autenticado;
    }
}
