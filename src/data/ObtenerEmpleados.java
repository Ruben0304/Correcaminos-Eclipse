package data;

import java.util.ArrayList;

import models.usuarios.Empleado;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ObtenerEmpleados {
	
	public static ArrayList<Empleado> cargarDesdeArchivo(){
		 
	    Gson gson = new Gson();
        
	    ArrayList<Empleado> empleados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./empleados.json"))) {
            Type listType = new TypeToken<ArrayList<Empleado>>() {
            }.getType();

            empleados = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return empleados;
	}
}

