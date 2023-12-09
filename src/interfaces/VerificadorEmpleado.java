package interfaces;

import java.util.ArrayList;


import modelos.usuarios.Empleado;

public interface VerificadorEmpleado {
	
	boolean verificarRequisitos(String e);

	ArrayList<Empleado> getEmpleadosPendientes(ArrayList<Empleado> empleadosSolicitudesPendientes);
}
