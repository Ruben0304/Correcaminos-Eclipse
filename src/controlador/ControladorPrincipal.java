package controlador;

import java.util.ArrayList;

import modelos.auth.GestorUsuarios;
import modelos.entidades.*;
import vistas.Inicio;
import vistas.auth.Login;

public class ControladorPrincipal {

    public static void mostrarInicio(GestorUsuarios gestorUsuarios) {
        
        Inicio inicio = new Inicio(gestorUsuarios);
        inicio.setVisible(true);
        
    }

    
}
