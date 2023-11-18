package models.interfaces;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEmpleados;
import models.usuarios.Empleado;

public interface VerificadorEmpleado {
	boolean verificarRequisitos(ResponsabilidadesEmpleados responsabilidadesTrabajador);
	
	 public ArrayList<Empleado> getEmpleadosPendientes(ArrayList<ResponsabilidadesEmpleados> responsabilidades);
}
