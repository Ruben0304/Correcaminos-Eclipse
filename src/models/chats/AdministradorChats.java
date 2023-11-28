package models.chats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

import data.ObtenerChats;
import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import util.TipoDepartamento;

public class AdministradorChats {
    private Map<Admin, Map<Persona, ArrayList<Mensaje>>> chats;
    public static AdministradorChats administradorChats = null;

    public static AdministradorChats getAdministradorChats() {
        if (administradorChats == null) {
            administradorChats = new AdministradorChats();
        }
        return administradorChats;
    }

    private AdministradorChats() {
        this.chats = new TreeMap<>();

    }

    

    public ArrayList<Mensaje> obtenerMensajes(Admin departamento, Persona p) {

        return chats.get(departamento).get(p);

    }

}
