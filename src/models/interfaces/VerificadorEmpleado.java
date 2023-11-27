package models.interfaces;

import java.util.ArrayList;

import models.responsabilidades.ResponsabilidadesEmpleados;
import models.usuarios.Empleado;

public interface VerificadorEmpleado {
	boolean verificarRequisitos(Empleado e);
	
	 public ArrayList<Empleado> getEmpleadosPendientes();
}
