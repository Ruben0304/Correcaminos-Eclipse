package modelos.auth;

import java.util.ArrayList;

import modelos.datos.AdminFactory;
import modelos.entidades.Departamento;
import modelos.entidades.Persona;
import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;
import modelos.entidades.Usuario;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Departamento> admins;

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

    public static Usuario buscarUsuarioPorCi(String id, ArrayList<Persona> usuarios) {
        boolean encontrado = false;
        Usuario usuarioEncontrado = null;
        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = id.equals(usuarios.get(i).getCi());
            if (encontrado) {
                usuarioEncontrado = usuarios.get(i);
            }
        }
        return usuarioEncontrado;
    }
}
