package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.usuarios.Becado;
import modelos.usuarios.Credenciales;
import modelos.usuarios.Docente;
import modelos.usuarios.Estudiante;
import modelos.usuarios.NoDocente;
import modelos.usuarios.Persona;

public class ObtenerUsuariosCujae {

	public static HashMap<Credenciales, Persona> cargarDesdeArchivo() {

		Gson gson = new Gson();
	 	HashMap<Credenciales, Persona> usuarios = new HashMap<>();
	 	HashMap<Credenciales, Persona> cuentaEstudiantes = new HashMap<>();
        HashMap<Credenciales, Persona> cuentaEstudiantesBecados = new HashMap<>();
	 	HashMap<Credenciales, Persona> cuentaDocentes = new HashMap<>();
	 	HashMap<Credenciales, Persona> cuentaNoDocentes = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/usuarios/usuariosDocentes.json"))) {
            Type listType = new TypeToken<HashMap<Credenciales, Docente>>() {
            }.getType();
            cuentaDocentes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/usuarios/usuariosNoDocentes.json"))) {
            Type listType = new TypeToken<HashMap<Credenciales, NoDocente>>() {
            }.getType();
            cuentaNoDocentes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/usuarios/usuariosEstudiantes.json"))) {
            Type listType = new TypeToken<HashMap<Credenciales, Estudiante>>() {
            }.getType();
            cuentaEstudiantes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/usuarios/usuariosBecados.json"))) {
            Type listType = new TypeToken<HashMap<Credenciales, Becado>>() {
            }.getType();
            cuentaEstudiantesBecados = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        usuarios.putAll(cuentaDocentes);
        usuarios.putAll(cuentaNoDocentes);
        usuarios.putAll(cuentaEstudiantes);
        usuarios.putAll(cuentaEstudiantesBecados);
        return usuarios;
        
	}

}
