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
import models.usuarios.Docente;
import models.usuarios.Empleado;
import models.usuarios.NoDocente;

public class ObtenerSolicitudesEmpleados {
	
	public static HashMap<Empleado, Set<Solicitud>> cargarDesdeArchivo() {

        Gson gson = new Gson();
        HashMap<Empleado, Set<Solicitud>> solicitudes = new HashMap<>();
        HashMap<Empleado, Set<Solicitud>> licenciasDocentes = new HashMap<>();
        HashMap<Empleado, Set<Solicitud>> licenciasNoDocentes = new HashMap<>();
        HashMap<Empleado, Set<Solicitud>> bajasDocentes = new HashMap<>();
        HashMap<Empleado, Set<Solicitud>> bajasNoDocentes = new HashMap<>();


        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesLicenciaDocentes.json"))) {
            Type listType = new TypeToken<HashMap<Docente, Set<SolicitudLicencia>>>() {
            }.getType();
            licenciasDocentes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesBajasDocentes.json"))) {
            Type listType = new TypeToken<HashMap<Docente, Set<SolicitudBaja>>>() {
            }.getType();
            bajasDocentes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesLicenciaNoDocentes.json"))) {
            Type listType = new TypeToken<HashMap<NoDocente, Set<SolicitudLicencia>>>() {
            }.getType();
            licenciasNoDocentes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./jsons/solicitudes/solicitudesBajasNoDocentes.json"))) {
            Type listType = new TypeToken<HashMap< NoDocente, Set<SolicitudBaja>>>() {
            }.getType();
            bajasNoDocentes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        solicitudes.putAll(licenciasDocentes);
        solicitudes.putAll(licenciasNoDocentes);
        solicitudes.putAll(bajasDocentes);
        solicitudes.putAll(bajasNoDocentes);


        return solicitudes;
    }
}
