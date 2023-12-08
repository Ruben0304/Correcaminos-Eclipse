package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.gestion.Correcaminos;
import models.gestion.GestorDepartamentos;
import models.gestion.estudiantes.Secretaria;
import models.usuarios.Credenciales;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import views.layouts.Pricipal;

public class Main {
	public static void main(String[] args) {
		Correcaminos.getGestorPrincipal();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				
				

				
				// ControladorLogin.comprobarSession();
				// Pricipal frame = Pricipal.getInstancia();
				// frame.setVisible(true);
				// JOptionPane.showMessageDialog(null, "Muy importante leer documento
				// Importante.txt en la raiz del proyecto");
				ControladorLogin.mostrarLogin();
				tests();

			}
		});

	}

	public static void tests() {
		
		System.out.println(GestorDepartamentos.gestorDepartamentos().getSeguridadInformatica().getUsuariosCujae().size());
       Credenciales credenciales = new Credenciales("estudiante1", "eweryiewfhwewobuebweubeuewbx");
	   System.out.println(GestorDepartamentos.gestorDepartamentos().getSeguridadInformatica().getUsuariosCujae().get(credenciales));
	   
	}
}
