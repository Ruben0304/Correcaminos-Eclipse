package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import modelos.auth.Auth;
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
        ArrayList<Usuario> usuarios = GestorPrincipal.gestorUsuarios().getUsuarios();

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && hashContrasena(contrasena).equals(usuarios.get(i).getContrasena())) {
                autenticado = true;
                Auth.iniciarSesion(usuarios.get(i));

            }

        }

        return autenticado;
    }


    public static void cerrarSesion() {
        Auth.cerrarSesion();
        mostrarLogin();
    }

       public static void cambiarContrasena(String contrasena) {
        Auth.usuarioAutenticado().setContrasena(hashContrasena(contrasena));
    }

    private static String hashContrasena(String contrasena) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] passwordBytes = contrasena.getBytes();

            byte[] hashBytes = md.digest(passwordBytes);

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                hexString.append(String.format("%02x", hashByte));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
