package autenticacion;



import interfaces.Autenticable;


public class Auth {
    
    private static String nombreUsuario;
    private static Autenticable usuario;


    public static Autenticable usuarioAutenticado() {
        return usuario;
    }

    public static void iniciarSesion(Autenticable user, String nombreUser) {
        usuario = user;
        nombreUsuario = nombreUser;
    }

    public static boolean hayUsuarioAutenticado() {
        
        return usuario != null;
    }

    public static void logout() {
        usuario = null;
        nombreUsuario = null;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }
}
