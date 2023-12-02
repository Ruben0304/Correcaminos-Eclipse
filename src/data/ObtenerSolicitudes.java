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

import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBajaEstudiante;
import models.solicitudes.SolicitudLicencia;
import models.solicitudes.SolicitudLicenciaEstudiante;
import models.usuarios.Estudiante;

public class ObtenerSolicitudes {
    public static ArrayList<Solicitud> cargarDesdeArchivo() {

        Gson gson = new Gson();
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        ArrayList<SolicitudLicencia> licencias = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudes.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudLicencia>>() {
            }.getType();
            licencias = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        solicitudes.addAll(licencias);
        return solicitudes;
    }

    // private static void escribir() {
    // SolicitudLicenciaEstudiante solicitud = new SolicitudLicenciaEstudiante(
    // new Estudiante(null, null, null, null, null, null, null, 0, null, null, 0),
    // null, null, null);
    // Gson gson = new Gson();
    // System.out.println(gson.toJson(solicitud));
    // }

    // private static void escribirB() {
    // SolicitudBajaEstudiante solicitud = new SolicitudBajaEstudiante(null,
    // new Estudiante(null, null, null, null, null, null, null, 0, null, null, 0));
    // Gson gson = new Gson();
    // System.out.println(gson.toJson(solicitud));
    // }

}
