package models.departamentos;

import java.util.ArrayList;

import interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;
import util.TiposResponsabilidad;

public class DireccionDeBecas implements VerificadorEstudiante {

	public boolean tienePertenenciasDeLaCUJAE(ResponsabilidadesEstudiantes r) {
		return r.getResponsabilidades().contains(TiposResponsabilidad.PERTENENCIAS_BECA);
	}
    public boolean tieneCarnetDeBecado(ResponsabilidadesEstudiantes r) {
		return r.getResponsabilidades().contains(TiposResponsabilidad.CARNET_BECADO);
	}
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes) {
		return tienePertenenciasDeLaCUJAE(responsabilidadesEstudiantes) || tieneCarnetDeBecado(responsabilidadesEstudiantes);
	}
	
	public void recogerPertenenciasDeEstudiante(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
		boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.PERTENENCIAS_BECA);
                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.CARNET_BECADO);
            }

        }
	}
	
	@Override
	public ArrayList<Estudiante> getEstudiantesPendientes(
            ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (ResponsabilidadesEstudiantes r : responsabilidades) {
            if (verificarRequisitos(r)) {
                es.add(r.getEstudiante());
            }
        }
        return es;
    }
}
