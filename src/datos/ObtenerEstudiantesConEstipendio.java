package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.usuarios.Estudiante;
import util.TiposResponsabilidad;

public class ObtenerEstudiantesConEstipendio {

	public static HashMap<String, TiposResponsabilidad> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<String, TiposResponsabilidad> estudiantes = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/estudiantesEstipendio.json"))) {
            Type listType = new TypeToken<HashMap<String, TiposResponsabilidad>>() {
            }.getType();
            estudiantes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudiantes;
	}

}
