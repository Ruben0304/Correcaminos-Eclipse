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

public class ObtenerEmpleadosConDeudas {

	public static HashMap<Empleado, Double> cargarDesdeArchivo() {
		
		 Gson gson = new Gson();
		 	HashMap<Empleado, Double> deudasEmpleados = new HashMap<>();
		 	HashMap<Empleado, Double> deudasDocentes = new HashMap<>();
		 	HashMap<Empleado, Double> deudasNoDocentes = new HashMap<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/deudas/deudasDocentes.json"))) {
	            Type listType = new TypeToken<HashMap<Docente, Double>>() {
	            }.getType();
	            deudasDocentes = gson.fromJson(reader, listType);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/deudas/deudasNoDocentes.json"))) {
	            Type listType = new TypeToken<HashMap<NoDocente, Double>>() {
	            }.getType();
	            deudasNoDocentes = gson.fromJson(reader, listType);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        

	        deudasEmpleados.putAll(deudasDocentes);
	        deudasEmpleados.putAll(deudasNoDocentes);
	        return deudasEmpleados;
	}

}
