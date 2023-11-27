package app;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.chats.AdministradorChats;
import models.gestion.Correcaminos;
import models.gestion.estudiantes.Secretaria;
import models.solicitudes.SolicitudBajaEstudiante;
import views.layouts.Pricipal;

public class Pruebas {
    public static void main(String[] args) {
		
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				

				
		        HashMap<String,String> hash = new HashMap<>();
				hash.put("facultad", "Ing_Informatica");
				hash.put("buscar", "78901234560");
				hash.put("estado", "ACEPTADO");
				hash.put("anio", "2023");
				;
				for (SolicitudBajaEstudiante s : Secretaria.gestorEstudiantes().getGestorSolicitudes().filtradoDinamicoSolicitudBajaEstudiantes(hash)) {
					System.out.println(s.getEstudiante().getNombreCompleto());
				}

			}
		});
	}
}
