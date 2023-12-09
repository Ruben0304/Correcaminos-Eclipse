package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class ObtenerPersonasConLibrosBibliotecaPendientes {

	public static HashMap<String, Set<String>> cargarDesdeArchivo() {
		
		Gson gson = new Gson();
		HashMap<String, Set<String>> personas = new HashMap<>();
		

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/libros/librosPendientesBiblioteca.json"))) {
            Type listType = new TypeToken<HashMap<String, Set<String>>>() {
            }.getType();
            personas = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
        
    
        
       
        
        return personas;
    
	}

}
