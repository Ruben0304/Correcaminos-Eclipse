package models.departamentos;

import java.util.ArrayList;

import models.interfaces.VerificadorEmpleado;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
import util.ResponsabilidadesTrabajador;
import util.TiposResponsabilidad;

public class Contabilidad implements VerificadorEmpleado {
	
	public boolean tieneDeudaPendiente(ResponsabilidadesEmpleados r) {
		return r.getResponsabilidades().contains(ResponsabilidadesTrabajador.DEUDA);
	}
	
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador) {
		return tieneDeudaPendiente(responsabilidadesTrabajador);
	}
	
	public void saldarDeuda(Estudiante e, ArrayList<ResponsabilidadesEstudiantes> responsabilidades) {
		boolean encontrado = false;
        for (int i = 0; i < responsabilidades.size() && !encontrado; i++) {

            encontrado = responsabilidades.get(i).getEstudiante().equals(e);
            if (encontrado) {
                responsabilidades.get(i).getResponsabilidades().remove(TiposResponsabilidad.LIBROS_BIBLIOTECA);
            }

        }
	}
	
	@Override
	public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<ResponsabilidadesEmpleados> responsabilidades) {
        ArrayList<Empleado> es = new ArrayList<>();
        for (ResponsabilidadesEmpleados r : responsabilidades) {
            if (verificarRequisitos(r)) {
                es.add(r.getEmpleado());
            }
        }
        return es;
    }
}
