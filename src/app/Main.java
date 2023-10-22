package app;
import java.util.ArrayList;

import modelos.datos.AdminFactory;
import modelos.entidades.Admin;
import modelos.entidades.Secretaria;
import modelos.entidades.Usuario;
import vistas.auth.Login;
public class Main {

	public static void main(String[] args) {
		
		Secretaria secretaria = new Secretaria();

		ArrayList<Admin> admins = new ArrayList<>();
		admins.addAll(AdminFactory.inicializarAdmins());

		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.addAll(secretaria.getEstudiantes());
		usuarios.addAll(admins);
		
		Login loginView = new Login(usuarios);
	    loginView.setVisible(true);

	}

}
