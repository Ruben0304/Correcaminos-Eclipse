package autenticacion;

import interfaces.Autenticable;
import modelos.departamentos.SeguridadInformatica;
import modelos.gestion.GestorAdmins;
import modelos.gestion.GestorDepartamentos;
import modelos.usuarios.Admin;
import modelos.usuarios.Credenciales;
import modelos.usuarios.Persona;

public class VerificacionCredenciales {

    public static Autenticable autenticar(String nombreUsuario, String contrasena) {

        Credenciales credenciales = new Credenciales(nombreUsuario, contrasena);

        System.out.println(credenciales.getUsuario());
        if (!(credenciales.getUsuario() == null)) {

            SeguridadInformatica s = GestorDepartamentos.gestorDepartamentos().getSeguridadInformatica();
            GestorAdmins a = GestorAdmins.gestorAdmins();


            Persona usuarioCujae = !s.getUsuariosCujae().isEmpty() ? s.getUsuariosCujae().get(credenciales) : null;
            Persona temporal = !s.getTemporales().isEmpty() ? s.getTemporales().get(credenciales) : null;
            Admin admin = !a.getAdmins().isEmpty() ? a.getAdmins().get(credenciales) : null;

            return usuarioCujae != null ? usuarioCujae : (temporal != null ? temporal : (admin != null ? admin : null));
        }
        return null;

    }

}
