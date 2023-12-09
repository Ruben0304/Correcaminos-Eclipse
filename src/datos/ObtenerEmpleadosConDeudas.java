package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.usuarios.Docente;
import modelos.usuarios.Empleado;
import modelos.usuarios.NoDocente;

public class ObtenerEmpleadosConDeudas {

	public static HashMap<String, Double> cargarDesdeArchivo() {
		
		 Gson gson = new Gson();
		 	HashMap<String, Double> deudasEmpleados = new HashMap<>();
		 	

	        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/deudas/deudasEmpleados.json"))) {
	            Type listType = new TypeToken<HashMap<String, Double>>() {
	            }.getType();
	            deudasEmpleados = gson.fromJson(reader, listType);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }


	        return deudasEmpleados;
	}

}
