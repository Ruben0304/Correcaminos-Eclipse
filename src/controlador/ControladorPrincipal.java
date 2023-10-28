package controlador;

import java.util.ArrayList;

import modelos.entidades.*;
import vistas.Inicio;
import vistas.usuarios.EstudianteTramites;
import vistas.usuarios.RequisitosBajaEstudiantes;

public class ControladorPrincipal {

    public static void mostrarInicio() {
        Usuario usuarioAutenticado = GestorPrincipal.getGestorPrincipal().getUsuarioAutenticado();
        if (usuarioAutenticado != null) {
            Inicio inicio = new Inicio(usuarioAutenticado,GestorPrincipal.getGestorPrincipal().getSecretaria());
            inicio.setVisible(true);
        } else {
            ControladorLogin.mostrarLogin();
        }

    }

    public static void mostrarTramites() {
        if (usuarioAutenticado instanceof Estudiante) {
            EstudianteTramites estudianteTramites = new EstudianteTramites((Estudiante) usuarioAutenticado,GestorPrincipal.getGestorPrincipal().getSecretaria());
            estudianteTramites.setVisible(true);
        } else if (usuarioAutenticado instanceof Empleado) {

        }

    }

    public static void mostrarRequisitosBajaEstudiantes(Usuario usuarioAutenticado, ArrayList<Usuario> usuarios,
            Secretaria secretaria, RecursosHumanos recursosHumanos) {
        RequisitosBajaEstudiantes requisitosBajaEstudiantes = new RequisitosBajaEstudiantes(
                (Estudiante) usuarioAutenticado,
                usuarios, secretaria, recursosHumanos);
        requisitosBajaEstudiantes.setVisible(true);

    }

}
