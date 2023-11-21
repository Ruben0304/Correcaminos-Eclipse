package models.chats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import models.usuarios.Persona;
import util.TipoDepartamento;

public class AdministradorChats {
    private Map<TipoDepartamento, ArrayList<Chat>> chats;
    public static AdministradorChats administradorChats = null;

    public static AdministradorChats getAdministradorChats() {
        if (administradorChats == null) {
            administradorChats = new AdministradorChats();
        }
        return administradorChats;
    }

    private AdministradorChats() {
        this.chats = new HashMap<>();
        crearChat(TipoDepartamento.Biblioteca, null);
        crearChat(TipoDepartamento.Economia, null);
        Gson gson = new Gson();
        System.out.println(gson.toJson(this));
    }

    public void crearChat(TipoDepartamento departamento, Persona persona) {
        Chat chat = new Chat(departamento, persona);
        ArrayList<Chat> lista = chats.get(departamento);
        if (lista == null) {
            lista = new ArrayList<>();
            chats.put(departamento, lista);
        }
        lista.add(chat);
    }

    public void eliminarChat(TipoDepartamento departamento, Persona persona) {

        ArrayList<Chat> lista = chats.get(departamento);
        lista.remove(buscarChat(departamento, persona));

    }

    public Chat buscarChat(TipoDepartamento departamento, Persona persona) {
        ArrayList<Chat> lista = chats.get(departamento);
        Chat chat = null;
        if (lista != null) {
            for (Chat ch : lista) {
                if (ch.getPersona().getCi().equals(persona.getCi())) {
                    chat = ch;
                }
            }
        }
        return chat;
    }

    public List<Chat> listarChats(TipoDepartamento departamento) {
        ArrayList<Chat> lista = chats.get(departamento);

        return lista != null ? lista : null;
    }

}
