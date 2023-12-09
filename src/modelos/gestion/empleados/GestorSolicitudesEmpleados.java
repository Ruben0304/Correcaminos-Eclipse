package modelos.gestion.empleados;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

import datos.ObtenerSolicitudesEmpleados;
import modelos.solicitudes.Solicitud;
import modelos.solicitudes.SolicitudBaja;
import modelos.solicitudes.SolicitudLicencia;
import modelos.usuarios.Empleado;
import modelos.usuarios.Estudiante;

import java.util.HashSet;
import java.util.Map;

import util.Estado;
import util.MotivoBaja;
import util.MotivoLicencia;

public class GestorSolicitudesEmpleados {
    
	private HashMap<Empleado, Set<Solicitud>> solicitudesEmpleados;
	
	public GestorSolicitudesEmpleados() {
		solicitudesEmpleados = new  HashMap<Empleado, Set<Solicitud>>();
		registrarLicenciasEmpleados();
	}
    
    private void registrarLicenciasEmpleados() {
    	solicitudesEmpleados = ObtenerSolicitudesEmpleados.cargarDesdeArchivo();
    }

	public HashMap<Empleado, Set<Solicitud>> getSolicitudesPendientes() {
		return solicitudesEmpleados;
	}

	  public boolean verificarEmpleadoSolicitaAlgo(Empleado e) {
        boolean solicita = false;
        if (solicitudesEmpleados.containsKey(e)) {
            for (Solicitud s : solicitudesEmpleados.get(e)) {
                if (s.getEstado().equals(Estado.PENDIENTE)) {
                    solicita = true;
                }
            }

        }

        return solicita;

    }
	
	public void crearSolicitudBaja(MotivoBaja motivo, Empleado e) {

        
        if (solicitudesEmpleados.containsKey(e)) {
           solicitudesEmpleados.get(e).add(new SolicitudBaja(12,motivo));
        }
        else{
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudBaja(12,motivo));
            solicitudesEmpleados.put(e, solicituds);
        }

    }

    public void crearSolicitudLicencia(MotivoLicencia motivo, Empleado e, Calendar salida, Calendar regreso) {

        if (solicitudesEmpleados.containsKey(e)) {
            solicitudesEmpleados.get(e).add(new SolicitudLicencia(12,motivo,salida,regreso));
        }
         else{
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudLicencia(12,motivo,salida,regreso));
            solicitudesEmpleados.put(e, solicituds);
        }

    }
    
    public Set<Solicitud> getSolicitudesEmpleado(Empleado e) {
    	return solicitudesEmpleados.get(e);
    }
    
    public ArrayList<Empleado> obtenerEstudiantesPendientes() {
    	
    	ArrayList<Empleado> empleados = new ArrayList<>();
    	for (Map.Entry<Empleado, Set<Solicitud>> solicitud : solicitudesEmpleados.entrySet()) {
            
    		Empleado estudiante = solicitud.getKey();
            Set<Solicitud> listaSolicitudes = solicitud.getValue();
            
            for (Solicitud s: listaSolicitudes) {
            	if (s.getEstado().equals(Estado.PENDIENTE)) {
            		empleados.add(estudiante);
            	}
            }
        }

        return empleados;
    }
    
}
