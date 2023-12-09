package datos;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.usuarios.Docente;
import modelos.usuarios.Empleado;
import modelos.usuarios.NoDocente;

import java.lang.reflect.Type;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ObtenerEmpleados {

    public static ArrayList<Empleado> cargarDesdeArchivo() {

        Gson gson = new Gson();

        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<NoDocente> noDocentes = new ArrayList<>();
        ArrayList<Docente> docentes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/nodocentes.json"))) {
            Type listType = new TypeToken<ArrayList<NoDocente>>() {
            }.getType();

            noDocentes = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/docentes.json"))) {
            Type listType = new TypeToken<ArrayList<Docente>>() {
            }.getType();

            docentes = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        empleados.addAll(noDocentes);
        empleados.addAll(docentes);
        return empleados;
    }
}
