package controllers;

import java.util.ArrayList;

import auth.Auth;
import models.departamentos.Biblioteca;
import models.departamentos.Economia;
import models.gestion.GestorDepartamentos;
import models.gestion.GestorPrincipal;
import models.gestion.estudiantes.GestorEstudiantes;
import models.gestion.estudiantes.GestorResponsabilidadesEstudiantes;
import models.gestion.estudiantes.GestorSolicitudesEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
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

        
        ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantes = GestorEstudiantes.gestorEstudiantes()
                .getGestorResponsabilidadesEstudiantes().getResponsabilidadesEstudiantesPendientes();

                GestorDepartamentos gestDep = GestorDepartamentos.gestorDepartamentos();

        if (Auth.usuarioAutenticado() instanceof Estudiante) {
            Estudiante usuarioAutenticado = (Estudiante) Auth.usuarioAutenticado();

            boolean tieneLibrosPrestados = gestDep.getBiblioteca().getgetListadoDeUnEstudiante(usuarioAutenticado)

            boolean tieneEstipendio = Economia.tieneEstipendio(usuarioAutenticado,
                    responsabilidadesEstudiantes);

            boolean tieneDeuda = Economia.tieneDeuda(usuarioAutenticado,
                    responsabilidadesEstudiantes);
                    
            RequisitosBajaEstudiantes requisitosBajaEstudiantes = new RequisitosBajaEstudiantes(
                    usuarioAutenticado, tieneEstipendio, tieneDeuda, tieneLibrosPrestados);
            requisitosBajaEstudiantes.setVisible(true);

            

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
