package modelos.departamentos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// import modelos.fabricas.EstudianteFactory;
// import modelos.fabricas.SolicitudFactory;
import modelos.solicitudes.SolicitudBajaEstudiante;
import modelos.solicitudes.SolicitudLicenciaEstudiante;
import modelos.usuarios.Estudiante;

public class Secretaria {
    ArrayList<Estudiante> estudiantes;
    ArrayList<SolicitudLicenciaEstudiante> solicitudesLicenciaPendientes;
    ArrayList<SolicitudBajaEstudiante> solicitudesBaja;

    public Secretaria() {
        estudiantes = new ArrayList<>();
        solicitudesLicenciaPendientes = new ArrayList<>();
        solicitudesBaja = new ArrayList<>();
    }

    public ArrayList<Estudiante> registrarEstudiantes() {
        Gson gson = new Gson();
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./estudiantes.json"))) {
            Type listType = new TypeToken<ArrayList<Estudiante>>() {
            }.getType();
            
            estudiantes = gson.fromJson(reader, listType);

            // Ahora tienes la lista de estudiantes cargada desde el archivo JSON
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.estudiantes.addAll(estudiantes);
        return estudiantes;
    }

    public void registrarLicenciasEstudiantes() {
        Gson gson = new Gson();
        ArrayList<SolicitudLicenciaEstudiante> solicitudes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./solicitudes.json"))) {
            Type listType = new TypeToken<ArrayList<SolicitudLicenciaEstudiante>>() {}.getType();
            solicitudes = gson.fromJson(reader, listType);

      

            ArrayList<SolicitudLicenciaEstudiante> solicitudesRegistradas = new ArrayList<>();

            for (SolicitudLicenciaEstudiante solicitud : solicitudes) {
                String estudianteId = solicitud.getEstudiante().getCi();
                Estudiante estudianteExistente = buscarEstudiante(estudianteId);

                if (estudianteExistente != null) {
                   
                    SolicitudLicenciaEstudiante solicitudRegistrada = new SolicitudLicenciaEstudiante(estudianteExistente,solicitud.getMotivo(),solicitud.getFechaSalida(),solicitud.getFechaRegreso());
                    solicitudesRegistradas.add(solicitudRegistrada);
                } 
            }

            
            this.solicitudesLicenciaPendientes.addAll(solicitudesRegistradas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarSolicitudDeLicencia(SolicitudLicenciaEstudiante solicitud) {
        solicitudesLicenciaPendientes.add(solicitud);
    }

    public boolean verificarEstudianteSolicitaLicencia(Estudiante e) {
        boolean encontrado = false;
        for (int i = 0; i < this.solicitudesLicenciaPendientes.size() && !encontrado; i++) {
            encontrado = e.getCi().equals(this.solicitudesLicenciaPendientes.get(i).getEstudiante().getCi());
        }
        return encontrado;
    }

    public Estudiante buscarEstudiante(String id) {
        boolean encontrado = false;
        Estudiante estudianteEncontrado = null;
        for (int i = 0; i < this.estudiantes.size() && !encontrado; i++) {
            encontrado = id.equals(this.estudiantes.get(i).getCi());
            if (encontrado) {
                estudianteEncontrado = this.estudiantes.get(i);
            }
        }
        return estudianteEncontrado;
    }

    public ArrayList<SolicitudLicenciaEstudiante> getSolicitudesLicenciaPendientes() {

        return solicitudesLicenciaPendientes;
    }

    public ArrayList<Estudiante> getEstudianteLicenciaPendientes() {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (SolicitudLicenciaEstudiante s : this.solicitudesLicenciaPendientes) {
            es.add(s.getEstudiante());
        }
        return es;
    }

    public ArrayList<Estudiante> getEstudiantes() {

        return estudiantes;
    }

}
