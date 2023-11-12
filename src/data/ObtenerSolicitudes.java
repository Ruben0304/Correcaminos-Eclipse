package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.interfaces.RegistradorSolicitudesLicencias;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Estudiante;

public class ObtenerSolicitudes {
    public static ArrayList<SolicitudLicencia> cargarDesdeArchivo() {
       
        Gson gson = new Gson();
        ArrayList<SolicitudLicencia> solicitudes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudes.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudLicencia>>() {
            }.getType();
            solicitudes = gson.fromJson(reader, listType);   
        } catch (IOException e) {
            e.printStackTrace();
        }
    return solicitudes;
    }
}
