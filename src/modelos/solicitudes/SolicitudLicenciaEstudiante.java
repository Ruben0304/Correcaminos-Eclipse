package modelos.solicitudes;

import modelos.usuarios.Estudiante;

public class SolicitudLicenciaEstudiante extends SolicitudBajaEstudiante{
    private String fechaSalida;
    private String fechaRegreso;
    
   
    public SolicitudLicenciaEstudiante(Estudiante estudiante, String motivo,
            String fechaSalida, String fechaRegreso) {
        super(estudiante, motivo);
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
