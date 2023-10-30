package modelos.gestion;

import java.util.ArrayList;

import modelos.departamentos.RecursosHumanos;
import modelos.departamentos.Secretaria;
import modelos.fabricas.AdminFactory;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;
import modelos.usuarios.Usuario;

public class GestorPrincipal {
    private static GestorPrincipal gestorPrincipal;
    private GestorUsuarios gestorUsuarios;
    private Secretaria secretaria;
    private RecursosHumanos recursosHumanos;

    private GestorPrincipal() {
        secretaria = new Secretaria();
        recursosHumanos = new RecursosHumanos();
        gestorUsuarios = new GestorUsuarios();

        ArrayList<Admin> admins = AdminFactory.inicializarAdmins();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(secretaria.registrarEstudianteFictisios());
        usuarios.addAll(recursosHumanos.getEmpleados());
        usuarios.addAll(admins);
        gestorUsuarios.registrar(usuarios);
        secretaria.registrarLicenciasEstudiantesFictisios();

    }

    public static GestorPrincipal getGestorPrincipal() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal;
    }

    public static Secretaria secretaria() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal.getSecretaria();
    }

    public static GestorUsuarios gestorUsuarios() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal.getGestorUsuarios();
    }

    public static RecursosHumanos recursosHumanos() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal.getRecursosHumanos();
    }

    

    private Secretaria getSecretaria() {
        return secretaria;
    }

    private RecursosHumanos getRecursosHumanos() {
        return recursosHumanos;
    }

    private GestorUsuarios getGestorUsuarios() {
        return gestorUsuarios;
    }

    public static Persona buscarPersonaEnLista(String id, ArrayList<Persona> usuarios) {
        boolean encontrado = false;
        Persona usuarioEncontrado = null;
        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = id.equals(usuarios.get(i).getCi());
            if (encontrado) {
                usuarioEncontrado = usuarios.get(i);
            }
        }
        return usuarioEncontrado;
    }

}
