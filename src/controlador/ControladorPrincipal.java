package controlador;

import java.util.ArrayList;

import modelos.entidades.*;
import vistas.Inicio;
import vistas.usuarios.EstudianteTramites;

public class ControladorPrincipal {

    public static void mostrarInicio(Usuario usuarioAutenticado, ArrayList<Usuario> usuarios,Secretaria secretaria, RecursosHumanos recursosHumanos) {

        Inicio inicio = new Inicio(usuarioAutenticado, usuarios,secretaria,recursosHumanos);
        inicio.setVisible(true);

    }

    public static void mostrarTramites(Usuario usuarioAutenticado, ArrayList<Usuario> usuarios,Secretaria secretaria, RecursosHumanos recursosHumanos) {
        if (usuarioAutenticado instanceof Estudiante) {
            EstudianteTramites estudianteTramites = new EstudianteTramites((Estudiante)usuarioAutenticado, usuarios,secretaria,recursosHumanos);
            estudianteTramites.setVisible(true);
        } else if (usuarioAutenticado instanceof Empleado) {

        }

    }

}
