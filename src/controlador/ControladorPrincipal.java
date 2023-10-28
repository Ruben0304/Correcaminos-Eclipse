package controlador;


import modelos.auth.Auth;
import modelos.entidades.*;
import vistas.Inicio;
import vistas.usuarios.EstudianteTramites;
import vistas.usuarios.RequisitosBajaEstudiantes;

public class ControladorPrincipal {

    public static void mostrarInicio() {
        
        if (Auth.hayUsuarioAutenticado()) {
            Inicio inicio = new Inicio(Auth.usuarioAutenticado(), GestorPrincipal.secretaria());
            inicio.setVisible(true);
        } else {
            ControladorLogin.mostrarLogin();
        }

    }

    public static void mostrarTramites() {
        Usuario usuarioAutenticado = Auth.usuarioAutenticado();
        if (usuarioAutenticado instanceof Estudiante) {
            EstudianteTramites estudianteTramites = new EstudianteTramites((Estudiante) usuarioAutenticado,
                    GestorPrincipal.secretaria());
            estudianteTramites.setVisible(true);
        } else if (usuarioAutenticado instanceof Empleado) {

        }

    }

    public static void mostrarRequisitosBajaEstudiantes() {
        RequisitosBajaEstudiantes requisitosBajaEstudiantes = new RequisitosBajaEstudiantes(
                (Estudiante) Auth.usuarioAutenticado());
        requisitosBajaEstudiantes.setVisible(true);
    }

}
