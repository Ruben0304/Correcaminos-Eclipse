package modelos.chats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import modelos.usuarios.Persona;
import util.TipoDepartamento;

public class AdministradorChats {
  private Map<TipoDepartamento, Map<Persona, Chat>> chats;
  private static AdministradorChats instancia = null;

  private AdministradorChats() {
    chats = new HashMap<>();
  }

  public static AdministradorChats getInstancia() {
    if (instancia == null) {
      instancia = new AdministradorChats();
    }
    return instancia;
  }

  public Chat obtenerChat(TipoDepartamento entidad, Persona persona) {

    return chats.get(entidad).get(persona);
  }

}
