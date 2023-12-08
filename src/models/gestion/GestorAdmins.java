package models.gestion;


import java.util.HashMap;
import data.ObtenerAdmins;
import models.usuarios.Admin;
import models.usuarios.Credenciales;

public class GestorAdmins {
    private static GestorAdmins gestorAdmins;
    private HashMap<Credenciales, Admin> admins;


    

    private GestorAdmins() {
        admins = new HashMap<>();
        cargarAdmins();
    }

    public static GestorAdmins gestorAdmins() {
        if (gestorAdmins == null) {
            gestorAdmins = new GestorAdmins();
        }
        return gestorAdmins;
    }

    private void cargarAdmins() {
        this.admins = ObtenerAdmins.cargarDesdeArchivo();
    }

    public HashMap<Credenciales, Admin> getAdmins() {

        return admins;
    }
}
