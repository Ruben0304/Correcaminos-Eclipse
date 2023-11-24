package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.SolicitudLicenciaEstudiante;

public class ObtenerSolicitudesLicenciaEstudianteAceptadas {

	public static ArrayList<SolicitudLicenciaEstudiante> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
        ArrayList<SolicitudLicenciaEstudiante> solicitudes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudesLicenciaEstudianteAceptadas.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudLicenciaEstudiante>>() {
            }.getType();
            solicitudes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
	}

}
