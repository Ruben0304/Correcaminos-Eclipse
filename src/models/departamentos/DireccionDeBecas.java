package models.departamentos;

import models.interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import utiles.TiposResponsabilidad;

public class DireccionDeBecas implements VerificadorEstudiante {

	public boolean tienePertenenciasDeLaCUJAE(ResponsabilidadesEstudiantes r) {
		return r.getResponsabilidades().contains(TiposResponsabilidad.PERTENENCIAS_BECA);
	}
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes) {
		return tienePertenenciasDeLaCUJAE(responsabilidadesEstudiantes);
	}
	
}
