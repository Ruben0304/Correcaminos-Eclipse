package models.chats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

import data.ObtenerChats;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import util.TipoDepartamento;

public class AdministradorChats {
    private Map<TipoDepartamento,Map<String,ArrayList<Mensaje>>> chats;
    // private ArrayList<Chat> chats;
    public static AdministradorChats administradorChats = null;

    public static AdministradorChats getAdministradorChats() {
        if (administradorChats == null) {
            administradorChats = new AdministradorChats();
        }
        return administradorChats;
    }

    private AdministradorChats() {
        this.chats = new TreeMap<>();
        // crearChat(TipoDepartamento.Biblioteca, new Estudiante("Manuel", null,
        // "00909090909", null, null, null, null, 0, null, null, 0));
        // crearChat(TipoDepartamento.Economia, new Estudiante("Manuel", null,
        // "0090909909", null, null, null, null, 0, null, null, 0));
        chats = ObtenerChats.cargarDesdeArchivo();
        Gson gson = new Gson();
        System.out.println(gson.toJson(chats));
    }

    public void crearChat(TipoDepartamento departamento, String nombreUsuario) {
        Chat chat = new Chat(departamento, nombreUsuario);
        chats.add(chat);
    }

    // public void eliminarChat(TipoDepartamento departamento, Persona persona) {

    // ArrayList<Chat> lista = chats.get(departamento);
    // lista.remove(buscarChat(departamento, persona));

    // }

    public Chat buscarChat(TipoDepartamento departamento, String ci) {
        Chat chat = null;

        for (Chat ch : chats) {
            if (ch.getNombreUsuario().equals(ci) && ch.getDepartamento().equals(departamento)) {
                chat = ch;
            }
        }

        return chat;
    }

    public ArrayList<Chat> listarChats(TipoDepartamento departamento) {
        ArrayList<Chat> chs = new ArrayList<>();
        for (Chat chat : chats) {
            if (chat.getDepartamento().equals(departamento)) {
                chs.add(chat);
            }
        }

        return chs;
    }

}
