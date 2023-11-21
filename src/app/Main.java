package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.gestion.GestorPrincipal;
import models.gestion.estudiantes.GestorEstudiantes;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import views.Pricipal;

public class Main {
	public static void main(String[] args) {
		GestorPrincipal.getGestorPrincipal();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				ArrayList<Persona> lala = new ArrayList<>();
				

				ControladorLogin.comprobarSession();
				Pricipal frame = Pricipal.getInstancia();
				frame.setVisible(true);
				// JOptionPane.showMessageDialog(null, "Muy importante leer documento
				// Importante.txt en la raiz del proyecto");
				ControladorPrincipal.mostrarInicio();

			}
		});

	}

	public static void tests() {
		for (Estudiante e : GestorEstudiantes.gestorEstudiantes().filtrar("Juan")) {
			System.out.println(e.getApellidos());
		}

	}
}
