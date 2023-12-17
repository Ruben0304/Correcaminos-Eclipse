package modelos.chats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.Autenticable;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;

public class AdministradorChats {
    private Map<Admin, Map<Persona,Chat>> chats;

    public Chat obtenerChat (Admin entidad, Persona persona){

      return chats.get(entidad).get(persona);
    }
    
}
