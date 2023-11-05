package modelos.departamentos;

import java.util.ArrayList;

import modelos.solicitudes.SolicitudBajaEmpleados;
import modelos.solicitudes.SolicitudLicenciaEmpleado;
import modelos.usuarios.Empleado;



public class RecursosHumanos {
    private ArrayList<Empleado> empleados;
    private ArrayList<SolicitudBajaEmpleados> solicitudesBajaEmpleados;
    private ArrayList<SolicitudLicenciaEmpleado> solicitudesLicenciaEmpleados;

    public RecursosHumanos() {
        this.empleados = new ArrayList<Empleado>();
        this.solicitudesBajaEmpleados = new ArrayList<SolicitudBajaEmpleados>();
        this.solicitudesLicenciaEmpleados = new ArrayList<SolicitudLicenciaEmpleado>();
    }
    
    public void cargarEmpleados() {}
    public void cargarSolicitudesDeBaja() {}
    public void cargarSolicitudesDeLicencia() {}
    
    public void agregarNuevaSolicitudDeBaja(SolicitudBajaEmpleados solicitud) {
    	solicitudesBajaEmpleados.add(solicitud);
    }
    public void agregarNuevaSolicitudDeLicencia(SolicitudLicenciaEmpleado solicitud) {
    	solicitudesLicenciaEmpleados.add(solicitud);
    }
    
   
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

	public ArrayList<SolicitudBajaEmpleados> getSolicitudesBajaEmpleados() {
		return solicitudesBajaEmpleados;
	}

	public ArrayList<SolicitudLicenciaEmpleado> getSolicitudesLicenciaEmpleados() {
		return solicitudesLicenciaEmpleados;
	}

    
    

   
}
