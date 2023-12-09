package modelos.gestion;


import java.util.HashMap;

import datos.ObtenerAdmins;
import modelos.usuarios.Admin;
import modelos.usuarios.Credenciales;

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
