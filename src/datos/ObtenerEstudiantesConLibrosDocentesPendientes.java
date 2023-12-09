package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.usuarios.Estudiante;

public class ObtenerEstudiantesConLibrosDocentesPendientes {

	public static HashMap<String, Set<String>> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<String,  Set<String>> estudiantes = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/libros/estudiantesLibrosDocentesPendientes.json"))) {
            Type listType = new TypeToken<HashMap<String, Set<String>>>() {
            }.getType();
            estudiantes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (true) {
            
        }
        return estudiantes;
	}

}
