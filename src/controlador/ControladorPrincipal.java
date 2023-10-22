package controlador;

import java.util.ArrayList;

import modelos.entidades.*;
import vistas.Inicio;
import vistas.auth.Login;

public class ControladorPrincipal {

    public static void mostrarInicio(Usuario usuario,) {
        
        Inicio inicio = new Inicio(usuario);
        inicio.setVisible(true);
        
    }

    
}
