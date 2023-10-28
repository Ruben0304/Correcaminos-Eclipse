package modelos.entidades;

import java.util.ArrayList;

import modelos.datos.AdminFactory;

public class GestorPrincipal {
    private static GestorPrincipal gestorPrincipal;
    private GestorUsuarios gestorUsuarios;
    private Secretaria secretaria;
    private RecursosHumanos recursosHumanos;

    public static GestorPrincipal getGestorPrincipal() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal();
        }
        return gestorPrincipal;
    }

    public static void setGestorPrincipal(GestorPrincipal gestor) {
        GestorPrincipal.gestorPrincipal = gestor;
    }

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

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public GestorUsuarios getGestorUsuarios() {
        return gestorUsuarios;
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
