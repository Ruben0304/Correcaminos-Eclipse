package models.departamentos;

import models.interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import utiles.TiposResponsabilidad;

public class AlmacenDeLibros implements VerificadorEstudiante {

	public boolean tieneLibrosDocentes(ResponsabilidadesEstudiantes r) {
		return r.getResponsabilidades().contains(TiposResponsabilidad.LIBROS_DOCENTES);
	}
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes) {
		return tieneLibrosDocentes(responsabilidadesEstudiantes);
	}

}
