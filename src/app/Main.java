package app;

import javax.swing.SwingUtilities;

import controlador.ControladorLogin;
import modelos.auth.GestorUsuarios;

import modelos.entidades.RecursosHumanos;
import modelos.entidades.Secretaria;
import vistas.auth.Login;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Secretaria secretaria = new Secretaria();
					RecursosHumanos recursosHumanos = new RecursosHumanos();
					GestorUsuarios gestorUsuarios = new GestorUsuarios(secretaria, recursosHumanos, true);
					ControladorLogin.mostrarLogin(gestorUsuarios.getUsuarios(), secretaria, recursosHumanos);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
