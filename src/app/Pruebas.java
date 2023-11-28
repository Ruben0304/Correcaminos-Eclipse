package app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import models.chats.AdministradorChats;
import models.chats.Mensaje;
import models.gestion.Correcaminos;
import models.gestion.estudiantes.Secretaria;
import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Persona;
import util.Facultad;
import util.TipoCurso;
import util.TipoDepartamento;
import views.layouts.Pricipal;

public class Pruebas {
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Crear un objeto de la clase AdministradorChats
				AdministradorChats administradorChats = AdministradorChats.getAdministradorChats();

				// Crear algunos objetos de las clases Admin, Persona y Mensaje
				Admin admin1 = new Admin("admin1", "admin1@gmail.com", TipoDepartamento.Biblioteca);
				Admin admin2 = new Admin("admin2", "admin2@gmail.com", TipoDepartamento.Economia);
				Estudiante persona1 = new Estudiante("persona1", "111111", "12345678", "Juan", "Pérez", "García",
						Facultad.Arquitectura, 1, TipoCurso.DIURNO, "Informática", 101);
				Estudiante persona2 = new Estudiante("persona2", "222222", "87654321", "María", "López", "Sánchez",
						Facultad.Ing_Automatica_y_Biomedica, 2, TipoCurso.DIURNO, "Matemáticas", 202);
				Estudiante persona3 = new Estudiante("persona3", "333333", "13572468", "Pedro", "González", "Rodríguez",
						Facultad.Ing_Civil, 3, TipoCurso.DIURNO, "Física", 303);
				Mensaje mensaje1 = new Mensaje(persona1.getNombreUsuario(), "Hola, ¿cómo estás?");
				Mensaje mensaje2 = new Mensaje(admin1.getNombreUsuario(), "Bien, gracias. ¿Y tú?");
				Mensaje mensaje3 = new Mensaje(persona2.getNombreUsuario(), "¿Qué tal el proyecto?");
				Mensaje mensaje4 = new Mensaje(admin2.getNombreUsuario(), "Va bien, solo falta un poco.");
				Mensaje mensaje5 = new Mensaje(persona3.getNombreUsuario(), "Hola, soy nuevo aquí.");
				Mensaje mensaje6 = new Mensaje(admin1.getNombreUsuario(), "Bienvenido, ¿en qué puedo ayudarte?");

				// Crear algunas listas de mensajes para cada chat
				ArrayList<Mensaje> mensajes1 = new ArrayList<>();
				mensajes1.add(mensaje1);
				mensajes1.add(mensaje2);
				ArrayList<Mensaje> mensajes2 = new ArrayList<>();
				mensajes2.add(mensaje3);
				mensajes2.add(mensaje4);
				ArrayList<Mensaje> mensajes3 = new ArrayList<>();
				mensajes3.add(mensaje5);
				mensajes3.add(mensaje6);

				// Crear algunos mapas de personas y mensajes para cada admin
				Map<Persona, ArrayList<Mensaje>> chats1 = new HashMap<>();
				chats1.put(persona1, mensajes1);
				chats1.put(persona3, mensajes3);
				Map<Persona, ArrayList<Mensaje>> chats2 = new HashMap<>();
				chats2.put(persona2, mensajes2);

				// Añadir los mapas de chats al hashmap de administradorChats
				administradorChats.getChats().put(admin1, chats1);
				administradorChats.getChats().put(admin2, chats2);

				// Crear un objeto de la clase Gson

				// Convertir el hashmap de administradorChats a un json
				

				// Imprimir el json
				

				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = gson.toJson(administradorChats.getChats());
				try {

					FileWriter writerA = new FileWriter("./chats/biblioteca.json");

					writerA.write(json);
					writerA.close();

					System.out.println(json);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
