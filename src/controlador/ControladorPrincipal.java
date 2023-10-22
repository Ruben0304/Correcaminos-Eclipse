package controlador;

import modelos.entidades.*;
import vistas.Inicio;

public class ControladorPrincipal {

    public static void mostrarInicio(Usuario usuario) {
        
        Inicio inicio = new Inicio(usuario);
        inicio.setVisible(true);
        inicio.dispose();
    }
}
