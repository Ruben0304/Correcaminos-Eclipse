package data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Becado;
import models.usuarios.Estudiante;


public class ObtenerSolicitudesEstudiantes {
    public static HashMap<Estudiante, Set<Solicitud>> cargarDesdeArchivo() {

        Gson gson = new Gson();
        HashMap<Estudiante, Set<Solicitud>> solicitudes = new HashMap<>();
        HashMap<Estudiante, Set<Solicitud>> licencias = new HashMap<>();
        HashMap<Estudiante, Set<Solicitud>> licenciasBecados = new HashMap<>();
        HashMap<Estudiante, Set<Solicitud>> bajas = new HashMap<>();
        HashMap<Estudiante, Set<Solicitud>> bajasBecados = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesLicenciasEstudiantes.json"))) {
            Type listType = new TypeToken<HashMap<Estudiante, Set<SolicitudLicencia>>>() {
            }.getType();
            licencias = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesLicenciasBecados.json"))) {
            Type listType = new TypeToken<HashMap<Becado, Set<SolicitudLicencia>>>() {
            }.getType();
            licenciasBecados = gson.fromJson(reader, listType);
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

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesBajasbecados.json"))) {
            Type listType = new TypeToken<HashMap<Becado, Set<SolicitudBaja>>>() {
            }.getType();
            bajasBecados = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        solicitudes.putAll(licencias);
        solicitudes.putAll(licenciasBecados);
        solicitudes.putAll(bajas);
        solicitudes.putAll(bajasBecados);

        return solicitudes;
    }

}
