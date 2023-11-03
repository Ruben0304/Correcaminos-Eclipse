package modelos.gestion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.solicitudes.SolicitudLicenciaEstudiante;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;
import modelos.usuarios.Usuario;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;

    public GestorUsuarios() {
        usuarios = new ArrayList<>();

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void registrar(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void registrar(ArrayList<Usuario> usuarios) {
        this.usuarios.addAll(usuarios);
    }

    private ArrayList<Admin> inicializarAdmins() {
        Gson gson = new Gson();
        ArrayList<Admin> admins = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./datos/admins.json"))) {
            Type listType = new TypeToken<ArrayList<Admin>>() {
            }.getType();
            admins = gson.fromJson(reader, listType);

            // Ahora tienes la lista de estudiantes cargada desde el archivo JSON
        } catch (IOException e) {
            e.printStackTrace();
        }

        return admins;

    }

    public void registrarUsuarios(ArrayList<Persona> personas) {

        this.usuarios.addAll(inicializarAdmins());
        this.usuarios.addAll(personas);

    }

    public ArrayList<Admin> getAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Admin) {
                admins.add((Admin) usuario);
            }
        }
        return admins;
    }

}
