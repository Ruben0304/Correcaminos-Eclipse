package controlador;

import modelos.entidades.*;
import vistas.Inicio;

public class ControladorPrincipal {

    public static void mostrarInicio(Usuario usuario) {

        if (usuario instanceof Estudiante) {
            if (usuario instanceof Becado) {
                Inicio inicio = new Inicio("Becado");
            } else {
                Inicio inicio = new Inicio("Estudiante");
            }

        }
        else{
            Inicio inicio = new Inicio("Empleado");
        }
        inicio.setVisible(true);
                inicio.dispose();
    }
}
