package app;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.chats.AdministradorChats;
import models.gestion.GestorPrincipal;
import views.Pricipal;

public class Pruebas {
    public static void main(String[] args) {
		
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {

					AdministradorChats.getAdministradorChats();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
			}
		});
	}
}
