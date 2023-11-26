package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.SolicitudBajaEmpleado;

public class ObtenerSolicitudesBajasEmpleadosAceptadas {

	public static ArrayList<SolicitudBajaEmpleado> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		ArrayList<SolicitudBajaEmpleado> solicitudes = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudesEmpleadosAceptadas.json"))) {
			Type listType = new TypeToken<ArrayList<SolicitudBajaEmpleado>>() {
			}.getType();
			solicitudes = gson.fromJson(reader, listType);   
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return solicitudes;
	}

}
