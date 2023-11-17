package models.departamentos;

import models.interfaces.VerificadorEmpleado;
import models.interfaces.VerificadorEstudiante;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.responsabilidades.ResponsabilidadesEstudiantes;
import utiles.ResponsabilidadesTrabajador;
import utiles.TiposResponsabilidad;

public class SeguridadInformatica implements VerificadorEstudiante, VerificadorEmpleado {

	public boolean tieneCuentaUsuarioAbierta(ResponsabilidadesEmpleados r) {
		return (r.getResponsabilidades().contains(ResponsabilidadesTrabajador.CUENTA_USUARIO));
	}
	
	public boolean tieneCuentaUsuarioAbierta(ResponsabilidadesEstudiantes r) {
		return (r.getResponsabilidades().contains(TiposResponsabilidad.CUENTA_USUARIO));
	}
	
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador) {
		return tieneCuentaUsuarioAbierta(responsabilidadesTrabajador);
	}

	@Override
	public boolean verificarRequisitos(ResponsabilidadesEstudiantes responsabilidadesEstudiantes) {
		return tieneCuentaUsuarioAbierta(responsabilidadesEstudiantes);
	}

}
