package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.Solicitud;

import models.solicitudes.SolicitudLicencia;
import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.NoDocente;

public class ObtenerSolicitudes {
    public static HashMap<Empleado, Set<Solicitud>> cargarDesdeArchivo() {

        Gson gson = new Gson();
        HashMap<Empleado, Set<Solicitud>> solicitudes = new HashMap<>();
        HashMap<Empleado, Set<Solicitud>> licencias = new HashMap<>();
        HashMap<Empleado, Set<Solicitud>> licenci = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes.json"))) {
            Type listType = new TypeToken<HashMap<Docente, Set<SolicitudLicencia>>>() {
            }.getType();
            licencias = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes.json"))) {
            Type listType = new TypeToken<HashMap<NoDocente, Set<SolicitudLicencia>>>() {
            }.getType();
            licenci = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        solicitudes.putAll(licencias);
        solicitudes.putAll(licenci);
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
