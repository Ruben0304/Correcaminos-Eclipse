package controlador;

import java.util.ArrayList;

import modelos.entidades.*;
import vistas.Inicio;

public class ControladorPrincipal {

    public static void mostrarInicio(Usuario usuarioAutenticado, ArrayList<Usuario> usuarios) {

        Inicio inicio = new Inicio(usuarioAutenticado, usuarios);
        inicio.setVisible(true);

    }

}
