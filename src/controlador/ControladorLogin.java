package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.google.gson.Gson;


import modelos.auth.Auth;
import modelos.auth.Session;
import modelos.gestion.GestorPrincipal;

import modelos.usuarios.Usuario;
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

    public static boolean autenticarSinHash(String nombreUsuario, String contrasena) {
        boolean encontrado = false;
        boolean autenticado = false;
        ArrayList<Usuario> usuarios = GestorPrincipal.gestorUsuarios().getUsuarios();

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && contrasena.equals(usuarios.get(i).getContrasena())) {
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

    public static boolean comprobarSession() {
        Gson gson = new Gson();
        Session session = null;
        File file = new File("./session.json");

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                session = gson.fromJson(reader, Session.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            session = new Session("null", "null");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                String json = gson.toJson(session);
                writer.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return session != null && autenticarSinHash(session.getNombreUsuario(), session.getContrasena());
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
