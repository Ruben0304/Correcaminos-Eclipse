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

import models.usuarios.Empleado;
import models.usuarios.Estudiante;

public class ObtenerEstudiantes {
    public static ArrayList<Estudiante> cargarDesdeArchivo() {
         Gson gson = new Gson();
        
	    ArrayList<Estudiante> estudiantes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./estudiantes.json"))) {
            Type listType = new TypeToken<ArrayList<Estudiante>>() {
            }.getType();

            estudiantes = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return estudiantes;
    }
}
