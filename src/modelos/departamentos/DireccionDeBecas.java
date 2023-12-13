package modelos.departamentos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import datos.ObtenerEstudiantesConEstipendio;
import datos.ObtenerEstudiantesConPertenenciasBeca;
import interfaces.AdministradorDeudas;
import interfaces.VerificadorEstudiante;
import modelos.usuarios.Becado;
import modelos.usuarios.Estudiante;

public class DireccionDeBecas implements VerificadorEstudiante, AdministradorDeudas {

	private HashMap<String, Set<String>> pertenenciasBecados;

	public DireccionDeBecas() {
		pertenenciasBecados = new HashMap<String, Set<String>>();
		cargarInformacionEstudiantesConPertenenciasBeca();
	}

	public void cargarInformacionEstudiantesConPertenenciasBeca() {
		pertenenciasBecados = ObtenerEstudiantesConPertenenciasBeca.cargarDesdeArchivo();
	}

	@Override
	public boolean verificarRequisitos(Estudiante e) {
		return pertenenciasBecados.containsKey(e.getCi());
	}

	public void recogerDeudas(String e, Set<String> pertenencias) {
		pertenenciasBecados.get(e).removeAll(pertenencias);
	}

	public void confirmarEntrega(String e) {
		pertenenciasBecados.remove(e);
	}

	@Override
	public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<Estudiante> estudiantesSolicitudesPendientes) {

		ArrayList<Estudiante> estudiantes = new ArrayList<>();

		for (Estudiante e : estudiantesSolicitudesPendientes) {
			if (pertenenciasBecados.containsKey(e.getCi())) {
				estudiantes.add(e);
			}
		}

		return estudiantes;

	}

	public Set<String> obtenerDeudas(String e) {
		return pertenenciasBecados.get(e);
	}
}
