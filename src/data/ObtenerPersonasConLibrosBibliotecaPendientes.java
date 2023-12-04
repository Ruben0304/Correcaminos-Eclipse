package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.Persona;
import models.usuarios.Estudiante;
import models.usuarios.NoDocente;

public class ObtenerPersonasConLibrosBibliotecaPendientes {

	public static HashMap<Persona, Set<String>> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<Estudiante, Set<String>> estudianteslibrosPendientes = new HashMap<Estudiante, Set<String>>();
		HashMap<Empleado, Set<String>> docenteslibrosPendientes = new HashMap<Empleado, Set<String>>();
		HashMap<Empleado, Set<String>> noDocenteslibrosPendientes = new HashMap<Empleado, Set<String>>();
		

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/libros/librosPendientesEmpleadosDocentes.json"))) {
            Type listType = new TypeToken<HashMap<Docente, Set<String>>>() {
            }.getType();
            docenteslibrosPendientes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/libros/librosPendientesEmpleadosNoDocentes.json"))) {
            Type listType = new TypeToken<HashMap<NoDocente, Set<String>>>() {
            }.getType();
            noDocenteslibrosPendientes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/libros/librosPendientesEstudiantes.json"))) {
            Type listType = new TypeToken<HashMap<Estudiante, Set<String>>>() {
            }.getType();
            estudianteslibrosPendientes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        HashMap<Persona, Set<String>> personas = new HashMap<Persona, Set<String>>();
        
        personas.putAll(noDocenteslibrosPendientes);
        personas.putAll(docenteslibrosPendientes);
        personas.putAll(estudianteslibrosPendientes);
        
        return personas;
    
	}

}
