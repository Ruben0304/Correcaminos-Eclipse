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

	public static HashMap<Empleado, TiposResponsabilidad> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<Empleado, TiposResponsabilidad> empleados = new HashMap<Empleado, TiposResponsabilidad>();
		HashMap<Empleado, TiposResponsabilidad> empleadosDocentes = new HashMap<Empleado, TiposResponsabilidad>();
		HashMap<Empleado, TiposResponsabilidad> empleadosNoDocentes = new HashMap<Empleado, TiposResponsabilidad>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/docentesSalarioIndebido.json"))) {
            Type listType = new TypeToken<HashMap<Docente, TiposResponsabilidad>>() {
            }.getType();
            empleadosDocentes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/noDocentesSalarioIndebido.json"))) {
            Type listType = new TypeToken<HashMap<NoDocente, TiposResponsabilidad>>() {
            }.getType();
            empleadosNoDocentes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        empleados.putAll(empleadosNoDocentes);
        empleados.putAll(empleadosDocentes);
        return empleados;
	}

}
