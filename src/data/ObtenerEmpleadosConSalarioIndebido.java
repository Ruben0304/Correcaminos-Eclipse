package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.NoDocente;
import util.TiposResponsabilidad;

public class ObtenerEmpleadosConSalarioIndebido {

	public static HashMap<String, TiposResponsabilidad> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<String, TiposResponsabilidad> empleados = new HashMap<>();
		

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/empleadosSalarioIndebido.json"))) {
            Type listType = new TypeToken<HashMap<String, TiposResponsabilidad>>() {
            }.getType();
            empleados = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        
        
        return empleados;
	}

}
