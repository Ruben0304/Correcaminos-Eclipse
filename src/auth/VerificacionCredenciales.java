package auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import interfaces.Autenticable;
import models.departamentos.SeguridadInformatica;
import models.gestion.Correcaminos;
import models.gestion.GestorDepartamentos;
import models.usuarios.Credenciales;

public class VerificacionCredenciales {

    public static Autenticable autenticar(String nombreUsuario, String contrasena) {

        Credenciales credenciales = new Credenciales(nombreUsuario, contrasena);

        SeguridadInformatica s = GestorDepartamentos.gestorDepartamentos().getSeguridadInformatica();

        return s.getUsuariosCujae().get(credenciales);
    }

   

}
