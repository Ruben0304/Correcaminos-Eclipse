package app;

import javax.swing.SwingUtilities;

import controlador.ControladorLogin;



public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorLogin.mostrarLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
