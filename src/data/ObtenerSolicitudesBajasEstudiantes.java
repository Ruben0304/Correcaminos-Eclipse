package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.SolicitudBajaEstudiante;

public class ObtenerSolicitudesBajasEstudiantes {

	public static ArrayList<SolicitudBajaEstudiante> cargarDesdeArchivoB() {
		
		Gson gson = new Gson();
        ArrayList<SolicitudBajaEstudiante> solicitudes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudesBajasEstudiantes.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudBajaEstudiante>>() {
            }.getType();
            solicitudes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
	}

}
