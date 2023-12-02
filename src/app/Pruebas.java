package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import controllers.ControladorLogin;
import controllers.ControladorPrincipal;
import data.ObtenerChats;
import data.ObtenerEmpleados;
import models.chats.AdministradorChats;
import models.chats.Mensaje;
import models.gestion.Correcaminos;
import models.gestion.estudiantes.Secretaria;
import models.usuarios.Admin;
import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.NoDocente;
import models.usuarios.Persona;
import util.Facultad;
import util.TipoCurso;
import util.TipoDepartamento;
import views.chat.ChatPanel;
import views.layouts.Pricipal;

public class Pruebas {
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
			System.out.println(ObtenerEmpleados.cargarDesdeArchivo().get(4).getNombre());	

			}
		});
	}
}
