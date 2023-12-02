package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import models.chats.Mensaje;
import models.usuarios.Admin;
import models.usuarios.Estudiante;
import models.usuarios.Persona;

public class ObtenerChats {
    public static HashMap<Admin, Map<Persona, ArrayList<Mensaje>>> cargarDesdeArchivo() {
        Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(new
				FileReader("./chats/biblioteca.json"))) {
				Type listType = new TypeToken<HashMap<Admin, Map<Persona, ArrayList<Mensaje>>>>(){}.getType();

				HashMap<Admin, Map<Persona, ArrayList<Mensaje>>> chats = gson.fromJson(reader,
				listType);
				return chats;

				} catch (IOException e) {
				e.printStackTrace();
				}

        return null;
    }
}
