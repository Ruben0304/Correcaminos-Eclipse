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

import models.solicitudes.SolicitudBajaEstudiante;
import models.solicitudes.SolicitudLicenciaEstudiante;
import models.usuarios.Estudiante;

//cambiar nombre a de clase a ObtenerSolicitudesLicenciaEstudiantes 

public class ObtenerSolicitudes {
    public static ArrayList<SolicitudLicenciaEstudiante> cargarDesdeArchivo() {
       
        Gson gson = new Gson();
        ArrayList<SolicitudLicenciaEstudiante> solicitudes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudes.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudLicenciaEstudiante>>() {
            }.getType();
            solicitudes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }

    // private static void escribir() {
    //     SolicitudLicenciaEstudiante solicitud = new SolicitudLicenciaEstudiante(
    //             new Estudiante(null, null, null, null, null, null, null, 0, null, null, 0), null, null, null);
    //     Gson gson = new Gson();
    //     System.out.println(gson.toJson(solicitud));
    // }

    

    // private static void escribirB() {
    //     SolicitudBajaEstudiante solicitud = new SolicitudBajaEstudiante(null,
    //             new Estudiante(null, null, null, null, null, null, null, 0, null, null, 0));
    //     Gson gson = new Gson();
    //     System.out.println(gson.toJson(solicitud));
    // }

}
