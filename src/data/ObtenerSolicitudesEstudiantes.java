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
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import models.usuarios.NoDocente;

public class ObtenerSolicitudesEstudiantes {
    public static HashMap<Estudiante, Set<Solicitud>> cargarDesdeArchivo() {

        Gson gson = new Gson();
        HashMap<Estudiante, Set<Solicitud>> solicitudes = new HashMap<>();
        HashMap<Estudiante, Set<Solicitud>> licencias = new HashMap<>();
        HashMap<Estudiante, Set<Solicitud>> bajas = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesLicenciasEstudiantes.json"))) {
            Type listType = new TypeToken<HashMap<Estudiante, Set<SolicitudLicencia>>>() {
            }.getType();
            licencias = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesBajasEstudiantes.json"))) {
            Type listType = new TypeToken<HashMap<Estudiante, Set<SolicitudBaja>>>() {
            }.getType();
            bajas = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        solicitudes.putAll(licencias);
        solicitudes.putAll(bajas);
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
