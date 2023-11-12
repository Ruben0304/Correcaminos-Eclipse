package models.gestion;

import java.util.ArrayList;

import data.ObtenerAdmins;
import models.usuarios.Admin;

public class GestorAdmins {
    private ArrayList<Admin> admins;

    


    public GestorAdmins() {
        admins = new ArrayList<>();
        ObtenerAdmins.cargarDesdeArchivo();
    }




    public ArrayList<Admin> getAdmins() {

        return admins;
    }
}
