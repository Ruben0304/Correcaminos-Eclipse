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

public class ControladorAdmin {
    public static void mostrarGestionLicencias() {
        ArrayList<Persona> usuariosPendientes = new ArrayList<>();
        Usuario usuarioAutenticado = Auth.usuarioAutenticado();
        Secretaria secretaria = GestorPrincipal.secretaria();
        switch (((Admin) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(secretaria.getSolicitudesLicenciaPendientes(TipoDepartamento.Biblioteca));
                CasosPendientes biblioteca = new CasosPendientes(usuarioAutenticado,usuariosPendientes);
                biblioteca.setVisible(true);
                break;

            default:
                break;
        }

    }
}
