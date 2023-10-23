package controlador;

import java.util.ArrayList;

import modelos.entidades.Departamento;
import modelos.entidades.Persona;
import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;
import modelos.entidades.SolicitudLicenciaEstudiante;
import modelos.entidades.Usuario;
import vistas.admin.Biblioteca;

public class ControladorAdmin {
    public static void mostrarGestionLicencias(Usuario usuarioAutenticado, ArrayList<Usuario> usuarios,
            Secretaria secretaria, RecursosHumanos recursosHumanos) {
                ArrayList<Persona> usuariosPendientes = new ArrayList<>();
        switch (((Departamento) usuarioAutenticado).getTipoDepartamento()) {
            case Biblioteca:
            for (SolicitudLicenciaEstudiante s : secretaria.getSolicitudesLicencia()) {
                if (s.getEstudiante().tieneLibrosDeBiblioteca()) {
                    usuariosPendientes.add(s.getEstudiante());
                }
                
            }
                Biblioteca biblioteca = new Biblioteca(usuarioAutenticado,usuarios,secretaria,recursosHumanos);
                biblioteca.setVisible(true);
                break;

            default:
                break;
        }

    }
}
