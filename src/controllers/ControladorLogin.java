package controllers;

import java.awt.CardLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JPanel;



import auth.Auth;
import auth.Session;
import auth.VerificarCredenciales;
import models.gestion.GestorPrincipal;
import models.usuarios.Usuario;
import views.Principal;
import views.prueba;
import views.auth.Entrar;
import views.auth.Login;

public class ControladorLogin {

    public static void mostrarLogin() {

        Login login = new Login();
        login.setVisible(true);

    }

    public static void mostrarInicio() {

        prueba instancia = prueba.getInstancia();

        Container contenedor = instancia.getContentPane();

        Entrar entrar = Entrar.getVista();

        
        contenedor.add(entrar.getPanel());

        prueba.getInstancia().revalidate();
        prueba.getInstancia().repaint();
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
