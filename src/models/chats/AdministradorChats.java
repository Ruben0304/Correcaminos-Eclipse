package models.chats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.gson.Gson;

import data.ObtenerChats;
import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import util.TipoDepartamento;

public class AdministradorChats {
    private HashMap<String, HashMap<String, ArrayList<Mensaje>>> chats;
    // public static AdministradorChats administradorChats = null;

    // public static AdministradorChats getAdministradorChats() {
    //     if (administradorChats == null) {
    //         administradorChats = new AdministradorChats();
    //     }
    //     return administradorChats;
    // }

    public AdministradorChats() {
        chats = new HashMap<>();

    }

    public void addChat(String departamento, String p, ArrayList<Mensaje> mensajes ) {

        if (!chats.containsKey(departamento)) {
            chats.put(departamento, new HashMap<String, ArrayList<Mensaje>>());
          }
         
          chats.get(departamento).put(p, mensajes);
        

    }

    public HashMap<String, HashMap<String, ArrayList<Mensaje>>> getChats() {
        return chats;
    }
    

    public ArrayList<Mensaje> obtenerMensajes(String departamento, String p) {

        return chats.get(departamento).get(p);

    }

}
