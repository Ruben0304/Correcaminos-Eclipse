package controlador;


import modelos.auth.UsuarioAutenticado;
import modelos.entidades.*;
import vistas.Inicio;
import vistas.usuarios.EstudianteTramites;
import vistas.usuarios.RequisitosBajaEstudiantes;

public class ControladorPrincipal {

    public static void mostrarInicio() {
        Usuario usuarioAutenticado = UsuarioAutenticado.obtenerInstancia().getUsuario();
        if (usuarioAutenticado != null) {
            Inicio inicio = new Inicio(usuarioAutenticado, GestorPrincipal.getGestorPrincipal().getSecretaria());
            inicio.setVisible(true);
        } else {
            ControladorLogin.mostrarLogin();
        }

    }

    public static void mostrarTramites() {
        Usuario usuarioAutenticado = UsuarioAutenticado.obtenerInstancia().getUsuario();
        if (usuarioAutenticado instanceof Estudiante) {
            EstudianteTramites estudianteTramites = new EstudianteTramites((Estudiante) usuarioAutenticado,
                    GestorPrincipal.getGestorPrincipal().getSecretaria());
            estudianteTramites.setVisible(true);
        } else if (usuarioAutenticado instanceof Empleado) {

        }

    }

    public static void mostrarRequisitosBajaEstudiantes() {
        RequisitosBajaEstudiantes requisitosBajaEstudiantes = new RequisitosBajaEstudiantes(
                (Estudiante) UsuarioAutenticado.obtenerInstancia().getUsuario());
        requisitosBajaEstudiantes.setVisible(true);
    }

}
