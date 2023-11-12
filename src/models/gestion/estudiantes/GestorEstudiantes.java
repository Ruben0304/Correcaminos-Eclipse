package models.gestion.estudiantes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.ObtenerEstudinetes;
import models.interfaces.Actualizador;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;

public class GestorEstudiantes implements Actualizador{
    private GestorSolicitudesEstudiante gestorSolicitudes;
    private GestorResponsabilidadesEstudiantes gestorResponsabilidadesEstudiantes;
    private ArrayList<Estudiante> estudiantes;
    protected ArrayList<ResponsabilidadesEstudiantes> resp;

    public GestorEstudiantes() {
        estudiantes = new ArrayList<>();
        registrarEstudiantes();
        gestorSolicitudes=new GestorSolicitudesEstudiante(estudiantes);

        for (Estudiante estudiante : estudiantes) {

            this.resp.add(new ResponsabilidadesEstudiantes(estudiante.getResponsabilidades(), estudiante));
        }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonAdmins = gson.toJson(resp);
		try {

			FileWriter writerA = new FileWriter("./responsabilidadesEstudiantes.json");
			writerA.write(jsonAdmins);
			writerA.close();

			System.out.println("Guardado todo ok.");
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    

    private void registrarEstudiantes() {
        this.estudiantes = ObtenerEstudinetes.cargarDesdeArchivo();
    }

    public Estudiante buscarEstudiantePorCi(String id) {
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

    public ArrayList<Estudiante> getEstudiantes() {

        return estudiantes;
    }

    @Override
    public void actualizarDatos() {

    }
}
