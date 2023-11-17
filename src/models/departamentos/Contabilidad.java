package models.departamentos;

import models.interfaces.VerificadorEmpleado;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import utiles.ResponsabilidadesTrabajador;

public class Contabilidad implements VerificadorEmpleado {
	
	public boolean tieneDeudaPendiente(ResponsabilidadesEmpleados r) {
		return r.getResponsabilidades().contains(ResponsabilidadesTrabajador.DEUDA);
	}
	
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador) {
		return tieneDeudaPendiente(responsabilidadesTrabajador);
	}
}
