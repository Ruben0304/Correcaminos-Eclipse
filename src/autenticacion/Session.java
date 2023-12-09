package autenticacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelos.usuarios.Credenciales;



public class Session {
    

    public Session(Credenciales c) {
       

        Gson gson = new Gson();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./jsons/session.json"))) {
            String json = gson.toJson(c);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Credenciales obtenerSession() {
        Gson gson = new Gson();
        File file = new File("./jsons/session.json");
        Credenciales session = null;
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                session = gson.fromJson(reader, Credenciales.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            new Session(session);
        }
        return session;
    }


}
