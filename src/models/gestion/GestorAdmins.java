package models.gestion;

import java.util.ArrayList;

import data.ObtenerAdmins;
import models.interfaces.actualizador;
import models.usuarios.Admin;

public class GestorAdmins implements actualizador {
    private ArrayList<Admin> admins;

    public GestorAdmins() {
        admins = new ArrayList<>();
        ObtenerAdmins.cargarDesdeArchivo();
    }

    @Override
    public void actualizarDatos() {

    }

    public ArrayList<Admin> getAdmins() {

        return admins;
    }
}
