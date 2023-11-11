package app;

import javax.swing.SwingUtilities;

import controllers.ControladorPrincipal;
import models.gestion.GestorPrincipal;

public class MainPrueba {
	public static void main(String[] args) {
		GestorPrincipal gestor = GestorPrincipal.getGestorPrincipal();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorPrincipal.mostrarInicio();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
