package modelos.entidades;

import java.util.ArrayList;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;
    

    public GestorUsuarios() {
        usuarios = new ArrayList<>();
        
    }

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = this.usuarios;
        return usuarios;
    }

    public void registrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void registrar(ArrayList<Usuario> usuarios) {
        usuarios.addAll(usuarios);
    }

}
