package modelos.solicitudes;

import modelos.usuarios.Docente;
import modelos.usuarios.NoDocente;

public class SolicitudLicenciaEmpleado extends SolicitudBajaEmpleados{
	 
	 private String fechaSalida;
     private String fechaRegreso;
	
	
	public SolicitudLicenciaEmpleado(Docente docente, String motivo, String fechaSalida, String fechaRegreso) {
		super(docente, motivo);
		this.fechaSalida = fechaSalida;
		this.fechaRegreso = fechaRegreso;
		
	}
	
	public SolicitudLicenciaEmpleado(NoDocente noDocente, String motivo, String fechaSalida, String fechaRegreso) {
		super(noDocente, motivo);
		this.fechaSalida = fechaSalida;
		this.fechaRegreso = fechaRegreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public String getFechaRegreso() {
		return fechaRegreso;
	}

	
    
}
