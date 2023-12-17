package modelos.chats;

import interfaces.Autenticable;

public class Mensaje {
    private String mensaje;
    private Autenticable persona;

    public Mensaje(String mensaje, Autenticable persona) {
        this.mensaje = mensaje;
        this.persona = persona;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public Autenticable getPersona() {
        return persona;
    }
    
}
