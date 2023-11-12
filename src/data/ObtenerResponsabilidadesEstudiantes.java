package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.responsabilidades.ResponsabilidadesEstudiantes;


public class ObtenerResponsabilidadesEstudiantes {
    public static ArrayList<ResponsabilidadesEstudiantes> cargarDesdeArchivo() {
       
        Gson gson = new Gson();
        ArrayList<ResponsabilidadesEstudiantes> resp = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./responsabilidadesEstudiantes.json"))) {
            Type listType = new TypeToken<ArrayList<ResponsabilidadesEstudiantes>>() {
            }.getType();
            resp = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
    return resp;
    }
}
