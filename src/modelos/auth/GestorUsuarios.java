package modelos.auth;

import java.util.ArrayList;

import modelos.datos.AdminFactory;
import modelos.entidades.Admin;

import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;
import modelos.entidades.Usuario;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Admin> admins;

    public GestorUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public GestorUsuarios(Secretaria secretaria, RecursosHumanos recursosHumanos, Boolean datosFictisios) {
        this.usuarios = new ArrayList<>();
        this.admins = new ArrayList<>();
        if (datosFictisios) {
            this.admins.addAll(AdminFactory.inicializarAdmins());
            this.usuarios.addAll(secretaria.registrarEstudianteFictisios());
            this.usuarios.addAll(recursosHumanos.getEmpleados());
            this.usuarios.addAll(admins);
        } else {
            throw new IllegalArgumentException("Solo modo prueba");
        }

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static Usuario buscarUsuarioPorId(String nombreUsuario, String contrasena, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }
}
