package modelos.departamentos;

import java.util.ArrayList;

import modelos.solicitudes.SolicitudBajaEmpleados;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;
import utiles.ResponsabilidadesTrabajador;
import utiles.TiposResponsabilidad;

public class Biblioteca {
    public static boolean tieneLibrosPrestados(Estudiante e) {
        return e.getResponsabilidades().contains(TiposResponsabilidad.LIBROS_BIBLIOTECA);
    }

    public static boolean tieneRequisitosCumplidos(Estudiante e) {
        return tieneLibrosPrestados(e);
    }
    
    public static boolean verificarRequisitos(Empleado e) {
    	return e.tieneLibrosDeBiblioteca() && e.tieneCarnetBiblioteca();
    }
    
    public static void devolverLibrosPrestados(Estudiante e) {
     ArrayList<TiposResponsabilidad> resp = e.getResponsabilidades();
     boolean encontrado = false;
        for (int i = 0; i < resp.size() && !encontrado; i++) {
            if (resp.get(i).equals(TiposResponsabilidad.LIBROS_BIBLIOTECA)) {
                resp.remove(i);
                encontrado = true;
            }
        }
    }
    
    public static void devolverLibrosPrestados(Empleado e) {
    	
    	ArrayList<ResponsabilidadesTrabajador> resp = e.getResponsabilidades();
		resp.remove(ResponsabilidadesTrabajador.LIBROS_BIBLIOTECA);
    }
    
    public static void entregarCarnetBiblioteca(Empleado e) {
    	
    	ArrayList<ResponsabilidadesTrabajador> resp = e.getResponsabilidades();
		resp.remove(ResponsabilidadesTrabajador.CARNET_BIBLIOTECA);
    }

    public static ArrayList<Estudiante> getEstudiantesPendientes(Secretaria s){
        ArrayList<Estudiante> es = new ArrayList<>();
        for (Estudiante e : s.getEstudianteLicenciaPendientes()) {
            if (e.tieneLibrosDeBiblioteca()) {
                es.add(e);
            }
        }
         return es;
    }
    
    public static ArrayList<Empleado> empleadosConLibrosPorDevolver(RecursosHumanos rh) {
    	
    	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ArrayList<SolicitudBajaEmpleados> solicitudesBaja = rh.getSolicitudesBajaEmpleados();
		
		for (SolicitudBajaEmpleados solicitud: solicitudesBaja) {
			
			Empleado e = solicitud.getEmpleado();
			
			if (e.tieneLibrosDeBiblioteca()) {
				empleados.add(e);
			}
		}
		
		return empleados;
    }
    
    public static ArrayList<Empleado> empleadosConCarnetPorDevolver(RecursosHumanos rh) {
    	
    	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ArrayList<SolicitudBajaEmpleados> solicitudesBaja = rh.getSolicitudesBajaEmpleados();
		
		for (SolicitudBajaEmpleados solicitud: solicitudesBaja) {
			
			Empleado e = solicitud.getEmpleado();
			
			if (e.tieneCarnetBiblioteca()) {
				empleados.add(e);
			}
		}
		
		return empleados;
    }

    
}
