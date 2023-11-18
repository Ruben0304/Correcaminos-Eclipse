package app;

import javax.swing.SwingUtilities;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.gestion.GestorPrincipal;
import views.Pricipal;

public class Main {
	public static void main(String[] args) {
		GestorPrincipal.getGestorPrincipal();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					ControladorLogin.comprobarSession();
					Pricipal frame = Pricipal.getInstancia();
					frame.setVisible(true);
					ControladorPrincipal.mostrarInicio();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
