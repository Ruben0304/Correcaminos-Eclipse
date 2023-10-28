package modelos.entidades;

import java.util.ArrayList;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;
    

    public GestorUsuarios() {
        usuarios = new ArrayList<>();
        
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void registrar(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void registrar(ArrayList<Usuario> usuarios) {
       this.usuarios.addAll(usuarios);
    }

}
