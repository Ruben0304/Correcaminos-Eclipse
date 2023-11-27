package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.usuarios.Estudiante;
import util.TiposResponsabilidad;

public class ObtenerEstudiantesConEstipendio {

	public static HashMap<Estudiante, TiposResponsabilidad> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<Estudiante, TiposResponsabilidad> estudiantes = new HashMap<Estudiante, TiposResponsabilidad>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/estudiantesEstipendio.json"))) {
            Type listType = new TypeToken<HashMap<Estudiante, TiposResponsabilidad>>() {
            }.getType();
            estudiantes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudiantes;
	}

}
