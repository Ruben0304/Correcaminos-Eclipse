package controlador;

import java.util.ArrayList;

import modelos.auth.Auth;
import modelos.entidades.Admin;
import modelos.entidades.GestorPrincipal;
import modelos.entidades.Persona;
import modelos.entidades.Secretaria;
import modelos.entidades.Usuario;
import utiles.TipoDepartamento;
import vistas.admin.CasosPendientes;
import vistas.admin.SecretariaPendientes;
import vistas.admin.Secretaria_Rhumanos2;

public class ControladorAdmin {
    public static void mostrarGestionLicencias() {
        ArrayList<Persona> usuariosPendientes = new ArrayList<>();
        Usuario usuarioAutenticado = Auth.usuarioAutenticado();
        Secretaria secretaria = GestorPrincipal.secretaria();
        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(secretaria.getSolicitudesLicenciaPendientes(TipoDepartamento.Biblioteca));
                CasosPendientes biblioteca = new CasosPendientes(usuarioAutenticado, usuariosPendientes);
                biblioteca.setVisible(true);
                break;
            case Secretaria:
                usuariosPendientes.addAll(secretaria.getSolicitudesLicenciaPendientes());
                SecretariaPendientes view = new SecretariaPendientes(usuarioAutenticado,usuariosPendientes);
                view.setVisible(true);
                break;
            default:
                break;
        }

    }
}
