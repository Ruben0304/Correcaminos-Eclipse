package models.departamentos;

import java.util.ArrayList;

import models.interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Estudiante;
import util.TiposResponsabilidad;

public class Secretaria implements VerificadorEstudiante {

	public boolean tieneCarnetDeEstudiante(ResponsabilidadesEstudiantes r) {
		return r.getResponsabilidades().contains(TiposResponsabilidad.CARNET_CUJAE);
	}
	
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes) {
		return tieneCarnetDeEstudiante(responsabilidadesEstudiantes);
	}
	
	public void devolverCarnetCujae(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
		 boolean encontrado = false;
	        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

	            encontrado = responsabilidades.get(i).getEstudiante().equals(e);
	            if (encontrado) {
	                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.CARNET_CUJAE);
	            }

	        }
	}
	
	@Override
	public ArrayList<Estudiante> getEstudiantesPendientes(ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
        ArrayList<Estudiante> es = new ArrayList<>();
        for (ResponsabilidadesEstudiantes r : responsabilidades) {
            if (verificarRequisitos(r)) {
                es.add(r.getEstudiante());
            }
        }
        return es;
    }
	
	
    
}