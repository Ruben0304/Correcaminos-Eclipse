package auth;

import interfaces.Autenticable;
import models.departamentos.SeguridadInformatica;
import models.gestion.GestorAdmins;
import models.gestion.GestorDepartamentos;
import models.usuarios.Admin;
import models.usuarios.Credenciales;
import models.usuarios.Persona;

public class VerificacionCredenciales {

    public static Autenticable autenticar(String nombreUsuario, String contrasena) {

        Credenciales credenciales = new Credenciales(nombreUsuario, contrasena);

        System.out.println(credenciales.getUsuario());
        if (!(credenciales.getUsuario() == null)) {

            SeguridadInformatica s = GestorDepartamentos.gestorDepartamentos().getSeguridadInformatica();
            GestorAdmins a = GestorAdmins.gestorAdmins();

            Persona usuarioCujae = s.getUsuariosCujae().get(credenciales);
            Admin admin = a.getAdmins().get(credenciales);

            System.out.println(usuarioCujae.getApellidos());
            return usuarioCujae != null ? usuarioCujae : (admin != null ? admin : null);
        }
        return null;

    }

}
