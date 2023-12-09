package app;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controladores.ControladorLogin;
import controladores.ControladorPrincipal;
import modelos.gestion.Correcaminos;
import modelos.gestion.GestorDepartamentos;
import modelos.gestion.estudiantes.Secretaria;
import modelos.usuarios.Credenciales;
import modelos.usuarios.Estudiante;
import modelos.usuarios.Persona;
import vistas.template.Pricipal;

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
		System.out.println(Calendar.getInstance());
	// 	System.out.println(GestorDepartamentos.gestorDepartamentos().getSeguridadInformatica().getUsuariosCujae().size());
    //    Credenciales credenciales = new Credenciales("estudiante1", "eweryiewfhwewobuebweubeuewbx");
	//    System.out.println(GestorDepartamentos.gestorDepartamentos().getSeguridadInformatica().getUsuariosCujae().get(credenciales));
	   
	}
}
