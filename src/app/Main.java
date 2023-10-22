package app;

import modelos.auth.GestorUsuarios;

import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;

import vistas.auth.Login;

public class Main {

	public static void main(String[] args) {

		Secretaria secretaria = new Secretaria();
		RecursosHumanos recursosHumanos = new RecursosHumanos();

		GestorUsuarios gestorUsuarios = new GestorUsuarios(secretaria, recursosHumanos, true);

		Login loginView = new Login(gestorUsuarios.getUsuarios());
		loginView.setVisible(true);

	}

}
