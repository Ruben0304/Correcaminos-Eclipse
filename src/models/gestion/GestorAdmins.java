package models.gestion;

import java.util.ArrayList;
import java.util.HashMap;
import data.ObtenerAdmins;
import interfaces.Actualizador;
import models.usuarios.Admin;
import models.usuarios.Credenciales;

public class GestorAdmins implements Actualizador {
    private static GestorAdmins gestorAdmins;
    private HashMap<Credenciales,Admin> admins;

    // public GestorAdmins() {
    //     admins = new ArrayList<>();
    //     admins = ObtenerAdmins.cargarDesdeArchivo();
        
    // }

    public static GestorAdmins gestorAdmins() {
        if (gestorAdmins == null) {
            gestorAdmins = new GestorAdmins();
        }
        return gestorAdmins;
    }

    @Override
    public void actualizarDatos() {

    }

    public HashMap<Credenciales,Admin> getAdmins() {

        return admins;
    }
}
