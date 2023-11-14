package data;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.usuarios.Estudiante;

public class ObtenerEstudiantes {
    public static ArrayList<Estudiante> cargarDesdeArchivo() {
        // URL del archivo PHP que devuelve JSON
        String url = "https://rplay-soccer.com/correcamino/ObtenerDatos.php?Token=Correcaminos&Listado=estudiantes";

        try {
            // Crea una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            // Obtiene la respuesta JSON
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }

            String json = jsonBuilder.toString();
            reader.close();
            connection.disconnect();

            // Convierte el JSON en un ArrayList de objetos Estudiante
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Estudiante>>() {
            }.getType();
            ArrayList<Estudiante> estudiantes = gson.fromJson(json, listType);

            return estudiantes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
