package controlador;

import modelos.entidades.*;
import vistas.Inicio;

public class ControladorPrincipal {

    public static void mostrarInicio(Usuario usuario) {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        // inicio.dispose();
        // if (usuario instanceof Estudiante) {
        // if (usuario instanceof Becado) {

        // } else {
        // inicio.setVisible(true);
        // inicio.dispose();
        // }

        // }
    }
}
