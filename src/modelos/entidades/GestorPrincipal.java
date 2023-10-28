package modelos.entidades;

import java.util.ArrayList;

import modelos.datos.AdminFactory;

public class GestorPrincipal {
    private static GestorPrincipal gestorPrincipal;
    private ArrayList<Usuario> usuarios;
    private Secretaria secretaria;
    private RecursosHumanos recursosHumanos;

    public static GestorPrincipal getGestorPrincipal() {
        if (gestorPrincipal == null) {
            gestorPrincipal = new GestorPrincipal(true);
        }
        return gestorPrincipal;
    }

    public static void setGestorPrincipal(GestorPrincipal gestor) {
        GestorPrincipal.gestorPrincipal = gestor;
    }

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = this.usuarios;
        return usuarios;
    }

    private GestorPrincipal(boolean isPrueba) {
        secretaria = new Secretaria();
        recursosHumanos = new RecursosHumanos();
       if (isPrueba) {
        usuarios = new ArrayList<>();
        usuarios.addAll(AdminFactory.inicializarAdmins());
        usuarios.addAll(secretaria.registrarEstudianteFictisios());
        usuarios.addAll(recursosHumanos.getEmpleados());
        secretaria.registrarLicenciasEstudiantesFictisios();

       }
        
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
