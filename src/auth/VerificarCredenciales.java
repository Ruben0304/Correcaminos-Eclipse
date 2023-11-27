package auth;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;



import models.gestion.Correcaminos;
import models.usuarios.Usuario;

public class VerificarCredenciales {
private boolean credencialesCorrectas;
private Usuario usuario;

    public VerificarCredenciales(String nombreUsuario, String contrasena){
        usuario= null;
        credencialesCorrectas =  autenticar(nombreUsuario, contrasena);
    }
   
    private boolean autenticar(String nombreUsuario, String contrasena) {
        boolean encontrado = false;
        boolean autenticado = false;
        ArrayList<Usuario> usuarios = Correcaminos.getGestorPrincipal().getUsuarios();

        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            encontrado = nombreUsuario.equals(usuarios.get(i).getNombreUsuario());

            if (encontrado && hashContrasena(contrasena).equals(usuarios.get(i).getContrasena())) {
                autenticado = true;
                this.usuario = usuarios.get(i);
                

            }

        }

        return autenticado;
    }



     private  String hashContrasena(String contrasena) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] passwordBytes = contrasena.getBytes();

            byte[] hashBytes = md.digest(passwordBytes);

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                hexString.append(String.format("%02x", hashByte));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean credencialesCorrectas() {
        return credencialesCorrectas;
    }


    public Usuario usuarioAlQuePertenecen() {
        return usuario;
    }

    
    
}
