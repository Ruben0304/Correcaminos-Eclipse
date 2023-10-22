package app;
import java.util.ArrayList;


import modelos.entidades.Secretaria;
import modelos.entidades.Usuario;
import vistas.auth.Login;
public class Main {

	public static void main(String[] args) {
		
		Secretaria secretaria = new Secretaria();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.addAll(secretaria.getEstudiantes());
		Login loginView = new Login(usuarios);
	    loginView.setVisible(true);

	}

}
