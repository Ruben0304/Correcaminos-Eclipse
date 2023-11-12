package controllers;

import auth.Auth;
import models.gestion.GestorPrincipal;
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
            GestorSolicitudesEstudiante gestorSolicitudesEstudiante =  GestorPrincipal.getGestorPrincipal().getGestorEstudiantes().getGestorSolicitudes();
            Inicio inicio = new Inicio(Auth.usuarioAutenticado(), gestorSolicitudesEstudiante);
            inicio.setVisible(true);
        }else{
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
