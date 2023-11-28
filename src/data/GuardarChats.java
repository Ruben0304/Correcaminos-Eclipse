package data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.chats.AdministradorChats;

import models.chats.Mensaje;
import models.usuarios.Admin;
import models.usuarios.Persona;
import util.TipoDepartamento;

public class GuardarChats {
    public static void guardarChat(Admin departamento,  Persona p,) {
        
        public void guardarMensajes(TipoDepartamento departamento,  Persona p, ArrayList<Mensaje> mensajes) {
        // Chat chat = new Chat(departamento, nombreUsuario);
        // chats.add(chat);
    }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonAdmins = gson.toJson(AdministradorChats.getAdministradorChats().listarChats(departamento));
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
