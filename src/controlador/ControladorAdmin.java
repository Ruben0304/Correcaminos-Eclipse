package controlador;

import java.util.ArrayList;

import modelos.auth.Auth;
import modelos.departamentos.Biblioteca;
import modelos.departamentos.Secretaria;
import modelos.gestion.GestorPrincipal;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;
import modelos.usuarios.Usuario;
import vistas.admin.CasosPendientes;
import vistas.admin.SecretariaPendientes;


public class ControladorAdmin {
    public static void mostrarGestionLicencias() {
        ArrayList<Persona> usuariosPendientes = new ArrayList<>();
        Usuario usuarioAutenticado = Auth.usuarioAutenticado();
        Secretaria secretaria = GestorPrincipal.secretaria();
        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(Biblioteca.getEstudiantesPendientes(secretaria));
                CasosPendientes biblioteca = new CasosPendientes(usuarioAutenticado, usuariosPendientes);
                biblioteca.setVisible(true);
                break;
            case Secretaria:
                usuariosPendientes.addAll(secretaria.getEstudianteLicenciaPendientes());
                SecretariaPendientes view = new SecretariaPendientes(usuarioAutenticado,usuariosPendientes);
                view.setVisible(true);
                break;
            default:
                break;
        }

    }
}
