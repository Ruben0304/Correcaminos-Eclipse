package models.departamentos;

import java.util.ArrayList;

import models.interfaces.VerificadorEmpleado;
import models.responsabilidades.ResponsabilidadesEmpleados;
import models.usuarios.Empleado;
import utiles.ResponsabilidadesTrabajador;



public class RecursosHumanos implements VerificadorEmpleado {

	public boolean tieneSalarioIndebido(ResponsabilidadesEmpleados r) {
		return r.getResponsabilidades().contains(ResponsabilidadesTrabajador.SALARIO_INDEBIDO);
	}
	@Override
	public boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador) {
		return tieneSalarioIndebido(responsabilidadesTrabajador);
	}
   

    

   
}
