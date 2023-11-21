package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.chats.Chat;
import models.usuarios.Estudiante;

public class ObtenerChats {
    public static ArrayList<Chat> cargarDesdeArchivo() {
        Gson gson = new Gson();

        ArrayList<Chat> chat = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./chats/biblioteca.json"))) {
            Type listType = new TypeToken<ArrayList<Chat>>() {
            }.getType();

            chat = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return chat;
    }
}
