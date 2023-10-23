package modelos.entidades;

import utiles.Estado;

public class SolicitudLicenciaEstudiante extends SolicitudBajaEstudiante{
    private String fechaSalida;
    private String fechaRegreso;
    
   
    public SolicitudLicenciaEstudiante(Estudiante estudiante, String motivo, String fecha,
            String fechaSalida, String fechaRegreso) {
        super(estudiante, motivo, fecha);
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
