package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;

public class ObtenerSolicitudesEmpleados {
	
	public static ArrayList<SolicitudBaja> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
        ArrayList<SolicitudBaja> solicitudes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudesEmpleados.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudBaja>>() {
            }.getType();
            solicitudes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
	}
}
