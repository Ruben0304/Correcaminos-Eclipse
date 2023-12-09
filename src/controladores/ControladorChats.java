package controladores;

import java.util.ArrayList;

import datos.GuardarChats;
import modelos.chats.AdministradorChats;
import modelos.chats.Mensaje;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;


public class ControladorChats {

    public static ArrayList<Mensaje> obtenerMensajes(Admin departamento, Persona p) {
        return AdministradorChats.getAdministradorChats().obtenerMensajes(departamento, p);
    }

    public static void guardarMensajes(Admin departamento, Persona p, ArrayList<Mensaje> mensajes) {
        AdministradorChats.getAdministradorChats().actualizarMensajes(departamento, p, mensajes);
        GuardarChats.guardarChat(departamento, p);
    }
}
