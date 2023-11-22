package models.gestion.estudiantes;

import java.util.ArrayList;

import data.ObtenerResponsabilidadesEstudiantes;
import data.ObtenerSolicitudes;
import models.interfaces.Actualizador;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Estudiante;

public class GestorResponsabilidadesEstudiantes implements Actualizador {
    private ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantesPendientes;
    private ArrayList<ResponsabilidadesEstudiantes> responsabilidadesEstudiantesCujae;

    public GestorResponsabilidadesEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.responsabilidadesEstudiantesCujae = new ArrayList<>();
        this.responsabilidadesEstudiantesPendientes = new ArrayList<>();
        registrarResponsabilidades(estudiantes);
    }

    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantesPendientes() {
        return responsabilidadesEstudiantesPendientes;
    }

    public ArrayList<ResponsabilidadesEstudiantes> getResponsabilidadesEstudiantesCujae() {
        return responsabilidadesEstudiantesCujae;
    }
    

    private void registrarResponsabilidades(ArrayList<Estudiante> estudiantes) {
        ArrayList<ResponsabilidadesEstudiantes> responsabilidades = ObtenerResponsabilidadesEstudiantes
                .cargarDesdeArchivo();
        ArrayList<ResponsabilidadesEstudiantes> responsabilidadesRegistradas = new ArrayList<>();

        for (ResponsabilidadesEstudiantes resp : responsabilidades) {
            String estudianteId = resp.getEstudiante().getCi();
            Estudiante estudianteExistente = referenciarEstudiante(estudianteId, estudiantes);

            if (estudianteExistente != null) {
                ResponsabilidadesEstudiantes respRegistrada = new ResponsabilidadesEstudiantes(
                        resp.getResponsabilidades(), estudianteExistente);
                responsabilidadesRegistradas.add(respRegistrada);
            }
        }
        this.responsabilidadesEstudiantesPendientes.addAll(responsabilidadesRegistradas);
    }

    private Estudiante referenciarEstudiante(String id, ArrayList<Estudiante> estudiantes) {
        boolean encontrado = false;
        Estudiante estudianteEncontrado = null;
        for (int i = 0; i < estudiantes.size() && !encontrado; i++) {
            encontrado = id.equals(estudiantes.get(i).getCi());
            if (encontrado) {
                estudianteEncontrado = estudiantes.get(i);
            }
        }
        return estudianteEncontrado;
    }

    public ResponsabilidadesEstudiantes getListadoDeUnEstudiante(Estudiante e) {
        ResponsabilidadesEstudiantes responsabilidadesEst = null;
        for (ResponsabilidadesEstudiantes responsabilidadesEstudiantes : responsabilidadesEstudiantesPendientes) {
            if (e.getCi().equals(responsabilidadesEstudiantes.getEstudiante().getCi())) {
            responsabilidadesEst = responsabilidadesEstudiantes;
            }
        }
        return responsabilidadesEst;
    }

    @Override
    public void actualizarDatos() {

    }

}
