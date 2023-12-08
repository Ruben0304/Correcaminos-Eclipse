package models.gestion.empleados;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import data.ObtenerSolicitudesEmpleados;
import models.solicitudes.Solicitud;
import models.solicitudes.SolicitudBaja;
import models.solicitudes.SolicitudLicencia;
import models.usuarios.Empleado;
import models.usuarios.Estudiante;
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

    public void crearSolicitudLiciencia(MotivoLicencia motivo, Empleado e) {

       
        Calendar c = Calendar.getInstance();
        Calendar a = Calendar.getInstance();
        a.add(Calendar.YEAR, 1);

        if (solicitudesEmpleados.containsKey(e)) {
            solicitudesEmpleados.get(e).add(new SolicitudLicencia(12,motivo,c,a));
        }
         else{
            Set<Solicitud> solicituds = new HashSet<>();
            solicituds.add(new SolicitudLicencia(12,motivo,c,a));
            solicitudesEmpleados.put(e, solicituds);
        }

    }
    
    public Set<Solicitud> getSolicitudesEmpleado(Empleado e) {
    	return solicitudesEmpleados.get(e);
    }
    
}
