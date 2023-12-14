package datos;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.usuarios.Becado;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;

public class ObtenerEstudiantes {
    public static ArrayList<Estudiante> cargarDesdeArchivo() {
         Gson gson = new Gson();
        
	    ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Estudiante> estudiantesB = new ArrayList<>();
        ArrayList<Estudiante> estudiantesNoB = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/estudiantes.json"))) {
            Type listType = new TypeToken<ArrayList<Estudiante>>() {
            }.getType();

            estudiantesNoB = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/estudiantesBecados.json"))) {
            Type listType = new TypeToken<ArrayList<Becado>>() {
            }.getType();

            estudiantesB = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        estudiantes.addAll(estudiantesNoB);
        estudiantes.addAll(estudiantesB);

        return estudiantes;
    }
}
