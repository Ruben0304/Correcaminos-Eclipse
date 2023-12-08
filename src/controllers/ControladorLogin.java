package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import auth.Auth;
import auth.Session;
import auth.VerificacionCredenciales;
import interfaces.Autenticable;
import models.gestion.Correcaminos;
import models.usuarios.Credenciales;
import views.Inicio;
import views.auth.Entrar;
import views.auth.LoginTemplate;
import views.layouts.Pricipal;

public class ControladorLogin {

    public static void mostrarLogin() {
        LoginTemplate frame = new LoginTemplate();
        if (Session.obtenerSession() != null) {
            Credenciales c = Session.obtenerSession();

            if (c.getUsuario() != null) {
                Autenticable auth = VerificacionCredenciales.autenticar(c.getUsuario(), c.getContrasena());
                if (auth != null) {
                    Auth.iniciarSesion(auth, c.getUsuario());
                    ControladorPrincipal.mostrarInicio();

                }

                else {

                    try {
                       
                        frame.setVisible(true);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } else {
                
                try {
                   
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Pricipal instancia = Pricipal.getInstancia();
            // instancia.setVista(Entrar.getVista().getPanel());
            // Pricipal.getInstancia().revalidate();
            // Pricipal.getInstancia().repaint();
            try {
                
                frame.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void mostrarInicio() {

    }

    public static boolean intentarAutenticar(String nombreUsuario, String password, boolean mantenerConectado) {
        boolean autenticado = false;
        Autenticable auth = VerificacionCredenciales.autenticar(nombreUsuario, hashContrasena(password));
        if (auth != null) {
            Auth.iniciarSesion(auth, nombreUsuario);
            autenticado = true;
            if (mantenerConectado) {
                new Session(new Credenciales(nombreUsuario, hashContrasena(password)));
            }
        }

        return autenticado;
    }

    public static void cerrarSesion() {
        Auth.logout();
        new Session(null);
        mostrarLogin();
    }

    // public static void cambiarContrasena(String contrasena) {
    // Auth.usuarioAutenticado().setContrasena(hashContrasena(contrasena));
    // }

    public static void comprobarSession() {
        Autenticable u = Session.ValidarSession();
        if (u != null) {
            Auth.iniciarSesion(u);
        }
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
