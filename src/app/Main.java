package app;
import java.util.ArrayList;

import modelos.auth.GestorUsuarios;
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
		GestorUsuarios gestorUsuarios = new GestorUsuarios(usuarios);

		Login loginView = new Login(gestorUsuarios);
	    loginView.setVisible(true);

	}

}
