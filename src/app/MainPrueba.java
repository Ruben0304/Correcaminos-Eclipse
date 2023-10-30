package app;

import javax.swing.SwingUtilities;

import controlador.ControladorPrincipal;
import modelos.gestion.GestorPrincipal;

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
