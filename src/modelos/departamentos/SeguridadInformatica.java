package modelos.departamentos;

import java.util.ArrayList;

import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import utiles.ResponsabilidadesTrabajador;
import utiles.TiposResponsabilidad;
import modelos.solicitudes.SolicitudBajaEmpleados;
import modelos.usuarios.Docente;

public class SeguridadInformatica {
	
	public static boolean verificarRequisitos(Estudiante e) {
		return e.tieneCuentaCerrada();
	}
	
	public static boolean verificarRequisitos(Empleado e) {
		return ((Docente)e).tieneCuentaUsuarioCerrada();
	}
	
	public static void cerrarCuenta(Estudiante e) {
		
		ArrayList<TiposResponsabilidad> resp = e.getResponsabilidades();
		resp.remove(TiposResponsabilidad.CUENTA_USUARIO);
	}
	
	public static void cerrarCuenta(Empleado e) {
		
		ArrayList<ResponsabilidadesTrabajador> resp = e.getResponsabilidades();
		resp.remove(ResponsabilidadesTrabajador.CUENTA_USUARIO);
	}
	
	public static ArrayList<Estudiante> estudiantesConCuentasPorCerrar(Secretaria s) {
		
		ArrayList<Estudiante> est = new ArrayList<Estudiante>();
		ArrayList<Estudiante> estudiantesPendientes = s.getEstudianteLicenciaPendientes();
		
		for (Estudiante e : estudiantesPendientes) {
			if (!e.tieneCuentaCerrada()) {
				est.add(e);
			}
		}
		return est;
	}
	
	public static ArrayList<Empleado> docentesConCuentasPorCerrar(RecursosHumanos rh) {
		
		ArrayList<Empleado> emp = new ArrayList<Empleado>();
		ArrayList<SolicitudBajaEmpleados> solicitudesPendientes = rh.getSolicitudesBajaEmpleados();
		
		for (SolicitudBajaEmpleados s : solicitudesPendientes) {
			
			Empleado e = s.getEmpleado();
			
			if (!((Docente)e).tieneCuentaUsuarioCerrada()) {
				emp.add(e);
			}
		}
		return emp;
	}
}
