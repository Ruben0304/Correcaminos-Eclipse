package models.solicitudes;

import util.Estado;

public abstract class Solicitud {
    protected Estado estado;
    protected String motivo;

    public Solicitud(Estado estado, String motivo) {
        this.estado = Estado.PENDIENTE;
        this.motivo = motivo;
    }

     public Estado getEstado() {
        return estado;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
