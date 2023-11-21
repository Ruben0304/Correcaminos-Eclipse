package models.chats;

import java.sql.Date;
import java.util.ArrayList;

import com.google.gson.Gson;

import data.GuardarChats;
import models.usuarios.Persona;

import util.TipoDepartamento;

public class Chat {
    private TipoDepartamento departamento;
    private String nombreUsuario;
    private ArrayList<Mensaje> mensajes;

    public Chat(TipoDepartamento departamento, String nombreUsuario) {
        this.departamento = departamento;
        this.nombreUsuario = nombreUsuario;
        mensajes = new ArrayList<>();
        // mensajes.add(new Mensaje(departamento.toString(), persona.getNombreUsuario()));
        // mensajes.add(new Mensaje("jujujuj", "habla"));

    }

    public TipoDepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(TipoDepartamento departamento) {
        this.departamento = departamento;
    }

    // public Persona getPersona() {
    //     return persona;
    // }

    // public void setPersona(Persona persona) {
    //     this.persona = persona;
    // }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

     public void agregarMensaje(Mensaje m) {

        this.mensajes.add(m);
        GuardarChats.guardarChat(this.getDepartamento());
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

	
    

}
