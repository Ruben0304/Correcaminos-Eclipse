package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.SolicitudLicenciaEmpleado;

public class ObtenerSolicitudesLicenciaEmpleadosAceptadas {

	public static ArrayList<SolicitudLicenciaEmpleado> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
        ArrayList<SolicitudLicenciaEmpleado> solicitudes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudesLicenciaEmpleadosAceptadas.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudLicenciaEmpleado>>() {
            }.getType();
            solicitudes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
	}

}
