package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.reflect.TypeToken;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import controllers.ControladorFiltrado;
import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import data.ObtenerChats;
import data.ObtenerEmpleados;
import data.ObtenerEmpleadosConDeudas;
import data.ObtenerEmpleadosConSalarioIndebido;
import data.ObtenerEstudiantesConEstipendio;
import data.ObtenerEstudiantesConLibrosDocentesPendientes;
import data.ObtenerEstudiantesConPertenenciasBeca;
import data.ObtenerPersonasConLibrosBibliotecaPendientes;
import data.ObtenerSolicitudesEstudiantes;
import data.ObtenerUsuariosCujae;
import models.chats.AdministradorChats;
import models.chats.Mensaje;
import models.gestion.Correcaminos;
import models.gestion.estudiantes.Secretaria;
import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Admin;
import models.usuarios.Becado;
import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.NoDocente;
import models.usuarios.Persona;
import util.Facultad;
import util.MotivoBaja;
import util.MotivoLicencia;
import util.Motivos;
import util.TipoCurso;
import util.TipoDepartamento;
import views.chat.ChatPanel;
import views.layouts.Pricipal;

public class Pruebas {
	public static void main(String[] args) {

//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
	// 	HashMap<Estudiante, Set<Solicitud>> solicitudesEstudiantes = new HashMap<>();

	// 	for (int i = 0; i < 5; i++) {
    //     //    Estudiante estudiante = new Estudiante("CI" + i, "Nombre" + i, "Apellido1_" + i, "Apellido2_" + i, Facultad.Ing_Informatica, i, TipoCurso.DIURNO, "Carrera" + i, i);
    //     //    Set<Solicitud> solicitudes = new HashSet<>();

    //     //    for (int j = 0; j < 3; j++) {
    //     //        if (j % 2 == 0) {
    //     //            SolicitudBaja solicitudBaja = new SolicitudBaja(j, MotivoBaja.Accidente);
    //     //            solicitudes.add(solicitudBaja);
    //     //        } else {
    //     //            Calendar fechaSalida = Calendar.getInstance();
    //     //            Calendar fechaRegreso = Calendar.getInstance();
    //     //            fechaRegreso.add(Calendar.MONTH, 1);
    //     //            SolicitudLicencia solicitudLicencia = new SolicitudLicencia(j, MotivoLicencia.Accidente, fechaSalida, fechaRegreso);
    //     //            solicitudes.add(solicitudLicencia);
    //     //        }
    //     //    }

    //     //    solicitudesEstudiantes.put(estudiante, solicitudes);
    //    }

		// pingaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa


		HashMap<String, String> filtros = new HashMap<>();

		// filtros.put("anio", "2023");
		// filtros.put("buscar", "1234567890");
		// filtros.put("estado", "PENDIENTE");
		// filtros.put("motivo", "");

		// HashMap<String, String> filtros1 = new HashMap<String, String>();
		// filtros1.put("anio", "");
		// filtros1.put("buscar", "");
		// filtros1.put("estado", "");
		// filtros1.put("motivo", "");

		// HashMap<String, String> filtros2 = new HashMap<String, String>();
		// filtros2.put("anio", "");
		// filtros2.put("buscar", "");
		// filtros2.put("estado", "");
		// filtros2.put("motivo", "");



		HashMap<Estudiante, Set<Solicitud>> solicitudesFiltradas = ControladorFiltrado.filtradoDinamicoSolicitudEstudiantes(filtros);
		for (Map.Entry<Estudiante, Set<Solicitud>> solicitudes : solicitudesFiltradas.entrySet()) {
            Estudiante estudiante = solicitudes.getKey();
			Set<Solicitud> listaSolicitudes = solicitudes.getValue();
			System.out.println(estudiante.getNombreCompleto());
		}
		

		// SwingUtilities.invokeLater(new Runnable() {
		// 	public void run() {
		// 		Gson gson = new Gson();

		// 		// Crear una instancia de AdministradorChats
		// 		AdministradorChats chatCollection = new AdministradorChats();

		// 		// Crear algunos objetos de la clase Mensaje
		// 		Mensaje mensaje1 = new Mensaje("persona1", "Hola, ¿cómo estás?");
		// 		Mensaje mensaje2 = new Mensaje("admin1", "Bien, gracias. ¿Y tú?");
		// 		Mensaje mensaje3 = new Mensaje("persona2", "¿Qué tal el proyecto?");
		// 		Mensaje mensaje4 = new Mensaje("admin2", "Va bien, solo falta un poco.");
		// 		Mensaje mensaje5 = new Mensaje("persona3", "Hola, soy nuevo aquí.");
		// 		Mensaje mensaje6 = new Mensaje("admin1", "Bienvenido, ¿en qué puedo ayudarte?");

		// 		// Crear algunas listas de mensajes para cada chat
		// 		ArrayList<Mensaje> mensajes1 = new ArrayList<>();
		// 		mensajes1.add(mensaje1);
		// 		mensajes1.add(mensaje2);
		// 		ArrayList<Mensaje> mensajes2 = new ArrayList<>();
		// 		mensajes2.add(mensaje3);
		// 		mensajes2.add(mensaje4);
		// 		ArrayList<Mensaje> mensajes3 = new ArrayList<>();
		// 		mensajes3.add(mensaje5);
		// 		mensajes3.add(mensaje6);

		// 		// Agregar los chats a la colección usando el método addChat de la clase
		// 		// AdministradorChats
		// 		// Usar solo el nombre de usuario como clave del mapa
		// 		chatCollection.addChat("admin1", "persona1", mensajes1);
		// 		chatCollection.addChat("admin2", "persona2", mensajes2);
		// 		chatCollection.addChat("admin1", "persona3", mensajes3);

		// 		// Convertir la instancia de AdministradorChats a una cadena JSON
		// 		String json = gson.toJson(chatCollection);

		// 		// Guardar la cadena JSON en un archivo
		// 		try {
		// 			FileWriter fileWriter = new FileWriter("chats.json");
		// 			fileWriter.write(json);
		// 			fileWriter.close();
		// 		} catch (IOException e) {
		// 			e.printStackTrace();
		// 		}

		// 		// Leer la cadena JSON desde el archivo
		// 		try {
		// 			FileReader fileReader = new FileReader("chats.json");
		// 			chatCollection = gson.fromJson(fileReader, AdministradorChats.class);
		// 			fileReader.close();
		// 		} catch (IOException e) {
		// 			e.printStackTrace();
		// 		}

		// 		// Obtener los chats desde la instancia de AdministradorChats
		// 		HashMap<String, HashMap<String, ArrayList<Mensaje>>> chats = chatCollection.getChats();

		// 		ChatPanel chatPanel = new ChatPanel("admin1");


				
//			}
//		});
		// 		// Imprimir los chats por consola
		// 		// ControladorLogin.comprobarSession();
		// 		// Pricipal frame = Pricipal.getInstancia();
		// 		// frame.setVisible(true);
		// 		// Crear un objeto de la clase Gson

		// 		// Convertir el hashmap de administradorChats a un json

		// 		// Imprimir el json

		// 		// Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// 		// try {

		// 		// String json = gson.toJson(administradorChats.getChats(), new
		// 		// TypeToken<HashMap<String, Map<Persona, ArrayList<Mensaje>>>>() {
		// 		// }.getType());

		// 		// FileWriter writerA = new FileWriter("./chats/biblioteca.json");

		// 		// writerA.write(json);
		// 		// writerA.close();

		// 		// }
		// 		// catch (Exception e) {
		// 		// e.printStackTrace();
		// 		// }

		// 	}
		// });
		
//		System.out.println(ObtenerEmpleados.cargarDesdeArchivo().get(4).getNombre());
//		
//		System.out.println(ObtenerSolicitudesEstudiantes.cargarDesdeArchivo().toString());
		
		System.out.println(ObtenerEstudiantesConEstipendio.cargarDesdeArchivo().isEmpty());
		
		System.out.println(ObtenerPersonasConLibrosBibliotecaPendientes.cargarDesdeArchivo().isEmpty());
		
		Collection<Set<String>> libros = ObtenerPersonasConLibrosBibliotecaPendientes.cargarDesdeArchivo().values();
		
		for (Set<String> s : libros) {
			for (String libro : s) {
				System.out.println(libro);
			}
		}
		
		HashMap<Empleado, Double> d = ObtenerEmpleadosConDeudas.cargarDesdeArchivo();
		
		Set<Empleado> em = d.keySet();
		
		for (Empleado e : em) {
			System.out.println(d.get(e));
		}
		
		Collection<Set<String>> pertenencias = ObtenerEstudiantesConPertenenciasBeca.cargarDesdeArchivo().values();
		
		for (Set<String> pertenencia : pertenencias) {
			for (String p : pertenencia) {
				System.out.println(p);
			}
		}
		
		Collection<Set<String>> ld = ObtenerEstudiantesConLibrosDocentesPendientes.cargarDesdeArchivo().values();
		
		for (Set<String> librosdocentes : ld) {
			for (String librod : librosdocentes) {
				System.out.println(librod);
			}
		}
		
		System.out.println(ObtenerEmpleadosConSalarioIndebido.cargarDesdeArchivo().isEmpty());
		
		System.out.println(ObtenerUsuariosCujae.cargarDesdeArchivo().isEmpty());
		
		System.out.println(ObtenerSolicitudesEstudiantes.cargarDesdeArchivo().isEmpty());


		
	}
}
