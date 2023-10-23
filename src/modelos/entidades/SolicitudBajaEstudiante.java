package modelos.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import utiles.Estado;

public class SolicitudBajaEstudiante {
    protected String idEstudiante;
    protected Estado estado;
    protected String motivo;
    protected String fecha;

    public SolicitudBajaEstudiante(String idEstudiante, String motivo) {
        this.idEstudiante = idEstudiante;
        this.estado = Estado.PENDIENTE;
        this.motivo = motivo;
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        this.fecha = fechaActual.format(formatter);
    }

    public String getIdEstudiante() {
        return idEstudiante;
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
