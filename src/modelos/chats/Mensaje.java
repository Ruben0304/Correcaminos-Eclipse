package modelos.chats;

import interfaces.Autenticable;

public class Mensaje {
    private String mensaje;
    private String autor;

    public Mensaje(String mensaje, String autor) {
        this.mensaje = mensaje;
        this.autor = autor;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public String getAutor() {
        return autor;
    }
    
}
