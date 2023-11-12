package app;

import javax.swing.SwingUtilities;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.gestion.GestorPrincipal;


public class Main {
	public static void main(String[] args) {
		GestorPrincipal.getGestorPrincipal();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					// ControladorLogin.comprobarSession();
					// ControladorPrincipal.mostrarInicio();
                     
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
