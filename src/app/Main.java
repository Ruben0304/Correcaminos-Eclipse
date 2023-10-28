package app;

import javax.swing.SwingUtilities;


import controlador.ControladorPrincipal;



public class Main {
	public static void main(String[] args) {
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
