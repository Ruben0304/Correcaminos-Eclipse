package controllers;


import auth.Auth;
import auth.Session;
import auth.VerificarCredenciales;
import models.gestion.GestorPrincipal;
import models.usuarios.Usuario;
import views.Inicio;
import views.Pricipal;
import views.auth.Entrar;
import views.old.Login;

public class ControladorLogin {

    public static void mostrarLogin() {
        if (Auth.hayUsuarioAutenticado()) {
            ControladorPrincipal.mostrarInicio();
        } else {
            Pricipal instancia = Pricipal.getInstancia();
            instancia.setVista(Entrar.getVista().getPanel());
            Pricipal.getInstancia().revalidate();
            Pricipal.getInstancia().repaint();
        }

    }

    public static void mostrarInicio() {

    }

    public static boolean intentarAutenticar(String nombreUsuario, String password, boolean mantenerConectado) {
        boolean autenticado = false;
        VerificarCredenciales verificar = new VerificarCredenciales(nombreUsuario, password);
        if (verificar.credencialesCorrectas()) {
            Auth.iniciarSesion(verificar.usuarioAlQuePertenecen());
            autenticado = true;
            if (mantenerConectado) {
                new Session(Auth.usuarioAutenticado().getNombreUsuario(),
                        Auth.usuarioAutenticado().getContrasena());

            }
        }
        return autenticado;
    }

    public static void cerrarSesion() {
        Auth.cerrarSesion();
        new Session("null", "null");
        mostrarLogin();
    }

    // public static void cambiarContrasena(String contrasena) {
    // Auth.usuarioAutenticado().setContrasena(hashContrasena(contrasena));
    // }

    public static void comprobarSession() {
        Usuario u = Session.ValidarSession();
        if (u != null) {
            Auth.iniciarSesion(u);
        }
    }

}
