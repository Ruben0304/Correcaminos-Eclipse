package models.solicitudes;

import java.sql.Date;
import java.time.LocalDate;

import models.usuarios.Estudiante;
import util.Estado;

public class SolicitudBaja {
    protected Estudiante estudiante;
    protected Estado estado;
    protected String motivo;
    protected Date fecha;

    

    public SolicitudBaja(Estudiante estudiante, String motivo) {
        this.estudiante = estudiante;
        this.estado = Estado.PENDIENTE;
        this.motivo = motivo;
        this.fecha = new Date(System.currentTimeMillis()); 
    }
    

    

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

   
}
