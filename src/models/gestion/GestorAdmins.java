package models.gestion;

import java.util.ArrayList;

import data.ObtenerAdmins;
import models.interfaces.Actualizador;
import models.usuarios.Admin;

public class GestorAdmins implements Actualizador {
    private static GestorAdmins gestorAdmins;
    private ArrayList<Admin> admins;

    public GestorAdmins() {
        admins = new ArrayList<>();
        admins = ObtenerAdmins.cargarDesdeArchivo();
    }

    public static GestorAdmins gestorAdmins() {
        if (gestorAdmins == null) {
            gestorAdmins = new GestorAdmins();
        }
        return gestorAdmins;
    }

    @Override
    public void actualizarDatos() {

    }

    public ArrayList<Admin> getAdmins() {

        return admins;
    }
}
