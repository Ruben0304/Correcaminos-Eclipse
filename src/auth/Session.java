package auth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.gestion.GestorPrincipal;

import models.usuarios.Usuario;

public class Session {
    private String nombreUsuario;
    private String password;


    public Session(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;

        Gson gson = new Gson();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./session.json"))) {
            String json = gson.toJson(this);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Session obtenerSession() {
        Gson gson = new Gson();
        File file = new File("./session.json");
        Session session = null;
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                session = gson.fromJson(reader, Session.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
        else{
           session = new Session("null", "null");
        }
        return session;
    }

    public static Usuario ValidarSession() {
        boolean encontrado = false;
        ArrayList<Usuario> usuarios = GestorPrincipal.getGestorPrincipal().getUsuarios();
        Session session = obtenerSession();
        Usuario u = null;

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = session.getNombreUsuario().equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && session.getPassword().equals(usuarios.get(i).getContrasena())) {
                u = usuarios.get(i);
            }

        }

        return u;
    }

    private String getNombreUsuario() {
        return nombreUsuario;
    }

    private String getPassword() {
        return password;
    }

}