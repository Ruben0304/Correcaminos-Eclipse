package app;

import javax.swing.SwingUtilities;

import controlador.ControladorLogin;
import controlador.ControladorPrincipal;
import modelos.gestion.GestorPrincipal;

public class Main {
    public static void main(String[] args) {
		GestorPrincipal.getGestorPrincipal();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					if (ControladorLogin.comprobarSession()) {
						ControladorPrincipal.mostrarInicio();
					 }
					 else{
						ControladorLogin.mostrarLogin();
					 }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
