package modelos.entidades;


import utiles.Estado;

public class SolicitudBajaEstudiante {
    protected Estudiante estudiante;
    protected Estado estado;
    protected String motivo;
    protected String fecha;

    

    public SolicitudBajaEstudiante(Estudiante estudiante, String motivo, String fecha) {
        this.estudiante = estudiante;
        this.estado = Estado.PENDIENTE;
        this.motivo = motivo;
        this.fecha = fecha;
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
