package controllers;

import java.util.ArrayList;

import auth.Auth;
import models.departamentos.Biblioteca;
import models.gestion.GestorDepartamentos;
import models.gestion.GestorPrincipal;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.Usuario;
import utiles.Colores;
import views.Inicio;
import views.usuarios.EstudianteTramites;
import views.usuarios.RequisitosBajaEstudiantes;

public class ControladorPrincipal {

    public static void mostrarInicio() {

        if (Auth.hayUsuarioAutenticado()) {
            boolean estudianteSolicitaLicencia = false;
            if (Auth.usuarioAutenticado() instanceof Estudiante) {
                estudianteSolicitaLicencia = GestorPrincipal.getGestorPrincipal().getGestorEstudiantes()
                        .getGestorSolicitudes()
                        .verificarEstudianteSolicitaLicencia((Estudiante) Auth.usuarioAutenticado());
            }
            Inicio inicio = new Inicio(Auth.usuarioAutenticado(), estudianteSolicitaLicencia);
            inicio.setVisible(true);
        } else {
            ControladorLogin.mostrarLogin();
        }

    }

    public static void mostrarTramites() {

    }

    public static void mostrarRequisitosBajaEstudiantes() {
        Usuario usuarioAutenticado = Auth.usuarioAutenticado();
        GestorDepartamentos gestorDepartamentos = GestorPrincipal.getGestorPrincipal().getGestorDepartamentos();
        GestorResponsabilidadesEstudiantes gestorResponsabilidadesEstudiantes = GestorPrincipal.getGestorPrincipal()
                .getGestorEstudiantes().getGestorResponsabilidadesEstudiantes();

        if (usuarioAutenticado instanceof Estudiante) {

            ArrayList<Boolean> requisitos = gestorDepartamentos.verificarRequisitosEstudiantes(
                    (Estudiante) usuarioAutenticado,
                    gestorResponsabilidadesEstudiantes.getResponsabilidadesEstudiantesPendientes());
            RequisitosBajaEstudiantes requisitosBajaEstudiantes = new RequisitosBajaEstudiantes(
                    (Estudiante) Auth.usuarioAutenticado(), requisitos);
            requisitosBajaEstudiantes.setVisible(true);

        } else if (usuarioAutenticado instanceof Empleado) {

        }

    }

    public static void modoOscuro(boolean modoOscuro) {
        if (modoOscuro) {
            Colores.modoOscuro();
        } else {
            Colores.modoClaro();
        }
        mostrarInicio();
    }

    public static void actualizarDatos() {

        GestorPrincipal.getGestorPrincipal().actualizarDatos();
        mostrarInicio();

    }
}
