package models.chats;

import java.sql.Date;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.usuarios.Persona;

import util.TipoDepartamento;

public class Chat {
    private TipoDepartamento departamento;
    private Persona persona;
    private ArrayList<Mensaje> mensajes;

  
    public Chat(TipoDepartamento departamento, Persona persona) {
        this.departamento = departamento;
        this.persona = persona;
      mensajes.add(new Mensaje(departamento.toString(), "mmawebo", null));
        mensajes.add(new Mensaje(persona.getNombreUsuario(), "habla", null));
       
    
    }

    public TipoDepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(TipoDepartamento departamento) {
        this.departamento = departamento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    
}
