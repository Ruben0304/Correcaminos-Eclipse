package controlador;

import java.util.ArrayList;

import modelos.entidades.Departamento;
import modelos.entidades.Persona;
import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;
import modelos.entidades.Usuario;
import utiles.TipoDepartamento;
import vistas.admin.CasosPendientes;

public class ControladorAdmin {
    public static void mostrarGestionLicencias(Usuario usuarioAutenticado, ArrayList<Usuario> usuarios,
            Secretaria secretaria, RecursosHumanos recursosHumanos) {
        ArrayList<Persona> usuariosPendientes = new ArrayList<>();
        switch (((Departamento) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
                usuariosPendientes.addAll(secretaria.getSolicitudesLicenciaPendientes(TipoDepartamento.Biblioteca));
                CasosPendientes biblioteca = new CasosPendientes(usuarioAutenticado, usuarios, secretaria,
                        recursosHumanos, usuariosPendientes);
                biblioteca.setVisible(true);
                break;

            default:
                break;
        }

    }
}
