package interfaces;

import java.util.ArrayList;


import modelos.usuarios.Empleado;

public interface VerificadorEmpleado {
	
	boolean verificarRequisitos(Empleado e);

	ArrayList<Empleado> getEmpleadosPendientes(ArrayList<Empleado> empleadosSolicitudesPendientes);
}
