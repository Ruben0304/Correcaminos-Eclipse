package models.gestion;

import java.util.ArrayList;
import java.util.HashMap;
import data.ObtenerAdmins;
import interfaces.Actualizador;
import models.usuarios.Admin;
import models.usuarios.Credenciales;

public class GestorAdmins{
    private static GestorAdmins gestorAdmins;
    private HashMap<Credenciales,Admin> admins;

  
    public static GestorAdmins gestorAdmins() {
        if (gestorAdmins == null) {
            gestorAdmins = new GestorAdmins();
        }
        return gestorAdmins;
    }


    public HashMap<Credenciales,Admin> getAdmins() {

        return admins;
    }
}
