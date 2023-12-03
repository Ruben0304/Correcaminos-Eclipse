package auth;

import java.util.HashMap;

import interfaces.Autenticable;
import models.usuarios.Admin;

import models.usuarios.Persona;

public class Auth {
    private static Auth instancia;
    private String nombreUsuario;
    private Autenticable usuario;

    private Auth() {

    }

    public static Autenticable usuarioAutenticado() {
        if (instancia == null) {
            instancia = new Auth();
        }
        return instancia.getUsuario();
    }

    public static Auth obtenerInstancia() {
        if (instancia == null) {
            instancia = new Auth();
        }
        return instancia;
    }

    public static void iniciarSesion(Autenticable usuario) {
        if (instancia == null) {
            instancia = new Auth();
        }
        instancia.login(usuario);
    }

    public static boolean hayUsuarioAutenticado() {
        if (instancia == null) {
            instancia = new Auth();
        }
       return instancia.existe();
    }

    public static void cerrarSesion() {
        if (instancia == null) {
            instancia = new Auth();
        }
        instancia.logout();
    }

    private Autenticable getUsuario() {
        return usuario;
    }

    private void login(Autenticable usuario) {
        this.usuario = usuario;
    }

    private boolean existe() {
        
        return usuario != null;
    }

    private void logout() {
        usuario = null;
    }
}
