package Modelos;

import java.util.ArrayList;

public class Economia {
	private ArrayList<String> idEstudiantesConDeuda;
	private ArrayList<String> idEstudiantesConEstipendio;

	public boolean tieneDeuda(String id) {
		boolean encontrado = false;
		for (int i = 0; i < idEstudiantesConDeuda.size() && !encontrado; i++) {
			encontrado = idEstudiantesConDeuda.get(i).equals(id);
		}
		return encontrado;
	}

	public boolean controlEstipendio(String id) {
		boolean encontrado = false;
		for (int i = 0; i < idEstudiantesConEstipendio.size() && !encontrado; i++) {
			encontrado = idEstudiantesConEstipendio.get(i).equals(id);
		}
		return encontrado;
	}
}
