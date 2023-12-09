package autenticacion;

import interfaces.Autenticable;
import modelos.admin.SeguridadInformatica;
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

            Persona usuarioCujae = s.getUsuariosCujae().get(credenciales);
            Admin admin = a.getAdmins().get(credenciales);


            return usuarioCujae != null ? usuarioCujae : (admin != null ? admin : null);
        }
        return null;

    }

}
