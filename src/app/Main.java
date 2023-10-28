package app;

import javax.swing.SwingUtilities;

import controlador.ControladorPrincipal;
import modelos.entidades.GestorPrincipal;

public class Main {
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
