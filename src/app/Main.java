package app;

import controlador.ControladorLogin;
import modelos.auth.GestorUsuarios;

import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;



public class Main {

	public static void main(String[] args) {

		Secretaria secretaria = new Secretaria();
		RecursosHumanos recursosHumanos = new RecursosHumanos();

		GestorUsuarios gestorUsuarios = new GestorUsuarios(secretaria, recursosHumanos, true);

		ControladorLogin.mostrarLogin(gestorUsuarios.getUsuarios(),secretaria,recursosHumanos);

	}

}
