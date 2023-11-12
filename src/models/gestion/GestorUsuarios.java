package models.gestion;


import java.util.ArrayList;

import data.ObtenerAdmins;
import models.usuarios.Admin;
import models.usuarios.Persona;
import models.usuarios.Usuario;

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


    public void registrarUsuarios(ArrayList<Persona> personas) {

        this.usuarios.addAll(ObtenerAdmins.cargarDesdeArchivo());
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
