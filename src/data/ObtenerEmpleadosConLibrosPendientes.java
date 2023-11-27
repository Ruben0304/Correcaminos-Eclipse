package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.usuarios.Empleado;

public class ObtenerEmpleadosConLibrosPendientes {

	public static HashMap<Empleado, Set<String>> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<Empleado, Set<String>> librosPendientes = new HashMap<Empleado, Set<String>>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/librosPendientes.json"))) {
            Type listType = new TypeToken<HashMap<Empleado, Set<String>>>() {
            }.getType();
            librosPendientes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return librosPendientes;
	}

}
