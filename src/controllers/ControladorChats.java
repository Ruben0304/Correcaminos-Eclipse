package controllers;

import java.util.ArrayList;

import data.GuardarChats;
import models.chats.AdministradorChats;
import models.chats.Mensaje;
import models.usuarios.Admin;
import models.usuarios.Persona;
import util.TipoDepartamento;

public class ControladorChats {

    public static ArrayList<Mensaje> obtenerMensajes(Admin departamento, Persona p) {
        return AdministradorChats.getAdministradorChats().obtenerMensajes(departamento, p);
    }

    public static void guardarMensajes(Admin departamento, Persona p) {
        GuardarChats.guardarChat(departamento, p);
    }
}
