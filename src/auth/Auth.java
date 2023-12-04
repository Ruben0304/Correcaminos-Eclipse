package auth;

import java.util.HashMap;

import interfaces.Autenticable;
import models.usuarios.Admin;

import models.usuarios.Persona;

public class Auth {
    
    private static String nombreUsuario;
    private static Autenticable usuario;


    public static Autenticable getUsuario() {
        return usuario;
    }

    public static void login(Autenticable usuari) {
        usuario = usuari;
    }

    public static boolean hayUsuarioAutenticado() {
        
        return usuario != null;
    }

    public static void logout() {
        usuario = null;
        nombreUsuario = null;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }
}
