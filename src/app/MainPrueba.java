package app;

import javax.swing.SwingUtilities;

import controllers.ControladorPrincipal;
import data.ObtenerSolicitudes;
import models.gestion.GestorPrincipal;

public class MainPrueba {
	public static void main(String[] args) {
		// GestorPrincipal gestor = GestorPrincipal.getGestorPrincipal();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					ObtenerSolicitudes.cargarDesdeArchivoB();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
