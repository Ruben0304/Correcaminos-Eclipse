package data;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.chats.Chat;
import models.chats.Mensaje;

public class GuardarChats {
    public static void guardarChat(Chat chat) {
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonAdmins = gson.toJson(chat);
        try {

            FileWriter writerA = new FileWriter("./chats/biblioteca.json");
          
            writerA.write(jsonAdmins);
            writerA.close();

            System.out.println("Guardado todo ok.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
