package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;

public class ObtenerResponsabilidadesEmpleados {
	
	public static ArrayList<ResponsabilidadesEmpleados> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
        ArrayList<ResponsabilidadesEmpleados> resp = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./responsabilidadesEmpleados.json"))) {
            Type listType = new TypeToken<ArrayList<ResponsabilidadesEmpleados>>() {
            }.getType();
            resp = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
	}
}
