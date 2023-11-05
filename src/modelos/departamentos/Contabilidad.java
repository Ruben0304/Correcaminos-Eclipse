package modelos.departamentos;

import java.util.ArrayList;

import modelos.solicitudes.SolicitudBajaEmpleados;
import modelos.usuarios.Empleado;
import utiles.ResponsabilidadesTrabajador;

public class Contabilidad {
	
	public static boolean verificarRequisitos(Empleado e) {
		return e.tieneDeuda();
	}
	
	public static void saldarDeuda(Empleado e) {
		ArrayList<ResponsabilidadesTrabajador> resp = e.getResponsabilidades();
		
		resp.remove(ResponsabilidadesTrabajador.DEUDA);
	}
	
	public static ArrayList<Empleado> empleadosDeudasPendientes(RecursosHumanos rh) {
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ArrayList<SolicitudBajaEmpleados> solicitudesBaja = rh.getSolicitudesBajaEmpleados();
		
		for (SolicitudBajaEmpleados solicitud: solicitudesBaja) {
			
			Empleado e = solicitud.getEmpleado();
			
			if (e.tieneDeuda()) {
				empleados.add(e);
			}
		}
		
		return empleados;
	}
}
