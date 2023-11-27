package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Empleado;

public class ObtenerSolicitudesEmpleados {
	
	public static HashMap<Empleado, Set<Solicitud>> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<Empleado, Set<Solicitud>> solicitudes = new HashMap<Empleado, Set<Solicitud>>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudesEmpleados.json"))) {
            Type listType = new TypeToken<HashMap<Empleado, Set<Solicitud>>>() {
            }.getType();
            solicitudes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
	}
}
