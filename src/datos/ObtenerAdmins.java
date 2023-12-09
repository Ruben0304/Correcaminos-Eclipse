package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelos.usuarios.Admin;
import modelos.usuarios.Credenciales;

public class ObtenerAdmins {

        public static HashMap<Credenciales, Admin> cargarDesdeArchivo() {

                HashMap<Credenciales, Admin> entidades = new HashMap<>();
                Gson gson = new Gson();

                try (BufferedReader reader = new BufferedReader(
                                new FileReader("./jsons/usuarios/admins.json"))) {
                        Type listType = new TypeToken<HashMap<Credenciales, Admin>>() {
                        }.getType();
                        entidades = gson.fromJson(reader, listType);
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return entidades;
        }
}
